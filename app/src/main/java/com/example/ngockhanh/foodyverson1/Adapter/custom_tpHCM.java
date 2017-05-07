package com.example.ngockhanh.foodyverson1.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.ngockhanh.foodyverson1.Object.Quan_Duong;
import com.example.ngockhanh.foodyverson1.R;
import com.example.ngockhanh.foodyverson1.Object.ShowList;

import java.util.List;

/**
 * Created by Ngoc Khanh on 5/5/2017.
 */

public class custom_tpHCM extends BaseAdapter {
    Context context;
    int layout;
    List<Quan_Duong> listQuanDuong;


    public  custom_tpHCM(Context context, int layout, List<Quan_Duong> quan_duongs)
    {
        this.context=context;
        this.layout=layout;
        this.listQuanDuong=quan_duongs;


    }
    public static class  viewHolder{
        TextView txtQuan;
        TextView txtDuong;

    }
    @Override
    public int getCount() {
        return listQuanDuong.size();
    }

    @Override
    public Object getItem(int position) {
        return position;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent)
    {
        LayoutInflater inflater= (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View viewRow=convertView;
        if(viewRow==null){
            viewRow=inflater.inflate(layout,parent,false);
            custom_tpHCM.viewHolder viewHolder=new custom_tpHCM.viewHolder();
            viewHolder.txtQuan = (TextView) viewRow.findViewById(R.id.txtQuan);
            viewHolder.txtDuong    = (TextView) viewRow.findViewById(R.id.txtDuong);

            viewRow.setTag(viewHolder);
        }

        custom_tpHCM.viewHolder holder= (custom_tpHCM.viewHolder) viewRow.getTag();
        holder.txtQuan.setText(listQuanDuong.get(position).getQuan());
        holder.txtDuong.setText(listQuanDuong.get(position).getDuong());

        return viewRow;
    }
}
