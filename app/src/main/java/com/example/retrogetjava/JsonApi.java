package com.example.retrogetjava;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface JsonApi {

    @GET("api/user/categories")
    Call<List<Post>> getApi();
    
}
