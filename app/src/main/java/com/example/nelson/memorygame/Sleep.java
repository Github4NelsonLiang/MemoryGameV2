package com.example.nelson.memorygame;

import android.content.Context;
import android.util.Log;

/**
 * Created by nelson on 9/16/16.
 */
public class Sleep implements Runnable {
    private Context mcontext;
    private int[]positions;
    private ImageAdapter adapter;

    public Sleep (Context c,ImageAdapter a,int[] pos){
        mcontext=c;
        adapter=a;
        positions = pos;
        Log.d("update","Click!");
        adapter.remove(pos[0]);
        adapter.remove(pos[1]);
    }





    @Override
    public void run() {
        adapter.hide(positions[0]);
        adapter.hide(positions[1]);
        adapter.installclick(positions[0]);
        adapter.installclick(positions[1]);
    }
}
