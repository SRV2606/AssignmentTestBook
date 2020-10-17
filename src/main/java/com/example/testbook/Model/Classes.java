package com.example.testbook.Model;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

public class Classes extends ClassLoader implements Parcelable {

    public static final Creator<Classes> CREATOR = new Creator<Classes>() {
        @Override
        public Classes createFromParcel(Parcel in) {
            return new Classes(in);
        }

        @Override
        public Classes[] newArray(int size) {
            return new Classes[size];
        }
    };
    @SerializedName("_id")
    String id;

    @SerializedName("courseLogo")

    String courseLogo;

    @SerializedName("classInfo")

    ClassInfo classInfo;

    @SerializedName("titles")

    String courseTitles;

    protected Classes(Parcel in) {

        id = in.readString();
        courseLogo = in.readString();
        courseTitles = in.readString();
        in.readValue(classInfo);
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCourseLogo() {
        return courseLogo;
    }

    public void setCourseLogo(String courseLogo) {
        this.courseLogo = courseLogo;
    }

    public ClassInfo getClassInfo() {
        return classInfo;
    }

    public void setClassInfo(ClassInfo classInfo) {
        this.classInfo = classInfo;
    }

    public String getCourseTitles() {
        return courseTitles;
    }

    public void setCourseTitles(String courseTitles) {
        this.courseTitles = courseTitles;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {

        parcel.writeString(id);
        parcel.writeString(courseLogo);
        parcel.writeString(courseTitles);
        parcel.writeValue(classInfo);
    }
}
