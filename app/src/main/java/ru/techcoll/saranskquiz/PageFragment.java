package ru.techcoll.saranskquiz;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;

import java.util.List;

import ru.techcoll.saranskquiz.service.GameDataManager;
import ru.techcoll.saranskquiz.model.Quiz;


public class PageFragment extends Fragment {


    static{


    }

    static final String ARGUMENT_PAGE_NUMBER = "arg_page_number";

    int pageNumber;
    List<Quiz> QList;
    GameDataManager gameDataManager = GameDataManager.getInstance();
    Quiz currQuiz;


    public PageFragment() {
        // Required empty public constructor
    }


    static PageFragment newInstance(int page) {
        PageFragment pageFragment = new PageFragment();
        Bundle args = new Bundle();
        args.putInt(ARGUMENT_PAGE_NUMBER, page);
        pageFragment.setArguments(args);
        return pageFragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        pageNumber = getArguments().getInt(ARGUMENT_PAGE_NUMBER);

        while(gameDataManager.getQuizList() == null){
            Log.e("dd", "WAIT");
        }
        currQuiz = QList.get(pageNumber);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_page, null);

        ImageView ivPicQuiz = (ImageView) view.findViewById(R.id.ivPicQuiz);

        Picasso.with(getActivity())
                .load(currQuiz.getImage())
                .placeholder(R.drawable.error_pic_quiz)
                .error(R.drawable.error_pic_quiz)
                .into(ivPicQuiz);

        return view;
    }
}
