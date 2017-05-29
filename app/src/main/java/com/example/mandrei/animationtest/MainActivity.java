package com.example.mandrei.animationtest;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnticipateOvershootInterpolator;
import android.view.animation.TranslateAnimation;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;


public class MainActivity extends AppCompatActivity {

    private Button button1;
    private Button button2;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ((Button) findViewById( R.id.btn1 )).setOnClickListener( new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                ImageView img = (ImageView) findViewById( R.id.img1 );
                moveViewToScreen( img, 100, 500 );

            }
        });
    }

    private void moveViewToScreen( View view, int x1, int y1 ) {
        RelativeLayout root = (RelativeLayout) findViewById(R.id.rootLayout);
        DisplayMetrics dm = new DisplayMetrics();
        this.getWindowManager().getDefaultDisplay().getMetrics(dm);
        int statusBarOffset = dm.heightPixels - root.getMeasuredHeight();

        int originalPos[] = new int[2];
        view.getLocationOnScreen(originalPos);

        //int xDest = dm.widthPixels / 3;

        //xDest -= (view.getMeasuredWidth() / 3);
        int xDest = x1;
        //int yDest = dm.heightPixels / 3 - (view.getMeasuredHeight() / 3) - statusBarOffset;
        int yDest = y1;

        TranslateAnimation anim = new TranslateAnimation(0, xDest - originalPos[0], 0, yDest - originalPos[1]);
        anim.setDuration(300);
        anim.setFillAfter(true);
        view.startAnimation(anim);
    }


}



