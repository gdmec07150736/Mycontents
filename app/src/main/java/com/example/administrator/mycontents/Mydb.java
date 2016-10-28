package com.example.administrator.mycontents;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class Mydb extends SQLiteOpenHelper {
    private static String dbname="My_db.db";
    private static int dbversion=2;
    private SQLiteDatabase db;
    public Mydb(Context context){
        super(context,dbname,null,dbversion);
        db=getWritableDatabase();
        
    }

   public SQLiteDatabase open(){
       if(!db.isOpen()){
           db=getWritableDatabase();
       }
       return db;
   }
    public void close(){
        try {
            if (db != null && db.isOpen()) {
                db.close();
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    public boolean createtable(String tablesql){
        try{
            open();
            db.execSQL(tablesql);
        }catch (SQLException e){
            e.printStackTrace();
            return false;
        }finally {
            close();
        }
        return true;
    }
    public boolean save(String table,ContentValues value){
        try{
            open();
            db.insert(table,null,value);
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }finally {
            close();
        }
        return true;
    }
    public boolean update(String table,ContentValues value,String whereclause,String[] whereargs){
        try {
            open();
            db.update(table,value,whereclause,whereargs);
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }finally {
            close();
        }
        return true;
    }
    public boolean delete(String table,String delsql,String ob[]){
        try{
            open();
            db.delete(table,delsql,ob);
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }finally {
            close();
        }
        return true;
    }
    public Cursor select(String selsql,String ob[]){
        try{
            open();
            Cursor c=db.rawQuery(selsql,ob);
            return c;
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }
    public boolean tableexist(String table){
        try{
            open();
            String s="select count(*)xcount from "+table;
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }finally {
            close();
        }
        return true;
    }
}
