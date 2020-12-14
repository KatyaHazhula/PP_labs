package com.company.Droids;

public class DroidFairy extends Droid{
    public DroidFairy(String name, int health, int damage ) {
        super(name, health, damage);
    }

    @Override
    public void usePower() {
       System.out.println("Дроїд дуже злий,він взяв в лапки зілля");
       super.setHealth(super.getHealth()+200);
    }
}
