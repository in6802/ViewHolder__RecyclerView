package com.example.edu.viewholder__recyclerview;

import android.support.annotation.NonNull;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashMap;

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.MyViewHolder> {

    class MyViewHolder extends RecyclerView.ViewHolder{
        public ImageView itemImage;
        public TextView itemTitle, itemDetail;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            itemImage = itemView.findViewById(R.id.item_image);
            itemTitle = itemView.findViewById(R.id.item_title);
            itemDetail = itemView.findViewById(R.id.item_detail);
        }
    }


    ArrayList<HashMap<String, Object>> arrayList = null;
    public RecyclerAdapter(ArrayList<HashMap<String, Object>> arrayList){
        this.arrayList = new ArrayList<>();
        this.arrayList = arrayList;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflate = LayoutInflater.from(parent.getContext());
        View view = inflate.inflate(R.layout.item_cardlayout, parent, false);
        MyViewHolder viewHolder = new MyViewHolder(view);

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        HashMap<String, Object> hashMap = arrayList.get(position);

        holder.itemImage.setImageResource((Integer)hashMap.get("image"));
        holder.itemTitle.setText((String)hashMap.get("title"));
        holder.itemImage.setImageResource((Integer)hashMap.get("image"));

    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }
}
