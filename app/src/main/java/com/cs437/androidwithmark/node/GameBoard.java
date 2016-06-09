package com.cs437.androidwithmark.node;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.os.Handler;
import android.util.Log;
import android.view.View;

import java.util.ArrayList;
import java.util.Random;

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
    Obstacle obstacle;
    Node selected = null;
    int nodesLeft;

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
    //TODO: Arrange nodes to be equally spaced throughout the whole screen instead of this hacky way.
    private void initBoard() {



        for (int i = 0; i < gameBoard_Y; i++){
            for (int j = 0; j < gameBoard_X; j++){
                Node test = new Node(i * 100 + 50, j * 100 + 50);
                if (Math.random() * 10 + 1 < 2){
                    test.isActive = true;
                    nodesLeft++;
                }
                gameNodes.add(test);

            }
        }
        initObstacle();
    }

    public void initObstacle(){
        // Create a random generator for a possible location for the obstacle to spawn on
        Random random = new Random();
        int obstaclePosition = random.nextInt(gameNodes.size() - 1);

        // We have to make sure our random location does not hit an active node
        // Loop until our random position is on an inactive node
        while(gameNodes.get(obstaclePosition).isActive){
            obstaclePosition = random.nextInt(gameNodes.size() - 1);
        }

        // Create obstacle object
        obstacle = new Obstacle(gameNodes.get(obstaclePosition));
    }

    public void draw(Canvas canvas){
        //get device size, and divide evenly between nodes
        //for each node, place equal distance on screen
        for (Node toDraw : gameNodes){
            toDraw.draw(canvas);
        }
    }

    public void drawObstacle(Canvas canvas){
        obstacle.draw(canvas);
    }

    public void selectNode(int x, int y){
        //check nodes for match
        for (Node node : gameNodes){
            int distanceFromX = Math.abs(node.cx - x);
            int distanceFromY = Math.abs(node.cy - y);
            //System.out.println("X: " + distanceFromX);
            //System.out.println("Y:" + distanceFromY);
            if (distanceFromX < 25 && distanceFromY < 25){
                if (node.isActive){
                    if (selected == null){
                        selected = node;
                        selected.isSelected = true;
                    } else {
                        if (selected != node){
                            selected.setPartner(node);
                            selected = null;
                            nodesLeft--;
                        }
                    }
                }
                break;
            }
        }
    }

    /***
     * Method to determine current game status.
     * @return Should return 0 for loser, 1 for winner, and -1 for neither.
     */
    public int checkGameStatus() {
        //System.out.println(nodesLeft);
        if (nodesLeft == 1){
            System.out.println("GAME OVER");
            return 1;
        }
        return -1;
    }

    private void winnerAnimation() {
        for (Node node : gameNodes) {
            node.isConnected = false;
            node.isActive = false;
            node.isSelected = true;
        }
    }
}
