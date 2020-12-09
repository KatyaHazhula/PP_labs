package com.company.Menu;

import com.company.Battle.Battle;
import com.company.Droids.*;
import com.company.Player.Player;

import java.util.Scanner;


public class Menu {
    private int playerChoice;
    private Player player;
    private Battle battle;

    public Menu() {
        playerChoice = 0;
    }

    public void start() {

        System.out.println(" =================================================================================================");

        player = new Player();

        while((playerChoice = menuDisplay()) != 5) {
            System.out.println();
            switch (playerChoice) {
                case 1: {
                    // Start 1vs1 battle
                    battle1vs1Section();
                    break;
                } case 2: {
                    // Start 3vs3 battle
                    battle3vs3Section();
                    break;
                } case 3: {
                    // Get list of droids
                    showDroidsSection();
                    break;
                } case 4: {
                    // Create a Droid
                    typeOfDroid();
                    break;
                } default: {
                    System.out.println("Неправильний номер, виберіть інший...");
                    System.out.println();
                }
            }
        }
    }

    private int menuDisplay() {
        System.out.println(" *-*-*-*-*-*-*-*--*--*--*-*-*-*");
        System.out.println(" *                                *");
        System.out.println(" *           Головне меню         *");
        System.out.println(" *                                *");
        System.out.println(" *-*-*-*-*-*-*-*--*--*--*-*-*-*");
        System.out.println(" * 1. Гра 1 на 1                  *");
        System.out.println(" * 2. Гра 3 на 3                  *");
        System.out.println(" * 3. Показати дроїдів            *");
        System.out.println(" * 4. Створити дроїда             *");
        System.out.println(" * 5. Вийти                       *");
        System.out.println(" *-*-*-*-*-*-*-*--*--*--*-*-*-*");
        System.out.print(" ------------- Введіть номер --> ");

        Scanner in = new Scanner(System.in);
        return in.nextInt();
    }

    private void battle1vs1Section() {
        if(Player.getCountOfDroids() < 2) {
            System.out.println("Вам потрібно 6 дроїдів щоб битись! ");
            System.out.println("Створіть їх, натиснувши на 4 кнопку в розділі Меню.");
            return;
        }

        System.out.println(" *-*-*-*-*-*-*-*--*--*--*-*-*-*");
        System.out.println(" *                                *");
        System.out.println(" *         Гра 1 на  1            *");
        System.out.println(" *                                *");
        System.out.println(" *-*-*-*-*-*-*-*--*--*--*-*-*-*");
        System.out.println(" * Виберіть 2 дроїдів             *");
        System.out.println(" * з запропонованого списку       *");
        System.out.println(" * Список:                        *");
        System.out.println(" *-*-*-*-*-*-*-*--*--*--*-*-*-*");

        for (int i = 0; i < Player.getCountOfDroids(); i++) {
            System.out.println(" * " + (i+1) + ". " + player.droidStation.get(i));
        }
        System.out.println(" *-*-*-*-*-*-*-*--*--*--*-*-*-*");

        Scanner in = new Scanner(System.in);

        System.out.print(" ------------- Введіть 1 дроїда  --> ");
        int first = in.nextInt();
        System.out.print(" ------------- Введіть 2 дроїда  --> ");
        int second = in.nextInt();

        System.out.println();
        System.out.println();
        Droid firstDroid = player.droidStation.get(first - 1);
        Droid secondDroid = player.droidStation.get(second - 1);

        battle = new Battle(firstDroid, secondDroid);
        battle.start1vs1Battle();
    }

    private void battle3vs3Section() {
        if(Player.getCountOfDroids() < 6) {
            System.out.println("Вам потрібно 6 дроїдів щоб битись! ");
            System.out.println("Створіть їх, натиснувши на 4 кнопку в розділі Меню.");
            return;
        }

        System.out.println(" *-*-*-*-*-*-*-*--*--*--*-*-*-*");
        System.out.println(" *                                *");
        System.out.println(" *         Батл 3 на 3            *");
        System.out.println(" *                                *");
        System.out.println(" *-*-*-*-*-*-*-*--*--*--*-*-*-*");
        System.out.println(" * Виберіть 6 дроїдів             *");
        System.out.println(" * з запропонованого списку       *");
        System.out.println(" * Список:                        *");
        System.out.println(" *-*-*-*-*-*-*-*--*--*--*-*-*-*");
        for (int i = 0; i < Player.getCountOfDroids(); i++) {
            System.out.println(" * " + (i+1) + ". " + player.droidStation.get(i));
        }
        System.out.println(" *-*-*-*-*-*-*-*--*--*--*-*-*-*");

        Scanner in = new Scanner(System.in);

        System.out.print(" ------------- Введіть 1 дроїда  --> ");
        int first = in.nextInt();
        System.out.print(" ------------- Введіть 2 дроїда  --> ");
        int second = in.nextInt();
        System.out.print(" ------------- Введіть 3 дроїда  --> ");
        int third = in.nextInt();
        System.out.print(" ------------- Введіть 4 дроїда  --> ");
        int forth = in.nextInt();
        System.out.print(" ------------- Введіть 5 дроїда  --> ");
        int fifth = in.nextInt();
        System.out.print(" ------------- Введіть 6 дроїда  --> ");
        int sixth = in.nextInt();

        System.out.println();
        System.out.println();
        Droid firstDroid = player.droidStation.get(first - 1);
        Droid secondDroid = player.droidStation.get(second - 1);
        Droid thirdDroid = player.droidStation.get(third - 1);
        Droid fourthDroid = player.droidStation.get(forth - 1);
        Droid fifthDroid = player.droidStation.get(fifth - 1);
        Droid sixthDroid = player.droidStation.get(sixth - 1);

        battle = new Battle(firstDroid, secondDroid, thirdDroid, fourthDroid, fifthDroid, sixthDroid);
        battle.start3vs3Battle();

    }

