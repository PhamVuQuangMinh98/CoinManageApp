package com.example.coinmanage;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class QuanLyTaiChinhDatabase extends SQLiteOpenHelper {

    //Tạo Database
    private static final int Database_version=1;
    private static final String Database_name="QuanLyTaiChinh";
    public static final String Key_id="_id";

    //Tạo bảng thu nhập
    private static final String Table_ThuNhap="ThuNhap";
    public static final String Key_MieuTaThuNhap="Mieu_ta_thu_nhap";
    public static final String Key_TienThuNhap="Tien_thu_nhap";

    //Tạo bảng chi tiêu
    private static final String Table_ChiTieu="ChiTieu";
    public static final String Key_MieuTaChiTieu="Mieu_ta_chi_tieu";
    public static final String Key_TienChiTieu="Tien_chi_tieu";
    public static final String Key_PhanLoai="Phan_loai";

    //Tạo bảng nợ
    private static final String Table_No="BangNo";
    public static final String Key_MieuTaNo="Mieu_ta_no";
    public static final String Key_TienNo="Tien_no";

    public QuanLyTaiChinhDatabase(Context context)
    {
        super(context,Database_name,null,Database_version);
    }
    @Override
    public void onCreate(SQLiteDatabase db) {
            String Create_ThuNhap_Table="CREATE TABLE "+ Table_ThuNhap + "("
                    +Key_id + " integer primary key autoincrement, "
                    +Key_MieuTaThuNhap + " text not null, "
                    +Key_TienThuNhap + " integer not null);";

            String Create_ChiTieu_Table="CREATE TABLE "+ Table_ChiTieu + "("
                    +Key_id + " integer primary key autoincrement, "
                    +Key_MieuTaChiTieu + " text not null, "
                    +Key_TienChiTieu + " integer not null, "
                    +Key_PhanLoai + " text not null);";

            String Create_No_Table="CREATE TABLE "+ Table_No + "("
                    +Key_id + " integer primary key autoincrement, "
                    +Key_MieuTaNo + " text not null, "
                    +Key_TienNo + " integer not null);";

            db.execSQL(Create_ChiTieu_Table);
            db.execSQL(Create_ThuNhap_Table);
            db.execSQL(Create_No_Table);

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }

    public void ThemThuNhap(ThuNhap thuNhap)
    {
        SQLiteDatabase db=this.getWritableDatabase();

        ContentValues content=new ContentValues();
        content.put(Key_MieuTaThuNhap,thuNhap.getMieuTaThuNhap());
        content.put(Key_TienThuNhap,thuNhap.getTienThuNhap());

        db.insert(Table_ThuNhap,null,content);
        db.close();
    }

    public void ThemChiTieu(ChiTieu chiTieu)
    {
        SQLiteDatabase db=this.getWritableDatabase();

        ContentValues content=new ContentValues();
        content.put(Key_MieuTaChiTieu,chiTieu.getMieuTaChiTieu());
        content.put(Key_TienChiTieu,chiTieu.getTienChiTieu());
        content.put(Key_PhanLoai,chiTieu.getPhanLoai());

        db.insert(Table_ChiTieu,null,content);
        db.close();
    }

    public void ThemNo(No no)
    {
        SQLiteDatabase db=this.getWritableDatabase();

        ContentValues content=new ContentValues();
        content.put(Key_MieuTaNo,no.getMieuTaNo());
        content.put(Key_TienNo,no.getTienNo());

        db.insert(Table_No,null,content);
        db.close();
    }

    public void XoaThuNhap(ThuNhap thuNhap)
    {
        SQLiteDatabase db=this.getWritableDatabase();
        db.delete(Table_ThuNhap, Key_MieuTaThuNhap + " = " + "'" + thuNhap.getMieuTaThuNhap() +"'",null);
        db.close();
    }

    public void XoaChiTieu(ChiTieu chiTieu)
    {
        SQLiteDatabase db=this.getWritableDatabase();
        db.delete(Table_ChiTieu, Key_MieuTaChiTieu + " = " + "'" + chiTieu.getMieuTaChiTieu() +"'",null);
        db.close();
    }

    public void XoaNo(No no)
    {
        SQLiteDatabase db=this.getWritableDatabase();
        db.delete(Table_No, Key_MieuTaNo + " = " + "'" + no.getMieuTaNo() +"'",null);
        db.close();
    }

    public Cursor layDuLieuThuNhap()
    {
        SQLiteDatabase db=this.getWritableDatabase();
        String[] cot={Key_id,Key_MieuTaThuNhap,Key_TienThuNhap};

        Cursor cursor=db.query(Table_ThuNhap,cot,null,null,null,null, Key_id+ " DESC");
        if (cursor!=null)
        {
            cursor.moveToFirst();
        }else return null;
        return cursor;
    }

    public Cursor layDuLieuChiTieu()
    {
        SQLiteDatabase db=this.getWritableDatabase();
        String[] cot={Key_id,Key_MieuTaChiTieu,Key_TienChiTieu,Key_PhanLoai};

        Cursor cursor=db.query(Table_ChiTieu,cot,null,null,null,null, Key_id+ " DESC");
        if (cursor!=null)
        {
            cursor.moveToFirst();
        }else return null;
        return cursor;
    }

    public Cursor layDuLieuNo()
    {
        SQLiteDatabase db=this.getWritableDatabase();
        String[] cot={Key_id,Key_MieuTaNo,Key_TienNo};

        Cursor cursor=db.query(Table_No,cot,null,null,null,null, Key_id+ " DESC");
        if (cursor!=null)
        {
            cursor.moveToFirst();
        }else return null;
        return cursor;
    }
}
