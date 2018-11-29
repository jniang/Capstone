package com.example.jenniferniang.karatetournament_app;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_register_enter);

        //Spinners for Register Layout
        //-----Spinner Role-----
        Spinner spinnerRole = (Spinner) findViewById(R.id.spinner_role);
        ArrayAdapter<CharSequence> adapterRole = ArrayAdapter.createFromResource(this, R.array.roles, android.R.layout.simple_spinner_item);
        adapterRole.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerRole.setAdapter(adapterRole);

        //-----Spinner Experience-----
        Spinner spinnerExperience = (Spinner) findViewById(R.id.spinner_experience);
        ArrayAdapter<CharSequence> adapterExperience = ArrayAdapter.createFromResource(this, R.array.experience, android.R.layout.simple_spinner_item);
        adapterExperience.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerExperience.setAdapter(adapterExperience);

        //-----Spinner Club-----
        Spinner spinnerClubID = (Spinner) findViewById(R.id.spinner_clubID);
        ArrayAdapter<CharSequence> adapterClub = ArrayAdapter.createFromResource(this, R.array.clubID, android.R.layout.simple_spinner_item);
        adapterClub.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerClubID.setAdapter(adapterClub);
    }

    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        String text = parent.getItemAtPosition(position).toString();
        Toast.makeText(parent.getContext(), text, Toast.LENGTH_SHORT).show();

    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }





}

