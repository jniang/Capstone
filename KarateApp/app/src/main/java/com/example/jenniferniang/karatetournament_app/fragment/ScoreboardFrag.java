package com.example.jenniferniang.karatetournament_app.fragment;


import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.jenniferniang.karatetournament_app.R;

public class ScoreboardFrag extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_bracket, container, false);

        return view;
    }
}
