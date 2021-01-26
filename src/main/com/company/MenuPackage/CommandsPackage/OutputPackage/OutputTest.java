package main.com.company.MenuPackage.CommandsPackage.OutputPackage;

import main.com.company.MenuPackage.CommandsPackage.DepositsPackage.AccumulateDeposit;
import main.com.company.MenuPackage.CommandsPackage.DepositsPackage.Deposit;
import main.com.company.MenuPackage.CommandsPackage.DepositsPackage.SacredDeposit;
import main.com.company.MenuPackage.CommandsPackage.DepositsPackage.UniversalDeposit;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class OutputTest {
    ArrayList<Deposit> allDeposits;
    Output output;

    @BeforeEach
    void setUp() {
        output= new Output();
        allDeposits=new ArrayList<>();
        allDeposits.add(new SacredDeposit("Deposit 1",34,1,8));
        allDeposits.add(new UniversalDeposit("Deposit 2",345,55,2));
        allDeposits.add(new AccumulateDeposit("Deposit 3",2,89,5));
    }

    @AfterEach
    void tearDown() {
        allDeposits.removeAll(allDeposits);
    }

    @Test
    void openOutput() {
        output.openOutput(allDeposits);
    }
}