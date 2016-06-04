package com.cs437.androidwithmark.node;

import android.graphics.Canvas;
import android.graphics.Paint;

/**
 * Created by arendon on 6/4/16.
 */
public class Node {
    boolean isActive;
    Node partner;
    int cx, cy;

    public Node(){
        isActive = false;
        partner = null;
    }

    public void draw(Canvas canvas, int x, int y){
        Paint paint = new Paint();
        int radius = 5;
        cx = x;
        cy = y;

        canvas.drawCircle(x, y, radius, paint);
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
