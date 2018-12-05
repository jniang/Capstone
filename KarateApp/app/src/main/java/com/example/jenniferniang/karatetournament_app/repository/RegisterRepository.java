package com.example.jenniferniang.karatetournament_app.repository;

import android.app.Application;
import android.arch.lifecycle.MutableLiveData;
import android.os.AsyncTask;

import com.example.jenniferniang.karatetournament_app.Utils.JSONRegisterUtils;
import com.example.jenniferniang.karatetournament_app.activity.db.RegisterDao;
import com.example.jenniferniang.karatetournament_app.activity.db.RegisterRoomDatabase;
import com.example.jenniferniang.karatetournament_app.activity.db.RegisterTable;
import com.example.jenniferniang.karatetournament_app.general.User;

import org.json.JSONException;

public class RegisterRepository {

    private final MutableLiveData<User> jsonData = new MutableLiveData<User>();
    private String mUserJson;
    private RegisterDao mRegisterDao;
    private String mJsonString;
    private String mUsername;

    public ProfileRepository(Application application){
        RegisterRoomDatabase db = RegisterRoomDatabase.getDatabase(application);
        mRegisterDao = db.registerDao();
        //loadData();
    }

    public void setUser(String userName, String user){
        mUsername = userName;
        mUserJson = user;
        loadData();
    }

    public MutableLiveData<User> getData(){
        return jsonData;
    }

    public void loadData(){
        new AsyncTask<String, Void, String>(){
            @Override
            protected String doInBackground(String... strings){
                String userJson = strings[0];
                return  userJson;
            }
            @Override
            protected void onPostExcecute(String s){
                if(s != null){
                    mJsonString = s;
                    insert();
                }
                try{
                    jsonData.setValue(JSONRegisterUtils.getRegisterData(s));
                } catch(JSONException e){
                    e.printStackTrace();
                }
            }
        }.execute(mUserJson);
    }

    private void insert(){
        RegisterTable registerTable = new RegisterTable(mUsername, mJsonString);
        new insertAsyncTask(mRegisterDao).execute(registerTable);
    }

    private static class insertAsyncTask extends AsyncTask<RegisterTable, Void, Void>{
        private  RegisterDao mAsyncTaskDao;

        insertAsyncTask(RegisterDao dao){
            mAsyncTaskDao = dao;
        }

        @Override
        protected Void doInBackground(RegisterTable... registerTables){
            mAsyncTaskDao.insert(registerTables[0]);
            return null;
        }
    }

}
