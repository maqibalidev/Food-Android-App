package com.example.foodapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import com.example.foodapp.Adapters.Main_Adapter;
import com.example.foodapp.Models.Main_Model;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
RecyclerView recyclerView;
Main_Adapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
getSupportActionBar().setTitle("Food Recipes");
        recyclerView=findViewById(R.id.recyc);

        LinearLayoutManager layoutManager =new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);

        ArrayList<Main_Model> list =new ArrayList<>();

        list.add(new Main_Model(R.drawable.aaa,"Food 1","dasdadsanjdnjasnjdnjandjkankdnajknsdjanjdnajsndjandjnajksdnjadnjan"
        ,45));
        list.add(new Main_Model(R.drawable.bb,"Food 2","dasdadsanjdnjasnjdnjandjkankdnajknsdjanjdnajsndjandjnajksdnjadnjan"
                ,66));
        list.add(new Main_Model(R.drawable.cc,"Food 3","dasdadsanjdnjasnjdnjandjkankdnajknsdjanjdnajsndjandjnajksdnjadnjan"
                ,22));
        list.add(new Main_Model(R.drawable.dd,"Food 4","dasdadsanjdnjasnjdnjandjkankdnajknsdjanjdnajsndjandjnajksdnjadnjan"
                ,32));
        list.add(new Main_Model(R.drawable.gg,"Food 5","dasdadsanjdnjasnjdnjandjkankdnajknsdjanjdnajsndjandjnajksdnjadnjan"
                ,11));
        list.add(new Main_Model(R.drawable.hh,"Food 6","dasdadsanjdnjasnjdnjandjkankdnajknsdjanjdnajsndjandjnajksdnjadnjan"
                ,6));

adapter = new Main_Adapter(list,MainActivity.this);

recyclerView.setAdapter(adapter);



    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu,menu);

        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId()==R.id.order){
            Intent intent = new Intent(MainActivity.this,orders.class);
            startActivity(intent);
        }

        return super.onOptionsItemSelected(item);
    }
}