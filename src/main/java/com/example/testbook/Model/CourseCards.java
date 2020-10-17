package com.example.testbook.Model;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

public class CourseCards extends ClassLoader implements Parcelable {


    public static final Creator<CourseCards> CREATOR = new Creator<CourseCards>() {
        @Override
        public CourseCards createFromParcel(Parcel in) {
            return new CourseCards(in);
        }

        @Override
        public CourseCards[] newArray(int size) {
            return new CourseCards[size];
        }
    };
    @SerializedName("data")
    Courses courses;
    @SerializedName("success")
    Boolean success;

    public CourseCards() {

    }

    protected CourseCards(Parcel in) {
        in.readValue(courses);
        this.success = (Boolean) in.readValue(Boolean.class.getClassLoader());
    }

    public Courses getCourses() {
        return courses;
    }

    public void setCourses(Courses courses) {
        this.courses = courses;
    }

    public Boolean getSuccess() {
        return success;
    }

    public void setSuccess(Boolean success) {
        this.success = success;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {

        parcel.writeValue(courses);
        parcel.writeValue(success);
    }
}
