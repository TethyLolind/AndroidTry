package com.example.bzhang26.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class SecondActivity extends AppCompatActivity {

    private List<User> defaultUserList =new ArrayList<>();
    private DataStorage db;
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

        final EditText userID=(EditText)findViewById(R.id.userID);
        final EditText userPswd=(EditText)findViewById(R.id.userPswd);


        final Button buttonLoginLast =(Button)findViewById(R.id.lastLoginbutton);
        buttonLoginLast.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               if (db!=null){
                   String lastLoginInfo=db.ReadData();
                   Toast.makeText(SecondActivity.this,lastLoginInfo,Toast.LENGTH_LONG).show();

               }
               else {
                   Toast.makeText(SecondActivity.this,"no info",Toast.LENGTH_LONG).show();
               }
                }
        });

        final Button buttonConfirm =(Button)findViewById(R.id.confirmbutton);
        final Intent intent=getIntent();
        final boolean isNewUser=intent.getBooleanExtra("flag",false);
        if (isNewUser){
            buttonConfirm.setText("Register");
        }
        final String dataFromMain =intent.getStringExtra("data");
        buttonConfirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (userPswd!=null&&userID!=null){
                    db=new DataStorage(userID.getText().toString()+"_"+userPswd.getText().toString()+"_"+isNewUser,SecondActivity.this);
                    db.SaveToFile();
                    db.SaveToPreference();


                }else{
                    Toast.makeText(SecondActivity.this,"LACK INPUT",Toast.LENGTH_SHORT).show();
                }

                userID.setText("");
                userPswd.setText("");
                Toast.makeText(SecondActivity.this,"has been logined in",Toast.LENGTH_SHORT).show();

           }
        });



    }




}


