package com.example.edu.viewholder__recyclerview;

import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.HashMap;

public class RecyclerViewActivity extends AppCompatActivity {
    RecyclerView recyclerView;
    RecyclerView.LayoutManager layoutManager;
    RecyclerAdapter adapter;

    MyDBOpenHelper dbHelper;
    SQLiteDatabase db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ArrayList<HashMap<String, Object>> arrayList = new ArrayList<HashMap<String, Object>>();

        //Data Base
        // DB 생성
        dbHelper = new MyDBOpenHelper(this, "RecyclerView.db", null, 1);
        // DB 정보를 가져와
        db = dbHelper.getWritableDatabase();

        //Add Data
        putHashMap(arrayList);

        recyclerView = (RecyclerView)findViewById(R.id.recycler_view);
        layoutManager = new LinearLayoutManager(this);
        //layoutManager = new GridLayoutManager(this, 2);
        recyclerView.setLayoutManager(layoutManager);
        //arrayList
        //adapter = new RecyclerAdapter(arrayList);
        // DB  db에 넣어줌
        adapter = new RecyclerAdapter(db);
        recyclerView.setAdapter(adapter);
    }


    protected void putHashMap(ArrayList<HashMap<String, Object>> arrayList) {
        HashMap<String, Object> hashMap = null;

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
    }
}
