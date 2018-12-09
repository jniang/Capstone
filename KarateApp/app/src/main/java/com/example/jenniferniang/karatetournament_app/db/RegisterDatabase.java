package com.example.jenniferniang.karatetournament_app.db;

import android.arch.persistence.db.SupportSQLiteDatabase;
import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.content.Context;
import android.os.AsyncTask;
import android.support.annotation.NonNull;

import com.example.jenniferniang.karatetournament_app.general.User;

@Database(entities = {Register.class}, version = 1, exportSchema = false)
public abstract class RegisterDatabase extends RoomDatabase {

    private static RegisterDatabase instance;

    public abstract RegisterDao registerDao();

    public static synchronized RegisterDatabase getInstance( Context context){
        if(instance==null) {
            instance = Room.databaseBuilder(context.getApplicationContext(),
                    RegisterDatabase.class, "register_database")
                    .fallbackToDestructiveMigration()
                    .addCallback(roomCallback)
                    .build();
        }
        return instance;
    }

    private static RoomDatabase.Callback roomCallback = new RoomDatabase.Callback(){
        @Override
        public void onOpen(@NonNull SupportSQLiteDatabase db) {
            super.onCreate(db);
            new PopulateDbAsync(instance).execute();
        }
    };

    private static class PopulateDbAsync extends AsyncTask<Void,Void,Void> {
        private RegisterDao registerDao;

        PopulateDbAsync(RegisterDatabase db){
            registerDao = db.registerDao();
        }

        @Override
        protected Void doInBackground(Void... voids) {
            registerDao.insert(new Register("madyKarateKid", "Niang", "Mady",
                    "Athlete", "7", "male", "Sandy", "USA", "84092",
                    "50", "0-1 Beginner", "MA Budokan Shotokan",
                    "Niang", "yes"));
            return null;
        }
    }
}
