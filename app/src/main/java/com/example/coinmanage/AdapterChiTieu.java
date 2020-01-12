package com.example.coinmanage;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class AdapterChiTieu extends BaseAdapter {
    LayoutInflater inflater;
    TextView textView;
    ImageView imageView;
    Context context;

    public AdapterChiTieu(Context context)
    {
        inflater=LayoutInflater.from(context);
        this.context=context;
    }
    @Override
    public int getCount() {
        return ChiTieuActivity.chiTieus.size();
    }

    @Override
    public Object getItem(int i) {
        return ChiTieuActivity.chiTieus.get(i);
    }

    @Override
    public long getItemId(int i) {
        return ChiTieuActivity.chiTieus.get(i).getId();
    }

    @Override
    public View getView(final int i, View convertView, ViewGroup parent) {
        View view=inflater.inflate(R.layout.list_view_chi_tieu,null);
        textView=view.findViewById(R.id.txtListChiTieu);
        textView.setText(Integer.toString(ChiTieuActivity.chiTieus.get(i).getTienChiTieu()));

        textView=view.findViewById(R.id.txtListMieuTaChiTieu);
        textView.setText(ChiTieuActivity.chiTieus.get(i).getMieuTaChiTieu());

        textView=view.findViewById(R.id.txtListPhanLoai);
        textView.setText(ChiTieuActivity.chiTieus.get(i).getPhanLoai());

        imageView=view.findViewById(R.id.imgXoa1);
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ChiTieuActivity.db.XoaChiTieu(ChiTieuActivity.chiTieus.get(i));
                ChiTieuActivity.chiTieus.remove(i);
                notifyDataSetChanged();
            }
        });
        return view;
    }
}
