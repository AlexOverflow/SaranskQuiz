package ru.techcoll.saranskquiz.view.activity;

import android.content.Intent;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.squareup.picasso.Picasso;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.BindViews;
import butterknife.ButterKnife;
import butterknife.OnClick;
import ru.techcoll.saranskquiz.R;
import ru.techcoll.saranskquiz.model.Answer;
import ru.techcoll.saranskquiz.model.Question;
import ru.techcoll.saranskquiz.model.Quiz;
import ru.techcoll.saranskquiz.service.DataManager;
import ru.techcoll.saranskquiz.service.GameDataManager;

public class GameQuizActivity extends AppCompatActivity {

    private Quiz quiz = null;
    private List<Question> questionList;
    private int questionIndex = 0;


    @BindView(R.id.question_text)
    TextView textView;

    @BindView(R.id.imageQuestion)
    ImageView imageView;

    @BindViews({R.id.answer1, R.id.answer2, R.id.answer3, R.id.answer4})
    Button[] answerButtons;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        TestTask task = new TestTask();
        task.execute();
        setContentView(R.layout.fragment_text_or_image_question);
        ButterKnife.bind(this);


        //String id = getIntent().getStringExtra("objectId");

    }

    class TestTask extends AsyncTask<Void, Void, List<Quiz>> {

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
        }

        @Override
        protected List<Quiz> doInBackground(Void... params) {
            Log.e("quweue", "gfhhghghghghghghg");
            DataManager manager = new DataManager();
            List<Quiz> list = new ArrayList<>();
            try {
                list = manager.getQuizList();
            } catch (IOException e) {
                e.printStackTrace();
            }
            Log.e("Backendless", list.get(0).toString());
            quiz = list.get(0);
            questionList = quiz.getQuestionList();
            Log.e("Inter", quiz.toString());


            return list;
        }

        @Override
        protected void onPostExecute(List<Quiz> result) {
            quiz = result.get(0);

            loadImage(questionList.get(questionIndex).getImage());

            textView.setText(quiz.getQuestionList().get(0).getText());

            setButtonText(quiz.getQuestionList().get(0));
        }


    }


    @OnClick({R.id.answer1, R.id.answer2, R.id.answer3, R.id.answer4})
    public void click(Button b){
        StringBuilder builder = new StringBuilder();
        if(b.getText().equals(questionList.get(questionIndex).getTrueAnswer().getText())){
            builder.append("correct!");
        }else builder.append("incorrect!");
        Toast tost = Toast.makeText(this, builder.toString(), Toast.LENGTH_SHORT);
        tost.show();
        questionIndex++;
        


    }

    public void setButtonText(Question q){
        List<Answer> answerList = q.getAnswers();
        for(int i = 0; i < 4; i++){
            answerButtons[i].setText(answerList.get(i).getText());
        }



    }

    public void loadImage(String url) {
        Picasso.with(GameQuizActivity.this)
                .load(url)
                .placeholder(R.drawable.error_pic_quiz)
                .error(R.drawable.error_pic_quiz)
                .into(imageView);
    }





}
