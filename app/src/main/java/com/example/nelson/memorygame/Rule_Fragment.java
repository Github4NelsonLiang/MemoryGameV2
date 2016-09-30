package com.example.nelson.memorygame;

import android.app.Activity;
import android.app.Dialog;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.graphics.Point;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.Display;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;

/**
 * Created by nelson on 9/29/16.
 */
public class Rule_Fragment extends DialogFragment {
   /** public static Rule_Fragment newInstance(){
        return new Rule_Fragment();
    }**/



    public Rule_Fragment() {}

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view =inflater.inflate(R.layout.activity_rules, container, false);
        b=(Button) view.findViewById(R.id.xbutton);
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getDialog().dismiss();
            }
        });

        return view;
    }

    @Override
    public void onStart() {
        super.onStart();
        Dialog dialog = getDialog();
        Window window = getDialog().getWindow();
        WindowManager.LayoutParams params = window.getAttributes();
        Point point = new Point();
        Display display = window.getWindowManager().getDefaultDisplay();
        display.getSize(point);

        int width = point.x;

        window.setLayout((int)(width*1),1000);
        window.setGravity(Gravity.BOTTOM);

    }


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setStyle(DialogFragment.STYLE_NORMAL,R.style.DIALOG);
    }
        private Button b;

}
