package main.com.company.MenuPackage.CommandsPackage.DepositOperationsPackage;

import main.com.company.MenuPackage.CommandsPackage.Command;
import main.com.company.MenuPackage.CommandsPackage.DepositsPackage.Deposit;
import main.com.company.MenuPackage.CommandsPackage.DepositsPackage.SacredDeposit;
import main.com.company.MenuPackage.CommandsPackage.OutputPackage.OutputCommand;
import main.com.company.MenuPackage.Menu.Client;

import java.util.ArrayList;
import java.util.Scanner;

public class DepositReplenishment implements Command {

    private ArrayList<Deposit> deposits;
    private DepositOperations depositOperations;
    private int depositNum;
    private Command output;
    private Client client = new Client();

    DepositReplenishment(ArrayList<Deposit> deposits, DepositOperations depositOperations) {
        this.deposits = deposits;
        this.depositOperations = depositOperations;
        output=new OutputCommand(deposits);
    }

    public void execute() {

        if(deposits.size()==0){
            System.out.println("Your list of deposits is empty(((");
            return;
        }

        Scanner in=new Scanner(System.in);
        client.setCommand(output);

        System.out.println("You can replenish accumulate and universal deposit");
        System.out.println("If you replenish your deposit then the percentage of your deposit increases by 0.1%");

        client.commandExecute();
        System.out.println("Choose deposit, which you want to replenish:");

        this.depositNum=in.nextInt();

        if(deposits.get(depositNum-1) instanceof SacredDeposit && deposits.get(depositNum-1).getSum()!=0){//якщо це ощадний то ми не можем його поповнити
            System.out.println("You can not replenish the sacred deposit!");
            return;
        }

        if(deposits.get(depositNum-1).getDod()!=-1 && deposits.get(depositNum-1).getSum()==0){ //якщо це один з додаткових і він поповнюється вперше то можна
            deposits.get(deposits.get(depositNum-1).getDod()).setPercentage(deposits.get(deposits.get(depositNum-1).getDod()).getPercentage()+0.5);
        }

        if(deposits.get(depositNum-1).getSum()!=0){ //збільшуємо відсоток
            deposits.get(depositNum-1).setPercentage(deposits.get(depositNum-1).getPercentage()+0.1);
        }

        System.out.println("Enter sum:");
        double newSum=in.nextDouble();
        deposits.get(depositNum-1).setSum(deposits.get(depositNum-1).getSum()+newSum);
        System.out.println("\nYou have successfully replenish your deposit!");

    }
}
