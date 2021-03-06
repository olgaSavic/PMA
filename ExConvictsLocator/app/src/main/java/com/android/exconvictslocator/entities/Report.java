package com.android.exconvictslocator.entities;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.PrimaryKey;

@Entity(foreignKeys ={ @ForeignKey(entity=User.class, parentColumns="id", childColumns="userId"),
        @ForeignKey(entity=ExConvict.class, parentColumns="id", childColumns="exConvictId")  })
public class Report {
    @NonNull
    @ColumnInfo
    @PrimaryKey(autoGenerate = true)
    private int id;
    @ColumnInfo
    private String location;
    @ColumnInfo
    private String date;
    @ColumnInfo
    private String city;
    @ColumnInfo
    private String comment;
    @ColumnInfo
    private int userId;
    @ColumnInfo
    private int exConvictId;
    @ColumnInfo
    private double lat;
    @ColumnInfo
    private double lang;
    @ColumnInfo
    private boolean isSync = true ;

    public Report(){}

    public Report(String location, String date, String city, String comment, int userId, int exConvictId, double lat, double lang) {
        this.location = location;
        this.date = date;
        this.city = city;
        this.comment = comment;
        this.userId = userId;
        this.exConvictId = exConvictId;
        this.lang = lang;
        this.lat = lat;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getExConvictId() {
        return exConvictId;
    }

    public void setExConvictId(int exConvictId) {
        this.exConvictId = exConvictId;
    }

    public double getLat() {
        return lat;
    }

    public void setLat(double lat) {
        this.lat = lat;
    }

    public double getLang() {
        return lang;
    }

    public void setLang(double lang) {
        this.lang = lang;
    }

    public boolean isSync() {
        return isSync;
    }

    public void setSync(boolean sync) {
        isSync = sync;
    }

    @Override
    public String toString() {
        return "Report{" +
                "id=" + id +
                ", location='" + location + '\'' +
                ", date='" + date + '\'' +
                ", city='" + city + '\'' +
                ", comment='" + comment + '\'' +
                ", userId='" + userId + '\'' +
                ", exConvictId=" + exConvictId +
                ", lat=" + lat +
                ", lang=" + lang +
                ", isSync=" + isSync +
                '}';
    }
}
