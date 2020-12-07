package com.company.MenuPackage.CommandsPackage.DepositOperationsPackage;

import com.company.MenuPackage.CommandsPackage.CalculatePercentage.CalculatePercentage;
import com.company.MenuPackage.CommandsPackage.Command;
import com.company.MenuPackage.CommandsPackage.DepositsPackage.Deposit;

import java.util.ArrayList;

public class DepositOperationsCommand implements Command {
    private ArrayList<Deposit> deposits;
    private DepositOperations depositOperations;
    public DepositOperationsCommand(ArrayList<Deposit> deposits) {
        depositOperations =  new DepositOperations();

        this.deposits = deposits;
    }

    public void execute(){depositOperations.openOperations(deposits, depositOperations);}//викликається пвений метод
}
