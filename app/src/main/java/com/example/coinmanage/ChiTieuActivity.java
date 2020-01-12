package com.example.coinmanage;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ListView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;

public class ChiTieuActivity extends AppCompatActivity {

    FloatingActionButton fab;
    ListView listView;
    public static ArrayList<ChiTieu>chiTieus;
    public static QuanLyTaiChinhDatabase db;
    int id;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chi_tieu);
        Toolbar toolbar = findViewById(R.id.toolbar3);
        setSupportActionBar(toolbar);
        listView=findViewById(R.id.listChiTieu);
        db=new QuanLyTaiChinhDatabase(this);

        try {
            AddChiTieuActivity.CapNhatDuLieu();
        }catch (Exception e){}
        if(chiTieus!=null)
        {
            listView.setAdapter(new AdapterChiTieu(getApplicationContext()));
        }

        id=0;
        fab=findViewById(R.id.fabThemChiTieu);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(ChiTieuActivity.this,AddChiTieuActivity.class);
                startActivity(i);
                finish();
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        id = item.getItemId();

        //noinspection SimplifiableIfStatement
        switch (id)
        {
            case R.id.QuanLyNguonThu:
            {
                Intent i=new Intent(ChiTieuActivity.this,ThuNhapActivity.class);
                startActivity(i);
                finish();
            }
            break;
            case R.id.QuanLyChiTieu:
            {

            }
            break;
            case R.id.QuanLyNo:
            {
                Intent i=new Intent(ChiTieuActivity.this,NoActivity.class);
                startActivity(i);
                finish();
            }
            break;
            case R.id.TrangChu:
            {
                Intent i=new Intent(ChiTieuActivity.this,MainActivity.class);
                startActivity(i);
                finish();
            }
            break;
            default:
            {
                //
            }
        }

        return super.onOptionsItemSelected(item);
    }
}
