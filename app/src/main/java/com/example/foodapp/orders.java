package com.example.foodapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.example.foodapp.Adapters.Main_Adapter;
import com.example.foodapp.Adapters.Order_Adapter;
import com.example.foodapp.Models.Main_Model;
import com.example.foodapp.Models.Order_Model;

import java.util.ArrayList;

public class orders extends AppCompatActivity {
    RecyclerView recyclerView;
    Order_Adapter adapter;
    TextView records;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_orders);
getSupportActionBar().setTitle("Orders");
records=findViewById(R.id.records);

        recyclerView=findViewById(R.id.orders_recyc);

        LinearLayoutManager layoutManager =new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);

        myFoodDb db =new myFoodDb(orders.this);
        ArrayList<Order_Model> list=db.showData();
if (list.isEmpty()){
    records.setVisibility(View.VISIBLE);
}

   else {
    adapter = new Order_Adapter(list, orders.this);
    recyclerView.setAdapter(adapter);
}




    }

    @Override
    public void onBackPressed() {
        Intent intent =new Intent(orders.this,MainActivity.class);
        startActivity(intent);
    }
}