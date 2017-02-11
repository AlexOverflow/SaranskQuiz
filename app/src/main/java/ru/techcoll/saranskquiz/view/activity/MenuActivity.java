package ru.techcoll.saranskquiz.view.activity;

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
import butterknife.OnClick;
import ru.techcoll.saranskquiz.R;
import ru.techcoll.saranskquiz.model.FireBaseDataStorage;
import ru.techcoll.saranskquiz.model.Question;
import ru.techcoll.saranskquiz.model.Quiz;
import ru.techcoll.saranskquiz.service.DataManager;

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

        new TestTask().execute();







    }


    @OnClick(R.id.new_game_button)
    public void createNewGame(){

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
            list.add(manager.getQuiz("3BD69120-9283-8C76-FFBD-24E52A941B00"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        Log.e("Backendless", list.get(0).toString());
        return  null;
    }

    @Override
    protected void onPostExecute(Void result) {
        super.onPostExecute(result);
    }
}




