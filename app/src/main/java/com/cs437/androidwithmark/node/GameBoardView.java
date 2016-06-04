package com.cs437.androidwithmark.node;

import android.app.Activity;
import android.content.Context;
import android.graphics.Canvas;
import android.view.View;


public class GameBoardView extends View {
    private Activity activity;
    private GameBoard gameBoard;

    public GameBoardView(Context context) {
        super(context);
        activity = (Activity) context;
        gameBoard = new GameBoard(100,100);

    }

    @Override
    protected void onDraw(Canvas canvas){
        gameBoard.draw(canvas);
    }

}
