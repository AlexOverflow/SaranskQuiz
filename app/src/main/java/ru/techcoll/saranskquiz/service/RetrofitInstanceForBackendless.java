package ru.techcoll.saranskquiz.service;

import java.io.IOException;

import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


public class RetrofitInstanceForBackendless {

    private static final String APP_ID = "B4CEA9BF-3B7C-B434-FFB3-4BD31CCB9800";
    private static final String SECRET_KEY = "7B647986-E09E-59D5-FFEC-8E0DCB2A5C00";

    public static final Retrofit retrofit = new Retrofit.Builder()
            .baseUrl("http://api.backendless.com/v1/data/")
            .addConverterFactory(GsonConverterFactory.create())
            .client(new OkHttpClient.Builder().addInterceptor(new Interceptor() {
                @Override
                public Response intercept(Interceptor.Chain chain) throws IOException {
                    Request original = chain.request();

                    Request request = original.newBuilder()
                            .header("application-id", APP_ID )
                            .header("secret-key",  SECRET_KEY)
                            .header("application-type", "REST")
                            .build();

                    return chain.proceed(request);
                }
            }).build())
            .build();
}
