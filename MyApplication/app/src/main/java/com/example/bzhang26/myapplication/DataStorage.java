package com.example.bzhang26.myapplication;

import android.content.Context;
import android.content.SharedPreferences;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;

public class DataStorage {
    private String data;
    private Context context;
    public DataStorage(String input,Context context){
        this.data=input;
        this.context=context;
    }

    public void SaveToFile()  {
        FileOutputStream outputStream=null;
        BufferedWriter writer =null;

        try {
            outputStream=context.openFileOutput(data,Context.MODE_PRIVATE);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        writer=new BufferedWriter(new OutputStreamWriter(outputStream));
        try {
            writer.write(data);
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {

        }



    }

    public void SaveToPreference(){
        SharedPreferences.Editor editor= context.getSharedPreferences("data",Context.MODE_PRIVATE).edit();
        String[] a=this.data.split("_");
        editor.putString("name",a[0]);
        editor.putString("pswd",a[1]);
        boolean isNew;
        if (a[2]=="false"){
            isNew=false;
        }else {
            isNew=true;
        }
        editor.putBoolean("isnew",isNew);
        //key procedure!!!
        editor.apply();
    }


    public String ReadData(){
        SharedPreferences pref= context.getSharedPreferences("data",Context.MODE_PRIVATE);
        String name =pref.getString("name","null");
        String pswd=pref.getString("pswd","null");
        boolean isNew= pref.getBoolean("isnew",false);
        return name+"_"+pswd+"_"+isNew;

    }

}
