package com.company.MenuPackage.CommandsPackage.DepositOperationsPackage;

import com.company.MenuPackage.CommandsPackage.Command;
import com.company.MenuPackage.CommandsPackage.DepositsPackage.Deposit;

import java.util.ArrayList;

public class DepositEarlyWithdrawal implements Command {
    private ArrayList<Deposit> deposits;
    private DepositOperations depositOperations;

    DepositEarlyWithdrawal(ArrayList<Deposit> deposits, DepositOperations depositOperations) {
        this.deposits = deposits;
        this.depositOperations = depositOperations;
    }

    public void execute() {
        System.out.println("Here we withdraw the deposit ahead of time");
        //depositOperations.openOperations(deposits, depositOperations);
    }
}
