package com.example.jenniferniang.karatetournament_app.activity.db;


import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;
import android.support.annotation.NonNull;

@Entity(tableName = "register_table")
public class RegisterTable {

    @PrimaryKey
    @NonNull
    @ColumnInfo(name = "username")
    private String userName;

    @NonNull
    @ColumnInfo(name = "registerdata")
    private String registerJson;

    public RegisterTable(@NonNull String userName, @NonNull String profileJson) {
        this.userName = userName;
        this.registerJson = profileJson;
    }

    public void setUserName(String userName){
        this.userName = userName;
    }

    public void setRegisterJson(String registerJson){
        this.registerJson = registerJson;
    }

    public String getUserName(){
        return userName;
    }

    public String getRegisterJson(){
        return registerJson;
    }

}
