package com.droidbaza.movies.api;

import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import static com.droidbaza.movies.utils.Constants.BASE_URL;

/**
 * Created by droidbaza on 16/10/19.
 */
public class ApiService {

    private static Retrofit getRetrofitInstance(){
        return new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();
    }

    public static MovieApi getMovieApi(){
        return getRetrofitInstance().create(MovieApi.class);
    }
}
