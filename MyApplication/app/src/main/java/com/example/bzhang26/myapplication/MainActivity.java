package com.example.bzhang26.myapplication;

import android.app.ProgressDialog;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    private ProgressBar progressBar ;
    private IntentFilter intentFilter;
    private NetworkChangeReceiver networkChangeReceiver;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ActionBar actionBar=getSupportActionBar();
        if (actionBar!=null) actionBar.hide();

        Button buttonMain=(Button)findViewById(R.id.exitbutton);
        buttonMain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });


        Button buttonACT2=(Button)findViewById(R.id.toACT2button);
        buttonACT2.setOnClickListener(MainActivity.this);

        Button buttonDialog=(Button)findViewById(R.id.dialogButton);
        buttonDialog.setOnClickListener(MainActivity.this);

        Button buttonDiaProgress=(Button)findViewById(R.id.progressButton);
        buttonDiaProgress.setOnClickListener(MainActivity.this);

        Button buttonImageProgress=(Button)findViewById(R.id.progressOnbutton);
        buttonImageProgress.setOnClickListener(MainActivity.this);

        Button buttonACT3=(Button)findViewById(R.id.toACT3button);
        buttonACT3.setOnClickListener(MainActivity.this);


        Button buttonRec=(Button)findViewById(R.id.recyclebutton);
        buttonRec.setOnClickListener(MainActivity.this);


        Button customBroadbutton=(Button)findViewById(R.id.customBroadbutton);
        customBroadbutton.setOnClickListener(MainActivity.this);

        progressBar = (ProgressBar) findViewById(R.id.progressBar);

//broadcast detector

        //接受的过滤器
        intentFilter=new IntentFilter();
        intentFilter.addAction("android.net.conn.CONNECTIVITY_CHANGE");

        //接手后要做的事情
        networkChangeReceiver=new NetworkChangeReceiver();
        registerReceiver(networkChangeReceiver,intentFilter);








    }
    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.toACT2button:
                Intent toACT2 =new Intent(MainActivity.this,SecondActivity.class);
                toACT2.putExtra("extradata","999");
                toACT2.putExtra("flag",true);
                startActivity(toACT2);
                break;
            case R.id.toACT3button:
                Intent toACT3=new Intent(MainActivity.this,ThirdActivity.class);
                startActivity(toACT3);
                break;
            case R.id.dialogButton:
                Intent toDiaActivity=new Intent(MainActivity.this,dialogActivity.class);
                startActivity(toDiaActivity);
                break;
            case R.id.progressButton:
                ProgressDialog progressDialog=new ProgressDialog(MainActivity.this);
                progressDialog.setTitle("processing ,please wait");
                progressDialog.setMessage("Loading...");
                progressDialog.setCancelable(true);
                progressDialog.show();
                break;
            case R.id.progressOnbutton:

                int count=progressBar.getProgress();
                count=count+5;
                if (count>progressBar.getMax()){
                    count=0;
                }
                progressBar.setProgress(count);

                break;
            case R.id.recyclebutton:
                Intent toRecActivity=new Intent(MainActivity.this,recycleActivity.class);
                startActivity(toRecActivity);

                break;

            case R.id.customBroadbutton:
                Intent toBroad=new Intent("com.example.bzhang26.myapplication.CUSTOMISE");

                sendBroadcast(toBroad);
//                sendOrderedBroadcast(toBroad,null);


                break;



            default:break;
        }

    }

    class NetworkChangeReceiver extends BroadcastReceiver {
        @Override
        public void onReceive(Context context, Intent intent) {
            ConnectivityManager connectivityManager =(ConnectivityManager)getSystemService(Context.CONNECTIVITY_SERVICE);

            NetworkInfo networkInfo=connectivityManager.getActiveNetworkInfo();
            if (networkInfo!=null&&networkInfo.isConnected()){
                Toast.makeText(context,"network!changes to available",Toast.LENGTH_SHORT).show();
            }
            else { Toast.makeText(context,"network!null ",Toast.LENGTH_SHORT).show();}


        }


    }




}
