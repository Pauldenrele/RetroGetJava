package com.example.retrogetjava;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    private TextView textViewRespponse;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textViewRespponse = findViewById(R.id.text_view_response);

        Retrofit retrofit = new Retrofit.Builder()
                                 .baseUrl("https://app-6924d9ff-0550-4ff9-9ac7-8d6cee9c5136.cleverapps.io/")
                                 .addConverterFactory(GsonConverterFactory.create())
                 .build();

        JsonApi jsonApi = retrofit.create(JsonApi.class);

        Call<List<Post>> call = jsonApi.getApi();

        call.enqueue(new Callback<List<Post>>() {
            @Override
            public void onResponse(Call<List<Post>> call, Response<List<Post>> response) {
                if(!response.isSuccessful()){
                    textViewRespponse.setText("code: " + response.code());
                    return;

                }

                List<Post> posts = response.body();

                for(Post post:posts){
                    String content = "";
                    content += "ID" + post.getId()  + "\n";
                    content += "Title" + post.getTitle() ;

                    textViewRespponse.append(content);

                }
            }

            @Override
            public void onFailure(Call<List<Post>> call, Throwable t) {
          textViewRespponse.setText(t.getMessage());
            }
        });


    }
}
