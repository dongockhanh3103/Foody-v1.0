package com.example.ngockhanh.foodyverson1.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.ngockhanh.foodyverson1.R;
import com.example.ngockhanh.foodyverson1.Object.ShowList;

import java.util.List;

/**
 * Created by Ngoc Khanh on 5/3/2017.
 */

public class customListMoiNhat  extends BaseAdapter{
    Context context;
    int layout;
    List<ShowList> listMoiNhat;


    public  customListMoiNhat(Context context,int layout,List<ShowList> listMoiNhat)
    {
        this.context=context;
        this.layout=layout;
        this.listMoiNhat=listMoiNhat;


    }
    public static class  viewHolder{
        ImageView imgIcon;
        TextView txtDes;

    }
    @Override
    public int getCount() {
        return listMoiNhat.size();
    }

    @Override
    public Object getItem(int position) {
        return listMoiNhat.get(position);
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
            viewHolder viewHolder=new viewHolder();
            viewHolder.imgIcon    = (ImageView) viewRow.findViewById(R.id.imgIcon);
            viewHolder.txtDes     = (TextView) viewRow.findViewById(R.id.txtDes);

            viewRow.setTag(viewHolder);
        }

        viewHolder  holder= (viewHolder) viewRow.getTag();
        holder.imgIcon.setImageResource(listMoiNhat.get(position).getIcon());
        holder.txtDes.setText(listMoiNhat.get(position).getDes());

        return viewRow;
    }


}
