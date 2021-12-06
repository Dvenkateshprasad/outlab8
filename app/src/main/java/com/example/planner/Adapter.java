package com.example.planner;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class Adapter extends RecyclerView.Adapter<Adapter.ViewHolder> {
    List<design> userList;
    public Adapter(List<design> userList){

        this.userList=userList;
    }
    @NonNull
    @Override
    public Adapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_design,parent,false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull Adapter.ViewHolder holder, int position) {
        String title  = userList.get(position).getTitle();
        String date = userList.get(position).getDate();
        String time = userList.get(position).getTime();
        String description = userList.get(position).getDescription();

        holder.setData(title,date,time,description);
    }

    @Override
    public int getItemCount() {
        return userList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        private TextView itemtitle;
        private TextView itemdate;
        private TextView itemtime;
        private TextView itemdescription;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            itemtime=itemView.findViewById(R.id.item_time);
            itemdate=itemView.findViewById(R.id.item_date);
            itemtitle=itemView.findViewById(R.id.item_title);
            itemdescription=itemView.findViewById(R.id.item_description);
        }

        public void setData(String title, String date, String time, String description) {
            itemtitle.setText(title);
            itemtime.setText(time);
            itemdate.setText(date);
            itemdescription.setText(description);
        }
    }
}
