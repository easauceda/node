package com.cs437.androidwithmark.node;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.widget.RelativeLayout;


public class GameBoardActivity extends Activity {
    GameBoardView test;
    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_board);

        test = new GameBoardView(this);


        RelativeLayout container = (RelativeLayout) findViewById(R.id.container);
        if (container != null) {
            container.addView(test);
            container.invalidate();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        super.onCreateOptionsMenu(menu);
        menu.add("New Game");
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item){
        if (item.getTitle() == "New Game"){
            test.startGame();
        }
        return true;
    }

}
