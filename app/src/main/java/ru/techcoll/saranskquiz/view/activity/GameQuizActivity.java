package ru.techcoll.saranskquiz.view.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import ru.techcoll.saranskquiz.R;

public class GameQuizActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_quiz);
        String id = getIntent().getStringExtra("objectId");

    }



}
