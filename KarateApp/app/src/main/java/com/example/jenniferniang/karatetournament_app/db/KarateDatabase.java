package com.example.jenniferniang.karatetournament_app.db;

import android.arch.persistence.db.SupportSQLiteDatabase;
import android.arch.persistence.db.SupportSQLiteOpenHelper;
import android.arch.persistence.room.Database;
import android.arch.persistence.room.DatabaseConfiguration;
import android.arch.persistence.room.InvalidationTracker;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.content.Context;
import android.os.AsyncTask;
import android.support.annotation.NonNull;

@Database(entities = {Register.class, Event.class}, version = 1, exportSchema = false)
public abstract class KarateDatabase extends RoomDatabase {

    private static KarateDatabase instance;

    public abstract RegisterDao registerDao();
    public  abstract  EventDao eventDao();

    public static synchronized KarateDatabase getInstance( Context context){
        if(instance==null) {
            instance = Room.databaseBuilder(context.getApplicationContext(),
                    KarateDatabase.class, "karate_database")
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
            new KarateDatabase.PopulateDbAsync(instance).execute();
        }
    };

    @Override
    protected SupportSQLiteOpenHelper createOpenHelper(DatabaseConfiguration config) {
        return null;
    }

    @Override
    protected InvalidationTracker createInvalidationTracker() {
        return null;
    }

    private static class PopulateDbAsync extends AsyncTask<Void,Void,Void> {
        private RegisterDao registerDao;
        private EventDao eventDao;

        PopulateDbAsync(KarateDatabase db){
            registerDao = db.registerDao();
            eventDao = db.eventDao();
        }

        @Override
        protected Void doInBackground(Void... voids) {
            registerDao.insert(new Register("madyKarateKid", "Niang", "Mady",
                    "Athlete", "7", "male", "Sandy", "USA", "84092",
                    "50", "0-1 Beginner", "MA Budokan Shotokan",
                    "Niang", "yes"));
            eventDao.insert(new Event("Title 1", "Description 1", 1));
            eventDao.insert(new Event("Title 2", "Description 2", 2));
            eventDao.insert(new Event("Title 3", "Description 3", 3));
            return null;

        }
    }
}
