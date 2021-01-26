package main.com.company.MenuPackage.CommandsPackage.AddElementPackage;

import main.com.company.MenuPackage.CommandsPackage.DepositsPackage.AccumulateDeposit;
import main.com.company.MenuPackage.CommandsPackage.DepositsPackage.Deposit;
import main.com.company.MenuPackage.CommandsPackage.DepositsPackage.SacredDeposit;
import main.com.company.MenuPackage.CommandsPackage.DepositsPackage.UniversalDeposit;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class AddElementTest {

    AddElement addElement;
    ArrayList<Deposit> allDeposits;
    ArrayList<Deposit> myDeposits;

    @org.junit.jupiter.api.BeforeEach
    void setUp() {

        addElement=new AddElement();
        allDeposits=new ArrayList<>();
        myDeposits=new ArrayList<>();
        allDeposits.add(new SacredDeposit("Deposit 1",0,0,8));
        allDeposits.add(new UniversalDeposit("Deposit 2",0,0,2));
        allDeposits.add(new AccumulateDeposit("Deposit 3",0,0,5));

    }

    @org.junit.jupiter.api.AfterEach
    void tearDown() {
        allDeposits.removeAll(allDeposits);
        myDeposits.removeAll(myDeposits);

    }

    @org.junit.jupiter.api.Test
    void openAddElement() {

        addElement.openAddElement(allDeposits,myDeposits);
        int expected=1;
        int actual=myDeposits.size();
        assertEquals(expected,actual);
    }
}