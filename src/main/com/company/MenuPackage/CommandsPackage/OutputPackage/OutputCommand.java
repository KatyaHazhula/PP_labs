package main.com.company.MenuPackage.CommandsPackage.OutputPackage;

import main.com.company.MenuPackage.CommandsPackage.Command;
import main.com.company.MenuPackage.CommandsPackage.DepositsPackage.Deposit;

import java.util.ArrayList;

public class OutputCommand implements Command {
   private Output output;
    private ArrayList<Deposit> deposits;

    public OutputCommand(ArrayList<Deposit> deposits) {
        output=new Output();
        this.deposits = deposits;
    }

    @Override
    public void execute() {
       output.openOutput(deposits);
    }
}
