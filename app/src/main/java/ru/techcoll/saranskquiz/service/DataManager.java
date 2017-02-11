package ru.techcoll.saranskquiz.service;


import java.io.IOException;
import java.io.Serializable;
import java.util.List;

import retrofit2.Call;
import ru.techcoll.saranskquiz.model.Answer;
import ru.techcoll.saranskquiz.model.Quiz;

public class DataManager {

    private AnswerApiService answerApiService;
    private QuizApiService quizApiService;

    public DataManager(){
        answerApiService = RetrofitInstanceForBackendless.retrofit.create(AnswerApiService.class);
        quizApiService = RetrofitInstanceForBackendless.retrofit.create(QuizApiService.class);
    }


    public List<Answer> getAnswerList() throws IOException {
        Call<AnswerList> call = answerApiService.getAnswerList();
        return call.execute().body().getData();
    }

    public List<Quiz> getQuizList() throws IOException {
        Call<QuizList> call = quizApiService.getQuizes();
        return call.execute().body().getData();
    }

    public Quiz getQuiz(String id) throws IOException {
        Call<Quiz> call =  quizApiService.getQuiz(id);
        return call.execute().body();
    }





    /*public void getAnswerListAsync(){
        Call<AnswerList> call = answerApiService.getAnswerList();
        call.enqueue(new Callback<AnswerList>() {
            @Override
            public void onResponse(Call<AnswerList> call, Response<AnswerList> response) {
                List<Answer> answerList = response.body().getData();
                Log.e("Backendless", answerList.get(0).toString());
            }
            @Override
            public void onFailure(Call<AnswerList> call, Throwable t) {
                Log.e("Main Activity", t.toString());
            }
        });
    }*/



     class AnswerList implements Serializable {
        private List<Answer> data;

        public List<Answer> getData() {
            return data;
        }

        public void setData(List<Answer> data) {
            this.data = data;
        }
    }

    class QuizList implements Serializable {
        private List<Quiz> data;

        public List<Quiz> getData() {
            return data;
        }

        public void setData(List<Quiz> data) {
            this.data = data;
        }
    }

}
