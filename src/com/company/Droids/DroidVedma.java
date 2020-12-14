package com.company.Droids;

import java.util.ArrayList;

public class DroidVedma extends Droid{

    public DroidVedma(String name, int health, int damage) {
        super(name, health, damage);
    }


    @Override
    public void usePower(Droid defender, ArrayList<Droid> fightingDroids) {
        System.out.println("Дроїд дуже злий,він хоче нанести прокляття");
        if(fightingDroids.size()==2){
            defender.setIsAbleToMove(false);
        }else{
            defender.decreasingHealth(200);
        }


    }
}
