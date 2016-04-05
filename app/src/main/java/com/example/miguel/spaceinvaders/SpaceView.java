package com.example.miguel.spaceinvaders;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Rect;
import android.view.MotionEvent;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

/**
 * Created by miguel on 3/30/2016.
 * Game Engine
 */

public class SpaceView extends SurfaceView
        implements  SurfaceHolder.Callback {
    public Bitmap mybitmap;
    public  int screenHeight, screenWidth;
    public SpaceView (Context context) {
        super(context) ;
        getHolder().addCallback(this);
        setFocusable(true);
        //initialize game state variables
        Bitmap mybitmap = BitmapFactory.decodeResource(getResources(), R.mipmap.ic_launcher);
    }
    SpaceThread st;

    @Override
    public void surfaceCreated(SurfaceHolder holder){
        /*initial state
         ...
          launch animator thread */
        st = new SpaceThread(this);
        st.start();
    }

    @Override
    public void surfaceChanged(SurfaceHolder holder, int format, int width, int height){
        //respond to surface changes
    }

    @Override
    public void surfaceDestroyed(SurfaceHolder holder) {

    }

    public void surfaceDestroyer(SurfaceHolder holder){
        //stops thread by interrupting it
        //checks for interrupt flag
        st.interrupt();
    }

    @Override
    public boolean onTouchEvent(MotionEvent e){
        //update game state by responding to event
        // touch up-down-move
        return true;
    }

    @Override
    protected void onDraw(Canvas c){
        c.drawColor(Color.BLACK);
        Rect dst = new Rect();
        dst.set(10, 30, 20, 40);
        c.drawBitmap(mybitmap, null, dst, null);
    }
}

