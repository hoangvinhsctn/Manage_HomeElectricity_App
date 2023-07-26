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
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private EditText e1,e2;
    private Button b1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        e1 = (EditText) findViewById(R.id.edtName);
        e2 = (EditText) findViewById(R.id.edtPhoneNumber);
        b1 = (Button) findViewById(R.id.btnClickView1);

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(e1.getText().toString().isEmpty() || e2.getText().toString().isEmpty())
                    Toast.makeText(MainActivity.this, "Bạn phải nhập đủ dữ liệu", Toast.LENGTH_SHORT).show();
                else
                {
                    Intent i1 = new Intent(MainActivity.this,MainActivity2.class);
                    i1.putExtra("phone_number",e2.getText().toString());
                    startActivity(i1);
                }
            }
        });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_back, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if(item.getItemId() == R.id.home_id)
        {
            Toast.makeText(this, "Bạn đã ở tại trang Home rồi!", Toast.LENGTH_SHORT).show();
        }
        return super.onOptionsItemSelected(item);
    }
}