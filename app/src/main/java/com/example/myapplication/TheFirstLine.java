package com.example.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class TheFirstLine extends AppCompatActivity {
    ArrayAdapter<String> adapter;
    ListView listView;
    String[]firstline = {"المرج الجديدة","المرج","عزبة النخل","عين شمس","المطرية",
            "حلمية الزيتون","حدائق الزيتون","سراي القبة","حمامات القبة","كوبري القبة"
,"منشية الصدر","الدمرداش","غمرة","الشهداء","احمد عرابي","جمال عبد الناصر","السادات",
            "سعد زغلول","السيدة زينب","الملك الصالح","مارجرجس","الزهراء","دار السلام",
            "حدائق المعادي","المعادي","ثكنات المعادي","طرة البلد","كوتسيكا","طرة الاسمنت",
            "المعصرة","حدائق حلوان","وادي حوف","جامعة حلوان","عين حلوان","حلوان",
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate ( savedInstanceState );
        setContentView ( R.layout.activity_the_first_line );
        listView = findViewById ( R.id.listview1 );
        adapter= new ArrayAdapter<> ( this,
                android.R.layout.simple_list_item_1,firstline );
        listView.setAdapter ( adapter );











    }
}
