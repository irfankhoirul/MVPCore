package com.irfankhoirul.mvp_core.base;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Merupakan Super Class dari kelas model dalam aplikasi. Berisi atribut standar yaitu id,
 * createdAt, dan updatedAt
 *
 * @author Irfan Khoirul Muhlishin - irfankhoirul@gmail.com
 * @since 1.0 (7 November 2016)
 */

public class BasePojo implements Parcelable {
    public static final Creator<BasePojo> CREATOR = new Creator<BasePojo>() {
        @Override
        public BasePojo createFromParcel(Parcel in) {
            return new BasePojo(in);
        }

        @Override
        public BasePojo[] newArray(int size) {
            return new BasePojo[size];
        }
    };
    @SerializedName("id")
    @Expose
    protected int id;
    @SerializedName("created_at")
    @Expose
    protected String createdAt;
    @SerializedName("updated_at")
    @Expose
    protected String updatedAt;

    protected BasePojo(Parcel in) {
        id = in.readInt();
        createdAt = in.readString();
        updatedAt = in.readString();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    public String getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(String updatedAt) {
        this.updatedAt = updatedAt;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(id);
        dest.writeString(createdAt);
        dest.writeString(updatedAt);
    }
}
