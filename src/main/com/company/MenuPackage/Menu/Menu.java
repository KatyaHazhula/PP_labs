package main.com.company.MenuPackage.Menu;


import main.com.company.MainPackage.Main;
import main.com.company.MenuPackage.CommandsPackage.AddElementPackage.AddElementCommand;
import main.com.company.MenuPackage.CommandsPackage.CalculatePercentage.CalculatePercentageCommand;
import main.com.company.MenuPackage.CommandsPackage.CombinePackage.CombineCommand;
import main.com.company.MenuPackage.CommandsPackage.Command;
import main.com.company.MenuPackage.CommandsPackage.DepositOperationsPackage.DepositOperationsCommand;
import main.com.company.MenuPackage.CommandsPackage.DepositsPackage.AccumulateDeposit;
import main.com.company.MenuPackage.CommandsPackage.DepositsPackage.Deposit;
import main.com.company.MenuPackage.CommandsPackage.DepositsPackage.SacredDeposit;
import main.com.company.MenuPackage.CommandsPackage.DepositsPackage.UniversalDeposit;
import main.com.company.MenuPackage.CommandsPackage.OutputPackage.OutputCommand;
import main.com.company.MenuPackage.CommandsPackage.SortPackage.SortCommand;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Menu {
    private Command calculatePercentage;
    private Command sort;
    private Command combine;
    private Command depositOperations;
    private Command addElement;
    private Command output;
    private ArrayList<Deposit> list;
    private ArrayList<Deposit> MyDepositList;


    private Client client = new Client();
    private Reader reader;
    private Scanner in=new Scanner(System.in);

    public Menu() throws NullPointerException {
        String directory = "InfoDeposits.txt";
        list = new ArrayList<>();
        MyDepositList=new ArrayList<>();
        try {
            reader = new FileReader(directory);
        } catch (FileNotFoundException e) {
            System.out.println(" File error!");
            return;
        }
//в кожну з своїх команд запихаєм список депозитів
        calculatePercentage = new CalculatePercentageCommand(MyDepositList);
        sort = new SortCommand(MyDepositList);
        combine = new CombineCommand(MyDepositList);
        addElement = new AddElementCommand(list,MyDepositList);
        depositOperations=new DepositOperationsCommand(MyDepositList);

    }
    public void Start() {
        int choice;

        InputData();

        do {
            System.out.println("\n ----------- Menu ----------- *");
            System.out.println(" 1. Deposit operations          *");
            System.out.println(" 2. Show  deposits              *");
            System.out.println(" 3. Combine deposits            *");
            System.out.println(" 4. Sort                        *");
            System.out.println(" 5. Calculate sum               *");
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
                System.out.println("What to output? the type of deposits-1/ your deposits-2");
                if(in.nextInt()==1){
                    output=new OutputCommand(list);
                }else{
                    output=new OutputCommand(MyDepositList);
                }
                client.setCommand(output);
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

        if(choice > 0 && choice < 7) {
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
                        list.add(new SacredDeposit(name, sum, term, percentage));//ощадний
                        break;
                    }
                    case 2: {
                        list.add(new AccumulateDeposit(name, sum, term, percentage));//накопичувальний
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
            Main.email.send(e.toString());
        }
    }




}
