package com.company.Droids;

public class DroidFairy extends Droid{
    public DroidFairy(String name, int health, int damage ) {
        super(name, health, damage);
    }

    public DroidFairy() {
    }

    @Override
    public void usePower() {
       System.out.println("Fairy");
       System.out.println(super.getHealth());
       super.setHealth(super.getHealth()+200);
        System.out.println(super.getHealth());
    }
}
