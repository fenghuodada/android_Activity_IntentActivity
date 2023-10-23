package com.example.intentactivity;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class BackhaulData extends AppCompatActivity {
    Button back,sum;
    TextView textView;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_backhaul_data);
        back=findViewById(R.id.BackhaulData_button_2);
        sum=findViewById(R.id.BackhaulData_button_1);
        textView=findViewById(R.id.BackhaulData_text_1);
        Intent intent=getIntent();
        Bundle bundle=intent.getExtras();
        String first=bundle.getString("firstEdit");
        String second=bundle.getString("secondEdit");
        int sumint_1= 0;
        if (first != null) {
            sumint_1 = Integer.parseInt(first);
        }
        int sumint_2= 0;
        if (second != null) {
            sumint_2 = Integer.parseInt(second);
        }
        String sumString;
        sumString= String.valueOf(sumint_2+sumint_1);
        sum.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                textView.setText(sumString);
            }
        });
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                    Intent intent1=new Intent();
                    intent1.putExtra("result",sumString);
                    setResult(2,intent1);
                    finish();
            }
        });

    }
}