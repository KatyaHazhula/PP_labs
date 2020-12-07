package com.company.MenuPackage.CommandsPackage.DepositOperationsPackage;

import com.company.MenuPackage.CommandsPackage.Command;
import com.company.MenuPackage.CommandsPackage.DepositsPackage.Deposit;
import com.company.MenuPackage.Menu.Client;

import java.util.ArrayList;
import java.util.Scanner;

public class DepositOperations {
        private Command depositEarlyWithdrawal;
        private Command depositReplenishment;


        private Scanner in = new Scanner(System.in);
        private Client client = new Client();

        public void openOperations(ArrayList<Deposit> deposits, DepositOperations depositOperations) {
            depositEarlyWithdrawal = new DepositEarlyWithdrawal(deposits, depositOperations);
            depositReplenishment = new DepositReplenishment(deposits, depositOperations);
            System.out.println("\n -------- Deposit Operations ------- *");
            System.out.println(" 1. Withdraw the deposit ahead of time *");
            System.out.println(" 2. Replenish the deposit              *");
            System.out.println(" 3. Return to menu                     *");


            System.out.print(" Choose number => ");
            int choice;

            try {
                choice = in.nextInt();
            }
            catch (java.util.InputMismatchException e) {
                choice = 0;
                in.next();
            }
            MakeChoice(choice);
        }
        private void MakeChoice(int choice) {
            switch (choice) {
                case 1: {
                    client.setCommand(depositEarlyWithdrawal);
                    break;
                }
                case 2: {
                    client.setCommand(depositReplenishment);
                    break;
                }
                case 3: {
                    return;
                }
                default: {
                    System.out.println("Wrong number!");
                }
            }

            client.commandExecute();
        }


}
