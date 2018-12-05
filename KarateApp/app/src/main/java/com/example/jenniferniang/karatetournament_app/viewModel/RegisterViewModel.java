package com.example.jenniferniang.karatetournament_app.viewModel;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.support.annotation.NonNull;

import com.example.jenniferniang.karatetournament_app.general.User;
import com.example.jenniferniang.karatetournament_app.repository.RegisterRepository;

public class RegisterViewModel extends AndroidViewModel {

    private MutableLiveData<User> jsonData;
    private RegisterRepository mRegisterRepository;

    public RegisterViewModel(@NonNull Application application) {
        super(application);

        mRegisterRepository = new RegisterRepository(application);
        jsonData = mRegisterRepository.getData();

    }

    public void setUser(String userName, String userJson){
        mRegisterRepository.setUser(userName, userJson);
    }

    public LiveData<User> getData(){
        return  jsonData;
    }
}
