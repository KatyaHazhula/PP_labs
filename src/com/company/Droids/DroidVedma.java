package com.company.Droids;

import java.util.ArrayList;

public class DroidVedma extends Droid{

    public DroidVedma(String name, int health, int damage) {
        super(name, health, damage);
    }

    public DroidVedma() {
    }
    @Override
    public void usePower(Droid defender, ArrayList<Droid> fightingDroids) {
        System.out.println("vedma");
        if(fightingDroids.size()==2){
            defender.setIsAbleToMove(false);
        }else{
            defender.decreasingHealth(200);
        }


    }
}
