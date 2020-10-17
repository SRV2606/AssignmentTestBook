package com.example.testbook;

import android.animation.ArgbEvaluator;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.PagerSnapHelper;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;

import com.example.testbook.Helpers.Injector;
import com.example.testbook.Model.CourseCards;
import com.example.testbook.ViewModels.CourseCardViewModel;
import com.example.testbook.ViewModels.CourseCardsViewModelFactory;

import java.util.Objects;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {


    @BindView(R.id.coursesRecycler)
    RecyclerView coursesRecycler;
    @BindView(R.id.viewPager)
    ViewPager viewPager;


    private CourseCardViewModel courseViewModel;
    Integer[] colors = null;
    ArgbEvaluator argbEvaluator = new ArgbEvaluator();
    private CoursesAdapter coursesAdapter;
    private ViewPAgerAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        CourseCardsViewModelFactory viewModelFactory = Injector.provideViewModelFactory(Objects.requireNonNull(getApplication()));
        courseViewModel = ViewModelProviders.of(this, viewModelFactory).get(CourseCardViewModel.class);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getApplicationContext(), RecyclerView.HORIZONTAL, false);
        coursesRecycler.setLayoutManager(linearLayoutManager);

        Integer[] colors_temp = {
                getResources().getColor(R.color.colorAccent),
                getResources().getColor(R.color.color2),
                getResources().getColor(R.color.color3),
                getResources().getColor(R.color.colorPrimaryDark)
        };

        colors = colors_temp;

        observeLiveDetails();
    }

    private void observeLiveDetails() {
        courseViewModel.getCourseCards().observe(this, new Observer<CourseCards>() {
            @Override
            public void onChanged(CourseCards courseCards) {
                setUpRecyclerView(courseCards);
                setupViewPager(courseCards);
            }
        });
    }

    private void setupViewPager(CourseCards courseCards) {

        adapter = new ViewPAgerAdapter(courseCards, this);
        viewPager.setAdapter(adapter);
        viewPager.setPadding(130, 0, 130, 0);
        viewPager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

                if (position < (adapter.getCount() - 1) && position < (colors.length - 1)) {
                    viewPager.setBackgroundColor(

                            (Integer) argbEvaluator.evaluate(
                                    positionOffset,
                                    colors[position],
                                    colors[position + 1]
                            )
                    );
                } else {
                    viewPager.setBackgroundColor(colors[colors.length - 1]);
                }
            }

            @Override
            public void onPageSelected(int position) {

            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });


    }


    private void setUpRecyclerView(CourseCards courseCards) {

        coursesAdapter = new CoursesAdapter(getApplicationContext(), courseCards, MainActivity.this);
        coursesRecycler.setAdapter(coursesAdapter);
        new PagerSnapHelper().attachToRecyclerView(coursesRecycler);
        coursesAdapter.notifyDataSetChanged();
    }
}