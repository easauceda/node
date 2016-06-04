package com.cs437.androidwithmark.node;

import android.graphics.Canvas;
import android.graphics.Paint;

/**
 * Created by arendon on 6/4/16.
 */
public class Node {
    boolean isActive;
    Node partner;

    public Node(){
        isActive = false;
        partner = null;
    }

    public void draw(Canvas canvas, int x, int y){
        Paint paint = new Paint();
        int radius = 5;

        canvas.drawCircle(x, y, radius, paint);
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
