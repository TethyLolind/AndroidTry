package com.example.bzhang26.myapplication;

import android.app.ProgressDialog;
import android.content.Intent;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    private ProgressBar progressBar;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ActionBar actionBar=getSupportActionBar();
        if (actionBar!=null) actionBar.hide();

        Button buttonMain=(Button)findViewById(R.id.button2);
        buttonMain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });


        Button buttonACT2=(Button)findViewById(R.id.button3);
        buttonACT2.setOnClickListener(MainActivity.this);

        Button buttonDialog=(Button)findViewById(R.id.dialogButton);
        buttonDialog.setOnClickListener(MainActivity.this);

        Button buttonDiaProgress=(Button)findViewById(R.id.button5);
        buttonDiaProgress.setOnClickListener(MainActivity.this);

        Button buttonImageProgress=(Button)findViewById(R.id.ieButton);
        buttonDiaProgress.setOnClickListener(MainActivity.this);

        Button buttonACT3=(Button)findViewById(R.id.button6);
        buttonACT3.setOnClickListener(MainActivity.this);

        progressBar=(ProgressBar)findViewById(R.id.progressBar);



    }
    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.button3:
                Intent toSecondActivity=new Intent(MainActivity.this,SecondActivity.class);
                toSecondActivity.putExtra("extradata","999");
                toSecondActivity.putExtra("flag",true);
                startActivity(toSecondActivity);
                break;
            case R.id.dialogButton:
                Intent toDiaActivity=new Intent(MainActivity.this,dialogActivity.class);
                startActivity(toDiaActivity);
                break;
            case R.id.button5:
                ProgressDialog progressDialog=new ProgressDialog(MainActivity.this);
                progressDialog.setTitle("processing ,please wait");
                progressDialog.setMessage("Loading...");
                progressDialog.setCancelable(true);
                progressDialog.show();
                break;
            case R.id.button6:
                Intent toACT3=new Intent(MainActivity.this,ThirdActivity.class);
                startActivity(toACT3);
                break;
            case R.id.ieButton:
                int count=progressBar.getProgress();
                count=count+5;
                progressBar.setProgress(count);
                break;

            default:break;
        }

    }




}
