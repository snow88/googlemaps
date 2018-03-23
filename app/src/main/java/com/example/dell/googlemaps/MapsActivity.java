package com.example.dell.googlemaps;

import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.FragmentActivity;
import android.os.Bundle;
import android.view.View;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.maps.model.PolygonOptions;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback {
    FloatingActionButton fab;
    private GoogleMap mMap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);

        fab = findViewById(R.id.fab);

        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MapsActivity.this, TrackerActivity.class));
            }
        });
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;

        PolygonOptions p = new PolygonOptions();
        LatLng l1 = new LatLng(28.6969230, 77.1423730);
        LatLng l2 = new LatLng(28.6969515, 77.1424300);
        LatLng l3 = new LatLng(28.6969421, 77.1423825);
        LatLng l4 = new LatLng(28.6969421, 77.1422825);
        p.add(l1);
        p.add(l2);
        p.add(l4);
        mMap.addPolygon(p);
        mMap.addMarker(new MarkerOptions().position(l3).title("Marker in CB"));
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(l3, 20));
    }
}
