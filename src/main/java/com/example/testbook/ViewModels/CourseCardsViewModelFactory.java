package com.example.testbook.ViewModels;

import androidx.annotation.NonNull;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

import com.example.testbook.Model.Repository.TRepository;

public class CourseCardsViewModelFactory extends ViewModelProvider.NewInstanceFactory {
    private final TRepository mRepository;

    public CourseCardsViewModelFactory(TRepository repository) {
        mRepository = repository;
    }


    @NonNull
    @Override
    @SuppressWarnings("unchecked cast")
    public <T extends ViewModel> T create(@NonNull Class<T> modelClass) {
        return (T) new CourseCardViewModel(mRepository);
    }
}
