package com.cs437.androidwithmark.node;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;


public class GameBoardView extends View {
    private Activity activity;
    public GameBoard gameBoard;
    private String TAG = "GameBoardView";
    private Drawable winImage;
    private boolean winner;
    private Paint paint;

    public GameBoardView(Context context) {
        super(context);
        activity = (Activity) context;
        startGame();
        paint = new Paint();
    }

    public void startGame() {
        gameBoard = new GameBoard(9,6);
        invalidate();
    }

    @Override
    protected void onDraw(Canvas canvas){
        paint.setColor(Color.DKGRAY);
        canvas.drawPaint(paint);
        gameBoard.draw(canvas);
        gameBoard.drawObstacle(canvas);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event){
//        Log.d(TAG, "Touch X: " + event.getX());
//        Log.d(TAG, "Touch Y: " + event.getY());
        int gameResult;
        gameBoard.selectNode(Math.round(event.getX()), Math.round(event.getY()));
        gameResult = gameBoard.checkGameStatus();
        if (gameResult == 1 || gameResult == 0){
            switch (gameResult){
                case 0:
                    winner = false;
                    gameOver(gameBoard.gameNodes.size() - 1);
                    break;
                case 1:
                    winner = true;
                    gameOver(gameBoard.gameNodes.size() - 1);
                    break;
            }
        }
        invalidate();
       return super.onTouchEvent(event);
    }

    /***
     * End of game animation method.
     * @param nodesLeft: How many nodes are left in the arrayList.
     */
    private void gameOver(final int nodesLeft){
        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                if (nodesLeft >= 0) {
                    Node targetNode = gameBoard.gameNodes.get(nodesLeft);
                    if (winner) {
                        targetNode.setGameWinner();
                    } else {
                        targetNode.setGameLoser();
                    }
                    gameOver(nodesLeft - 1);
                    invalidate();
                } else {
                    clearBoard();
                }
            }
        }, 10);
    }

    /***
     * This method is called once the end game animation has been finished. It will clear the board in
     * much the same way gameOver animates it.
     */
    private void clearBoard(){
        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                if (!gameBoard.gameNodes.isEmpty()) {
                    gameBoard.gameNodes.remove(gameBoard.gameNodes.size() - 1);
                    invalidate();
                    clearBoard();
                } else {
                    Intent gameOver = new Intent(getContext(), GameOver.class);
                    gameOver.putExtra("Winner", winner);
                    gameOver.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                    activity.startActivity(gameOver);
                }
            }
        }, 10);
    }

}
