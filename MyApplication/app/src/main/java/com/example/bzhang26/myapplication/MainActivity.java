package com.example.bzhang26.myapplication;

import android.app.ProgressDialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    private ProgressBar progressBar;
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.add_item:
                Toast.makeText(this,"you click add",Toast.LENGTH_SHORT).show();
                break;
            case R.id.remove_item:
                Toast.makeText(this,"you click remove",Toast.LENGTH_SHORT).show();
                break;
            default:

        }
        return true;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button buttonMain=(Button)findViewById(R.id.button2);
        buttonMain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });


        Button buttonNext=(Button)findViewById(R.id.button3);
        buttonNext.setOnClickListener(MainActivity.this);

        Button buttonDialog=(Button)findViewById(R.id.dialogButton);
        buttonDialog.setOnClickListener(MainActivity.this);

        Button buttonDiaProgress=(Button)findViewById(R.id.button5);
        buttonDiaProgress.setOnClickListener(MainActivity.this);

        Button buttonImageProgress=(Button)findViewById(R.id.ieButton);
        buttonDiaProgress.setOnClickListener(MainActivity.this);

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
            case R.id.ieButton:

                int count=progressBar.getProgress();
                count=count+5;
                progressBar.setProgress(count);
                break;
             default:break;
        }

    }




}
