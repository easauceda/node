package com.cs437.androidwithmark.node;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.RelativeLayout;
import android.widget.TextView;


public class GameBoardActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_board);

        TextView test = new TextView(this);
        test.setText("Hello, World! This is a test");

        RelativeLayout container = (RelativeLayout) findViewById(R.id.container);
        if (container != null) {
            container.addView(test);
            container.invalidate();
        }

    }
}
