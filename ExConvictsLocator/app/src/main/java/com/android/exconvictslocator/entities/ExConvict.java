package com.android.exconvictslocator.entities;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import com.fasterxml.jackson.annotation.JsonProperty;


@Entity
public class ExConvict {

    @NonNull
    @ColumnInfo
    @PrimaryKey(autoGenerate = true)
    @JsonProperty("id")
    private int id;
    @ColumnInfo
    @JsonProperty("firstName")
    private String firstName;
    @ColumnInfo
    @JsonProperty("lastName")
    private String lastName;
    @ColumnInfo
    @JsonProperty("pseudonym")
    private String pseudonym;
    @ColumnInfo
    @JsonProperty("photo")
    private int photo;
    @ColumnInfo
    @JsonProperty("address")
    private String address;
    @ColumnInfo
    @JsonProperty("gender")
    private String gender;
    @ColumnInfo
    @JsonProperty("dateOfBirth")
    private String dateOfBirth;
    @ColumnInfo
    @JsonProperty("crime")
    private String crime;
    @ColumnInfo
    @JsonProperty("description")
    private String description;

    public ExConvict(){}

    public ExConvict(String firstName, String lastName, String pseudonym, int photo, String address, String gender, String dateOfBirth, String crime, String description) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.pseudonym = pseudonym;
        this.photo = photo;
        this.address = address;
        this.gender = gender;
        this.dateOfBirth = dateOfBirth;
        this.crime = crime;
        this.description = description;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPseudonym() {
        return pseudonym;
    }

    public void setPseudonym(String pseudonym) {
        this.pseudonym = pseudonym;
    }

    public int getPhoto() {
        return photo;
    }

    public void setPhoto(int photo) {
        this.photo = photo;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getCrime() {
        return crime;
    }

    public void setCrime(String crime) {
        this.crime = crime;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }



}
