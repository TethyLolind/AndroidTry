package com.example.bzhang26.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class SecondActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        Button buttonTest=(Button)findViewById(R.id.button);
        final Intent intent=getIntent();
        final boolean flag=intent.getBooleanExtra("flag",false);
        buttonTest.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (flag){
                    Toast.makeText(SecondActivity.this
                            ,intent.getStringExtra("extradata"),Toast.LENGTH_SHORT).show();
                }


            }
        });
    }
}
