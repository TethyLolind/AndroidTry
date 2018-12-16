package com.example.bzhang26.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class recycleActivity extends AppCompatActivity {
    private List<User> defaultUserList =new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycle);

        initList();
        RecyclerView recyclerView=(RecyclerView)findViewById(R.id.userRecycle);
        LinearLayoutManager layoutManager= new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        RecyclerViewAdapter adapter=new RecyclerViewAdapter(defaultUserList);
        recyclerView.setAdapter(adapter);

    }


    private void  initList(){

        for (int i=0;i<10;i++){
            java.util.Random random=new Random();

            User tempUser=new User();
            tempUser.name="test"+i;
            tempUser.male=random.nextBoolean();
            tempUser.password=random.nextInt(10000);
            this.defaultUserList.add(tempUser);
        }
    }
}
