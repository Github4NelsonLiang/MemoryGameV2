package com.example.nelson.memorygame;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.media.Image;
import android.os.Parcelable;
import android.provider.ContactsContract;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.GridView;
import android.widget.ImageSwitcher;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;

public class Playview extends Activity {

    @BindView(R.id.restart)
    Button restart;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_playview);

        GridView gridview = (GridView) findViewById(R.id.gridview);
        gridview.setAdapter(new ImageAdapter(this));
        ImageAdapter p = new ImageAdapter(this);
        ButterKnife.bind(this);
        restart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = getIntent();
                finish();
                startActivity(intent);
            }
        });

       // ((TextView) findViewById(R.id.)).setText("Points  "+ p.printscore() );
    }

    public void onBackPressed() {
       Intent intent = new Intent(this,MainActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT);
        startActivity(intent);
        Log.i("Backpressed","Yes");
    }



}
