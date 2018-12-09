package com.example.jenniferniang.karatetournament_app.viewModel;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.support.annotation.NonNull;

import com.example.jenniferniang.karatetournament_app.db.Register;
import com.example.jenniferniang.karatetournament_app.general.User;
import com.example.jenniferniang.karatetournament_app.repository.RegisterRepository;

import java.util.List;

public class RegisterViewModel extends AndroidViewModel {

    private RegisterRepository registerRepository;
    private LiveData<List<Register>> allRegisters;

    public RegisterViewModel(@NonNull Application application) {
        super(application);

        registerRepository = new RegisterRepository(application);
        allRegisters = registerRepository.getAllRegisters();

    }

    public void insert(Register register) {
        registerRepository.insert(register);
    }

    public void update(Register register) {
        registerRepository.update(register);
    }

    public void delete(Register register) {
        registerRepository.delete(register);
    }

    public void deleteAllRegisters() {
        registerRepository.deleteAllRegisters();
    }

    public LiveData<List<Register>> getAllRegisters() {
        return allRegisters;
    }
}


