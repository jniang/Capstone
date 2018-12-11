package com.example.jenniferniang.karatetournament_app.fragment;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.helper.ItemTouchHelper;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

//TODO: Fix these import with right file
import com.example.jenniferniang.karatetournament_app.R;
import com.example.jenniferniang.karatetournament_app.activity.AddEditEventActivity;
import com.example.jenniferniang.karatetournament_app.activity.AddEditRegisterActivity;
import com.example.jenniferniang.karatetournament_app.db.Event;
import com.example.jenniferniang.karatetournament_app.db.Register;
import com.example.jenniferniang.karatetournament_app.general.EventAdapter;
import com.example.jenniferniang.karatetournament_app.general.RegisterAdapter;
import com.example.jenniferniang.karatetournament_app.viewModel.EventViewModel;
import com.example.jenniferniang.karatetournament_app.viewModel.RegisterViewModel;

import java.util.List;
//import com.example.jenniferniang.karatetournament_app.fragment.general.User;



public class RegisterFrag extends Fragment {
//    @Override
//    public View onCreateView(LayoutInflater inflater, ViewGroup container,
//                             Bundle savedInstanceState) {
//        View view = inflater.inflate(R.layout.fragment_register_edit, container, false);
//
//        return view;
//    }
    public static final int ADD_REGISTER_REQUEST = 1;
    public static final int EDIT_REGISTER_REQUEST = 2;

    private RegisterViewModel registerViewModel;


