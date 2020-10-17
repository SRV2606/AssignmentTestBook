package com.example.testbook.Model;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

public class Courses extends ClassLoader implements Parcelable {


    public static final Creator<Courses> CREATOR = new Creator<Courses>() {
        @Override
        public Courses createFromParcel(Parcel in) {
            return new Courses(in);
        }

        @Override
        public Courses[] newArray(int size) {
            return new Courses[size];
        }
    };
    @SerializedName("classes")
    List<Classes> classes;

    protected Courses(Parcel in) {
        classes = new ArrayList<>();
        in.readList(classes, Classes.class.getClassLoader());
    }

    public List<Classes> getClasses() {
        return classes;
    }

    public void setClasses(List<Classes> classes) {
        this.classes = classes;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {

        parcel.writeList(classes);
    }
}
