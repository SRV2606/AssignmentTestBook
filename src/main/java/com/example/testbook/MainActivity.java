package com.example.testbook;

import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import com.example.testbook.Helpers.Injector;
import com.example.testbook.Model.CourseCards;
import com.example.testbook.ViewModels.CourseCardViewModel;
import com.example.testbook.ViewModels.CourseCardsViewModelFactory;

import java.util.Objects;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.checkbox)
    TextView checkbox;
    private CourseCardViewModel courseViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        CourseCardsViewModelFactory viewModelFactory = Injector.provideViewModelFactory(Objects.requireNonNull(getApplication()));
        courseViewModel = ViewModelProviders.of(this, viewModelFactory).get(CourseCardViewModel.class);
        observeLiveDetails();
    }

    private void observeLiveDetails() {
        courseViewModel.getCourseCards().observe(this, new Observer<CourseCards>() {

            @Override
            public void onChanged(CourseCards courseCards) {
                Toast.makeText(MainActivity.this, "check" + courseCards.getSuccess(), Toast.LENGTH_SHORT).show();
                checkbox.setText(courseCards.getCourses().getClasses().get(0).getId());
            }
        });
    }
}