package com.example.testbook.Helpers;

import android.app.Application;

import com.example.testbook.Model.Repository.TRepository;
import com.example.testbook.ViewModels.CourseCardsViewModelFactory;

public class Injector {

    private static TRepository provideRepository(Application context) {


        return TRepository.getInstance(context);
    }

    public static CourseCardsViewModelFactory provideViewModelFactory(Application application) {
        TRepository repository = provideRepository(application);
        return new CourseCardsViewModelFactory(repository);
    }


}
