package com.example.simpleparadox.listycity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class showActivity extends AppCompatActivity {

    TextView cityName;
    Button Back;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show);

        cityName = (TextView) findViewById(R.id.cityName);
        Back = (Button) findViewById(R.id.back);

        //fetching the cities from list view
        // fetching intent comes from MainActivity
        String city = getIntent().getStringExtra("cityName");    // accessing cities using 'cityName' key
        cityName.setText(city);             // set the textview to string format

        // clicking 'Back' button, it will redirect to MainActivity i.e Home
        Back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                Intent intent = new Intent(showActivity.this, MainActivity.class); // fetch the current activity
                startActivity(intent);
            }
        });


    }
}