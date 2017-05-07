package com.example.ngockhanh.foodyverson1;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TabHost;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import  com.example.ngockhanh.foodyverson1.Adapter.customListMoiNhat;
import com.example.ngockhanh.foodyverson1.UI.UIUtil;

public class MainActivity extends Activity  {
    Button btnEatwhere,btnEatWhat,btnHuyMoiNhat,btnHuyDanhMuc;
    TabHost tabHost;


    ListView lsvMoiNhat;
    ListView lsvDanhMuc;
    ListView lsvTpHCM;

    String[] arrStringMoiNhat;
    String[] arrStringDanhMuc;


    String []arrStringQuan;
    String []arrStringDuong;


    int arrIconMoiNhatAnGi[]=
            {R.drawable.ic_moinhat,
            R.drawable.ic_gantoi,
            R.drawable.ic_phobien,
            R.drawable.ic_dukhach,
            R.drawable.ic_datcho,
            R.drawable.ic_uudaithe,
            R.drawable.ic_giaodathang};

    int arrIconDanhMucOdau[]={
            R.drawable.dm_sangtrong,
            R.drawable.dm_buffet,
            R.drawable.dm_nhahang,
            R.drawable.dm_anvat,
            R.drawable.dm_anchay,
            R.drawable.dm_cafe,
            R.drawable.dm_quanan,
            R.drawable.dm_bar,
            R.drawable.dm_quannhau,
            R.drawable.dm_beerclub,
            R.drawable.dm_tiembanh,
            R.drawable.dm_tiectannoi,
            R.drawable.dm_shopoline,
            R.drawable.dm_comvanphong,
            R.drawable.dm_khuamthuc,
            R.drawable.dm_vietnam,
            R.drawable.dm_chaumy,
            R.drawable.dm_my,
            R.drawable.dm_tayau,
            R.drawable.dm_y,
            R.drawable.dm_phap,
            R.drawable.dm_duc,
            R.drawable.dm_taybannha,
            R.drawable.dm_trunghoa,
            R.drawable.dm_ando,
            R.drawable.dm_thailan,
            R.drawable.dm_nhatban,
            R.drawable.dm_hanquoc,
            R.drawable.dm_malaysia,
            R.drawable.dm_quocte
    };

    int arrDanhMucAnGi[]=
   {
           R.drawable.dm_vietnam,
           R.drawable.dm_chaumy,
           R.drawable.dm_my,
           R.drawable.dm_tayau,
           R.drawable.dm_y,
           R.drawable.dm_phap,
           R.drawable.dm_duc,
           R.drawable.dm_taybannha,
           R.drawable.dm_trunghoa,
           R.drawable.dm_ando,
           R.drawable.dm_thailan,
           R.drawable.dm_nhatban,
           R.drawable.dm_hanquoc,
           R.drawable.dm_malaysia,
           R.drawable.dm_quocte,
           R.drawable.dm_sangtrong,
           R.drawable.dm_buffet,
           R.drawable.dm_nhahang,
           R.drawable.dm_anvat,
           R.drawable.dm_anchay,
           R.drawable.dm_cafe,
           R.drawable.dm_quanan,
           R.drawable.dm_bar,
           R.drawable.dm_quannhau,
           R.drawable.dm_beerclub,
           R.drawable.dm_tiembanh,
           R.drawable.dm_tiectannoi,
           R.drawable.dm_shopoline,
           R.drawable.dm_comvanphong,
           R.drawable.dm_khuamthuc
    };




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        arrStringMoiNhat = getResources().getStringArray(R.array.arrMoiNhatOdau);
        arrStringDanhMuc = getResources().getStringArray(R.array.arrDanhMucOdau);

