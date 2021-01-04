package main.com.company.MainPackage;

import main.com.company.MenuPackage.Menu.Menu;

public class Main {
    public static void main(String[] args) {

        try {
            Menu menu = new Menu();
            menu.Start();
        } catch (NullPointerException e) {
            System.out.println(" Exiting...");
        }
    }
}
