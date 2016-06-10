package com.cs437.androidwithmark.node;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;

import java.util.ArrayList;
import java.util.Random;

/**
 * Created by arendon on 6/4/16
 */

public class Node {
    boolean isActive;
    Node partner;
    int cx, cy;
    public boolean isSelected;
    public boolean isConnected;
    public boolean visited;
    private boolean isDead;
    private boolean isGod;
    private ArrayList<Node> neighbors = new ArrayList<>();

    public Node(int x, int y){
        isActive = false;
        isSelected = false;
        isConnected = false;
        isDead = false;
        isGod = false;
        visited = false;
        partner = null;
        cx = x;
        cy = y;
    }

    public void draw(Canvas canvas){
        Paint paint = new Paint();
        int radius = 25;
        if (isSelected){
            paint.setColor(Color.BLUE);
        } else if (isActive){
            paint.setColor(Color.GREEN);
        }

        if (isConnected){
            paint.setColor(Color.WHITE);
            drawLine(canvas, partner.cx, partner.cy);
        }

        if (isDead){
            paint.setColor(Color.RED);
        }

        if (isGod){
            paint.setColor(Color.YELLOW);
        }

        canvas.drawCircle(this.cx, this.cy, radius, paint);
        paint.setStyle(Paint.Style.STROKE);
        paint.setColor(Color.WHITE);
        canvas.drawCircle(this.cx, this.cy, radius, paint);
    }

    public void drawLine(Canvas canvas, int sx, int sy){
        Paint paint = new Paint();
        paint.setStrokeWidth(10);

        canvas.drawLine(this.cx, this.cy, sx, sy, paint);
    }

    public void setPartner(Node partner) {
        this.partner = partner;
        isConnected = true;
        isActive = false;
    }

    public void setGameLoser() {
        isConnected = false;
        isActive = false;
        isSelected = false;
        isDead = true;
    }

    public void setGameWinner() {
        isConnected = false;
        isActive = false;
        isSelected = false;
        isGod = true;
    }

    public void addNeighbors(Node neighbor) {
        if (!neighbors.contains(neighbor)){
            neighbors.add(neighbor);
            neighbor.addNeighbors(this);
        }
    }


    public Node getRandomNeighbor() {
        Random rand = new Random();
        for (Node candidate : neighbors){
            if (candidate.isActive || candidate.isConnected){
                return candidate;
            } else if (!candidate.visited){
                return candidate;
            }
        }
        return neighbors.get(rand.nextInt(neighbors.size()));
    }

    public void kill() {
        isDead = true;
 //       isActive = false;
        visited = true;
    }
}
