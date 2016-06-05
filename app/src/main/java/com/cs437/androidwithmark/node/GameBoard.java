package com.cs437.androidwithmark.node;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.Log;
import android.view.View;

import java.util.ArrayList;

/***
 * Gameboard Class. The Gameboard class is designed to model and display a gameboard for node.
 * The gameboard is represented as a graph, by way of an arrayList of Nodes.
 * Created by Erick Sauceda
 */
public class GameBoard {
    int gameBoard_X;
    int gameBoard_Y;
    int gameBoard_width;
    int gameBoard_height;
    ArrayList<Node> gameNodes = new ArrayList<>();

    /***
     * Constructor for the GameBoard class
     * @param x Number of horizontal rows
     * @param y Number of vertical columns
     */
    public GameBoard(int x, int y, int width, int height){
        gameBoard_X = x;
        gameBoard_Y = y;
        gameBoard_height = height;
        gameBoard_width = width;
        initBoard();
    }


    /***
     * Instantiates all nodes for the GameBoard.
     */
    //TODO: Arrange nodes to be equally spaced throughout the whole screen instead of this hacky way.
    private void initBoard() {
        int increment = (int) Math.floor((gameBoard_height * gameBoard_width) / (gameBoard_X * gameBoard_Y));
        Log.d("INCREMENT", String.valueOf(increment));

        //figure height out first


        for (int i = 0; i < gameBoard_Y; i++){
            for (int j = 0; j < gameBoard_X; j++){
                Node test = new Node(i * 75 + 25, j * 75 + 25);
                if (Math.random() * 10 + 1 < 3){
                    test.isActive = true;
                }
                gameNodes.add(test);

            }
        }
    }

    public void draw(Canvas canvas){
        //get device size, and divide evenly between nodes
        //for each node, place equal distance on screen
        for (Node toDraw : gameNodes){
            toDraw.draw(canvas);
        }
    }
}
