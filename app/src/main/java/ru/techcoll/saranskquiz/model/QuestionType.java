package ru.techcoll.saranskquiz.model;

import java.io.Serializable;

public enum QuestionType implements Serializable {

    TEXT_OR_IMAGE("TEXT_OR_IMAGE"),
    TEXT("TEXT"),
    TEXT_OR_IMAGE_INPUT("TEXT_OR_IMAGE_INPUT"),
    GEO("GEO"),
    TEXT_INPUT("TEXT_INPUT");


      QuestionType(String name){
        this.name = name;
    }

    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "QuestionType{" +
                "name='" + name + '\'' +
                '}';
    }
}
