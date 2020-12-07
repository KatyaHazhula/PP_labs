package com.company.PreparingForGame;


import com.company.Battle.Battle;
import com.company.Droids.Droid;

import java.util.ArrayList;

public class PreparingForGame {
    public boolean PreparingForGame(ArrayList<Droid> fightingDroids) {
        int countOfDeadDroids = 0;
        int arrayIterator = 0;
        int teamLastMember;
        int wholeTeamDead;
        //перевіряє учасника/учасників 1 команди
        for(teamLastMember = fightingDroids.size() / 2, wholeTeamDead = teamLastMember; arrayIterator < teamLastMember; arrayIterator++) {
            if(fightingDroids.get(arrayIterator).getHealth() <= 0) {
                countOfDeadDroids++;
            }
        }
        //якщо всі вмерли, то програвша команда -1, виходимо з ф-її. Якщо живі, то перевіряємо з другої команди
        if(countOfDeadDroids == wholeTeamDead){
            Battle.enlimatedTeam = 1;
            return false;
        }
        //перевіряємо з другої команди
        for (teamLastMember *= 2, countOfDeadDroids = 0; arrayIterator < teamLastMember; arrayIterator++) {
            if(fightingDroids.get(arrayIterator).getHealth() <= 0) {
                countOfDeadDroids++;
            }
        }

        //якщо з другої команди всі вмерли, то програвша команда-2
        if(countOfDeadDroids == wholeTeamDead){
            Battle.enlimatedTeam = 2;
            return false;
        }

        return true;
    }
}
