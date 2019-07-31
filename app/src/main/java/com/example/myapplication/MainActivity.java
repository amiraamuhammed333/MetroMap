package com.example.myapplication;

import android.Manifest;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.location.Location;
import android.location.LocationListener;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapView;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

import static com.example.myapplication.R.layout.activity_maps;

public class MainActivity extends AppCompatActivity
        implements LocationListener, OnMapReadyCallback, View.OnClickListener {

    private static final int MY_PERMISSIONS_REQUEST_Access_GPS = 500;
    TextView locationTextView;
    MapView mapView;
    GoogleMap googleMap;
    Button btn1,btn2,btn3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate ( savedInstanceState );

        setContentView ( R.layout.activity_main );
        locationTextView= findViewById ( R.id.location );
        btn1= findViewById ( R.id.btn1);
        btn2= findViewById ( R.id.btn2 );
        btn3= findViewById ( R.id.btn3 );
        btn1.setOnClickListener ( MainActivity.this );
        btn2.setOnClickListener ( MainActivity.this );
        btn3.setOnClickListener ( MainActivity.this );




        mapView = findViewById ( R.id.mapview);
        mapView.onCreate (savedInstanceState);
        mapView.getMapAsync ( this );


        if (isGPSPermissionAllowed ()){

            //call your  function
            initializeGPS ();
        }

        else {
            //request permisssion
            requestLocationPermision();
        }
    }
    @Override
    public void onClick(View v) {
        if (v.getId () == R.id.btn1) {

            Intent intent =new Intent (MainActivity.this,MetroMap.class );
            startActivity ( intent );
        }
        else if (v.getId () == R.id.btn2){


            Intent intent =new Intent (MainActivity.this,MetroStation.class );
            startActivity ( intent );
        }
        else if (v.getId () == R.id.btn3){


            Intent intent =new Intent (MainActivity.this,AboutMetro.class );
            startActivity ( intent );
        }

    }



    @Override
    protected void onStart() {
        super.onStart ();
        mapView.onStart ();
    }

    @Override
    protected void onResume() {
        super.onResume ();
        mapView.onResume ();
    }

    @Override
    protected void onPause() {
        super.onPause ();
        mapView.onPause ();
    }

    @Override
    protected void onStop() {
        super.onStop ();
        mapView.onStop ();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy ();
        mapView.onDestroy ();
    }

    @Override
    public void onLowMemory() {
        super.onLowMemory ();
        mapView.onLowMemory ();
    }


    Marker marker=null;
    public void setMyLocation(){
        if (location!=null&&googleMap!=null){
            LatLng latLng = new LatLng
                    ( location.getLatitude (),location.getLongitude () );
            if(marker==null)
            marker = googleMap.addMarker ( new MarkerOptions ().position ( latLng )
            .title ( "My Location" )
            .icon ( BitmapDescriptorFactory.fromResource ( R.drawable.bus ) )
            );
            else marker.setPosition(latLng);



            googleMap.animateCamera ( CameraUpdateFactory.newLatLngZoom ( latLng,12.0f ));

        }}


    public boolean isGPSPermissionAllowed(){

        if (ContextCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION)
                != PackageManager.PERMISSION_GRANTED) {
            // Permission is not granted
            return false;
        }
        return true;

    }
    MyLocationProvider locationProvider;
    Location location;
    public void initializeGPS(){
        Toast.makeText ( this,"GPS ALLOWED",Toast.LENGTH_SHORT ).show ();
        locationProvider = new MyLocationProvider ( this );
        location = locationProvider.getBestLastKnownLocation ();

        if (location==null){
            Toast.makeText ( this,"cannot get your location",Toast.LENGTH_SHORT ).show ();
        }
        else {
            locationTextView.setText ( location.getLatitude ()+""+location.getLongitude () );
            Log.e ( "location",location.toString () );
        }
        locationProvider.trackLocation ( this );
    }
    private void requestLocationPermision() {


            if (ActivityCompat.shouldShowRequestPermissionRationale(this,
                    Manifest.permission.ACCESS_FINE_LOCATION)) {
                // Show an explanation to the user *asynchronously* -- don't block
                // this thread waiting for the user's response! After the user
                // sees the explanation, try again to request the permission.
                //showDialog

                AlertDialog alertDialog = new AlertDialog.Builder(this)
                        .setTitle ( R.string.warning )
                        .setTitle ( R.string.message_request_GPS_reason )
                        .setPositiveButton ( R.string.ok, new DialogInterface.OnClickListener () {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                dialog.dismiss ();
                                ActivityCompat.requestPermissions(MainActivity.this,
                                        new String[]{Manifest.permission.ACCESS_FINE_LOCATION},
                                        MY_PERMISSIONS_REQUEST_Access_GPS);
                            }
                        } ).show ();

            } else {
                // No explanation needed, we can request the permission.
                ActivityCompat.requestPermissions(this,
                        new String[]{Manifest.permission.ACCESS_FINE_LOCATION},
                        MY_PERMISSIONS_REQUEST_Access_GPS);

                // MY_PERMISSIONS_REQUEST_READ_CONTACTS is an
                // app-defined int constant. The callback method gets the
                // result of the request.
            }


    }






    @Override
    public void onRequestPermissionsResult(int requestCode,
                                           @NonNull String[] permissions,
                                           @NonNull int[] grantResults) {
        switch (requestCode) {
            case MY_PERMISSIONS_REQUEST_Access_GPS: {
                // If request is cancelled, the result arrays are empty.
                if (grantResults.length > 0
                        && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    // permission was granted, yay! Do the
                    // contacts-related task you need to do.
                    initializeGPS ();
                } else {
                    // permission denied, boo! Disable the
                    // functionality that depends on this permission.
                    Toast.makeText ( this, "Permiossioin Denied App Canaot Access GPS ", Toast.LENGTH_SHORT ).show ();
                }
                return;
            }

            // other 'case' lines to check for other
            // permissions this app might request.
        }
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {

        this.googleMap=googleMap;
        setMyLocation ();

    }

    @Override
    public void onLocationChanged(Location location)
    {
       this.location = location;
       locationTextView.setText ( location.getLatitude ()+""+location.getLongitude () );
       setMyLocation ();
    }

    @Override
    public void onStatusChanged(String provider, int status, Bundle extras) {

    }

    @Override
    public void onProviderEnabled(String provider) {

    }

    @Override
    public void onProviderDisabled(String provider) {

    }



}
