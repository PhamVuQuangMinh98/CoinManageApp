package com.example.coinmanage;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class AdapterNo extends BaseAdapter {
    LayoutInflater inflater;
    TextView textView;
    ImageView imageView;
    Context context;

    public AdapterNo(Context context)
    {
        inflater=LayoutInflater.from(context);
        this.context=context;
    }
    @Override
    public int getCount() {
        return NoActivity.nos.size();
    }

    @Override
    public Object getItem(int i) {
        return NoActivity.nos.get(i);
    }

    @Override
    public long getItemId(int i) {
        return NoActivity.nos.get(i).getId();
    }

    @Override
    public View getView(final int i, View convertView, ViewGroup parent) {
        View view=inflater.inflate(R.layout.list_view_no,null);
        textView=view.findViewById(R.id.txtListNo);
        textView.setText(Integer.toString(NoActivity.nos.get(i).getTienNo()));

        textView=view.findViewById(R.id.txtListMieuTaNo);
        textView.setText(NoActivity.nos.get(i).getMieuTaNo());

        imageView=view.findViewById(R.id.imgXoa2);
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                NoActivity.db.XoaNo(NoActivity.nos.get(i));
                NoActivity.nos.remove(i);
                notifyDataSetChanged();
            }
        });
        return view;
    }
}
