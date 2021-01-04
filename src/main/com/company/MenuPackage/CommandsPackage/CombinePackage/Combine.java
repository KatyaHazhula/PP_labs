package main.com.company.MenuPackage.CommandsPackage.CombinePackage;

import main.com.company.MenuPackage.CommandsPackage.Command;
import main.com.company.MenuPackage.CommandsPackage.DepositsPackage.Deposit;
import main.com.company.MenuPackage.CommandsPackage.DepositsPackage.SacredDeposit;
import main.com.company.MenuPackage.CommandsPackage.OutputPackage.OutputCommand;
import main.com.company.MenuPackage.Menu.Client;

import java.util.ArrayList;
import java.util.Scanner;

public class Combine {

    private Command output;
    private Client client = new Client();
    Scanner in=new Scanner(System.in);

        public void openCombine(ArrayList<Deposit> MyDeposits) {

            output = new OutputCommand(MyDeposits);
            client.setCommand(output);

            System.out.println("This feature allows you to select the main deposit and invite three friends who automatically open sacred deposits.");
            System.out.println("If one of them replenishes his deposit for the first time, the percentage of your deposit increases by 0.5%");
            System.out.println("Please choose main deposit:");

            client.commandExecute();
            int num=in.nextInt();

            for(int i=0;i<3;i++){

                MyDeposits.add(new SacredDeposit("Класичний", 0, 0, 8));
                MyDeposits.get(MyDeposits.size()-1).setDod(num-1);//додаєм характеристику
                MyDeposits.get(MyDeposits.size()-1).setTerm(MyDeposits.get(num-1).getTerm());
            }

        }
}
