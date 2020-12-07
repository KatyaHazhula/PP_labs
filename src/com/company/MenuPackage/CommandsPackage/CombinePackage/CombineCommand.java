package com.company.MenuPackage.CommandsPackage.CombinePackage;

import com.company.MenuPackage.CommandsPackage.CalculatePercentage.CalculatePercentage;
import com.company.MenuPackage.CommandsPackage.Command;
import com.company.MenuPackage.CommandsPackage.DepositsPackage.Deposit;

import java.util.ArrayList;

public class CombineCommand implements Command {
    private ArrayList<Deposit> deposits;
    private Combine combine;
    public CombineCommand(ArrayList<Deposit> deposits) {
        combine =  new Combine();

        this.deposits = deposits;
    }

    public void execute(){combine.openCombine(deposits);}//викликається пвений метод
}
