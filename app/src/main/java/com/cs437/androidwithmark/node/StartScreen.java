package com.cs437.androidwithmark.node;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class StartScreen extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start_screen);

        Button start = (Button) findViewById(R.id.button);
        start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent startGame = new Intent(v.getContext(), GameBoardActivity.class);
                startActivity(startGame);
            }
        });
    }
}
