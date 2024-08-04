package com.example.foodapp;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import com.example.foodapp.Models.Main_Model;
import com.example.foodapp.Models.Order_Model;

import java.util.ArrayList;

public class myFoodDb extends SQLiteOpenHelper {

    public myFoodDb(@Nullable Context context) {
        super(context,"foodDatabase.db", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {

        sqLiteDatabase.execSQL(" CREATE TABLE recipe " +
                               "( id INTEGER PRIMARY KEY AUTOINCREMENT," +
                                "f_name TEXT," +
                                "f_desc TEXT," +
                                 "f_price INT," +
                                 "quantity INT," +
                                 "p_name TEXT," +
                                  "number TEXT," +
                "image INT," +

                                   "adress TEXT)");

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS foodDatabase.db");

        onCreate(sqLiteDatabase);


    }

    public boolean saveData(String f_name,String f_desc,int f_price,int quantity,String p_name,String number,String adress,int image)
    {

        SQLiteDatabase database = this.getReadableDatabase();
        ContentValues values = new ContentValues();
        values.put("f_name",f_name);
        values.put("f_desc",f_desc);
        values.put("f_price",f_price);
        values.put("quantity",quantity);
        values.put("image",image);
        values.put("p_name",p_name);
        values.put("number",number);
        values.put("adress",adress);


       long is_insert= database.insert("recipe",null,values);
       if (is_insert<=0){
           return false;
       }
       else {
           return true;
       }
    }

    public ArrayList<Order_Model> showData(){
        SQLiteDatabase database =this.getWritableDatabase();

      Cursor curser= database.rawQuery("SELECT * FROM recipe",null);
      ArrayList<Order_Model> list =new ArrayList<>();
while (curser.moveToNext()){

    Order_Model model = new Order_Model();
    model.setId(curser.getInt(0));
    model.setF_name(curser.getString(1));
    model.setF_disc(curser.getString(2));
    model.setPrice(curser.getInt(3));
    model.setQuantity(curser.getInt(4));
model.setImage(curser.getInt(7));
    model.setName(curser.getString(5));
    model.setNumber(curser.getString(6));
    model.setAdress(curser.getString(8));


list.add(model);

}

return list;

    }

    public Cursor getById(int id){

        SQLiteDatabase database =this.getWritableDatabase();

        Cursor cursor= database.rawQuery("SELECT * FROM recipe WHERE id= "+id,null);
if (cursor!=null){
    cursor.moveToFirst();
}
return cursor;
    }

public boolean updateData(int id,String f_name,String f_desc,int f_price,int quantity,String p_name,String number,String adress,int image){
        SQLiteDatabase database=this.getWritableDatabase();
    ContentValues values = new ContentValues();
    values.put("f_name",f_name);
    values.put("f_desc",f_desc);
    values.put("f_price",f_price);
    values.put("quantity",quantity);
    values.put("image",image);
    values.put("p_name",p_name);
    values.put("number",number);
    values.put("adress",adress);
   long is_insert=database.update("recipe",values,"id="+id,null);


    if (is_insert<=0){
        return false;
    }
    else {
        return true;
    }


}
public boolean delete(int id){
        SQLiteDatabase database =this.getWritableDatabase();
      long is_insert= database.delete("recipe","id="+id,null);
    if (is_insert<=0){
        return false;
    }
    else {
        return true;
    }

}
}
