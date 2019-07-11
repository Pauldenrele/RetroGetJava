package com.example.retrogetjava;

import com.google.gson.annotations.SerializedName;

public class Post {
    private String Id;
    private String title;

    @SerializedName("categories")
    private String text;

    public String getId() {
        return Id;
    }

    public String getTitle() {
        return title;
    }

    public String getText() {
        return text;
    }
}
