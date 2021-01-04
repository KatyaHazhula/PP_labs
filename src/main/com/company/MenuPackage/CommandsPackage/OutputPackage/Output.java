package main.com.company.MenuPackage.CommandsPackage.OutputPackage;

import main.com.company.MenuPackage.CommandsPackage.DepositsPackage.Deposit;

import java.util.ArrayList;

public class Output {
    private ArrayList<Deposit> deposits;
    public void openOutput(ArrayList<Deposit> deposits){
        if(deposits.size() == 0) {
            System.out.println(" Your list is empty.");
            return;
        }

        System.out.println("|------------------------------------------------------------------------|");
        System.out.println("|  Name                            | Term         | Sum        | Percentage |");
        System.out.println("|                                  |              |            |            |");
        //System.out.println("|------------------------------------------------------------------------|");

        for (Deposit it : deposits) {

            System.out.println(" +-----------------------------------------------------------------------+");
            System.out.printf(" | %-31s | %-12d | %-10.0f |  %-10.2f |\n",
                    it.getName(),
                    it.getTerm(),
                    it.getSum(),
                    it.getPercentage());
        }

        System.out.println(" +-------------------------------------------------------------------------+");

    }
}
