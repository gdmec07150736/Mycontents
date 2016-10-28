package com.example.administrator.mycontents;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.util.Log;

/**
 * Created by Administrator on 2016/10/26.
 */
public class table {
    private final static String tablename="table";
    private Mydb db;
    public table(Context context){
        db=new Mydb(context);
        if(!db.tableexist(tablename)){
            String createsql="create table if not exists"+tablename+"(id_db integer"+"primary key autoincrement"+
                    user.NAME+"varchar,"+
                    user.PHONE+"varchar,"+
                    user.QQ+"varchar"+
                    user.DANWEI+"varchar"+
                    user.DIZHI+"varchar)";
            db.createtable(createsql);
        }
    }
    public boolean adddata(user user){
        ContentValues value=new ContentValues();
        value.put(user.NAME,user.getName());
        value.put(user.PHONE,user.getName());
        value.put(user.DANWEI,user.getName());
        value.put(user.QQ,user.getName());
        value.put(user.DIZHI,user.getName());
        return db.save(tablename,value);
    }
    public user getuserbyid(int id){
        Cursor c=null;
        user temp=new user();
        try {
            c = db.select("select * from" + tablename + "where" + "id=?", new String[]{id + ""});
            c.moveToNext();
            temp.setId(c.getInt(c.getColumnIndex("id")));
            temp.setName(c.getString(c.getColumnIndex(user.NAME)));
            temp.setPhone(c.getString(c.getColumnIndex(user.PHONE)));
            temp.setQq(c.getString(c.getColumnIndex(user.QQ)));
            temp.setDizhi(c.getString(c.getColumnIndex(user.DIZHI)));
            Log.d("aa",temp.getName());
            return temp;
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            if(c!=null){
                c.close();
            }
            db.close();
        }
        return null;
    }
    public boolean update(user user){
        ContentValues value=new ContentValues();
        value.put(user.NAME,user.getName());
        value.put(user.PHONE,user.getPhone());
        value.put(user.DANWEI,user.getDanwei());
        value.put(user.QQ,user.getQq());
        value.put(user.DIZHI,user.getDizhi());
        return db.update(tablename,value,"id=?",new String[]{user.getId()+""});
    }
}
