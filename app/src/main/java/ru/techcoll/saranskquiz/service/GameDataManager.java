package ru.techcoll.saranskquiz.service;

import android.util.Log;

import java.util.List;

import ru.techcoll.saranskquiz.model.CurrentQuiz;
import ru.techcoll.saranskquiz.model.Quiz;


public class GameDataManager {
    private static GameDataManager ourInstance = new GameDataManager();

    public static GameDataManager getInstance() {
        return ourInstance;
    }

    List<Quiz> quizList;

    CurrentQuiz currentQuiz;

    private GameDataManager() {

    }

    public CurrentQuiz getCurrentQuiz() {
        return currentQuiz;
    }

    public List<Quiz> getQuizList() {
        return quizList;
    }

    public void setCurrentQuiz(CurrentQuiz currentQuiz) {
        ourInstance.setCurrentQuiz(currentQuiz);
    }

    public static GameDataManager getOurInstance() {
        return ourInstance;
    }

    public static void setOurInstance(GameDataManager ourInstance) {
        GameDataManager.ourInstance = ourInstance;
    }

    public void setQuizList(List<Quiz> quizList) {
        Log.e("LOG", quizList.toString());
        ourInstance.setQuizList(quizList);
    }
}
