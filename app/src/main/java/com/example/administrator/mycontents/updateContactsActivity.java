package com.example.administrator.mycontents;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.Toast;


public class updateContactsActivity extends AppCompatActivity {
    private EditText name;
    private EditText phone;
    private EditText qq;
    private EditText danwei;
    private EditText dizhi;
    private user user;


    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.edit);
        name=(EditText) findViewById(R.id.name);
        phone=(EditText) findViewById(R.id.phone);
        qq=(EditText) findViewById(R.id.qq);
        danwei=(EditText) findViewById(R.id.danwei);
        dizhi=(EditText) findViewById(R.id.dizhi);
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        menu.add(Menu.NONE,1,Menu.NONE,"保存");
        menu.add(Menu.NONE,2,Menu.NONE,"返回");
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch(item.getItemId()){
            case 1:
                if(!name.getText().toString().equals("")){
                    user user=new user();
                    user.setName(name.getText().toString());
                    user.setPhone(phone.getText().toString());
                    user.setQq(qq.getText().toString());
                    user.setDanwei(danwei.getText().toString());
                    user.setDizhi(dizhi.getText().toString());
                    table t=new table(this);
                    if(t.adddata(user)){
                        Toast.makeText(this,"ok",Toast.LENGTH_SHORT).show();
                        finish();
                    }else{
                        Toast.makeText(this,"fail",Toast.LENGTH_SHORT).show();
                    }
                    break;
                }
            case 2:finish();break;
            default:break;
        }
        return super.onOptionsItemSelected(item);
    }
}
