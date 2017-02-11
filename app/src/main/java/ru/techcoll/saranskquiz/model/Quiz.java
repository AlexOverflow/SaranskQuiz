package ru.techcoll.saranskquiz.model;


import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.List;

public class Quiz implements Serializable {

    @SerializedName("title")
    @Expose
    private String name;

    @SerializedName("question_list")
    @Expose
    private List<Question> questionList;

    private String image;

    public List<Question> getQuestionList() {
        return questionList;
    }

    public void setQuestionList(List<Question> questionList) {
        this.questionList = questionList;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Quiz{" +
                "name='" + name + '\'' +
                ", questionList=" + questionList +
                '}';
    }

    public String getImage() {
        return image;
    }
}
