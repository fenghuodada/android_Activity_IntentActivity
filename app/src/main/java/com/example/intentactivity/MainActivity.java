package com.example.intentactivity;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {

    Button disDmo,impDmo,bacDmo;
    EditText editTextFirst,editTextSecond;
    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView=findViewById(R.id.Activity_text_1);
        editTextFirst=findViewById(R.id.Activity_eaditText_1);
        editTextSecond=findViewById(R.id.Activity_eaditText_2);

    }

    @SuppressLint("QueryPermissionsNeeded")
    public void DisplayMode(View view) {
        Intent intent=new Intent(MainActivity.this,DisplayMode.class);
        if (intent.resolveActivity(getPackageManager())!=null){
            startActivity(intent);
        }

    }

    @SuppressLint("QueryPermissionsNeeded")
    public void ImplicitMode(View view) {
        Intent intent=new Intent().setAction("text").addCategory("android.intent.category.ImplicitMode");
        if (intent.resolveActivity(getPackageManager())!=null){
            startActivity(intent);
        }
    }

    @SuppressLint("QueryPermissionsNeeded")
    public void BackhaulData(View view) {
        if (editTextFirst.getText()==null){
            Toast.makeText(this, "请输入第一个对话框的数", Toast.LENGTH_SHORT).show();
        } else if (editTextSecond.getText()==null) {
            Toast.makeText(this, "请输入第二个对话框的数", Toast.LENGTH_SHORT).show();

        } else{
            Intent intent=new Intent(MainActivity.this,BackhaulData.class)
                    .addCategory("android.intent.category.BackhaulData");
            intent.setAction("text");
            Bundle bundle=new Bundle();
            bundle.putString("firstEdit",editTextFirst.getText().toString());
            bundle.putString("secondEdit",editTextSecond.getText().toString());
            intent.putExtras(bundle);
            if (intent.resolveActivity(getPackageManager())!=null){
                startActivityForResult(intent,1);
            }
        }


    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        switch (requestCode){
            case 1:
                if (resultCode == 2) {
                    String backtext=data.getStringExtra("result");
                    textView.setText("计算的和为:"+backtext);
                    Toast.makeText(this, "返回成功", Toast.LENGTH_SHORT).show();
                }
        }
    }
}