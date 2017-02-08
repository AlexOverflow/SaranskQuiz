package ru.techcoll.saranskquiz.view.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;
import ru.techcoll.saranskquiz.R;
import ru.techcoll.saranskquiz.model.FireBaseDataStorage;
import ru.techcoll.saranskquiz.model.Question;

public class MenuActivity extends AppCompatActivity {

    final FireBaseDataStorage<Question> dataStorage = new FireBaseDataStorage<>(Question.class);

    @BindView(R.id.new_game_button) Button newGameButton;
    @BindView(R.id.contiute_game_button) Button contiuteGameButton;
    @BindView(R.id.exit_button) Button exitButton;

    @BindView(R.id.game_count) TextView gameCountTextView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        List<String> list = new LinkedList<>();
        ArrayList<Question> questionList = new ArrayList<>();
        Log.e("fff", "test");
        list.add("question");
        dataStorage.addContentFromFireBase(questionList, list);
        for(Question q : questionList){
            Log.e("Firebase", q.toString());
        }
    }


    @OnClick(R.id.new_game_button)
    public void createNewGame(){

    }



}
