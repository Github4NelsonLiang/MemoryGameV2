package com.example.nelson.memorygame;

import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;
import android.media.Image;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.HandlerThread;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Interpolator;
import android.widget.BaseAdapter;
import android.widget.EditText;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.daimajia.androidanimations.library.Techniques;
import com.daimajia.androidanimations.library.YoYo;

import org.w3c.dom.Text;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.logging.Handler;

import butterknife.BindDrawable;
import butterknife.BindView;

/**
 * Created by nelson on 9/16/16.
 */
public class ImageAdapter extends BaseAdapter{
    private Context mcontext;
    private List imageview;
    private Integer [] pieces;
    private int piece_front=-1;
    int points ;

    public ImageAdapter(Context c){
        mcontext=c;
        List imagedeck = new ArrayList();
        for (int i=0;i<10;i++){
            imagedeck.add(i);
            imagedeck.add(i);
        }
        Collections.shuffle(imagedeck);
        pieces=(Integer[]) imagedeck.toArray(new Integer[0]);
        view();
    }
    public void view(){
        imageview = new ArrayList();
        for (int pos=0;pos<getCount();pos++){
            ImageView imageView;

            imageView = new ImageView(mcontext);
            imageView.setLayoutParams(new GridView.LayoutParams(300,350));
            imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
            imageView.setPadding(2,2,2,2);
            imageView.setImageResource(R.drawable.back);
            imageview.add(imageView);
            installclick(pos);
        }

    }


    public int getCount(){return mThumbIds.length*2;}

    public Object getItem(int pos){
        return imageview.get(pos);
    }

    public long getItemId(int pos){ return pieces[pos].longValue();}

    public synchronized View getView(int pos, View view, ViewGroup parent){
        return (ImageView) imageview.get(pos);
    }






    public void installclick(int pos){
      final ImageAdapter self = this;
        Log.d("ImageAdapter", "click *" + Integer.toString(pos));
        final ImageView imageView= (ImageView) imageview.get(pos);
      imageView.setOnClickListener(new View.OnClickListener() {

          public void onClick(View v) {
              int pos = imageview.indexOf((ImageView) v);
              YoYo.with(Techniques.BounceInUp)
                      .duration(1000)
                      .playOn(imageView);
              show(pos);
              if (piece_front == -1 || piece_front == pos){
                  piece_front = pos;
              }
              else {
                  if (pieces[pos] == pieces[piece_front]) {
                      ImageView image1 = (ImageView) imageview.get(pos);
                      ImageView image2 = (ImageView) imageview.get(piece_front);
                      YoYo.with(Techniques.RotateIn)
                              .duration(1000)
                              .playOn(image1);

                      YoYo.with(Techniques.RotateIn)
                              .duration(1000)
                              .playOn(image2);

                      points++;
                      Toast.makeText(mcontext, String.valueOf(points),Toast.LENGTH_LONG).show();
                      remove(pos);
                      remove(piece_front);
                  } else {
                      int remove[] = {piece_front, pos};
                      Sleep update = new Sleep(mcontext, self, remove);
                      android.os.Handler handle = new android.os.Handler();
                      ImageView image3 = (ImageView) imageview.get(pos);
                      YoYo.with(Techniques.BounceInUp)
                              .duration(1000)
                              .playOn(image3);

                      handle.postDelayed(update, 800);

                  }
                  piece_front=-1;

              }
          }


      });
  }

   public int Game_Point(int pts) {
       points=pts+points;
       return points;
   }

    public int printscore(){
        return points;
    }

public void remove(int pos){
    ImageView remove;
    remove = (ImageView) imageview.get(pos);
    remove.setOnClickListener(null);
}
    public void hide(int pos){
        ImageView img;
        img= (ImageView) imageview.get(pos);
        int piece=pieces[pos];
        img.setImageResource(R.drawable.back);
    }
public void show(int pos){
    ImageView img;
    img=(ImageView) imageview.get(pos);
    int piece = pieces[pos];
    img.setImageResource(mThumbIds[piece]);

}

    private Integer [] mThumbIds={
            R.drawable.a,
            R.drawable.b,
            R.drawable.c,
            R.drawable.d,
            R.drawable.e,
            R.drawable.f,
            R.drawable.g,
            R.drawable.h,
            R.drawable.i,
            R.drawable.j,


    };

}
