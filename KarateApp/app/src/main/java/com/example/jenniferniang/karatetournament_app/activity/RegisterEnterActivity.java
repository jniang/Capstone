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


public class RegisterEnterActivity extends AppCompatActivity implements RegisterEnterFrag.OnFloatingButtonClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register_enter);
        if(savedInstanceState == null){
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.container, new RegisterEnterFrag())
                    .commit();
        }

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        CollapsingToolbarLayout collapsingToolbarLayout = (CollapsingToolbarLayout) findViewById(R.id.collapsing_toolbar);
        collapsingToolbarLayout.setTitle("REGISTER");

        }

    @Override
    public void onFloatingButtonClicked() {
        this.startActivity(new Intent(this, HomeActivity.class));

    }
}

