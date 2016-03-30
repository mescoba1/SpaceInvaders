package com.example.miguel.spaceinvaders;

import android.view.MotionEvent;
import android.view.SurfaceView;

/**
 * Created by miguel on 3/30/2016.
 */

public class SpaceView extends SurfaceView implements SurfaceHolder.Callback {

    public SpaceView ( Contextcontext) {
        super (context) ;
        getHolder().addCallback(this);
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
    }

    @Override
    public void surfaceChaned(SurfaceHolder holder, int format, int width, int height){
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
}

