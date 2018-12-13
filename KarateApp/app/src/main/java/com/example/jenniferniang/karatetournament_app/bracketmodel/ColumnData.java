package com.example.jenniferniang.karatetournament_app.bracketmodel;

import java.io.Serializable;
import java.util.ArrayList;

public class ColumnData implements Serializable {


    public ColumnData(ArrayList<MatchData> matches) {
        this.matches = matches;
    }

    private ArrayList<MatchData> matches;

    public void setMatches(ArrayList<MatchData> matches) {
        this.matches = matches;
    }

    public ArrayList<MatchData> getMatches() {
        return matches;
    }
}