    private void showDroidsSection() {
        if(Player.getCountOfDroids() < 1) {
            System.out.println("Ви ще не маєте дроїдів  !");
            System.out.println("Створіть їх, натиснувши на 4 кнопку в розділі Меню.");
            return;
        }

        System.out.println(" *-*-*-*-*-*-*-*--*--*--*-*-*-*");
        System.out.println(" *                                *");
        System.out.println(" *          Показати дроїдів      *");
        System.out.println(" *                                *");
        System.out.println(" *-*-*-*-*-*-*-*--*--*--*-*-*-*");

        for(Droid i:player.droidStation) {
            System.out.println(" * " + i);
        }
        System.out.println();
        System.out.println();
    }
    private void createDroidSection(int value) {
        Scanner in=new Scanner(System.in);
        String name;
        int health;
        int damage;
        //inputAttributesForDroid(droid);
        System.out.println(" *-*-*-*-*-*-*-*--*--*--*-*-*-*");
        System.out.println(" *                                *");
        System.out.println(" *          Створити дроїда       *");
        System.out.println(" *                                *");
        System.out.println(" *-*-*-*-*-*-*-*--*--*--*-*-*-*");
        System.out.println(" * Кожен дроїд повинен мати       *");
        System.out.println(" * наступні дані :                *");
        System.out.println(" * 1. Ім'я                        *");
        System.out.println(" * 2. Кількість здоров'я          *");
        System.out.println(" * 3. Кількість нанесеної шкоди   *");
        System.out.println(" *-*-*-*-*-*-*-*--*--*--*-*-*-*");

        System.out.print(" -------------- Введіть ім'я   -> ");
        name=in.nextLine();

        System.out.print(" -- Введіть кількість здоров'я -> ");
        health=Integer.parseInt(in.nextLine());

        System.out.print(" ----- Введіть кількість нанесеної шкоди -> ");
        damage=Integer.parseInt(in.nextLine());

        switch (value){
            case 1:player.droidStation.add(new DroidKnight(name, health, damage));break;
            case 2:player.droidStation.add(new DroidFairy(name, health, damage));break;
            case 3:player.droidStation.add(new ArmoredDroid(name, health, damage));break;
            case 4:player.droidStation.add(new DroidVedma(name, health, damage));break;
            case 5:player.droidStation.add(new DangerousDroid(name, health, damage));break;
        }
       // Droid droid = new Droid();
//        inputAttributesForDroid(droid);
//        player.droidStation.add(droid);
    }

    private void typeOfDroid() {
        Scanner in = new Scanner(System.in);
//
//        System.out.print(" -------------- Введіть ім'я   -> ");
//        droid.setName(in.nextLine());
//
//        System.out.print(" -- Введіть кількість здоров'я -> ");
//        droid.setHealth(in.nextInt());
//
//        System.out.print(" ----- Введіть кількість нанесеної шкоди -> ");
//        droid.setDamage(in.nextInt());

        System.out.println(" *-*-*-*-*-*-*-*--*--*--*-*-*-*");
        System.out.println(" * Виберіть дроїда:               *");
        System.out.println(" * 1. Дроїд з мечем               *");
        System.out.println(" * 2. Дроїд фєєчка                *");
        System.out.println(" * 3. Дроїд з щитом               *");
        System.out.println(" * 4. Дроїд вєдьма                *");
        System.out.println(" * 5. Дроїд з ножиком             *");
        System.out.println(" *-*-*-*-*-*-*-*--*--*--*-*-*-*");
        System.out.print(" ------------- Введіть номер --> ");
        int value=Integer.parseInt(in.nextLine());

      //  droid.setTypeOfWeapon(in.nextInt());
        System.out.println();
        System.out.println();
        createDroidSection(value);
    }

}
