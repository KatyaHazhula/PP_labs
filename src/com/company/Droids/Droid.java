package com.company.Droids;

import com.company.Battle.Battle;
import com.company.Player.Player;

import java.util.ArrayList;

public abstract class Droid {

    private String name;
    private int health;
    private int damage;

    private int rage;
    private int typeOfWeapon;
    private int status;
    private boolean isAbleToMove;
    private int accuracyChance;
    private int attack;

//    public Droid() { //тут
//        isAbleToMove = true;
//    }

//    public Droid(Droid droid) {
//        this.name = droid.name;
//        this.health = droid.health;
//        this.damage = droid.damage;
//        this.typeOfWeapon = droid.typeOfWeapon;
//        this.isAbleToMove = droid.isAbleToMove;
//    }
    public Droid(String name, int health, int damage) {
        this.name = name;
        this.health = health;
        this.damage = damage;
        isAbleToMove=true;
    }

    public void gettingHealed(int amountOfHeal) {
        this.health += amountOfHeal;
    }

    public void decreasingHealth(int amountOfDamage) {
        if(this.health - amountOfDamage >= 0) {
            this.health -= amountOfDamage;
        } else {
            this.health = 0;
        }
    }

    public void decreaseRage(int amountOfDecrease) {
        if((this.rage - amountOfDecrease) > 0) {
            this.rage -= amountOfDecrease;
        } else {
            this.rage = 0;
        }
    }

    public void increaseRage(int amountOfIncrease) {
        if((this.rage + amountOfIncrease) <= 100) {
            this.rage += amountOfIncrease;
        } else {
            this.rage = 100;
        }
    }

    public void usePower(){
        System.out.println("gfudfgsev");
    }

    public void usePower(Droid droid, ArrayList<Droid> fightingDroids){
        System.out.println("gfudfgsev");
    }

    public void usePower(Droid droid){
        System.out.println("gfudfgsev");
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public int getDamage() {
        return damage;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }

    public int getRage() {
        return rage;
    }

    public void setRage(int rage) {
        this.rage = rage;
    }

    public int getTypeOfWeapon() {
        return typeOfWeapon;
    }

    public void setTypeOfWeapon(int typeOfWeapon) {
        this.typeOfWeapon = typeOfWeapon;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public boolean getIsAbleToMove() {
        return isAbleToMove;
    }

    public void setIsAbleToMove(boolean ableToMove) {
        isAbleToMove = ableToMove;
    }

    public int getAttack() {
        return attack;
    }
    public void setAttack(int attack) {
        this.attack = attack;
    }

    public int getAccuracyChance() {
        return accuracyChance;
    }
    public void setAccuracyChance(int accuracyChance) {
        this.accuracyChance = accuracyChance;
    }

    public void showDroidsInfo(ArrayList<Droid> fightingDroids) {
        System.out.println(" *-*-*-*-*-*-*-*--*--*--*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*");
        System.out.println("                                                               Раунд " + Battle.roundCount + ".");

        for (int i = 0, droidAmountInTeam = fightingDroids.size()/2; i < droidAmountInTeam; i++) {
            System.out.println((i+1) + ". " + fightingDroids.get(i).getName() + " - " +
                    fightingDroids.get(i).getHealth() + "hp, " +
                    fightingDroids.get(i).getRage() + "r.p." +
                    (fightingDroids.get(i).getIsAbleToMove() ? "                 ":". Не може рухатись.") +
                    "   ---   " + (i+1) + ". " + fightingDroids.get(i + droidAmountInTeam).getName() + " - " +
                    fightingDroids.get(i + droidAmountInTeam).getHealth() + "hp, " +
                    fightingDroids.get(i + droidAmountInTeam).getRage() + "r.p." +
                    (fightingDroids.get(i + droidAmountInTeam).getIsAbleToMove() ? "                 ":". Не може рухатись."));

        }

        System.out.println(" *-*-*-*-*-*-*-*--*--*--*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*");
    }

    @Override
    public String toString() { //тут
        return  "Ім'я= " + name +
                ", здоров'я= " + health +
                ", наносить шкоду= " + damage;
    }

}