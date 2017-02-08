package ru.techcoll.saranskquiz.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;


public class Question {
    @SerializedName("image")
    @Expose
    private String image;
    @SerializedName("question_list")
    @Expose
    private ArrayList<String> question_list;
    @SerializedName("text")
    @Expose
    private String text;
    @SerializedName("uuid")
    @Expose
    private String uuid;

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public ArrayList<String> getQuestionList() {
        return question_list;
    }

    public void setQuestion_list(ArrayList<String> questionList) {
        this.question_list = questionList;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    @Override
    public String toString() {
        return "Question{" +
                "image='" + image + '\'' +
                ", questionList=" + question_list +
                ", text='" + text + '\'' +
                ", uuid='" + uuid + '\'' +
                '}';
    }
}

