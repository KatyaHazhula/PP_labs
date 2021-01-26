package main.com.company.MainPackage;

import main.com.company.EmailPackage.Email;
import main.com.company.MenuPackage.Menu.Menu;

import java.io.IOException;
import java.util.logging.FileHandler;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

public class Main {

    static public Logger LOGGER;
    static public FileHandler fileHandler;
    static public Email email;

    public static void main(String[] args) {

        try {
            email=new Email();
            LOGGER = Logger.getLogger(Main.class.getName());
            fileHandler =new FileHandler("D:\\Polytechnic\\3 семестр\\ПП\\File.log");
            LOGGER.addHandler(fileHandler);
            SimpleFormatter formatter = new SimpleFormatter();
            fileHandler.setFormatter(formatter);

            LOGGER.info("Start program");
            Menu menu = new Menu();
            menu.Start();
        } catch (NullPointerException | IOException e) {
            System.out.println(" Exiting...");
            email.send(e.toString());
        }
    }
}
