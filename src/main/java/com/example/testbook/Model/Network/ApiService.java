package com.example.testbook.Model.Network;

import com.example.testbook.Model.CourseCards;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ApiService {


    @GET("popular-courses?")
    Observable<CourseCards> getCourseCards(
            @Query("isPremium") Boolean isPremium,
            @Query("includeIndividual") Boolean includeIndividual
    );


}
