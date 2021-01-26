package main.com.company.MenuPackage.CommandsPackage.CalculatePercentage;

import main.com.company.MenuPackage.CommandsPackage.AddElementPackage.AddElement;
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

class CalculatePercentageTest {

    ArrayList<Deposit> allDeposits;
    CalculatePercentage calculatePercentage;
    private Command output;
    private Client client = new Client();
    Scanner in;

    @BeforeEach
    void setUp() {

        calculatePercentage=new CalculatePercentage();
        allDeposits=new ArrayList<>();
        allDeposits.add(new SacredDeposit("Deposit 1",34,1,8));
        allDeposits.add(new UniversalDeposit("Deposit 2",345,55,2));
        allDeposits.add(new AccumulateDeposit("Deposit 3",2,89,5));
        output=new OutputCommand(allDeposits);//показуєм всі депозити і користувач робить вибір
        client.setCommand(output);
        in = new Scanner(System.in);

    }

    @AfterEach
    void tearDown() {
        allDeposits.removeAll(allDeposits);
    }

    @Test
    void calculateSum() {
        client.commandExecute();
        int num=in.nextInt();
        double expected=34.13972602739726;

        double actual = calculatePercentage.calculateSum(5,1,allDeposits,num);
        assertEquals(expected,actual);
    }
}