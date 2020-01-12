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

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;

public class AddChiTieuActivity extends AppCompatActivity {

    Button btnXacNhan, btnQuayLai;
    EditText edtMieuTa, edtChiTieu, edtPhanLoai;
    FloatingActionButton fab,fab1,fab2,fab3,fab4;
    boolean isFABopen;
    private String mieuta,tien,phanloai;
    private int id=-1;
    public static QuanLyTaiChinhDatabase db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_chi_tieu);
        db=new QuanLyTaiChinhDatabase(this);

        btnQuayLai=findViewById(R.id.btnQuayLai2);
        btnXacNhan=findViewById(R.id.btnXacNhan2);
        edtMieuTa=findViewById(R.id.edtMieuTa2);
        edtChiTieu=findViewById(R.id.edtChiTieu);
        edtPhanLoai=findViewById(R.id.edtPhanLoai);
        edtPhanLoai.setText(R.string.ThucPham);
        edtPhanLoai.setEnabled(false);


        fab=findViewById(R.id.fabPhanLoai);
        fab1=findViewById(R.id.fabFood);
        fab2=findViewById(R.id.fabHome);
        fab3=findViewById(R.id.fabJoystick);
        fab4=findViewById(R.id.fabMedicine);

        btnQuayLai.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(AddChiTieuActivity.this,ChiTieuActivity.class);
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

        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(!isFABopen)
                {
                    showFAB();
                }
                else
                {
                    closeFAB();
                }
            }
        });

        fab1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                edtPhanLoai.setText(R.string.ThucPham);
            }
        });

        fab2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                edtPhanLoai.setText(R.string.DoGiaDung);
            }
        });

        fab3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                edtPhanLoai.setText(R.string.GiaiTri);
            }
        });

        fab4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                edtPhanLoai.setText(R.string.ThuocMen);
            }
        });
    }

    private void showFAB()
    {
        isFABopen=true;
        fab1.animate().translationY(-150);
        fab2.animate().translationY(-300);
        fab3.animate().translationY(-150);
        fab3.animate().translationX(-200);
        fab4.animate().translationY(-300);
        fab4.animate().translationX(-200);
    }

    private void closeFAB()
    {
        isFABopen=false;
        fab1.animate().translationY(0);
        fab2.animate().translationY(0);
        fab3.animate().translationY(0);
        fab4.animate().translationY(0);
        fab3.animate().translationX(0);
        fab4.animate().translationX(0);
    }

    public static void CapNhatDuLieu()
    {
        if(ChiTieuActivity.chiTieus==null)
        {
            ChiTieuActivity.chiTieus=new ArrayList<>();
        }
        else
        {
            ChiTieuActivity.chiTieus.removeAll(ChiTieuActivity.chiTieus);
        }
        Cursor cursor=db.layDuLieuChiTieu();
        if(cursor!=null)
        {
            do
            {
                ChiTieu c=new ChiTieu();
                c.setId(Integer.parseInt(cursor.getString(cursor.getColumnIndex(db.Key_id))));
                c.setMieuTaChiTieu(cursor.getString(cursor.getColumnIndex(db.Key_MieuTaChiTieu)));
                c.setTienChiTieu(Integer.parseInt(cursor.getString(cursor.getColumnIndex(db.Key_TienChiTieu))));
                c.setPhanLoai(cursor.getString(cursor.getColumnIndex(db.Key_PhanLoai)));
                ChiTieuActivity.chiTieus.add(c);
            }while (cursor.moveToNext());
        }
    }
    public ChiTieu layDuLieu()
    {
        tien=edtChiTieu.getText().toString();
        mieuta=edtMieuTa.getText().toString();
        phanloai=edtPhanLoai.getText().toString();
        if(tien.trim().length()==0 || mieuta.trim().length()==0) {
            return null;
        }
        else
        {
            ChiTieu c=new ChiTieu();
            c.setId(id);
            c.setTienChiTieu(Integer.parseInt(tien));
            c.setMieuTaChiTieu(mieuta);
            c.setPhanLoai(phanloai);
            return c;
        }
    }
    public void them(View view)
    {
            ChiTieu c1=layDuLieu();
            if(c1!=null) {
                if (ChiTieuActivity.chiTieus == null) {
                    ChiTieuActivity.chiTieus = new ArrayList<>();
                }
                db.ThemChiTieu(c1);
                ChiTieuActivity.chiTieus.add(c1);
                CapNhatDuLieu();

                edtChiTieu.setText(null);
                edtMieuTa.setText(null);
            }
            else
            {
                Context context=getApplicationContext();
                (Toast.makeText(context,"Khong the luu",Toast.LENGTH_SHORT)).show();
            }
    }
}
