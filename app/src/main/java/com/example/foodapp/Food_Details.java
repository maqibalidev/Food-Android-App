package com.example.foodapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.foodapp.Models.Main_Model;

import java.util.concurrent.ForkJoinPool;

public class Food_Details extends AppCompatActivity {

ImageView foodImage,inc,dec;
TextView food_name,food_price,food_desc,food_quantity;
EditText user_name,user_number,user_adress;
Button button;
    int rs,quantity;
    int updated;
    Cursor cursor;
    int i;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_food_details);

        foodImage=findViewById(R.id.imageView);
        food_name=findViewById(R.id.f_name);
        food_desc=findViewById(R.id.disc);
        food_price=findViewById(R.id.f_price);
        food_quantity=findViewById(R.id.quantity);
        inc=findViewById(R.id.increment);
        dec=findViewById(R.id.decrement);
        button=findViewById(R.id.orderBtn);
        user_name=findViewById(R.id.edit_name);
        user_number=findViewById(R.id.editPhone);
        user_adress=findViewById(R.id.editAdress);
        i = getIntent().getIntExtra("quantity",0);
int a =getIntent().getIntExtra("img",00000);

        food_name.setText(getIntent().getStringExtra("name"));
        food_desc.setText(getIntent().getStringExtra("desc"));

        
        foodImage.setImageResource(a);
rs=getIntent().getIntExtra("price",0);
quantity=getIntent().getIntExtra("quantity",0);

         food_quantity.setText(String.valueOf(i));
updated=rs*getIntent().getIntExtra("quantity",0);
        food_price.setText("Rs "+updated+".00");
         inc.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View view) {
int newValue = rs;


  i++;

    food_quantity.setText(""+i);
updated = newValue*i;
food_price.setText("Rs "+updated+".00");

             }

         });


         dec.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View view) {

                 if (i <= 1) {
                     i = 1;
                 } else {
                     i--;
                 }
                 food_quantity.setText("" + i);



if (updated<=rs){
    updated=rs;
}




                 else {
    int newValue = rs;

    updated=newValue*i;
    food_price.setText("Rs " + updated + ".00");
}
                 }





         });
        myFoodDb db =new myFoodDb(Food_Details.this);


if(getIntent().getIntExtra("type",0)==1){

    getSupportActionBar().setTitle("Order Food");

    button.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            if (user_name.getText().toString().isEmpty()){
                user_name.setError("please enter name");
            }
            else if (user_number.getText().toString().isEmpty()){
                user_number.setError("please enter number");
            }
            else if (user_adress.getText().toString().isEmpty()){
                user_adress.setError("please enter adress");
            }
            else {
                Boolean is_save=   db.saveData(food_name.getText().toString(),food_desc.getText().toString()
                        ,getIntent().getIntExtra("price",0),Integer.parseInt(food_quantity.getText().toString()),
                        user_name.getText().toString(),user_number.getText().toString(),user_adress.getText().toString(),a);

                
                if(is_save) {

                    Toast.makeText(Food_Details.this, "order saved", Toast.LENGTH_SHORT).show();
                    button.setClickable(false);
                }
                else {
                    Toast.makeText(Food_Details.this, "cant save order", Toast.LENGTH_SHORT).show();
                }

            }



        }
    });

}
else {


getSupportActionBar().setTitle("Update Order");
cursor = db.getById(getIntent().getIntExtra("id",0));



    food_name.setText(cursor.getString(1));
    food_desc.setText(cursor.getString(2));
    food_price.setText("Rs "+updated+".00");
    food_quantity.setText(cursor.getInt(4)+"");
    foodImage.setImageResource(cursor.getInt(7));
    user_name.setText(cursor.getString(5));
   user_number.setText(cursor.getString(6));
    user_adress.setText(cursor.getString(8));



button.setText("Update Order");


    button.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            if (user_name.getText().toString().isEmpty()){
                user_name.setError("please enter name");
            }
            else if (user_number.getText().toString().isEmpty()){
                user_number.setError("please enter number");
            }
            else if (user_adress.getText().toString().isEmpty()){
                user_adress.setError("please enter adress");
            }
            else {
                Boolean is_save=   db.updateData(getIntent().getIntExtra("id",0),food_name.getText().toString(),food_desc.getText().toString()
                        ,getIntent().getIntExtra("price",0),Integer.parseInt(food_quantity.getText().toString()),
                        user_name.getText().toString(),user_number.getText().toString(),user_adress.getText().toString(),a);

                if(is_save) {

                    Toast.makeText(Food_Details.this, "Order Updated", Toast.LENGTH_SHORT).show();
                    button.setClickable(false);
                }
                else {
                    Toast.makeText(Food_Details.this, "cant update order", Toast.LENGTH_SHORT).show();
                }

            }



        }
    });










}






    }

    @Override
    public void onBackPressed() {
        if (getIntent().getIntExtra("type",0)==2){
            Intent intent =new Intent(Food_Details.this,orders.class);
            startActivity(intent);
        }
else {
            super.onBackPressed();
        }}
}