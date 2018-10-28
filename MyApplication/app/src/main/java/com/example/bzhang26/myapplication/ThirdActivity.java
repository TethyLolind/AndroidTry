package com.example.bzhang26.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class ThirdActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_third);
        ArrayAdapter<String> adapter=new ArrayAdapter<String>(ThirdActivity.this, R.layout.support_simple_spinner_dropdown_item,fruits);
        ListView listView=(ListView)findViewById(R.id.list_view);
        listView.setAdapter(adapter);
    }

    private  String[] fruits=new String[]{
      "APPLE","PINEAPPLE","PEACH","STRAWBERRY","WATERMELON","LEMONADE", "APPLE","PINEAPPLE","PEACH","STRAWBERRY","WATERMELON","LEMONADE", "APPLE","PINEAPPLE","PEACH","STRAWBERRY","WATERMELON","LEMONADE", "APPLE","PINEAPPLE","PEACH","STRAWBERRY","WATERMELON","LEMONADE"
    };
}
