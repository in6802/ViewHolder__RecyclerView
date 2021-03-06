package com.example.edu.viewholder__recyclerview;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.annotation.NonNull;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.sql.SQLClientInfoException;
import java.util.ArrayList;
import java.util.Date;
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

    //DB--------------------------------------------------------------------------
    private SQLiteDatabase mdb;
    public RecyclerAdapter(SQLiteDatabase db){
        this.mdb = db;
        //
        쿼리로
                
        String query = new StringBuilder().append("select...").toString();
        Cursor cursor = mdb.rawQuery(query, null);
        ArrayList<HashMap<String, Object>> arrayListTemp = new ArrayList<>();
        HashMap<String, Object> hashMap = null;
        while (cursor.moveToNext()) {
            hashMap = new HashMap<String, Object>();
            hashMap.put("itemTitle", cursor.getShort(0));
            arrayList.add(hashMap);
        }
        this.arrayList = arrayListTemp;
    }

    //HASHMAP--------------------------------------------------------------------------
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
    public void onBindViewHolder(@NonNull final MyViewHolder holder, int position) {
        HashMap<String, Object> hashMap = arrayList.get(position);

        /*holder.itemImage.setImageResource((Integer)hashMap.get("image"));
        holder.itemTitle.setText((String)hashMap.get("title"));
        holder.itemImage.setImageResource((Integer)hashMap.get("image"));*/

        holder.itemImage.setImageResource((Integer)hashMap.get("image"));
        holder.itemTitle.setText("0");
        holder.itemTitle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Integer count = Integer.parseInt(((TextView)holder.itemTitle).getText().toString())+1;
                ((TextView)holder.itemTitle).setText(count.toString());
                Toast.makeText(view.getContext(), ((TextView)view).getText(), Toast.LENGTH_SHORT).show();
                Date date = new Date();

                //DB 추가
                //insertRecord(mdb, count, date);
            }
        });
    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }
}
/*
adapter -
        값을 가지고 있고 뷰에 표시해줌

        그러나 내부 데이터가 변경되면 알아차리지는 못함
        그래서 함수 호출해줘야함.
        notifyDataSetChanged();

*/