    @Override
    public View onCreateView(final LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        View view = inflater.inflate(R.layout.fragment_register, container, false);

        FloatingActionButton buttonAddRegister = view.findViewById(R.id.btn_add_register);
        buttonAddRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), AddEditRegisterActivity.class);
                startActivityForResult(intent, ADD_REGISTER_REQUEST);
            }
        });


        RecyclerView recyclerView = view.findViewById(R.id.recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        recyclerView.setHasFixedSize(true);

        final RegisterAdapter registerAdapter = new RegisterAdapter();
        recyclerView.setAdapter(registerAdapter);



        //ViewModelProvider.Factory factory = ViewModelProvider.AndroidViewModelFactory.getInstance(getApplication());

        registerViewModel = ViewModelProviders.of(this).get(RegisterViewModel.class);
        // ViewModelProvider viewModelProvider = new ViewModelProvider(this, factory);
        // eventViewModel = viewModelProvider.get(EventViewModel.class);

        registerViewModel.getAllRegisters().observe(this, new Observer<List<Register>>() {
            @Override
            public void onChanged(@Nullable List<Register> registers) {
                //update Recycler View
                //Toast.makeText(MainActivity.this, "UnChanged", Toast.LENGTH_SHORT).show();
                registerAdapter.submitList(registers);
            }
        });
        new ItemTouchHelper(new ItemTouchHelper.SimpleCallback(0, ItemTouchHelper.LEFT | ItemTouchHelper.RIGHT) {
            @Override
            public boolean onMove(@NonNull RecyclerView recyclerView, @NonNull RecyclerView.ViewHolder viewHolder, @NonNull RecyclerView.ViewHolder viewHolder1) {
                return false;
            }

            @Override
            public void onSwiped(@NonNull RecyclerView.ViewHolder viewHolder, int i) {
                registerViewModel.delete(registerAdapter.getRegisterAt(viewHolder.getAdapterPosition()));
                Toast.makeText(getActivity(), "Register Deleted", Toast.LENGTH_SHORT).show();

            }
        }).attachToRecyclerView(recyclerView);

        registerAdapter.setOnItemClickListener(new RegisterAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(Register register) {
                Intent intent = new Intent(getActivity(), AddEditRegisterActivity.class);
                intent.putExtra(AddEditRegisterActivity.EXTRA_ID, register.getUserID());
                intent.putExtra(AddEditRegisterActivity.EXTRA_USERNAME, register.getUserName());
                intent.putExtra(AddEditRegisterActivity.EXTRA_LASTNAME, register.getLastName());
                intent.putExtra(AddEditRegisterActivity.EXTRA_FIRSTNAME, register.getFirstName());
                intent.putExtra(AddEditRegisterActivity.EXTRA_ROLE, register.getDelegRole());
                intent.putExtra(AddEditRegisterActivity.EXTRA_AGE, register.getAge());
                intent.putExtra(AddEditRegisterActivity.EXTRA_GENDER, register.getGender());
                intent.putExtra(AddEditRegisterActivity.EXTRA_CITY, register.getCity());
                intent.putExtra(AddEditRegisterActivity.EXTRA_COUNTRY, register.getCountry());
                intent.putExtra(AddEditRegisterActivity.EXTRA_ZIPCODE, register.getZipCode());
                intent.putExtra(AddEditRegisterActivity.EXTRA_WEIGHT, register.getWeight());
                intent.putExtra(AddEditRegisterActivity.EXTRA_EXPERIENCE, register.getExperience());
                intent.putExtra(AddEditRegisterActivity.EXTRA_CLUBID, register.getClubID());
                intent.putExtra(AddEditRegisterActivity.EXTRA_INSTRUCTORLASTNAME, register.getInstructorLastName());
                intent.putExtra(AddEditRegisterActivity.EXTRA_REGISTERPIC, register.getRegisterPic());



                startActivityForResult(intent, EDIT_REGISTER_REQUEST);
            }
        });

        return view;
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if(requestCode == ADD_REGISTER_REQUEST && resultCode == getActivity().RESULT_OK){
            String username = data.getStringExtra(AddEditRegisterActivity.EXTRA_USERNAME);
            String lastname = data.getStringExtra(AddEditRegisterActivity.EXTRA_LASTNAME);
            String firstname = data.getStringExtra(AddEditRegisterActivity.EXTRA_FIRSTNAME);
            String delegrole = data.getStringExtra(AddEditRegisterActivity.EXTRA_ROLE);
            String age = data.getStringExtra(AddEditRegisterActivity.EXTRA_AGE);
            String gender = data.getStringExtra(AddEditRegisterActivity.EXTRA_GENDER);
            String city = data.getStringExtra(AddEditRegisterActivity.EXTRA_CITY);
            String country = data.getStringExtra(AddEditRegisterActivity.EXTRA_COUNTRY);
            String zipcode = data.getStringExtra(AddEditRegisterActivity.EXTRA_ZIPCODE);
            String weight = data.getStringExtra(AddEditRegisterActivity.EXTRA_WEIGHT);
            String experience = data.getStringExtra(AddEditRegisterActivity.EXTRA_EXPERIENCE);
            String clubid = data.getStringExtra(AddEditRegisterActivity.EXTRA_CLUBID);
            String instructorlastname = data.getStringExtra(AddEditRegisterActivity.EXTRA_INSTRUCTORLASTNAME);
            String registerpic = data.getStringExtra(AddEditRegisterActivity.EXTRA_REGISTERPIC);

            //int priority = data.getIntExtra(AddEditRegisterActivity.EXTRA_PRIORITY, 1);

            Register register = new Register(username, lastname, firstname, delegrole, age, gender, city, country,
                    zipcode, weight, experience, clubid, instructorlastname, registerpic);
            registerViewModel.insert(register);

            Toast.makeText(getActivity(), "Register Saved", Toast.LENGTH_SHORT).show();
        } else if(requestCode == EDIT_REGISTER_REQUEST && resultCode == getActivity().RESULT_OK){
            int id = data.getIntExtra(AddEditRegisterActivity.EXTRA_ID,-1);

            if(id == -1){
                Toast.makeText(getActivity(), "Register Can't Be Updated", Toast.LENGTH_SHORT).show();
                return;
            }
            String username = data.getStringExtra(AddEditRegisterActivity.EXTRA_USERNAME);
            String lastname = data.getStringExtra(AddEditRegisterActivity.EXTRA_LASTNAME);
            String firstname = data.getStringExtra(AddEditRegisterActivity.EXTRA_FIRSTNAME);
            String delegrole = data.getStringExtra(AddEditRegisterActivity.EXTRA_ROLE);
            String age = data.getStringExtra(AddEditRegisterActivity.EXTRA_AGE);
            String gender = data.getStringExtra(AddEditRegisterActivity.EXTRA_GENDER);
            String city = data.getStringExtra(AddEditRegisterActivity.EXTRA_CITY);
            String country = data.getStringExtra(AddEditRegisterActivity.EXTRA_COUNTRY);
            String zipcode = data.getStringExtra(AddEditRegisterActivity.EXTRA_ZIPCODE);
            String weight = data.getStringExtra(AddEditRegisterActivity.EXTRA_WEIGHT);
            String experience = data.getStringExtra(AddEditRegisterActivity.EXTRA_EXPERIENCE);
            String clubid = data.getStringExtra(AddEditRegisterActivity.EXTRA_CLUBID);
            String instructorlastname = data.getStringExtra(AddEditRegisterActivity.EXTRA_INSTRUCTORLASTNAME);
            String registerpic = data.getStringExtra(AddEditRegisterActivity.EXTRA_REGISTERPIC);


            Register register = new Register(username, lastname, firstname, delegrole, age, gender, city,country,
                    zipcode, weight, experience, clubid, instructorlastname, registerpic);
            register.setUserID(id);
            registerViewModel.update(register);

            Toast.makeText(getActivity(), "Register Updated", Toast.LENGTH_SHORT).show();

        } else {
            Toast.makeText(getActivity(), "Register Not Saved", Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater menuInflater) {
//        MenuInflater menuInflater = getActivity().getMenuInflater();
        menuInflater.inflate(R.menu.main_menu,menu);
//        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.delete_all_registers:
                registerViewModel.deleteAllRegisters();
                Toast.makeText(getActivity(), "All Register Deleted", Toast.LENGTH_SHORT).show();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }



}

