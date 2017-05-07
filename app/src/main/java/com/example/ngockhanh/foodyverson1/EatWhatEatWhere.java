package com.example.ngockhanh.foodyverson1;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TabHost;
import android.widget.TabWidget;
import android.widget.TextView;

import com.example.ngockhanh.foodyverson1.Adapter.customListMoiNhat;
import com.example.ngockhanh.foodyverson1.Adapter.custom_tpHCM;
import com.example.ngockhanh.foodyverson1.Object.Quan_Duong;
import com.example.ngockhanh.foodyverson1.Object.ShowList;
import com.example.ngockhanh.foodyverson1.UI.UIUtil;

import java.util.ArrayList;
import java.util.List;

import static android.widget.TabHost.*;

/**
 * Created by Ngoc Khanh on 5/4/2017.
 */

public  class EatWhatEatWhere {
    private  int idListMoiNhat;
    private  int idListDanhMuc;
    private  int idListTinhThanh;
    private TabHost tabHost;
    private ListView listView;
    private Context context;
    private  List<ShowList> showLists;
    private List<Quan_Duong>showListQuanDuong;
    private  int []arrIcon;
    private String []arrDes;
    private  String []arrQuan;
    private  String []arrDuong;
    private  boolean flag;
    private int idtabIndex;




    public EatWhatEatWhere(TabHost tabHost,int idListMoiNhat,int idListDanhMuc,int idListTinhThanh)
    {
        this.idListMoiNhat=idListMoiNhat;
        this.idListDanhMuc=idListDanhMuc;
        this.idListTinhThanh=idListTinhThanh;

        this.tabHost=tabHost;
    }

    public EatWhatEatWhere(Context context,ListView listView,int []arrIcon,String []arrDes){
        this.listView=listView;
        this.context=context;
        this.arrIcon=arrIcon;
        this.arrDes=arrDes;
    }

    public EatWhatEatWhere(Context context,ListView listView,String []arrQuan,String []arrDuong)
    {
        this.listView=listView;
        this.context=context;
        this.arrQuan=arrQuan;
        this.arrDuong=arrDuong;
    }




    public   void createTab()
    {


        //Tab Mới nhất
        TabHost.TabSpec tabMoiNhat=tabHost.newTabSpec("Mới nhất");
        tabMoiNhat.setIndicator("Mới nhất");

        tabMoiNhat.setContent(idListMoiNhat);
        //Tab Danh Mục
        TabHost.TabSpec tabDanhMuc=tabHost.newTabSpec("Danh Mục");
        tabDanhMuc.setIndicator("Danh Mục");
        tabDanhMuc.setContent(idListDanhMuc);
        //Tab TP.HCM
        TabHost.TabSpec tabTpHCM=tabHost.newTabSpec("TP.HCM");
        tabTpHCM.setIndicator("TP.HCM");
        tabTpHCM.setContent(idListTinhThanh);


        tabHost.addTab(tabMoiNhat);
        tabHost.addTab(tabDanhMuc);
        tabHost.addTab(tabTpHCM);
        //tabHost.addTab(tabIndex);



        for(int i=0;i< tabHost.getTabWidget().getTabCount();i++){
            if(i==0)
            {
                TextView tv =  (TextView) tabHost.getTabWidget().getChildAt(i).findViewById(android.R.id.title);
                tv.setAllCaps(false);
                tv.setTextSize(13);
                tv.setTextColor(Color.RED);
            }
            TextView tv =  (TextView) tabHost.getTabWidget().getChildAt(i).findViewById(android.R.id.title);
            tv.setAllCaps(false);
            tv.setTextSize(13);



        }
      //  TabWidget tvc= (TabWidget) tabHost.getTabWidget().getChildAt(2);
      //  tvc.setVisibility(View.INVISIBLE);

        tabHost.getTabWidget().getChildAt(tabHost.getCurrentTab())
                .setBackgroundColor(Color.parseColor("#EEEEEE"));


        tabHost.setOnTabChangedListener(new OnTabChangeListener() {
            @Override
            public void onTabChanged(String tabId) {
                for (int i = 0; i < tabHost.getTabWidget().getChildCount(); i++){
                    tabHost.getTabWidget().getChildAt(i)
                            .setBackgroundColor(Color.parseColor("#FFFFFF"));
                }

                tabHost.getTabWidget().getChildAt(tabHost.getCurrentTab())
                        .setBackgroundColor(Color.parseColor("#EEEEEE")); // selected
            }
        });

    }

