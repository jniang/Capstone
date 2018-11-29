package com.example.jenniferniang.karatetournament_app.fragment;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

//TODO: Fix these import with right file
import com.example.jenniferniang.karatetournament_app.R;
//import com.example.jenniferniang.karatetournament_app.fragment.general.User;



public class RegisterFrag extends Fragment implements View.OnClickListener {


//create member variables from my registration form for those signing up for the Karate Tournament
private TextView mTvUserName, mTvLastName, mTvFirstName, mTvDelegRole, mTvAge, mTvGender, mTvCity,
        mTvCountry, mTvZipCode, mTvWeight, mTvExperience, mTvClubID, mTvInstructorLastName, mTvEvent;

//adding spinners
private TextView mTVSpinnerRole;

//create edit button variable
private Button mBtEdit;

//private DatabaseReference mDbUsers;

@Override
public View onCreateView(LayoutInflater inflater, ViewGroup container,
        Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_register, container, false);


        //mDbUsers = FirebaseDatabase.getInstance().getReference().child("Users").child(User.getUUID());

        mTvUserName = (TextView) view.findViewById(R.id.tv_userName_data);
        mTvLastName = (TextView) view.findViewById(R.id.tv_lastName_data);
        mTvFirstName = (TextView) view.findViewById(R.id.tv_firstName_data);
        mTvDelegRole = (TextView) view.findViewById(R.id.tv_role_data);
        mTvAge = (TextView) view.findViewById(R.id.tv_age_data);
        mTvGender = (TextView) view.findViewById(R.id.tv_gender_data);
        mTvCity = (TextView) view.findViewById(R.id.tv_city_data);
        mTvCountry = (TextView) view.findViewById(R.id.tv_country_data);
        mTvZipCode = (TextView) view.findViewById(R.id.tv_zipCode_data);
        mTvWeight = (TextView) view.findViewById(R.id.tv_weight_data);
        mTvExperience = (TextView) view.findViewById(R.id.tv_experience_data);
        mTvClubID = (TextView) view.findViewById(R.id.tv_clubID_data);
        mTvInstructorLastName = (TextView) view.findViewById(R.id.tv_instructorName_data);
        mTvEvent = (TextView) view.findViewById(R.id.tv_event_data);

        mBtEdit = (Button) view.findViewById(R.id.bt_edit_register);
        mBtEdit.setOnClickListener(this);

        //fillProfileInfo();

        return view;
        }
/*
private void fillProfileInfo() {
        mDbUsers.addValueEventListener(new ValueEventListener() {
@Override
public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
        mTvUserName.setText(dataSnapshot.child("userName").getValue(String.class));
        mTvAge.setText(dataSnapshot.child("age").getValue(String.class));
        mTvSex.setText(dataSnapshot.child("sex").getValue(String.class));
        mTvNation.setText(dataSnapshot.child("nation").getValue(String.class));
        mTvCity.setText(dataSnapshot.child("city").getValue(String.class));
        mTvHeight.setText(dataSnapshot.child("height").getValue(String.class));
        mTvWeight.setText(dataSnapshot.child("weight").getValue(String.class));
        }

@Override
public void onCancelled(@NonNull DatabaseError databaseError) {

        }
        });
        }
*/
@Override
public void onClick(View view) {
        // Create new fragment and transaction
        if (isValidData()) {

        //Fragment editRegisterFrag = new EditRegisterFrag();

        FragmentTransaction transaction = getFragmentManager().beginTransaction();

        // Replace whatever is in the fragment_container view with this fragment,
        // and add the transaction to the back stack
       // transaction.replace(R.id.main_container, editRegisterFrag);
        transaction.addToBackStack(null);

        // Commit the transaction
        transaction.commit();
        } else {
        Toast toast = Toast.makeText(getActivity(),
        "Invalid data entered", Toast.LENGTH_SHORT);
        toast.setGravity(Gravity.TOP, 0, 0);
        toast.show();
        }
        }

private boolean isValidData() {
        if (mTvUserName.getText().toString().matches("")
                || mTvCity.getText().toString().matches("")
                || mTvLastName.getText().toString().matches("")
                || mTvFirstName.getText().toString().matches("")
                || mTvAge.getText().toString().matches("")
                || mTvDelegRole.getText().toString().matches("")
                || mTvGender.getText().toString().matches("")
                || mTvCountry.getText().toString().matches("")
                || mTvZipCode.getText().toString().matches("")
                || mTvExperience.getText().toString().matches("")
                || mTvWeight.getText().toString().matches("")
                || mTvClubID.getText().toString().matches("")
                || mTvInstructorLastName.getText().toString().matches("")
                || mTvEvent.getText().toString().matches("")) {
        Toast toast = Toast.makeText(getActivity(),
        "Invalid data entered", Toast.LENGTH_SHORT);
        toast.setGravity(Gravity.TOP, 0, 0);
        toast.show();
        return false;
        }

//        if (!mTvAge.getText().toString().matches("^(0|[1-9][0-9]*)$")
//                || !mTvHeight.getText().toString().matches("^(0|[1-9][0-9]*)$")
//                || !mTvWeight.getText().toString().matches("^(0|[1-9][0-9]*)$")) {
//            Toast toast = Toast.makeText(getActivity(),
//                    "Please enter numbers for the height, weight, target hikes, target BMI, and target calories fields", Toast.LENGTH_SHORT);
//            toast.setGravity(Gravity.TOP, 0, 0);
//            toast.show();
//            return false;
//        }
        return true;
    }
}

