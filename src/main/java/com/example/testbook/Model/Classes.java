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

    protected Classes(Parcel in) {

        id = in.readString();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {

        parcel.writeString(id);
    }
}
