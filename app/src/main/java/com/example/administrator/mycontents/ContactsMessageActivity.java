package com.example.administrator.mycontents;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

public class ContactsMessageActivity extends AppCompatActivity {
    private TextView name;
    private TextView phone;
    private TextView qq;
    private TextView danwei;
    private TextView dizhi;
    private user user;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("联系人信息");
        name=(TextView) findViewById(R.id.name);
        phone=(TextView) findViewById(R.id.phone);
        qq=(TextView) findViewById(R.id.qq);
        danwei=(TextView) findViewById(R.id.danwei);
        dizhi=(TextView) findViewById(R.id.dizhi);
        Bundle localb=getIntent().getExtras();
        int id=localb.getInt("user_id");
        table t=new table(this);
        user =t.getuserbyid(id);
        name.setText(""+user.getName());
        phone.setText(""+user.getPhone());
        qq.setText(""+user.getQq());
        danwei.setText(""+user.getDanwei());
        dizhi.setText(""+user.getDizhi());
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        menu.add(Menu.NONE,1,Menu.NONE,"返回");
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case 1:finish();break;
            default:break;
        }
        return super.onOptionsItemSelected(item);
    }
}
