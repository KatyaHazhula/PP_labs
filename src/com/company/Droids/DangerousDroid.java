package com.company.Droids;public class DangerousDroid extends Droid{

    public DangerousDroid(String name, int health, int damage) {
        super(name, health, damage);
    }
    @Override
    public void usePower() {
        System.out.println("dangerous");
        super.setAttack(super.getAttack()+20);
    }
}
