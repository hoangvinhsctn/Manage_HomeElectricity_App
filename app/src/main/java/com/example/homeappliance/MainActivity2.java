package com.example.homeappliance;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.io.Serializable;
import java.util.ArrayList;

public class MainActivity2 extends AppCompatActivity {
    private EditText e1,e2,e3;
    private Button b1,b2;

    private ArrayList<Tool> toolArrayList;
    private ArrayList<Double> toolAllPt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        AnhXa();

        Intent i1 = new Intent(MainActivity2.this, MainActivity3.class);
        Intent i = getIntent();
        String phone = i.getStringExtra("phone_number");

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(e1.getText().toString().isEmpty() || e2.getText().toString().isEmpty() || e3.getText().toString().isEmpty())
                    Toast.makeText(MainActivity2.this, "Bạn phải nhập đủ dữ liệu", Toast.LENGTH_SHORT).show();
                else
                {
                    toolArrayList.add(new Tool(e1.getText().toString(),Double.parseDouble(e2.getText().toString()),Double.parseDouble(e3.getText().toString())));
                    toolAllPt.add(new Tool(e1.getText().toString(),Double.parseDouble(e2.getText().toString()),Double.parseDouble(e3.getText().toString())).getPt());
                    Toast.makeText(MainActivity2.this, "Bạn đã thêm thành công", Toast.LENGTH_SHORT).show();
                    e1.setText("");
                    e2.setText("");
                    e3.setText("");
                }
            }
        });

        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(toolArrayList.size() == 0)
                    Toast.makeText(MainActivity2.this, "Bạn phải nhập đủ dữ liệu", Toast.LENGTH_SHORT).show();
                else
                {
                    i1.putExtra("mang_tool", toolArrayList);
                    i1.putExtra("kq", tongptmang(toolAllPt));
                    i1.putExtra("phone_number",phone);
                    startActivity(i1);
                }
            }
        });

    }

    private void AnhXa()
    {
        e1 = (EditText) findViewById(R.id.edtToolName);
        e2 = (EditText) findViewById(R.id.edtToolP);
        e3 = (EditText) findViewById(R.id.edtToolt);
        b1 = (Button) findViewById(R.id.btnAdd);
        b2 = (Button) findViewById(R.id.btnNext);

        toolArrayList = new ArrayList<>();
        toolAllPt = new ArrayList<>();
    }

    private Double tongptmang(ArrayList<Double> arrayList){
        double sum = 0;
        for (int i = 0; i < arrayList.size(); i++) {
            sum += arrayList.get(i);
        }
        return sum;
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_back, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if(item.getItemId() == R.id.home_id)
        {
            Intent i1 = new Intent(MainActivity2.this, MainActivity.class);
            i1.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            startActivity(i1);
            finish();
        }
        return super.onOptionsItemSelected(item);
    }
}