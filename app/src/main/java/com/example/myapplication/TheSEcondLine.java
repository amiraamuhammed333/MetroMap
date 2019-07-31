package com.example.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class TheSEcondLine extends AppCompatActivity {
    ArrayAdapter<String> adapter2;
    ListView listView2;
    String[]secondline = {"شبرا الخيمة", "كلية الزراعة", "المظلات", "الخلفاوي", "سانت تريزا",
            "روض الفرج", "مسرة", "الشهداء", "العتبة", "محمد نجيب"
            , "السادات", "الاوبرا", "الدقي", "البحوث", "جامعة القاهرة", "فيصل", "الجيزة",
            "ام المصريين", "ساقية مكي", "المنيب", "مارجرجس",};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate ( savedInstanceState );
        setContentView ( R.layout.activity_the_second_line );
        listView2= findViewById ( R.id.listview2 );
        adapter2= new ArrayAdapter<> ( this,
                android.R.layout.simple_list_item_1,secondline );
        listView2.setAdapter ( adapter2 );
    }
}
