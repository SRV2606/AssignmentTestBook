package com.example.testbook.ViewModels;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import com.example.testbook.Model.CourseCards;
import com.example.testbook.Model.Repository.TRepository;

public class CourseCardViewModel extends ViewModel {

    private final TRepository mRepository;
    private TRepository mRepo;
    private LiveData<CourseCards> courseCards;

    public CourseCardViewModel(TRepository repository) {
        mRepository = repository;
    }

    public LiveData<CourseCards> getCourseCards() {
        courseCards = mRepository.getCourseCards();
        return courseCards;
    }

}
