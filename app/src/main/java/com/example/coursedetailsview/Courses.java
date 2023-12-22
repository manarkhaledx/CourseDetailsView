package com.example.coursedetailsview;

import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.DrawableRes;
import androidx.annotation.NonNull;

public class Courses implements Parcelable {
    String content;
    @DrawableRes int courseImage;

    public Courses(String content, @DrawableRes int courseImage) {
        this.content = content;
        this.courseImage=courseImage;
    }


    protected Courses(Parcel in) {
        content = in.readString();
        courseImage = in.readInt();
    }

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

    @Override
    public int describeContents() {
        return 0;
    }

    public void writeToParcel(@NonNull Parcel dest, int flags) {
        dest.writeString(content);
        dest.writeInt(courseImage);
    }
}
