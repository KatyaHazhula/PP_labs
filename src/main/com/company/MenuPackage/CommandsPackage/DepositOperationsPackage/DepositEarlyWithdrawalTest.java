package main.com.company.MenuPackage.CommandsPackage.DepositOperationsPackage;

import main.com.company.MenuPackage.CommandsPackage.Command;
import main.com.company.MenuPackage.CommandsPackage.DepositsPackage.AccumulateDeposit;
import main.com.company.MenuPackage.CommandsPackage.DepositsPackage.Deposit;
import main.com.company.MenuPackage.CommandsPackage.DepositsPackage.SacredDeposit;
import main.com.company.MenuPackage.CommandsPackage.DepositsPackage.UniversalDeposit;
import main.com.company.MenuPackage.CommandsPackage.OutputPackage.OutputCommand;
import main.com.company.MenuPackage.Menu.Client;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.*;

class DepositEarlyWithdrawalTest {

    ArrayList<Deposit> allDeposits;
    DepositEarlyWithdrawal obj;
    DepositOperations depositOperations;
    private Command output;
    private Client client = new Client();

    @BeforeEach
    void setUp() {

        allDeposits=new ArrayList<>();
        allDeposits.add(new SacredDeposit("Deposit 1",34,1,8));
        allDeposits.add(new UniversalDeposit("Deposit 2",345,55,2));
        allDeposits.add(new AccumulateDeposit("Deposit 3",2,89,5));
        depositOperations=new DepositOperations();
        obj=new DepositEarlyWithdrawal(allDeposits,depositOperations);
        output=new OutputCommand(allDeposits);//показуєм всі депозити і користувач робить вибір
        client.setCommand(output);
    }

    @AfterEach
    void tearDown() {
        allDeposits.removeAll(allDeposits);
    }

    @Test
    void execute() {
        int expected=2;
        obj.execute();
        int actual=allDeposits.size();
        assertEquals(expected,actual);
    }
}