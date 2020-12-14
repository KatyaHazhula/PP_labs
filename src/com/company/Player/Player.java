package com.company.Player;

import com.company.Droids.*;

import java.io.*;

import java.util.ArrayList;
import java.util.Scanner;

public class Player {

    private String userName;
 //   private static int countOfDroids;
    private String name;
    private int health;
    private int damage;
  //  private boolean isAbleToMove;

    public static ArrayList<Droid> droidStation = new ArrayList<>();

    public Player() {
        try {
            FileReader reader = new FileReader("InfoPlayer.txt");
            BufferedReader br = new BufferedReader(reader);

            String line;
            int value;

            userName = br.readLine();

            while((name = br.readLine()) != null ) {
                value = Integer.parseInt(br.readLine());
                health = Integer.parseInt(br.readLine());
                damage = Integer.parseInt(br.readLine());


                switch (value){
                    case 1:droidStation.add(new DroidKnight(name, health, damage));break;
                    case 2:droidStation.add(new DroidFairy(name, health, damage));break;
                    case 3:droidStation.add(new ArmoredDroid(name, health, damage));break;
                    case 4:droidStation.add(new DroidVedma(name, health, damage));break;
                    case 5:droidStation.add(new DangerousDroid(name, health, damage));break;
                }

            }
        } catch (FileNotFoundException e) {
            Scanner in = new Scanner(System.in);

            System.out.print(" Введіть своє ім'я -> ");
            userName = in.nextLine();
        } catch (IOException e) {
            System.out.println("Wrong data input!");
        }

        System.out.println(" Привіт " + userName + "! Щасти тобі!");
        System.out.println();
    }

    public static int getCountOfDroids() {
        return droidStation.size();
    }
}