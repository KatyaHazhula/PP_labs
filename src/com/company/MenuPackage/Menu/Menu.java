package com.company.MenuPackage.Menu;


import com.company.MenuPackage.CommandsPackage.AddElementPackage.AddElementCommand;
import com.company.MenuPackage.CommandsPackage.CalculatePercentage.CalculatePercentageCommand;
import com.company.MenuPackage.CommandsPackage.CombinePackage.CombineCommand;
import com.company.MenuPackage.CommandsPackage.Command;
import com.company.MenuPackage.CommandsPackage.DepositOperationsPackage.DepositOperationsCommand;
import com.company.MenuPackage.CommandsPackage.DepositsPackage.AccumulateDeposit;
import com.company.MenuPackage.CommandsPackage.DepositsPackage.Deposit;
import com.company.MenuPackage.CommandsPackage.DepositsPackage.SacredDeposit;
import com.company.MenuPackage.CommandsPackage.DepositsPackage.UniversalDeposit;
import com.company.MenuPackage.CommandsPackage.SortPackage.SortCommand;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Menu {
    private Command calculatePercentage;
    private Command sort;
    private Command combine;
    private Command depositOperations;
    private Command addElement;
    private ArrayList<Deposit> list;


    private Client client = new Client();
    private Reader reader;
    private Scanner in=new Scanner(System.in);

    public Menu() throws NullPointerException {
        String directory = "InfoDeposits.txt";
        list = new ArrayList<>();
        try {
            reader = new FileReader(directory);
        } catch (FileNotFoundException e) {
            System.out.println(" File error!");
            return;
        }
//в кожну з своїх команд запихаєм список депозитів
        calculatePercentage = new CalculatePercentageCommand(list);
        sort = new SortCommand(list);
        combine = new CombineCommand(list);
        addElement = new AddElementCommand(list);
        depositOperations=new DepositOperationsCommand(list);
    }
    public void Start() {
        int choice;

        InputData();

        do {
            System.out.println("\n ----------- Menu ----------- *");
            System.out.println(" 1. Deposit operations          *");
            System.out.println(" 2. Show all deposits           *");
            System.out.println(" 3. Combine deposits            *");
            System.out.println(" 4. Sort                        *");
            System.out.println(" 5. Calculate percentage        *");
            System.out.println(" 6. Add deposit                 *");
            System.out.println(" 7. Exit                        *");


            System.out.print(" Choose number => ");
            try {
                choice = in.nextInt();
            }
            catch (java.util.InputMismatchException e) {
                choice = 0;
                in.next();
            }

            MakeChoice(choice);
        } while(choice != 7);
    }

    private void MakeChoice(int choice) {
        switch (choice) {
            case 1: {
                client.setCommand(depositOperations);
                break;
            }
            case 2:{
                OutputData();
                break;
            }
            case 3: {
                client.setCommand(combine);
                break;
            }
            case 4: {
                client.setCommand(sort);
                break;
            }
            case 5: {
                client.setCommand(calculatePercentage);
                break;
            }
            case 6: {
                client.setCommand(addElement);
                break;
            }
            case 7: {
                return;
            }
            default: {
                System.out.println("Wrong number!");
                return;
            }
        }

        if(choice > 0 && choice < 7 &&choice!=2) {
            client.commandExecute();
        }
    }

    private void InputData() {
        try {
            BufferedReader br = new BufferedReader(reader);

            String name;

            double sum;
            int term;
            double percentage;

            int choice;

            while((name = br.readLine()) != null) {
                sum = Double.parseDouble(br.readLine());
                term = Integer.parseInt(br.readLine());
                percentage = Double.parseDouble(br.readLine());
                choice = Integer.parseInt(br.readLine());



                switch (choice) {
                    case 1: {
                        list.add(new SacredDeposit(name, sum, term, percentage));
                        break;
                    }
                    case 2: {
                        list.add(new AccumulateDeposit(name, sum, term, percentage));
                        break;
                    }
                    case 3: {
                        list.add(new UniversalDeposit(name, sum, term, percentage));
                        break;
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    private void OutputData() {
        if(list.size() == 0) {
            System.out.println(" Your list is empty.");
            return;
        }

        for (Deposit it : list) {
            System.out.println(" +-----------------------------------------------------------------------+");
            System.out.printf(" | %-29s | %-12d | %-10.0f |  %-10.2f |\n",
                    it.getName(),
                    it.getTerm(),
                    it.getSum(),
                    it.getPercentage());
        }

        System.out.println(" +----------------------------------------------------------------------------+");

    }

}
