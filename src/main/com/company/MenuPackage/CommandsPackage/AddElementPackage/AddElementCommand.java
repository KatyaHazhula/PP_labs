package main.com.company.MenuPackage.CommandsPackage.AddElementPackage;

import main.com.company.MenuPackage.CommandsPackage.Command;
import main.com.company.MenuPackage.CommandsPackage.DepositsPackage.Deposit;

import java.util.ArrayList;

public class AddElementCommand  implements Command {

        private ArrayList<Deposit> deposits;
        private ArrayList<Deposit> MyDeposits;
        private AddElement addElement;
        public AddElementCommand(ArrayList<Deposit> deposits,ArrayList<Deposit> MyDeposits) {
            addElement =  new AddElement();//Receiver

            this.deposits = deposits;
            this.MyDeposits=MyDeposits;
        }

        public void execute(){addElement.openAddElement(deposits,MyDeposits);}//викликається пвений метод

}