    public void showList(final TabHost tabHosttemp)
    {
        final ListView listContent=this.listView;

        if(arrQuan==null)
        {
            showLists=new ArrayList<>();
            for(int i=0;i<arrDes.length;i++)
            {
                ShowList showList=new ShowList();
                showList.setIcon(arrIcon[i]);
                showList.setDes(arrDes[i]);
                showLists.add(showList);
            }
            final customListMoiNhat customListMoiNhat=new customListMoiNhat(context,R.layout.moinhat_customlistview,showLists);
            customListMoiNhat.notifyDataSetChanged();

            listContent.setAdapter(customListMoiNhat);
            UIUtil.setListViewHeightBasedOnItems(listContent);
            flag=true;
        }
        else
        {
             showListQuanDuong  =new ArrayList<>();
            for(int i=0;i<arrQuan.length;i++)
            {
                Quan_Duong quan_duong=new Quan_Duong();
                quan_duong.setQuan(arrQuan[i]);
                quan_duong.setDuong(arrDuong[i]);
                showListQuanDuong.add(quan_duong);
            }
            final  custom_tpHCM custom_tpHCM=new custom_tpHCM(context,R.layout.customlistview_tphcm,showListQuanDuong);
            custom_tpHCM.notifyDataSetChanged();
            listContent.setAdapter(custom_tpHCM);

            flag=false;

        }




        listContent.setOnItemClickListener(new AdapterView.OnItemClickListener()
        {

            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                for(int i=0;i<listContent.getChildCount();i++)
                {
                    //View tempView =getViewByPosition(i,listContent);
                    TextView v;

                    if(flag)
                    {
                        v = (TextView) listContent.getChildAt(i).findViewById(R.id.txtDes);

                    }

                    else
                    {
                        v = (TextView) listContent.getChildAt(i).findViewById(R.id.txtQuan);
                    }
                    v.setTextColor(Color.BLACK);

                }
                TextView v;
                if(flag)
                {
                   v=(TextView)listContent.getChildAt(position).findViewById(R.id.txtDes);
                }
                else
                {
                   v =(TextView)listContent.getChildAt(position).findViewById(R.id.txtQuan);
                }
                v.setTextColor(Color.RED);

                 TextView tv =  (TextView) tabHosttemp.getTabWidget().getChildAt(tabHosttemp.getCurrentTab()).findViewById(android.R.id.title);
                if(flag) {
                    tv.setText(showLists.get(position).getDes());
                }
                else {
                    tv.setText(showListQuanDuong.get(position).getQuan());
                }

            }
        });



    }



   /* public View getViewByPosition(int pos, ListView listView) {
        System.out.println("POS  :"+pos);
        final int firstListItemPosition = listView.getFirstVisiblePosition();
        System.out.println("first :"+firstListItemPosition);

        final int lastListItemPosition = firstListItemPosition + listView.getChildCount() - 1;

        System.out.println("last :"+lastListItemPosition);

        System.out.println("Child count :"+listView.getChildCount());
        //pos mà 0<pos<10
        if (pos < firstListItemPosition || pos > lastListItemPosition ) {

            return listView.getAdapter().getView(pos, null, listView);
        }
        else
        {
           final int childIndex = pos - firstListItemPosition;
            //final int childIndex = pos + listView.getHeaderViewsCount() - firstListItemPosition;
            return listView.getChildAt(childIndex);
        }
    }*/


}
