package com.cs437.androidwithmark.node;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;

/**
 * Created by arendon on 6/4/16.
 */
public class Node {
    boolean isActive;
    Node partner;
    int cx, cy;

    public Node(int x, int y){
        isActive = false;
        partner = null;
        cx = x;
        cy = y;
    }

    public void draw(Canvas canvas){
        Paint paint = new Paint();
        int radius = 15;
        if (isActive){
            paint.setColor(Color.BLUE);
        }
        canvas.drawCircle(this.cx, this.cy, radius, paint);
    }

    public void drawLine(Canvas canvas, int sx, int sy){
        Paint paint = new Paint();

        canvas.drawLine(this.cx, this.cy, sx, sy, paint);
    }

    public boolean isActive() {
        return isActive;
    }

    public void setIsActive(boolean isActive) {
        this.isActive = isActive;
    }

    public Node getPartner() {
        return partner;
    }

    public void setPartner(Node partner) {
        this.partner = partner;
    }
}
