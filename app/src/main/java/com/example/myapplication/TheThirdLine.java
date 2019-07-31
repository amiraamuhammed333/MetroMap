package com.example.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class TheThirdLine extends AppCompatActivity {


    ArrayAdapter<String> adapter3;
    ListView listView3;
    String[]thirdline = {"المطار","عمر بن الخطاب", "عين شمس1 ", "عين شمس2", "العرب", "الف مسكن",
            "هليوبوليس", "هارون الرشيد", "الاهرام", "كلية البنات", "ستاد القاعرة"
            , "ارض المعارض", "االعباسية", "عبده باشا", "الجيش", "باب الشعرية", "العتبة", "جمال عبد الناصر",
            "ماسبيرو", "الزمالك", "السودان", "امبابة",};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate ( savedInstanceState );
        setContentView ( R.layout.activity_the_third_line );
        listView3 = findViewById ( R.id.listview3 );
        adapter3= new ArrayAdapter<> ( this,
                android.R.layout.simple_list_item_1,thirdline );
        listView3.setAdapter ( adapter3 );
    }
}
