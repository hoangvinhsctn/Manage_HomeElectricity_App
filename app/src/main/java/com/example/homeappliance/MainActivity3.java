package com.example.homeappliance;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity3 extends AppCompatActivity {
    private ListView listView;
    private Button btn;
    private ToolAdapter toolAdapter;
    private ArrayList<Tool> arrayList;
    private double message;
    private int position;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
        AnhXa();
        toolAdapter = new ToolAdapter(this,R.layout.dong_layout_adapter,arrayList);
        listView.setAdapter(toolAdapter);

        Intent i = getIntent();
        String phone_number = i.getStringExtra("phone_number");

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                Xử lý gửi tin nhắn tổng số năng lượng điện tiêu thụ
//                if(arrayList.size() == 0)
//                    Toast.makeText(MainActivity3.this, "Số năng lượng điện tiêu thụ: 0", Toast.LENGTH_SHORT).show();
//                else
//                    Toast.makeText(MainActivity3.this, "Tổng năng lượng điện tiêu thụ là: " + message, Toast.LENGTH_SHORT).show();
                if(arrayList.size() == 0)
                    Toast.makeText(MainActivity3.this, "Dữ liệu đang trống", Toast.LENGTH_SHORT).show();
                else
                {
                    Intent intent = new Intent();
                    intent.setAction(Intent.ACTION_SENDTO);
                    intent.putExtra("sms_body","Tổng năng lượng điện tiêu thụ là: " + message);
                    intent.setData(Uri.parse("sms:"+phone_number));
                    startActivity(intent);
                }
            }
        });

        listView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long l) {
                position = i;
                ShowDialog();
                return false;
            }
        });
    }

    private void AnhXa (){
        listView = (ListView) findViewById(R.id.lvTool);
        btn = (Button) findViewById(R.id.btnEnd);

        Intent intent = getIntent();
        arrayList = (ArrayList<Tool>) intent.getSerializableExtra("mang_tool");
        message = intent.getDoubleExtra("kq",0);
    }

    private void ShowDialog() {
        AlertDialog.Builder alertDialog = new AlertDialog.Builder(MainActivity3.this);
        alertDialog.setTitle("Xóa dữ liệu");
        alertDialog.setIcon(R.drawable.warning_icon);
        alertDialog.setMessage("Bạn có chắc chắn xóa dữ liệu?");
        alertDialog.setPositiveButton("Có", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                arrayList.remove(position);
                toolAdapter.notifyDataSetChanged();
                Toast.makeText(MainActivity3.this, "Bạn đã xóa thành công", Toast.LENGTH_SHORT).show();
            }
        });
        alertDialog.setNegativeButton("Không", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {

            }
        });
        alertDialog.show();
    }
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_back, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if(item.getItemId() == R.id.home_id)
        {
            Intent i1 = new Intent(MainActivity3.this, MainActivity.class);
            i1.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            startActivity(i1);
            finish();
        }
        return super.onOptionsItemSelected(item);
    }
}