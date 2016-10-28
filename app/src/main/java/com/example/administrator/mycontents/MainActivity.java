package com.example.administrator.mycontents;

import android.content.ContentValues;
import android.content.Intent;
import android.provider.Contacts;
import android.provider.ContactsContract;
import android.provider.Telephony;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private EditText name;
    private EditText phone;
    private EditText qq;
    private EditText dizhi;
    private EditText danwei;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("添加联系人");
        name=(EditText) findViewById(R.id.name);
        phone=(EditText) findViewById(R.id.phone);
        qq=(EditText) findViewById(R.id.qq);
        dizhi=(EditText) findViewById(R.id.dizhi);
        danwei=(EditText) findViewById(R.id.danwei);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        menu.add(0,1,0,"添加");
        menu.add(0,2,0,"编辑");
        menu.add(0,3,0,"查看信息");
        menu.add(0,4,0,"删除");
        menu.add(0,5,0,"查询");
        menu.add(0,6,0,"导入到通讯录");
        menu.add(0,7,0,"退出");
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        Intent intent=new Intent();
        switch (item.getItemId()) {
            case 1:
                intent.setClass(this,AddContactsActivity.class);
                startActivity(intent);

        }
        return super.onOptionsItemSelected(item);
    }
}
