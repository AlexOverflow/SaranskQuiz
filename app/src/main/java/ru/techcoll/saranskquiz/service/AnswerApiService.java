package ru.techcoll.saranskquiz.service;


import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import ru.techcoll.saranskquiz.model.Answer;


public interface AnswerApiService {

    @GET("Answers")
    Call<DataManager.AnswerList> getAnswerList();

}
