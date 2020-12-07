package com.company.MenuPackage.CommandsPackage.CalculatePercentage;

import com.company.MenuPackage.CommandsPackage.Command;
import com.company.MenuPackage.CommandsPackage.DepositsPackage.Deposit;

import java.util.ArrayList;

public class CalculatePercentageCommand implements Command {
    private ArrayList<Deposit> deposits;
    private CalculatePercentage calculatePercentage;
    public CalculatePercentageCommand(ArrayList<Deposit> deposits) {
        calculatePercentage =  new CalculatePercentage();

        this.deposits = deposits;
    }

    public void execute(){calculatePercentage.openCalculatePercentage(deposits);}//викликається пвений метод
}
