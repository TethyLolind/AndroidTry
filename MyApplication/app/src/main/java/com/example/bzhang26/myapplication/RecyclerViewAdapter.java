package com.example.bzhang26.myapplication;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder> {
    private List<User> listUsers;

    static class ViewHolder extends  RecyclerView.ViewHolder{

        TextView userInfo;
        TextView userPswd;
        TextView userSex;

        public ViewHolder(View view){
            super(view);
            userInfo=(TextView)view.findViewById(R.id.userInfo);
            userPswd=(TextView)view.findViewById(R.id.userPswd);
            userSex=(TextView)view.findViewById(R.id.userSex);
        }


    }



    public  RecyclerViewAdapter (List<User> listUsersInput){
        listUsers=listUsersInput;
    }


    @Override
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {

        View view=LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.recycler_viewitem,viewGroup,false);
        ViewHolder holder=new ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder( ViewHolder viewHolder, int i) {
        User user=listUsers.get(i);
        viewHolder.userInfo.setText(user.name);
        if (user.male){
            viewHolder.userSex.setText("Male");
        }else {
            viewHolder.userSex.setText("Female");
        }
        viewHolder.userPswd.setText(user.password);

    }

    @Override
    public int getItemCount() {
        return listUsers.size();
    }
}

class User{
    public String name;
    public int password;
    public boolean male;
}
