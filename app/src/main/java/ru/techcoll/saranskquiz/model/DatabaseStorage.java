package ru.techcoll.saranskquiz.model;


import java.util.ArrayList;

public interface DatabaseStorage {

     /*  В этом методе в качестве параметра указываете пустой ArrayList вопросов
     и этот массив заполняется объектами вопросов из пакета model( данные берутся из Firebase)
      */
     void setListQuestion(ArrayList<Question> questionArrayList);


     /*
      Этот метод отличается от предыдущего тем что заполняет не переданный массив
      а единичный объект вопроса, также в метод нужно передать uuid объекта вторым праметром.
     */
     void setQuestion(Question question, String questionId);
}
