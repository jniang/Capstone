package com.example.jenniferniang.karatetournament_app.db;


import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;
import android.support.annotation.NonNull;

@Entity(tableName = "register_table")
public class Register {

    @PrimaryKey(autoGenerate = true)
    private int userID;

    // User Registration Data: 14 things for data fields
    private String userName;
    private String lastName;
    private String firstName;
    private String delegRole;
    private String age;
    private String gender;
    private String city;
    private String country;
    private String zipCode;
    private String weight;
    private String experience;
    private String clubID;
    private String instructorLastName;
    private String registerPic;

    public Register(String userName, String lastName, String firstName, String delegRole,
                String age, String gender, String city, String country, String zipCode,
                String weight, String experience, String clubID, String instructorLastName,
                String registerPic){
        this.userName = userName;
        this.lastName = lastName;
        this.firstName = firstName;
        this.delegRole = delegRole;
        this.age = age;
        this.gender = gender;
        this.city = city;
        this.country = country;
        this.zipCode = zipCode;
        this.weight = weight;
        this.experience = experience;
        this.clubID = clubID;
        this.instructorLastName = instructorLastName;
        this.registerPic = registerPic;

    }


    //adding all of my getter and setter for my register data
    public int getUserID() {
        return userID;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }



    //1) userName
    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    //2) lastName
    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    //3) firstName
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    //4) Delegation Role
    public String getDelegRole() {
        return delegRole;
    }

    public void setDelegRole(String delegRole) {
        this.delegRole = delegRole;
    }

    //5) age
    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    //6) gender
    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {this.gender = gender;}

    //7) city
    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    //8) country
    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    //9) zipcode
    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    //10) weight
    public String getWeight() {
        return weight;
    }

    public void setWeight(String weight) {
        this.weight = weight;
    }

    //11) experience
    public String getExperience() { return experience; }

    public void setExperience(String experience) { this.experience= experience; }

    //12) clubID
    public String getClubID() {
        return clubID;
    }

    public void setClubID(String clubID) {
        this.clubID = clubID;
    }

    //13) instructor's last name
    public String getInstructorLastName() {
        return instructorLastName;
    }

    public void setInstructorLastName(String instructorLastName) {this.instructorLastName = instructorLastName;}

    //14) register picture
    public String getRegisterPic() { return registerPic; }

    public void setRegisterPic(String pic) { this.registerPic = pic; }

}
