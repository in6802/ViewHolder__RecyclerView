package com.example.edu.viewholder__recyclerview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.HashMap;

public class RecyclerViewActivity extends AppCompatActivity {
    RecyclerView recyclerView;
    RecyclerView.LayoutManager layoutManager;
    RecyclerAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

        ArrayList<HashMap<String, Object>> arrayList = new ArrayList<HashMap<String, Object>>();
        HashMap<String, Object> hashMap = null;

        //Add Data
        hashMap = new HashMap<String, Object>();
        hashMap.put("title", "Chapter One");
        hashMap.put("detail", "Item One Details");
        hashMap.put("image", R.drawable.android_image_1);
        arrayList.add(hashMap);


        hashMap = new HashMap<String, Object>();
        hashMap.put("title", "Chapter Two");
        hashMap.put("detail", "Item Two Details");
        hashMap.put("image", R.drawable.android_image_2);
        arrayList.add(hashMap);

        hashMap.put("title", "Chapter Three");
        hashMap.put("detail", "Item Three Details");
        hashMap.put("image", R.drawable.android_image_3);
        arrayList.add(hashMap);

        recyclerView = (RecyclerView)findViewById(R.id.recycler_view);
        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        adapter = new RecyclerAdapter(arrayList);
        recyclerView.setAdapter(adapter);

    }
}
