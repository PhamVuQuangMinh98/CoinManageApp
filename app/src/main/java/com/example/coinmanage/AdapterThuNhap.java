package com.example.coinmanage;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;


public class AdapterThuNhap extends BaseAdapter {
    LayoutInflater inflater;
    TextView textView;
    ImageView imageView;
    Context context;
    public AdapterThuNhap(Context context)
    {
        inflater=LayoutInflater.from(context);
        this.context=context;
    }
    @Override
    public int getCount() {
        return ThuNhapActivity.thuNhaps.size();
    }

    @Override
    public Object getItem(int i) {
        return ThuNhapActivity.thuNhaps.get(i);
    }

    @Override
    public long getItemId(int i) {
        return ThuNhapActivity.thuNhaps.get(i).getId();
    }

    @Override
    public View getView(final int i, View convertView, ViewGroup parent) {

        View view = inflater.inflate(R.layout.list_view_thu_nhap,null);
        textView =view.findViewById(R.id.txtListThuNhap);
        textView.setText(Integer.toString(ThuNhapActivity.thuNhaps.get(i).getTienThuNhap()));

        textView=view.findViewById(R.id.txtListMieuTaThuNhap);
        textView.setText(ThuNhapActivity.thuNhaps.get(i).getMieuTaThuNhap());

        imageView=view.findViewById(R.id.imgXoa);
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ThuNhapActivity.db.XoaThuNhap(ThuNhapActivity.thuNhaps.get(i));
                ThuNhapActivity.thuNhaps.remove(i);
                notifyDataSetChanged();
            }
        });
        return view;
    }
}
