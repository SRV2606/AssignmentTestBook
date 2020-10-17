package com.example.testbook.Model;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

public class ClassInfo extends ClassLoader implements Parcelable {


    public static final Creator<ClassInfo> CREATOR = new Creator<ClassInfo>() {
        @Override
        public ClassInfo createFromParcel(Parcel in) {
            return new ClassInfo(in);
        }

        @Override
        public ClassInfo[] newArray(int size) {
            return new ClassInfo[size];
        }
    };
    @SerializedName("facultiesImage")
    String facultyImageUrl;

    protected ClassInfo(Parcel in) {
        facultyImageUrl = in.readString();
    }

    public String getFacultyImageUrl() {
        return facultyImageUrl;
    }

    public void setFacultyImageUrl(String facultyImageUrl) {
        this.facultyImageUrl = facultyImageUrl;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {parcel.writeString(facultyImageUrl);}
}
