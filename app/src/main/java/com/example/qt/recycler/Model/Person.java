package com.example.qt.recycler.Model;

import android.os.Parcel;
import android.os.Parcelable;

public class Person implements Parcelable {

    private String name;
    private String age;
    private int photoId;

    public Person(){
    }

    public Person(String name, String age, int photoId){
        this.setName(name);
        this.setAge(age);
        this.setPhotoId(photoId);
    }

    protected Person(Parcel in) {
        name = in.readString();
        age = in.readString();
        photoId = in.readInt();
    }

    public static final Creator<Person> CREATOR = new Creator<Person>() {
        @Override
        public Person createFromParcel(Parcel in) {
            return new Person( in );
        }

        @Override
        public Person[] newArray(int size) {
            return new Person[size];
        }
    };

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public int getPhotoId() {
        return photoId;
    }

    public void setPhotoId(int photoId) {
        this.photoId = photoId;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString( name );
        dest.writeString( age );
        dest.writeInt( photoId );
    }
}
