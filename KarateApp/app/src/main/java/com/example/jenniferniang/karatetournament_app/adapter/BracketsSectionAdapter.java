package com.example.jenniferniang.karatetournament_app.adapter;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import com.example.jenniferniang.karatetournament_app.bracketmodel.ColumnData;
import com.example.jenniferniang.karatetournament_app.fragment.BracketsColumnFrag;

import java.util.ArrayList;

public class BracketsSectionAdapter extends FragmentStatePagerAdapter {

    private ArrayList<ColumnData> sectionList;


    public BracketsSectionAdapter(FragmentManager fm, ArrayList<ColumnData> sectionList) {
        super(fm);
        this.sectionList =sectionList;
    }

    @Override
    public Fragment getItem(int position) {
        Bundle bundle = new Bundle();
        bundle.putSerializable("colomn_data", this.sectionList.get(position));
        BracketsColumnFrag fragment = new BracketsColumnFrag();
        bundle.putInt("section_number", position);
        if (position > 0)
            bundle.putInt("previous_section_size", sectionList.get(position - 1).getMatches().size());
        else if (position == 0)
            bundle.putInt("previous_section_size", sectionList.get(position).getMatches().size());
        fragment.setArguments(bundle);

        return fragment;
    }

    @Override
    public int getCount() {
        return this.sectionList.size();
    }
}


