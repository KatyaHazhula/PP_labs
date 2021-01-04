package main.com.company.MenuPackage.CommandsPackage.AddElementPackage;

import main.com.company.MenuPackage.CommandsPackage.Command;
import main.com.company.MenuPackage.CommandsPackage.DepositsPackage.AccumulateDeposit;
import main.com.company.MenuPackage.CommandsPackage.DepositsPackage.Deposit;
import main.com.company.MenuPackage.CommandsPackage.DepositsPackage.SacredDeposit;
import main.com.company.MenuPackage.CommandsPackage.DepositsPackage.UniversalDeposit;
import main.com.company.MenuPackage.CommandsPackage.OutputPackage.OutputCommand;
import main.com.company.MenuPackage.Menu.Client;

import java.util.ArrayList;
import java.util.Scanner;

public class AddElement {
    Scanner in=new Scanner(System.in);
    private Command output;
    private Client client = new Client();

    public void openAddElement(ArrayList<Deposit> deposits,ArrayList<Deposit> MyDeposits) {
        double sum;
        int term;

        System.out.println("Here are three types of deposits ");
        System.out.println("1. Accumulative: with the possibility of replenishment but without the possibility of early withdrawal");
        System.out.println("2. Sacred: without the possibility of replenishment and early withdrawal");
        System.out.println("3. Universal: with the possibility of replenishment and early withdrawal");

        output=new OutputCommand(deposits);
        client.setCommand(output);

        client.commandExecute();
        System.out.println("Please choose the type of deposit: ");

        int num=Integer.parseInt(in.nextLine());

        System.out.println("Enter your term in months: ");
        term = Integer.parseInt(in.nextLine());

        System.out.println("Enter your sum: ");
        sum = Double.parseDouble(in.nextLine());

        if(deposits.get(num-1) instanceof SacredDeposit){
            //MyDeposits.add(new SacredDeposit(deposits.get(num-1).getName(), sum, term,deposits.get(num-1).getPercentage() ));//ощадний
            MyDeposits.add(new SacredDeposit(deposits.get(num-1), term, sum));//ощадний
        }else if(deposits.get(num-1) instanceof UniversalDeposit){
            MyDeposits.add(new UniversalDeposit(deposits.get(num-1), term, sum));

        }else if(deposits.get(num-1) instanceof AccumulateDeposit){
            MyDeposits.add(new AccumulateDeposit(deposits.get(num-1), term, sum));
        }

        System.out.println("\nYou have successfully add your deposit!");
        System.out.println("\nYou can see it in the list of your deposits.");
    }
}
