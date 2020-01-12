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

public class AddNoActivity extends AppCompatActivity {

    Button btnXacNhan, btnQuayLai;
    EditText edtMieuTa, edtNo;
    private String mieuta, tien;
    private static int id=-1;
    public static QuanLyTaiChinhDatabase db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_no);
        db=new QuanLyTaiChinhDatabase(this);

        btnQuayLai=findViewById(R.id.btnQuayLai1);
        btnXacNhan=findViewById(R.id.btnXacNhan1);
        edtMieuTa=findViewById(R.id.edtMieuTa1);
        edtNo=findViewById(R.id.edtNo);

        btnQuayLai.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(AddNoActivity.this,NoActivity.class);
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
        if(NoActivity.nos==null)
        {
            NoActivity.nos=new ArrayList<>();
        }
        else
        {
            NoActivity.nos.removeAll(NoActivity.nos);
        }
        Cursor cursor=db.layDuLieuNo();
        if(cursor!=null)
        {
            do
            {
                No n=new No();
                n.setId(Integer.parseInt(cursor.getString(cursor.getColumnIndex(db.Key_id))));
                n.setMieuTaNo(cursor.getString(cursor.getColumnIndex(db.Key_MieuTaNo)));
                n.setTienNo(Integer.parseInt(cursor.getString(cursor.getColumnIndex(db.Key_TienNo))));
                NoActivity.nos.add(n);
            }while (cursor.moveToNext());
        }
    }

    public No layDuLieu()
    {
        tien=edtNo.getText().toString();
        mieuta=edtMieuTa.getText().toString();
        if(tien.trim().length()==0 || mieuta.trim().length()==0) {
            return null;
        }
        else
        {
            No n=new No();
            n.setId(id);
            n.setMieuTaNo(mieuta);
            n.setTienNo(Integer.parseInt(tien));
            return n;
        }
    }

    public void them(View view)
    {
        No n1=layDuLieu();
        if(n1!=null)
        {
            if(NoActivity.nos==null)
            {
                NoActivity.nos=new ArrayList<>();
            }
            db.ThemNo(n1);
            NoActivity.nos.add(n1);
            CapNhatDuLieu();

            edtNo.setText(null);
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
