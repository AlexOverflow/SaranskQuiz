package ru.techcoll.saranskquiz.service;

import java.io.IOException;

import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


public class RetrofitInstanceForBackendless {

    private static final String APP_ID =  "E190B2DA-21B5-0F10-FF6A-237DBA3BC000";
    private static final String SECRET_KEY = "A8CDACE5-0C4D-23CD-FF20-36913B3B8200";

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
