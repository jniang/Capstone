package com.example.jenniferniang.karatetournament_app.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.jenniferniang.karatetournament_app.R;
import com.example.jenniferniang.karatetournament_app.fragment.RegisterEnterFrag;


public class RegisterEnterActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_register_enter);
//        if(savedInstanceState == null) {
//            getSupportFragmentManager().beginTransaction()
//                    .replace(R.id.container, new RegisterEnterFrag())
//                    .commit();
        }
//        setContentView(R.layout.fragment_register_enter);

        //Spinners for Register Layout
        //-----Spinner Role-----
//        Spinner spinnerRole = (Spinner) findViewById(R.id.spinner_role);
//        ArrayAdapter<CharSequence> adapterRole = ArrayAdapter.createFromResource(this, R.array.roles, android.R.layout.simple_spinner_item);
//        adapterRole.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
//        spinnerRole.setAdapter(adapterRole);
//
//        //-----Spinner Experience-----
//        Spinner spinnerExperience = (Spinner) findViewById(R.id.spinner_experience);
//        ArrayAdapter<CharSequence> adapterExperience = ArrayAdapter.createFromResource(this, R.array.experience, android.R.layout.simple_spinner_item);
//        adapterExperience.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
//        spinnerExperience.setAdapter(adapterExperience);
//
//        //-----Spinner Club-----
//        Spinner spinnerClubID = (Spinner) findViewById(R.id.spinner_clubID);
//        ArrayAdapter<CharSequence> adapterClub = ArrayAdapter.createFromResource(this, R.array.clubID, android.R.layout.simple_spinner_item);
//        adapterClub.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
//        spinnerClubID.setAdapter(adapterClub);
    }
//
//    @Override
//    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
//
//    }
//
//    @Override
//    public void onNothingSelected(AdapterView<?> parent) {
//
//    }

//    @Override
//    public void onClick(View view) {
//        switch (view.getId()) {

//            case R.id.button_get_user_picture: {
//                break;
//            }
//
//                /*case R.id.btn_country: {
//                    selectCountry();
//                    break;
//                }
//
//                case R.id.next: {
//                    // Check valid data entered
//                    if (isValidData()) {
//                        // Set the user profile
//                        setUserProfile();
//                        mListener.onFloatingButtonClicked();
//                    }
//                    break;
//                }
//                */
//
//            case R.id.button_get_started: {
//                // Check valid data entered
//                System.out.println("clicked");
//                Toast.makeText(this, "get started button clicked.", Toast.LENGTH_SHORT);
//                startActivity(new Intent(this, HomeActivity.class));
////                    if (isValidData()) {
////                        // Set the user profile
////                        setUserProfile();
//////                        mListener.onFloatingButtonClicked();
////                        startActivity(new Intent(getActivity(), HomeActivity.class));
////                    }
//                break;
//            }
//        }
//    }
//}
