package ru.techcoll.saranskquiz.view.activity;

import android.content.Intent;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.TextView;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import ru.techcoll.saranskquiz.QuizSwitcherActivity;
import ru.techcoll.saranskquiz.R;
import ru.techcoll.saranskquiz.model.FireBaseDataStorage;
import ru.techcoll.saranskquiz.model.Question;
import ru.techcoll.saranskquiz.model.Quiz;
import ru.techcoll.saranskquiz.service.DataManager;
import ru.techcoll.saranskquiz.service.GameDataManager;

public class MenuActivity extends AppCompatActivity {

    final FireBaseDataStorage<Question> dataStorage = new FireBaseDataStorage<>(Question.class);

    @BindView(R.id.new_game_button) Button newGameButton;
    @BindView(R.id.contiute_game_button) Button contiuteGameButton;
    @BindView(R.id.exit_button) Button exitButton;

    //@BindView(R.id.game_count) TextView gameCountTextView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
        ButterKnife.bind(this);

        new TestTask().execute();
        GameDataManager dataManager = GameDataManager.getInstance();
        List<Quiz> list = dataManager.getQuizList();
        for(Quiz q : list){
            Log.e("Back", q.toString());
        }







    }


    @OnClick(R.id.new_game_button)
    public void createNewGame(){
        Intent i = new Intent(this, QuizSwitcherActivity.class);
        startActivityForResult(i, 1);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if(data == null){ return;}
       String id = data.getStringExtra("objectId");
       Intent intent = new Intent(this, GameQuizActivity.class);
        intent.putExtra("objectId", id);
        startActivity(intent);
    }
}



class TestTask extends AsyncTask<Void, Void, Void> {

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
    }

    @Override
    protected Void doInBackground(Void... params) {
        DataManager manager = new DataManager();
        List<Quiz> list = new ArrayList<>();
        try {
            list = manager.getQuizList();
        } catch (IOException e) {
            e.printStackTrace();
        }
        Log.e("Backendless", list.get(0).toString());
        GameDataManager dataManager = GameDataManager.getInstance();
        dataManager.setQuizList(list);
        return  null;
    }

    @Override
    protected void onPostExecute(Void result) {
        super.onPostExecute(result);
    }
}




