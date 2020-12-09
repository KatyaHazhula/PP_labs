package com.company.Droids;

public class DroidKnight extends Droid{
    public DroidKnight(String name, int health, int damage) {
        super(name, health, damage);
    }

    public DroidKnight() {
    }

    @Override
    public void usePower() {
        System.out.println("Knight");
        System.out.println(super.getAccuracyChance());
        super.setAccuracyChance(getAccuracyChance()+40);
        System.out.println(super.getAccuracyChance());

    }
}
