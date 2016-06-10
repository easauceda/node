package com.cs437.androidwithmark.node;

import android.content.Intent;
import android.os.Bundle;
import android.app.Activity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class GameOver extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_over);
        ImageView endGameImage = (ImageView) findViewById(R.id.imageView2);
        Intent intent = getIntent();
        boolean winner = intent.getBooleanExtra("Winner", false);

        endGameImage.setImageResource(winner ? R.drawable.win : R.drawable.lose);

        Button playAgain = (Button) findViewById(R.id.button2);

        playAgain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent startAnotherGame = new Intent(v.getContext(), GameBoardActivity.class);
                startAnotherGame.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                startActivity(startAnotherGame);
            }
        });
    }

}
