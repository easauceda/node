package com.cs437.androidwithmark.node;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;

/**
 * Created by arendon on 6/4/16.
 * This class represents our obstacle that will be moving throughout gameplay
 * The shape of the obstacle will be a circle as it was easier for positioning.
 * Obstacle color is red in order to easily distinguish
 */
public class Obstacle {

    Node curNode;

    public Obstacle(Node curNode){
        this.curNode = curNode;
    }

    public void draw(Canvas canvas){
        Paint paint = new Paint();
        paint.setColor(Color.RED);

        int nodeX = curNode.cx;
        int nodeY = curNode.cy;

        System.out.println("Node cx: " + nodeX + "\n Node cy: " + nodeY);

        canvas.drawCircle(nodeX, nodeY, 15, paint);
    }

    // Setter is to be used when the obstacle moves location
    public void setCurNode(Node curNode) {
        this.curNode = curNode;
    }
}
