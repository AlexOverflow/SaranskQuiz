package ru.techcoll.saranskquiz.model;

import java.io.Serializable;
import java.util.List;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;


public class Question implements Serializable {

    @SerializedName("image")
    @Expose
    private String image;
    @SerializedName("true_answer")
    @Expose
    private Answer trueAnswer;
    @SerializedName("incorrect_answers")
    @Expose
    private List<Answer> answers;
    @SerializedName("text")
    @Expose
    private String text;
   // @SerializedName("question_type")
   // @Expose
   // private QuestionType questionType;
    @SerializedName("objectId")
    @Expose
    private String id;

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public List<Answer> getAnswers() {
        return answers;
    }

    public void setAnswers(List<Answer> answers) {
        this.answers = answers;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Answer getTrueAnswer() {
        return trueAnswer;
    }

    public void setTrueAnswer(Answer trueAnswer) {
        this.trueAnswer = trueAnswer;
    }

    @Override
    public String toString() {
        return "Question{" +
                "image='" + image + '\'' +
                ", answers=" + answers +
                ", text='" + text + '\'' +
                ", id='" + id + '\'' +
                '}';
    }
}