        arrStringQuan    = getResources().getStringArray(R.array.tpHCM_Quan);
        arrStringDuong   = getResources().getStringArray(R.array.tpHCMDuong);
        //tabhost
        tabHost= (TabHost) findViewById(R.id.TabHost);
        tabHost.setup();
        //map button
        btnEatwhere      =(Button)findViewById(R.id.btnEatWhere);
        btnEatWhat       =(Button)findViewById(R.id.btnEatWhat);
        btnHuyMoiNhat    =(Button)findViewById(R.id.btnHuyMoiNhat);
        //create tabhost
        createTabhost();
        btnEatwhere.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                btnEatWhereClick();
            }
        });

        btnEatWhat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                btnEatWhatClick();
            }
        });

        btnHuyMoiNhat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                xuli();

            }
        });

        btnHuyDanhMuc =(Button)findViewById(R.id.btnHuyDanhMuc);

        btnHuyDanhMuc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                xuli();
            }
        });



    }

    void xuli(){
        ListView listView=(ListView)findViewById(R.id.lvMoiNhat);
        listView.setVisibility(View.GONE);
      btnHuyMoiNhat.setVisibility(View.GONE);
        Button btn=(Button)findViewById(R.id.btnTest);
        btn.setVisibility(View.VISIBLE);
        tabHost.setCurrentTab(0);
    }






    void btnEatWhereClick(){
        btnEatwhere.setBackgroundResource(R.drawable.shapedemo);
        btnEatWhat.setBackgroundResource(R.drawable.shaperight);

        btnEatwhere.setTextColor(Color.BLACK);
        btnEatWhat.setTextColor(Color.WHITE);

        lsvMoiNhat= (ListView) findViewById(R.id.lvMoiNhat);
        arrIconMoiNhatAnGi= new int[]{R.drawable.ic_moinhat,
                R.drawable.ic_gantoi,R.drawable.ic_phobien,
                R.drawable.ic_dukhach,R.drawable.ic_datcho,
                R.drawable.ic_uudaithe,R.drawable.ic_giaodathang};
        arrStringMoiNhat=getResources().getStringArray(R.array.arrMoiNhatOdau);

        EatWhatEatWhere showlistMoiNhat  =new EatWhatEatWhere(MainActivity.this,lsvMoiNhat,arrIconMoiNhatAnGi,arrStringMoiNhat);
        showlistMoiNhat.showList(tabHost);


        lsvDanhMuc= (ListView) findViewById(R.id.lvDanhMuc);
        arrStringDanhMuc=getResources().getStringArray(R.array.arrDanhMucOdau);

        EatWhatEatWhere showlistDanhMucs  =new EatWhatEatWhere(MainActivity.this,lsvDanhMuc,arrIconDanhMucOdau,arrStringDanhMuc);
        showlistDanhMucs.showList(tabHost);


    }


    void btnEatWhatClick(){
        btnEatwhere.setBackgroundResource(R.drawable.shape_eatwhere_click);
        btnEatWhat.setBackgroundResource(R.drawable.shape_eatwhat_click);

        btnEatwhere.setTextColor(Color.WHITE);
        btnEatWhat.setTextColor(Color.BLACK);

        lsvMoiNhat= (ListView) findViewById(R.id.lvMoiNhat);
        arrIconMoiNhatAnGi= new int[]{R.drawable.ic_moinhat,R.drawable.ic_gantoi,R.drawable.ic_moinhat,R.drawable.ic_dukhach};
        arrStringMoiNhat=getResources().getStringArray(R.array.arrMoiNhatAnGi);

        EatWhatEatWhere showlistMoiNhat  =new EatWhatEatWhere(MainActivity.this,lsvMoiNhat,arrIconMoiNhatAnGi,arrStringMoiNhat);
        showlistMoiNhat.showList(tabHost);

        arrStringDanhMuc=getResources().getStringArray(R.array.arrDanhMucAngi);
        EatWhatEatWhere showlistDanhMuc=new EatWhatEatWhere(MainActivity.this,lsvDanhMuc,arrDanhMucAnGi,arrStringDanhMuc);
        showlistDanhMuc.showList(tabHost);

    }

    void createTabhost(){
        EatWhatEatWhere Tab=new EatWhatEatWhere(tabHost,R.id.tab1,R.id.tab2,R.id.tab3,R.id.tab4);
        Tab.createTab();


        lsvTpHCM= (ListView) findViewById(R.id.lvTpHCM);
        EatWhatEatWhere showlistTpHCM  =new EatWhatEatWhere(MainActivity.this,lsvTpHCM,arrStringQuan,arrStringDuong);
        showlistTpHCM.showList(tabHost);

        lsvMoiNhat= (ListView) findViewById(R.id.lvMoiNhat);
        arrIconMoiNhatAnGi= new int[]{R.drawable.ic_moinhat,
                R.drawable.ic_gantoi,R.drawable.ic_phobien,
                R.drawable.ic_dukhach,R.drawable.ic_datcho,
                R.drawable.ic_uudaithe,R.drawable.ic_giaodathang};
        arrStringMoiNhat=getResources().getStringArray(R.array.arrMoiNhatOdau);
        EatWhatEatWhere showlistMoiNhat  =new EatWhatEatWhere(MainActivity.this,lsvMoiNhat,arrIconMoiNhatAnGi,arrStringMoiNhat);
        showlistMoiNhat.showList(tabHost);

        lsvDanhMuc= (ListView) findViewById(R.id.lvDanhMuc);
        arrStringDanhMuc=getResources().getStringArray(R.array.arrDanhMucOdau);

        EatWhatEatWhere showlistDanhMucs  =new EatWhatEatWhere(MainActivity.this,lsvDanhMuc,arrIconDanhMucOdau,arrStringDanhMuc);
        showlistDanhMucs.showList(tabHost);


    }




}
