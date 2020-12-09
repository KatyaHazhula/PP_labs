package com.company.Droids;

public class ArmoredDroid extends Droid {


    public ArmoredDroid(String name, int health, int damage) {
        super(name, health, damage);
    }

    public ArmoredDroid() {
    }
    @Override
    public void usePower(Droid attacker) {
       attacker.setAttack((int)(attacker.getAttack()*0.2));
        System.out.println("armored");
    }
}
