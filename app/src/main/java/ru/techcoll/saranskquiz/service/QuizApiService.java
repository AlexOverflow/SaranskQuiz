package ru.techcoll.saranskquiz.service;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import ru.techcoll.saranskquiz.model.Quiz;

public interface QuizApiService {

    @GET("Quizes")
    Call<DataManager.QuizList> getQuizes();



}
