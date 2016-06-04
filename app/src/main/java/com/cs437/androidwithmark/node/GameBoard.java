package com.cs437.androidwithmark.node;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;

import java.util.ArrayList;

/***
 * Gameboard Class. The Gameboard class is designed to model and display a gameboard for node.
 * The gameboard is represented as a graph, by way of an arrayList of Nodes.
 * Created by Erick Sauceda
 */
public class GameBoard {
    int gameBoard_X;
    int gameBoard_Y;
    ArrayList<Node> gameNodes = new ArrayList<>();

    /***
     * Constructor for the GameBoard class
     * @param x Number of horizontal rows
     * @param y Number of vertical columns
     */
    public GameBoard(int x, int y){
        gameBoard_X = x;
        gameBoard_Y = y;
        initBoard();
    }

    /***
     * Instantiates all nodes for the GameBoard.
     */
    private void initBoard() {
        for (int i = 0; i < gameBoard_Y; i++){
            for (int j = 0; j < gameBoard_X; j++){
                Node test = new Node(i * 75 + 25, j * 75 + 25);
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
