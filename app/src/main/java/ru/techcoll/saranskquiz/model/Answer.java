package ru.techcoll.saranskquiz.model;

import java.io.Serializable;



public class Answer implements Serializable {

    private String objectId;
    private String text;

    public String getObjectId() {
        return objectId;
    }

    public void setObjectId(String objectId) {
        this.objectId = objectId;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    @Override
    public String toString() {
        return "Answer{" +
                "objectId='" + objectId + '\'' +
                ", text='" + text + '\'' +
                '}';
    }
}
