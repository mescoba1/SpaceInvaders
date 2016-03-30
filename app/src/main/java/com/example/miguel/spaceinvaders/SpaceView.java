package com.example.miguel.spaceinvaders;

import android.graphics.Color;
import android.view.MotionEvent;
import android.view.SurfaceView;

/**
 * Created by miguel on 3/30/2016.
 */

public class SpaceView extends SurfaceView implements SurfaceHolder.Callback {

    public SpaceView (Context context) {
        super(context) ;
        getHolder().addCallback( this );
        setFocusable(true);


    }
    SpaceThread st;

    @Override
    public void surfaceCreated(SurfaceHolder holder){
        /*initial state
         ...
          launch animator thread */
        st = new SpaceThread(this);
        st.start();
        //initialize game state variables
    }

    @Override
    public void surfaceChanged(SurfaceHolder holder, int format, int width, int height){
        //respond to surface changes
    }

    @Override
    public void surfaceDestroyer(SurfaceHolder holder){
        //stops thread by interrupting it
        //checks for interrupt flag
        st.interrupt();
    }

    @Override
    public boolean onTouchEvent(MotionEvent e){
        //update game state by responding to event
        // touch up-down-move
    }

    @Override
    protected void onDraw(Canvas c){
        c.drawColor(Color.BLACK);
        Rect dst = new Rect();
        dst.set(10. 30, 20, 40);
        c.drawBitmap(mybitmap, null, dst, null);
    }
}

