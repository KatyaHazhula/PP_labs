package main.com.company.MenuPackage.CommandsPackage.SortPackage;

import main.com.company.MainPackage.Main;
import main.com.company.MenuPackage.CommandsPackage.DepositsPackage.Deposit;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Sort {
    Scanner in=new Scanner(System.in);
    private ArrayList<Deposit> deposits;
    public void openSort(ArrayList<Deposit> deposits) {
        Main.LOGGER.info("Sort our lists of deposits");
        if(deposits.size()==0){
            System.out.println("Your list of deposits is empty(((");
            return;
        }
        System.out.println("\n ------------- Sort ------------- *");
        System.out.println(" 1. Sort by name                    *");
        System.out.println(" 2. Sort by sum                     *");
        System.out.println(" 3. Sort by percentage              *");
        System.out.println(" 4. Sort by term                    *");
        System.out.println(" 5. Change direction:" +
                (deposits.get(0).getSortPriority() > 0 ? " ascending   *" : " descending  *"));

        System.out.print(" Choose number => ");
        int choice;

        try {
            choice = in.nextInt();
        }
        catch (java.util.InputMismatchException e) {
            choice = 0;
            in.next();
            Main.email.send(e.toString());
        }

        this.deposits = deposits;
        MakeChoice(choice);

    }

    private void MakeChoice(int choice) {
        switch (choice) {
            case 1: {
                for(Deposit it:deposits) {
                    if(it.getSortPriority() > 0) {
                        it.setSortPriority(1);
                    }
                    else {
                        it.setSortPriority(-1);
                    }
                }
                break;
            }
            case 2: {
                for(Deposit it:deposits) {
                    if(it.getSortPriority() > 0) {
                        it.setSortPriority(2);
                    }
                    else {
                        it.setSortPriority(-2);
                    }
                }
                break;
            }
            case 3: {
                for(Deposit it:deposits) {
                    if(it.getSortPriority() > 0) {
                        it.setSortPriority(3);
                    }
                    else {
                        it.setSortPriority(-3);
                    }
                }
                break;
            }
            case 4: {
                for(Deposit it:deposits) {
                    if(it.getSortPriority() > 0) {
                        it.setSortPriority(4);
                    }
                    else {
                        it.setSortPriority(-4);
                    }
                }
                break;
            }
            case 5: {
                for(Deposit it:deposits) {
                    it.setSortPriority(it.getSortPriority() * -1);
                }
                break;
            }
            default: {
                System.out.println("Wrong number!");
            }
        }

        if(choice > 0 && choice < 6) {
            Collections.sort(deposits);
        }

        System.out.println("\nYou have successfully sort your deposit!");
        System.out.println("\nYou can see it in the list of your deposits.");
    }
}
