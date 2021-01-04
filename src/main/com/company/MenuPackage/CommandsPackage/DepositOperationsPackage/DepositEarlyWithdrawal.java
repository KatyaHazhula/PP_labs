package main.com.company.MenuPackage.CommandsPackage.DepositOperationsPackage;

import main.com.company.MenuPackage.CommandsPackage.CalculatePercentage.CalculatePercentage;
import main.com.company.MenuPackage.CommandsPackage.Command;
import main.com.company.MenuPackage.CommandsPackage.DepositsPackage.Deposit;

import java.util.ArrayList;

public class DepositEarlyWithdrawal implements Command {
    private ArrayList<Deposit> deposits;
    private DepositOperations depositOperations;

    CalculatePercentage calculatePercentage=new CalculatePercentage();
    private int depositNum;

    DepositEarlyWithdrawal(ArrayList<Deposit> deposits, DepositOperations depositOperations) {

        if(deposits.size()==0){
            System.out.println("Your list of deposits is empty(((");
            return;
        }

        this.deposits = deposits;
        this.depositOperations = depositOperations;
    }

    public void execute() {

        System.out.println("If you want to withdraw the deposit early, you can do it only with universal deposit");
        calculatePercentage.openCalculatePercentage(deposits,true);
    }
}
