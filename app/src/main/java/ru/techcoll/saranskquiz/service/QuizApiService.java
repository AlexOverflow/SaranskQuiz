package ru.techcoll.saranskquiz.service;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;
import ru.techcoll.saranskquiz.model.Quiz;

public interface QuizApiService {

    @GET("Quizes")
    Call<DataManager.QuizList> getQuizes();

    @GET("Quizes/{objectId}")
    Call<Quiz> getQuiz(@Path("objectId") String id);

}
