package com.example.testbook.Model.Repository;

import android.app.Application;

import androidx.lifecycle.LiveData;

import com.example.testbook.Model.CourseCards;
import com.example.testbook.Model.Network.RemoteNetworkCall;

public class TRepository {

    private static final Object LOCK = new Object();
    private static TRepository mRepository;
    private LiveData<CourseCards> courseCards;

    public TRepository(Application application) {


    }


    public synchronized static TRepository getInstance(Application application) {
        if (mRepository == null) {
            synchronized (LOCK) {
                mRepository = new TRepository(application);
            }
        }
        return mRepository;
    }


    public LiveData<CourseCards> getCourseCards() {
        courseCards = RemoteNetworkCall.getCourseCards(true, true);
        return courseCards;
    }


}
