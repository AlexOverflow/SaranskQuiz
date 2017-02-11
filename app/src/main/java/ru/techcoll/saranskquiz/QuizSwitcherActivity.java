package ru.techcoll.saranskquiz;

import android.os.AsyncTask;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import ru.techcoll.saranskquiz.model.Quiz;
import ru.techcoll.saranskquiz.service.DataManager;
import ru.techcoll.saranskquiz.service.GameDataManager;

public class QuizSwitcherActivity extends AppCompatActivity {

    static final String TAG = "MyLogs";
    //заменить на количество викторин всего
    int pageCount = 10;

    ViewPager pager;
    PagerAdapter pagerAdapter;

    List<Quiz> QuizList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz_switcher);

        pager = (ViewPager) findViewById(R.id.pager);
        pagerAdapter = new MyFragmentPagerAdapter(getSupportFragmentManager());
        pager.setAdapter(pagerAdapter);

        pager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
                //лог можно убрать
                Log.d(TAG, "onPageSelected, position = " + position);
            }

            @Override
            public void onPageSelected(int position) {

            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }

    private class MyFragmentPagerAdapter extends FragmentPagerAdapter {

        public MyFragmentPagerAdapter(FragmentManager fm){
            super(fm);
        }

        @Override
        public Fragment getItem(int position){
            return PageFragment.newInstance(position);
        }

        @Override
        public int getCount(){
            return pageCount;
        }

        @Override
        public CharSequence getPageTitle(int position){
            return "Quiz " + position;
        }

    }

    class TestTask extends AsyncTask<Void, Void, List<Quiz>> {

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
        }

        @Override
        protected List<Quiz> doInBackground(Void... params) {
            DataManager manager = new DataManager();
            List<Quiz> list = new ArrayList<>();
            try {
                list = manager.getQuizList();
            } catch (IOException e) {
                e.printStackTrace();
            }
            Log.e("Backendless", list.get(0).toString());

            pageCount = QuizList.size();

            GameDataManager gameDataManager = GameDataManager.getInstance();
            gameDataManager.setQuizList(list);

            return null;
        }

        @Override
        protected void onPostExecute(List<Quiz> result) {

            super.onPostExecute(result);

        }
    }
}
