package main.com.company.MenuPackage.CommandsPackage.CalculatePercentage;

import main.com.company.MainPackage.Main;
import main.com.company.MenuPackage.CommandsPackage.Command;
import main.com.company.MenuPackage.CommandsPackage.DepositsPackage.AccumulateDeposit;
import main.com.company.MenuPackage.CommandsPackage.DepositsPackage.Deposit;
import main.com.company.MenuPackage.CommandsPackage.DepositsPackage.SacredDeposit;
import main.com.company.MenuPackage.CommandsPackage.OutputPackage.OutputCommand;
import main.com.company.MenuPackage.Menu.Client;

import java.util.ArrayList;
import java.util.Scanner;

public class CalculatePercentage {

    Scanner in=new Scanner(System.in);
    private ArrayList<Deposit> deposits;
    private int depositNum;
    private Command output;
    private Client client = new Client();

    public void openCalculatePercentage(ArrayList<Deposit> deposits,boolean remove) {
       Main.LOGGER.info("Calculating the sum");

        if(deposits.size()==0){
            System.out.println("Your list of deposits is empty(((");
            return;
        }
        output=new OutputCommand(deposits);//показуєм всі депозити і користувач робить вибір
        client.setCommand(output);
        this.deposits=deposits;

        client.commandExecute();
        System.out.println("Choose deposit:");

        this.depositNum=in.nextInt();

        System.out.println(" +----------------------------------------------------------------------------+");
        System.out.println("After the term you have chosen -0/after the deadline-1 ");

        int choose=in.nextInt();

        if(deposits.get(depositNum-1) instanceof SacredDeposit || deposits.get(depositNum-1) instanceof AccumulateDeposit && choose==0 ){
            System.out.println("\nYou can not do early withdrawal with accumulate and sacred deposits!");
            return;
        }

        if(choose==0){
            System.out.println("Enter count of months: ");
            int monthsNum=in.nextInt();
            System.out.printf("This is the sum that is paid after the term you have chosen: %.2f ",calculateSum(monthsNum,deposits.get(depositNum-1).getPercentage()-0.5, deposits,depositNum));
        }else if(choose==1){
            System.out.printf("This is the sum that is paid after the deadline: %.2f",calculateSum(deposits.get(depositNum-1).getTerm(),deposits.get(depositNum-1).getPercentage(),deposits,depositNum));
        }

        if(remove){ //якщо це зняття то просто видаяєм депозит зі списку

            deposits.remove(depositNum-1);
            System.out.println("\nYou have successfully withdrawn your deposit!");
        }
    }

    public double calculateSum(int term,double percentage, ArrayList<Deposit> deposits,int depositNum){ //рахує суму грошей за певний час
        return deposits.get(depositNum-1).getSum()+((deposits.get(depositNum-1).getSum()*(percentage/100)/365)*(30*term));
    }
}
