package com.company.Player;

import com.company.Droids.Droid;

import java.io.*;

import java.util.ArrayList;
import java.util.Scanner;

public class Player {

    private String name;
    private static int countOfDroids;

    public final ArrayList<Droid> droidStation = new ArrayList<>();

//    public Player(String name) {
//        this.name = name;
//    }

    public Player() {
        try {
            FileReader reader = new FileReader("InfoPlayer.txt");
            BufferedReader br = new BufferedReader(reader);

            String line;
            int value;

            name = br.readLine();

            while((line = br.readLine()) != null ) {
                Droid droid = new Droid();

                droid.setName(line);

                value = Integer.parseInt(br.readLine());
                droid.setHealth(value);

                value = Integer.parseInt(br.readLine());
                droid.setDamage(value);

                value = Integer.parseInt(br.readLine());
                droid.setTypeOfWeapon(value);

                droidStation.add(droid);
            }
        } catch (FileNotFoundException e) {
            Scanner in = new Scanner(System.in);

            System.out.print(" Введіть своє ім'я -> ");
            name = in.nextLine();
        } catch (IOException e) {
            System.out.println("Wrong data input!");
        }

        System.out.println(" Привіт " + name + "! Щасти тобі!");
        System.out.println();
    }

    public static int getCountOfDroids() {
        return countOfDroids;
    }

    public static void increaseCountOfDroids() {
        countOfDroids++;
    }
}