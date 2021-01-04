package main.com.company.MenuPackage.CommandsPackage.SortPackage;

import main.com.company.MenuPackage.CommandsPackage.Command;
import main.com.company.MenuPackage.CommandsPackage.DepositsPackage.Deposit;

import java.util.ArrayList;

public class SortCommand implements Command {
    private ArrayList<Deposit> deposits;
    private Sort sort;
    public SortCommand(ArrayList<Deposit> deposits) {
        sort =  new Sort();//Receiver

        this.deposits = deposits;
    }

    public void execute(){sort.openSort(deposits);}//викликається пвений метод
}
