package com.example.jenniferniang.karatetournament_app.activity;

//import android.os.Bundle;
//import android.support.annotation.NonNull;
//import android.support.v4.app.Fragment;
//import android.support.v4.app.FragmentManager;
//import android.support.v7.app.AppCompatActivity;
//import android.util.DisplayMetrics;
//import android.util.TypedValue;
//import android.view.MenuItem;
//import android.view.View;
//import android.view.ViewGroup;
//
//import com.example.jenniferniang.karatetournament_app.fragment.AthletesFrag;
//import com.example.jenniferniang.karatetournament_app.fragment.BracketFrag;
//import com.example.jenniferniang.karatetournament_app.fragment.RegisterFrag;
//import com.example.jenniferniang.karatetournament_app.fragment.ScoreboardFrag;
//import com.example.jenniferniang.karatetournament_app.R;
//
//public class HomeActivity  extends AppCompatActivity {
//
//    final Fragment athletesFrag = new AthletesFrag();
//    final Fragment bracketFrag = new Fragment();
//    final Fragment scoreboardFrag = new Fragment();
//    final Fragment registerFrag = new RegisterFrag();
//    final FragmentManager fragBoss = getSupportFragmentManager();
//    Fragment active = registerFrag;
//
//    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
//            = new BottomNavigationView.OnNavigationItemSelectedListener() {
//        @Override
//        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
//
//            switch (item.getItemId()) {
//                case R.id.navigation_register:
//
//                    fragBoss.beginTransaction().hide(active).show(registerFrag).commit();
//                    active = registerFrag;
//                    return true;
//                case R.id.navigation_athletes:
//
//                    fragBoss.beginTransaction().hide(active).show(athletesFrag).commit();
//                    active = athletesFrag;
//                    return true;
//                case R.id.navigation_bracket:
//
//                    fragBoss.beginTransaction().hide(active).show(bracketFrag).commit();
//                    active = bracketFrag;
//                    return true;
//                case R.id.navigation_scoreboard:
//
//                    fragBoss.beginTransaction().hide(active).show(scoreboardFrag).commit();
//                    active = scoreboardFrag;
//                    return true;
//            }
//            return false;
//        }
//    };
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_home);
//    }
//}
