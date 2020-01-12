package com.example.coinmanage;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

import java.util.ArrayList;


public class MainActivity extends AppCompatActivity {

    public static QuanLyTaiChinhDatabase database;
    int id=0,tongThuNhap=0,tongChiTieu=0,tongNo=0;
    TextView textView1, textView2, textView3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        database=new QuanLyTaiChinhDatabase(this);

        try {
            AddChiTieuActivity.CapNhatDuLieu();
            AddThuNhapActivity.CapNhatDuLieu();
            AddNoActivity.CapNhatDuLieu();
        }catch (Exception e){}
        try{
            for(int i=0;i<ThuNhapActivity.thuNhaps.size();i++)
            {
                tongThuNhap+=ThuNhapActivity.thuNhaps.get(i).getTienThuNhap();
            }
        }catch (Exception e){

            ThuNhapActivity.thuNhaps=new ArrayList<>();
        }

        if(ChiTieuActivity.chiTieus==null)
        {
            ChiTieuActivity.chiTieus=new ArrayList<>();
        }
        else
        {
            for(int i=0;i<ChiTieuActivity.chiTieus.size();i++)
            {
                tongChiTieu+=ChiTieuActivity.chiTieus.get(i).getTienChiTieu();
            }
        }

        if(NoActivity.nos==null)
        {
            NoActivity.nos=new ArrayList<>();
        }
        else
        {
            tongNo=NoActivity.nos.size();
        }
        textView1=findViewById(R.id.txtTongThuNhap);
        textView1.setText(Integer.toString(tongThuNhap));

        textView2=findViewById(R.id.txtTongChiTieu);
        textView2.setText(Integer.toString(tongChiTieu));

        textView3=findViewById(R.id.txtTongNo);
        textView3.setText("Bạn có "+Integer.toString(tongNo)+" nợ cần giải quyết");
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
                Intent i=new Intent(MainActivity.this,ThuNhapActivity.class);
                startActivity(i);
            }
            break;
            case R.id.QuanLyChiTieu:
            {
                Intent i=new Intent(MainActivity.this,ChiTieuActivity.class);
                startActivity(i);
            }
            break;
            case R.id.QuanLyNo:
            {
                Intent i=new Intent(MainActivity.this,NoActivity.class);
                startActivity(i);
            }
            break;
            case R.id.TrangChu:
            {

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
