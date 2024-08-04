package com.example.foodapp.Adapters;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.foodapp.Food_Details;
import com.example.foodapp.Models.Main_Model;
import com.example.foodapp.R;

import java.util.ArrayList;

public class Main_Adapter extends RecyclerView.Adapter<Main_Adapter.viewHOlder>{
ArrayList<Main_Model> list;
Context context;

    public Main_Adapter(ArrayList<Main_Model> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @NonNull
    @Override
    public viewHOlder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.sample_main,parent,false);

        return new viewHOlder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull viewHOlder holder, int position) {
Main_Model model =list.get(position);

holder.image.setImageResource(model.getImage());
holder.name.setText(model.getName());
holder.price.setText("Rs "+model.getPrice()+".00");
holder.desc.setText(model.getDescriptiion());

holder.itemView.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View view) {
        Intent intent =new Intent(context, Food_Details.class);
        intent.putExtra("name",model.getName());
        intent.putExtra("desc",model.getDescriptiion());
        intent.putExtra("quantity",1);
        intent.putExtra("img",model.getImage());
        intent.putExtra("price",model.getPrice());
        intent.putExtra("type",1);
        context.startActivity(intent);

    }
});

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class viewHOlder extends RecyclerView.ViewHolder {
        ImageView image;
        TextView name,desc,price;

        public viewHOlder(@NonNull View itemView) {

            super(itemView);
            image=itemView.findViewById(R.id.food_img);
            name=itemView.findViewById(R.id.food_name);
            desc=itemView.findViewById(R.id.food_desc);
            price=itemView.findViewById(R.id.food_price);
        }
    }
}
