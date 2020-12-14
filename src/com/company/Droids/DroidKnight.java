package com.company.Droids;

public class DroidKnight extends Droid{
    public DroidKnight(String name, int health, int damage) {
        super(name, health, damage);
    }

    @Override
    public void usePower() {
        System.out.println("Дроїд дуже злий,він взяв в лапки меч");
        super.setAccuracyChance(getAccuracyChance()+40);

    }
}
