package com.example.jenniferniang.karatetournament_app.activity;

import android.support.v4.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.internal.BottomNavigationMenuView;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Spinner;


import com.example.jenniferniang.karatetournament_app.fragment.BracketFrag;
import com.example.jenniferniang.karatetournament_app.fragment.RegisterFrag;
import com.example.jenniferniang.karatetournament_app.fragment.ResultFrag;
import com.example.jenniferniang.karatetournament_app.fragment.ScoreboardFrag;
import com.example.jenniferniang.karatetournament_app.R;

public class HomeActivity  extends AppCompatActivity {

    final Fragment resultFrag = new ResultFrag();
    final Fragment bracketFrag = new BracketFrag();
    final Fragment scoreboardFrag = new ScoreboardFrag();
    final Fragment registerFrag = new RegisterFrag();
    final FragmentManager fragBoss = getSupportFragmentManager();
    Fragment active = resultFrag;

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {

            switch (item.getItemId()) {
                case R.id.navigation_registration:

                    fragBoss.beginTransaction().hide(active).show(registerFrag).commit();
                    active = registerFrag;
                    return true;
                case R.id.navigation_result:

                    fragBoss.beginTransaction().hide(active).show(resultFrag).commit();
                    active = resultFrag;
                    return true;
                case R.id.navigation_bracket:

                    fragBoss.beginTransaction().hide(active).show(bracketFrag).commit();
                    active = bracketFrag;
                    return true;
                case R.id.navigation_scoreboard:

                    fragBoss.beginTransaction().hide(active).show(scoreboardFrag).commit();
                    active = scoreboardFrag;
                    return true;
            }
            return false;
        }
    };
//
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);

        fragBoss.beginTransaction().add(R.id.main_container, scoreboardFrag, "4").hide(registerFrag).commit();
        fragBoss.beginTransaction().add(R.id.main_container, resultFrag, "3").hide(resultFrag).commit();
        fragBoss.beginTransaction().add(R.id.main_container, bracketFrag, "2").hide(bracketFrag).commit();
        fragBoss.beginTransaction().add(R.id.main_container, registerFrag, "1").commit();

        // Customize the size of the bottom navigation component.
        BottomNavigationView bottomNavigationView = (BottomNavigationView)
                this.findViewById(R.id.navigation);
        BottomNavigationMenuView menuView = (BottomNavigationMenuView)
                bottomNavigationView.getChildAt(0);

        for (int i = 0; i < menuView.getChildCount(); i++) {
            final View iconView =
                    menuView.getChildAt(i).findViewById(R.id.icon);
            final ViewGroup.LayoutParams layoutParams =
                    iconView.getLayoutParams();
            final DisplayMetrics displayMetrics =
                    getResources().getDisplayMetrics();
            layoutParams.height = (int)
                    TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 36,
                            displayMetrics);
            layoutParams.width = (int)
                    TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 36,
                            displayMetrics);
            iconView.setLayoutParams(layoutParams);
        }
    }
}
