package com.example.planner;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.List;

public class Adapter extends RecyclerView.Adapter<Adapter.ViewHolder> {
    Context context;
    List<design> userList;
    private OnItemClickListener mListener;

    public interface OnItemClickListener{
        void OnDeleteClick(int position);
    }
    public void setOnItemClickListener(OnItemClickListener listener){
        mListener = listener;
    }
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
        public TextView itemtitle;
        public TextView itemdate;
        public TextView itemtime;
        public TextView itemdescription;
        public ImageView deleteimg;
        public FloatingActionButton fab;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            itemtime=itemView.findViewById(R.id.item_time);
            itemdate=itemView.findViewById(R.id.item_date);
            itemtitle=itemView.findViewById(R.id.item_title);
            itemdescription=itemView.findViewById(R.id.item_description);
            deleteimg = itemView.findViewById(R.id.item_delete);
            deleteimg.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if(mListener!=null){
                        int position = getAbsoluteAdapterPosition();
                        if(position!=RecyclerView.NO_POSITION){
                            mListener.OnDeleteClick(position);
                        }

                    }
                }
            });

        }

        public void setData(String title, String date, String time, String description) {
            itemtitle.setText(title);
            itemtime.setText(time);
            itemdate.setText(date);
            itemdescription.setText(description);
        }
    }
}
