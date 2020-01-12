package com.example.coinmanage;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;

public class AddThuNhapActivity extends AppCompatActivity {

    Button btnXacNhan, btnQuayLai;
    EditText edtMieuTa, edtThuNhap;
    private String mieuta,tien;
    public static QuanLyTaiChinhDatabase db;
    private static int id=-1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_thu_nhap);
        db=new QuanLyTaiChinhDatabase(this);

        btnQuayLai=findViewById(R.id.btnQuayLai);
        btnXacNhan=findViewById(R.id.btnXacNhan);
        edtMieuTa=findViewById(R.id.edtMieuTa);
        edtThuNhap=findViewById(R.id.edtThuNhap);


        btnQuayLai.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(AddThuNhapActivity.this,ThuNhapActivity.class);
                startActivity(i);
                finish();
            }
        });

        btnXacNhan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                them(view);
            }
        });
    }
    public static void CapNhatDuLieu()
    {
        if(ThuNhapActivity.thuNhaps==null)
        {
            ThuNhapActivity.thuNhaps= new ArrayList<>();
        }
        else
        {
            ThuNhapActivity.thuNhaps.removeAll(ThuNhapActivity.thuNhaps);
        }
        Cursor cursor=db.layDuLieuThuNhap();
        if(cursor!=null)
        {
            do
            {
                ThuNhap t=new ThuNhap();
                t.setId(Integer.parseInt(cursor.getString(cursor.getColumnIndex(db.Key_id))));
                t.setMieuTaThuNhap(cursor.getString(cursor.getColumnIndex(db.Key_MieuTaThuNhap)));
                t.setTienThuNhap(Integer.parseInt(cursor.getString(cursor.getColumnIndex(db.Key_TienThuNhap))));
                ThuNhapActivity.thuNhaps.add(t);
            }while (cursor.moveToNext());
        }
    }

    public ThuNhap layDuLieu()
    {
        tien=edtThuNhap.getText().toString();
        mieuta=edtMieuTa.getText().toString();
        if(tien.trim().length()==0 || mieuta.trim().length()==0) {
            return null;
        }
        else
        {
            ThuNhap t= new ThuNhap();
            t.setId(id);
            t.setTienThuNhap(Integer.parseInt(tien));
            t.setMieuTaThuNhap(mieuta);
            return t;
        }
    }

    public void them(View view)
    {
        ThuNhap t1=layDuLieu();
        if(t1!=null)
        {
            if(ThuNhapActivity.thuNhaps==null)
            {
                ThuNhapActivity.thuNhaps=new ArrayList<ThuNhap>();
            }
            db.ThemThuNhap(t1);
            ThuNhapActivity.thuNhaps.add(t1);
            CapNhatDuLieu();

            edtThuNhap.setText(null);
            edtMieuTa.setText(null);
            id=-1;

        }
        else
        {
            Context context=getApplicationContext();
            (Toast.makeText(context,"Khong the luu",Toast.LENGTH_SHORT)).show();
        }
    }
}
