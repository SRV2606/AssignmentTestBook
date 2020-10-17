package com.example.testbook.Model.Network;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.example.testbook.Model.CourseCards;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.observers.DisposableObserver;
import io.reactivex.schedulers.Schedulers;

public class RemoteNetworkCall {

    private static MutableLiveData<CourseCards> mutableLiveData = new MutableLiveData<>();

    private static Observable<CourseCards> mObservableCourseCards;


    private static CompositeDisposable com = new CompositeDisposable();

    private static ApiService services = NetworkAdapter.getRetrofitInstance().create(ApiService.class);


    public static LiveData<CourseCards> getCourseCards(Boolean isPremium, Boolean isIndividual) {
        mObservableCourseCards = services.getCourseCards(isPremium, isIndividual);
        com.add(mObservableCourseCards.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(new DisposableObserver<CourseCards>() {


                    @Override
                    public void onNext(CourseCards courseCards) {

                        mutableLiveData.postValue(courseCards);
                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onComplete() {

                    }

                }));
        return mutableLiveData;


    }
}
