package com.example.jenniferniang.karatetournament_app.repository;

import android.app.Application;
import android.arch.lifecycle.LiveData;
import android.os.AsyncTask;

import com.example.jenniferniang.karatetournament_app.db.KarateDatabase;
import com.example.jenniferniang.karatetournament_app.db.RegisterDao;
import com.example.jenniferniang.karatetournament_app.db.Register;

import java.util.List;

public class RegisterRepository {

    private LiveData<List<Register>> allRegisters;
    private RegisterDao registerDao;


    public RegisterRepository(Application application){
        KarateDatabase database = KarateDatabase.getInstance(application);
        registerDao = database.registerDao();
        allRegisters = registerDao.getAllRegisters();
    }
    public void insert(Register register) {
        new InsertRegisterAsyncTask(registerDao).execute(register);
    }

    public void update(Register register) {
        new UpdateRegisterAsyncTask(registerDao).execute(register);
    }

    public void delete(Register register) {
        new DeleteRegisterAsyncTask(registerDao).execute(register);
    }

    public void deleteAllRegisters() {
        new DeleteAllRegistersAsyncTask(registerDao).execute();
    }

    public LiveData<List<Register>> getAllRegisters() {
        return allRegisters;
    }

    private static class InsertRegisterAsyncTask extends AsyncTask<Register, Void, Void> {
        private RegisterDao registerDao;

        private InsertRegisterAsyncTask(RegisterDao registerDao) {
            this.registerDao = registerDao;
        }

        @Override
        protected Void doInBackground(Register... registers) {
            registerDao.insert(registers[0]);
            return null;
        }
    }

    private static class UpdateRegisterAsyncTask extends AsyncTask<Register, Void, Void> {
        private RegisterDao registerDao;

        private UpdateRegisterAsyncTask(RegisterDao registerDao) {
            this.registerDao = registerDao;
        }

        @Override
        protected Void doInBackground(Register... registers) {
            registerDao.update(registers[0]);
            return null;
        }
    }

    private static class DeleteRegisterAsyncTask extends AsyncTask<Register, Void, Void> {
        private RegisterDao registerDao;

        private DeleteRegisterAsyncTask(RegisterDao registerDao) {
            this.registerDao = registerDao;
        }

        @Override
        protected Void doInBackground(Register... registers) {
            registerDao.delete(registers[0]);
            return null;
        }
    }

    private static class DeleteAllRegistersAsyncTask extends AsyncTask<Void, Void, Void> {
        private RegisterDao registerDao;

        private DeleteAllRegistersAsyncTask(RegisterDao registerDao) {
            this.registerDao = registerDao;
        }

        @Override
        protected Void doInBackground(Void... voids) {
            registerDao.deleteAllRegisters();
            return null;
        }
    }
}
