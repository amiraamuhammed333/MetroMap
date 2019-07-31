package com.example.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MetroStation extends AppCompatActivity implements View.OnClickListener {

    Button btn4,btn5,btn6;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate ( savedInstanceState );
        setContentView ( R.layout.activity_metro_station );
        btn4 = findViewById ( R.id.btn4 );
        btn5 = findViewById ( R.id.btn5 );
        btn6 = findViewById ( R.id.btn6 );

        btn4.setOnClickListener ( MetroStation.this );
        btn5.setOnClickListener ( MetroStation.this );
        btn6.setOnClickListener ( MetroStation.this );



    }

    @Override
    public void onClick(View v) {
        if (v.getId () == R.id.btn4) {

            Intent intent =new Intent (MetroStation.this,TheFirstLine.class );
            startActivity ( intent );
        }
        else if (v.getId () == R.id.btn5){


            Intent intent =new Intent (MetroStation.this,TheSEcondLine.class );
            startActivity ( intent );
        }
        else if (v.getId () == R.id.btn6){


            Intent intent =new Intent (MetroStation.this,TheThirdLine.class );
            startActivity ( intent );
        }


    }
}
