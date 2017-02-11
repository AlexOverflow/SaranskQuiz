package ru.techcoll.saranskquiz.service;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;
import ru.techcoll.saranskquiz.model.Quiz;

public interface QuizApiService {

    @GET("Quiz")
    Call<DataManager.QuizList> getQuizes();

    @GET("Quiz/{objectId}")
    Call<Quiz> getQuiz(@Path("objectId") String id);

}
