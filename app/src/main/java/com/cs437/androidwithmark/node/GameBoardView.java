package com.cs437.androidwithmark.node;

import android.app.Activity;
import android.content.Context;
import android.graphics.Canvas;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;


public class GameBoardView extends View {
    private Activity activity;
    private GameBoard gameBoard;
    private String TAG = "GameBoardView";

    public GameBoardView(Context context) {
        super(context);
        activity = (Activity) context;
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec){
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        int width = MeasureSpec.getSize(widthMeasureSpec);
        int height = MeasureSpec.getSize(heightMeasureSpec);
        gameBoard = new GameBoard(10,10, width, height);
    }

    @Override
    protected void onDraw(Canvas canvas){
        gameBoard.draw(canvas);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event){
//        Log.d(TAG, "Touch X: " + event.getX());
//        Log.d(TAG, "Touch Y: " + event.getY());
        gameBoard.findNodeAt(Math.round(event.getX()), Math.round(event.getY()));
        invalidate();
       return super.onTouchEvent(event);
    }

}
