package com.example.jenniferniang.karatetournament_app.activity.db;

import android.arch.persistence.db.SupportSQLiteDatabase;
import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.content.Context;
import android.os.AsyncTask;
import android.support.annotation.NonNull;

@Database(entities = {RegisterTable.class}, version = 1, exportSchema = false)
public abstract class RegisterRoomDatabase extends RoomDatabase {

    private static volatile RegisterRoomDatabase mInstance;

    public abstract RegisterDao RegisterDao();

    public static synchronized RegisterRoomDatabase getDatabase(final Context context){
        if(mInstance==null) {
            mInstance = Room.databaseBuilder(context.getApplicationContext(),
                    RegisterRoomDatabase.class, "register.db").addCallback(sRoomDatabaseCallback).build();
        }
        return mInstance;
    }

    private static RoomDatabase.Callback sRoomDatabaseCallback = new RoomDatabase.Callback(){
        @Override
        public void onOpen(@NonNull SupportSQLiteDatabase db) {
            super.onCreate(db);
            new PopulateDbAsync(mInstance).execute();
        }
    };

    private static class PopulateDbAsync extends AsyncTask<Void,Void,Void> {
        private final RegisterDao mDao;

        PopulateDbAsync(RegisterRoomDatabase db){
            mDao = db.RegisterDao();
        }

        @Override
        protected Void doInBackground(Void... voids) {
            mDao.deleteAll();
//            RegisterTable registerTable = new RegisterTable("dummy_loc","dummy_data");
//            mDao.insert(profileTable);
            return null;
        }
    }
}
