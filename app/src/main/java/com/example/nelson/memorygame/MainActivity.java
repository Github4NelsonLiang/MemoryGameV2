package com.example.nelson.memorygame;

import android.app.FragmentTransaction;
import android.content.Intent;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findViewById(R.id.button2).setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        android.support.v4.app.FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
        Rule_Fragment RF = new Rule_Fragment();
        RF.show(ft,"yo");
    }

    public void clicked_play(View view){
        Intent play = new Intent(this,Playview.class);
        play.addFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT);
        startActivity(play);
    }
    public void onBackPressed() {
        moveTaskToBack(true);
    }
}
