package com.company.Droids;

public class ArmoredDroid extends Droid {

    public ArmoredDroid(String name, int health, int damage) {
        super(name, health, damage);
    }

    @Override
    public void usePower(Droid attacker) {
        System.out.println("Дроїд дуже злий,він взяв в лапки щит");
        attacker.setAttack((int)(attacker.getAttack()*0.2));
    }
}
