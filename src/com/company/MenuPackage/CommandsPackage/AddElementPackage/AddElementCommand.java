package com.company.MenuPackage.CommandsPackage.AddElementPackage;

import com.company.MenuPackage.CommandsPackage.CalculatePercentage.CalculatePercentage;
import com.company.MenuPackage.CommandsPackage.Command;
import com.company.MenuPackage.CommandsPackage.DepositsPackage.Deposit;

import java.util.ArrayList;

public class AddElementCommand  implements Command {

        private ArrayList<Deposit> deposits;
        private AddElement addElement;
        public AddElementCommand(ArrayList<Deposit> deposits) {
            addElement =  new AddElement();//Receiver

            this.deposits = deposits;
        }

        public void execute(){addElement.openAddElement(deposits);}//викликається пвений метод

}
