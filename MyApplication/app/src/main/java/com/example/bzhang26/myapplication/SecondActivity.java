package com.example.bzhang26.myapplication;

import android.content.Intent;
import android.hardware.usb.UsbRequest;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class SecondActivity extends AppCompatActivity {

    private List<User> defaultUserList =new ArrayList<>();
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
        setContentView(R.layout.activity_second);


        Button buttonConfirm =(Button)findViewById(R.id.confirmbutton);
        final Intent intent=getIntent();
        final boolean flag=intent.getBooleanExtra("flag",false);
        buttonConfirm.setOnClickListener(new View.OnClickListener() {
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


