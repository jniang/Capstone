package com.example.jenniferniang.karatetournament_app.utility;

import android.util.DisplayMetrics;

import com.example.jenniferniang.karatetournament_app.application.BracketsApplication;

public class BracketsUtility {

    public static int dpToPx(int dp) {
        DisplayMetrics displayMetrics = BracketsApplication.getInstance().getBaseContext().getResources().getDisplayMetrics();
        return Math.round(dp * (displayMetrics.xdpi / DisplayMetrics.DENSITY_DEFAULT));
    }
}
