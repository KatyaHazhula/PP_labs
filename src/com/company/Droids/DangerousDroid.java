package com.company.Droids;public class DangerousDroid extends Droid{

    public DangerousDroid(String name, int health, int damage) {
        super(name, health, damage);
    }
    @Override
    public void usePower() {
        System.out.println("Дроїд дуже злий,він взяв в руки ножик");
        super.setAttack(super.getAttack()+20);
    }
}
