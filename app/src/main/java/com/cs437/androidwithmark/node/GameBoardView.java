package com.cs437.androidwithmark.node;

import android.app.Activity;
import android.content.Context;
import android.graphics.Canvas;
import android.util.Log;
import android.view.View;


public class GameBoardView extends View {
    private Activity activity;
    private GameBoard gameBoard;

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

}
