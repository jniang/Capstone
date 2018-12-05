package com.example.jenniferniang.karatetournament_app.Utils;

import com.example.jenniferniang.karatetournament_app.general.User;

import org.json.JSONException;
import org.json.JSONObject;

public class JSONRegisterUtils {

    public  static  String toRegisterJSonData(User user) {

        JSONObject oj = new JSONObject();
        try{
            oj.put("username", user.getUserName());
            oj.put("lastname", user.getLastName());
            oj.put("firstname", user.getFirstName());
            oj.put("role", user.getDelegRole());
            oj.put("gender", user.getGender());
            oj.put("age", user.getAge());
            oj.put("city", user.getCity());
            oj.put("country", user.getCountry());
            oj.put("zipCode", user.getZipCode());
            oj.put("weight", user.getWeight());
            oj.put("experience", user.getExperience());
            oj.put("clubID", user.getClubID());
            oj.put("instructorlastname", user.getInstructorLastName());



            return oj.toString();
        } catch(JSONException e){
            e.printStackTrace();
        }
        return null;
    }

    public  static  User getRegisterData(String data) throws  JSONException{
        User userData = new User();

        //Start parsing the JSON Data
        JSONObject jsonObject = new JSONObject(data); //must throw JSON Exception

        //Get User Profile Data
        userData.setUserName(jsonObject.getString("username"));
        userData.setLastName(jsonObject.getString("lastname"));
        userData.setFirstName(jsonObject.getString("firstname"));
        userData.setDelegRole(jsonObject.getString("role"));
        userData.setGender(jsonObject.getString("gender"));
        userData.setAge(jsonObject.getString("age"));
        userData.setCity(jsonObject.getString("city"));
        userData.setCountry(jsonObject.getString("country"));
        userData.setZipCode(jsonObject.getString("zipCode"));
        userData.setWeight(jsonObject.getString("weight"));
        userData.setExperience(jsonObject.getString("experience"));
        userData.setClubID(jsonObject.getString("clubID"));
        userData.setInstructorLastName(jsonObject.getString("instructorLastName"));

        return userData;
    }
}
