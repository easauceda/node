package com.cs437.androidwithmark.node;

import android.app.Activity;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.os.Handler;
import android.view.MotionEvent;
import android.view.View;


public class GameBoardView extends View {
    private Activity activity;
    public GameBoard gameBoard;
    private String TAG = "GameBoardView";

    public GameBoardView(Context context) {
        super(context);
        activity = (Activity) context;
        startGame();
    }

    public void startGame() {
        gameBoard = new GameBoard(9,6);
        invalidate();
    }

    @Override
    protected void onDraw(Canvas canvas){
        Paint paint = new Paint();
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
        if (gameResult == 0) {
            gameOver(gameBoard.gameNodes.size() - 1, false);
        } else if (gameResult == 1){
            gameOver(gameBoard.gameNodes.size() - 1, true);
        }
        invalidate();
       return super.onTouchEvent(event);
    }

    /***
     * End of game animation method.
     * @param nodesLeft: How many nodes are left in the arrayList.
     * @param winner: Boolean to determine node color during gameOver animation.
     */
    private void gameOver(final int nodesLeft, final boolean winner){
        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                if (nodesLeft >= 0){
                    Node targetNode = gameBoard.gameNodes.get(nodesLeft);
                    if (winner){
                        targetNode.setGameWinner();
                    } else {
                        targetNode.setGameLoser();
                    }
                    gameOver(nodesLeft - 1, winner);
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
                if (!gameBoard.gameNodes.isEmpty()){
                    gameBoard.gameNodes.remove(gameBoard.gameNodes.size() - 1);
                    invalidate();
                    clearBoard();
                }
            }
        }, 10);
    }

}
