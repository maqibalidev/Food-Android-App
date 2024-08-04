package com.example.foodapp.Adapters;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatDialog;
import androidx.recyclerview.widget.RecyclerView;

import com.example.foodapp.Food_Details;
import com.example.foodapp.Models.Main_Model;
import com.example.foodapp.Models.Order_Model;
import com.example.foodapp.R;
import com.example.foodapp.myFoodDb;

import java.util.ArrayList;

public class Order_Adapter extends RecyclerView.Adapter<Order_Adapter.viewHolder>{
    ArrayList<Order_Model> list;
    Context context;

    public Order_Adapter(ArrayList<Order_Model> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @NonNull
    @Override
    public viewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.sample_orders,parent,false);

        return new viewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull viewHolder holder, int position) {

        Order_Model model =list.get(position);

        holder.image.setImageResource(model.getImage());
        holder.name.setText(model.getF_name());
        holder.price.setText("Rs "+model.getPrice()+".00");
        holder.desc.setText(model.getF_disc());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent =new Intent(context, Food_Details.class);
                intent.putExtra("id",model.getId());
                intent.putExtra("name",model.getName());
                intent.putExtra("desc",model.getF_disc());
                intent.putExtra("img",model.getImage());
                intent.putExtra("price",model.getPrice());
              intent.putExtra("quantity",model.getQuantity());
                intent.putExtra("type",2);
                context.startActivity(intent);
                ((Activity)context).finish();
            }
        });

        com.example.foodapp.myFoodDb db =new myFoodDb(context);

holder.itemView.setOnLongClickListener(new View.OnLongClickListener() {
    @Override
    public boolean onLongClick(View view) {


     AlertDialog dialog =new AlertDialog.Builder(context)
             .setTitle("Delete Item")
             .setMessage("Are You Sure?")
             .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                 @Override
                 public void onClick(DialogInterface dialogInterface, int i) {

                     boolean isDelted=db.delete(model.getId());
                     if (isDelted){
                         Toast.makeText(context, "deletd", Toast.LENGTH_SHORT).show();
                         Intent intent =new Intent(context,com.example.foodapp.orders.class);
                         context.startActivity(intent);
                         ((Activity)context).finish();
                     }
                     else {
                         Toast.makeText(context, "can't delete", Toast.LENGTH_SHORT).show();
                     }
                 }
             }).setNegativeButton("No", new DialogInterface.OnClickListener() {
                 @Override
                 public void onClick(DialogInterface dialogInterface, int i) {


                 }
             })
             .show();






        return true;
    }
});
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class viewHolder extends RecyclerView.ViewHolder {
        ImageView image;
        TextView name,desc,price;

        public viewHolder(@NonNull View itemView) {
            super(itemView);
            image=itemView.findViewById(R.id.order_img);
            name=itemView.findViewById(R.id.order_name);
            desc=itemView.findViewById(R.id.order_desc);
            price=itemView.findViewById(R.id.order_price);

        }
    }

}
