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
    //ArrayList<Node> gameNodes;

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
                //create new node
                //add connections
                //if i > 0, then grab node directly behind in arrayList
                //if j > 0, then grab subtract size of gameBoard_x
            }
        }
    }

    public void draw(Canvas canvas){
        //get device size, and divide evenly between nodes
        //for each node, place equal distance on screen

        Node test = new Node();
        test.draw(canvas, 100, 100);
    }
}
