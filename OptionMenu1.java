package com.company;

import javax.swing.*;
import java.io.IOException;
import java.security.KeyStore;
import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

 class Account1 {

     /*     decleyar the variable         */

     private int customerNumber;
    private int pinNumber;
    private double checkingBalance = 0;
    private double savingBalance = 0;

    /*          input the user         */

    Scanner input = new Scanner(System.in);
    DecimalFormat moneyformat = new DecimalFormat("'$'###,##0.00");

    // set the custumer number
    public int setCustomerNumber(int customerNumber) {
        this.customerNumber = customerNumber;
        return customerNumber;
    }

    //   return the customer number
    public int getCustomerNumber() {return customerNumber;}

     // set pin number
    public int setPinNumber(int pinNumber) {
        this.pinNumber = pinNumber;
        return pinNumber;
    }
     //  return pin number
    public int getPinNumber() {return pinNumber;}
    // return checking balance
    public double getCheckingBalance() {
        return checkingBalance;
    }
    //  return saving balance
    public double getSavingBalance() {
        return savingBalance;
    }
       // return calc checking withdraw
    public double calcCheckingWithdraw(double amount) {
        checkingBalance = (checkingBalance - amount);
        return checkingBalance;
    }
     // return calc saving withdraw
    public double calcSavingWithdraw(double amount) {
        savingBalance = (savingBalance - amount);
        return savingBalance;
    }
     // return calc checking deposit
    public double calcCheckingDeposit(double amount) {
        checkingBalance = (checkingBalance + amount);
        return checkingBalance;
    }
     // return calc saving deposit
    public double calcSavingDeposit(double amount) {
        savingBalance = (savingBalance + amount);
        return savingBalance;
    }
       // return the chechking withdraw input
    public void getCheckingWithdrawInput() {
        System.out.println("Checking Account Balance: " + moneyformat.format(checkingBalance));
        System.out.println("Amount you want to withdraw from Checking Amount: ");
        double amount = input.nextDouble();

        if ((checkingBalance - amount) >= 0) {
            calcCheckingWithdraw(amount);
            System.out.println("new checkig amount balance: " + moneyformat.format(checkingBalance));
        } else {
            System.out.println("Balance cannot be negative." + "\n");
        }
    }
     // return the saving  withdraw input
    public void getSavingWithdrawInput() {
        System.out.println("Saving Account Balance: " + moneyformat.format(savingBalance));
        System.out.println("Amount you want to withdraw from Saving Amount: ");
        double amount = input.nextDouble();

        if ((savingBalance - amount) >= 0) {
            calcSavingWithdraw(amount);
            System.out.println("new Saving amount balance: " + savingBalance + "\n");
        } else {
            System.out.println("Balance cannot be negative." + "\n");
        }
    }
     // return the chechking deposit input
    public void getCheckingDepositInput() {
        System.out.println("Checking Account Balance: " + moneyformat.format(checkingBalance));
        System.out.println("Amount you want to deposit from Checking Amount: ");
        double amount = input.nextDouble();

        if ((checkingBalance + amount) >= 0) {
            calcCheckingDeposit(amount);
            System.out.println("new checkig amount balance: " + moneyformat.format(checkingBalance));
        } else {
            System.out.println("Balance cannot be negative." + "\n");
        }
    }
     // return the saving  deposit input
    public void getSavingDepositInput() {
        System.out.println("Saving Account Balance: " + moneyformat.format(savingBalance));
        System.out.println("Amount you want to deposit from Saving Amount: ");
        double amount = input.nextDouble();

        if ((savingBalance + amount) >= 0) {
            calcSavingDeposit(amount);
            System.out.println("new Saving amount balance: " + moneyformat.format(savingBalance));
        } else {
            System.out.println("Balance cannot be negative." + "\n");
        }
    }
}
// extends class
public class OptionMenu1 extends Account1 {
    int selection;
    Scanner menuInput = new Scanner(System.in);
    DecimalFormat moneyFormat = new DecimalFormat("'$'###,##0.00");
    HashMap<Integer, Integer> data = new HashMap<Integer, Integer>();

    /*    customer number and pin number     */

    public void getLogin() throws IOException {
        int x = 1;
        do {
            try {
                data.put(89898990, 8990);
                data.put(89898991, 8991);
                data.put(89898992, 8992);
                data.put(89898993, 8993);
                data.put(89898994, 8994);
                data.put(89898995, 8995);
                data.put(89898996, 8996);
                data.put(89898997, 8997);
                data.put(89898998, 8998);
                data.put(89898999, 8999);
                System.out.println("Welcome to the ATM Project");
                System.out.print("enter your customer number: ");
                setCustomerNumber(menuInput.nextInt());

                System.out.print("enter your pin number: ");
                setPinNumber(menuInput.nextInt());
            } catch (Exception e) {
                System.out.println("\n" + "Invalid character(s). Only number." + "\n");
                x = 2;
            }
            for (Map.Entry<Integer, Integer> entry : data.entrySet()) {
                if (entry.getKey() == getCustomerNumber() && entry.getValue() == getPinNumber()) {
                    getAccountType();
                }
            }
            System.out.println("\n" + "worng number and pin number." + "\n");
        }
        while (x == 1);
    }

    public void getAccountType() {
        System.out.println("select the Account you want to access;");
        System.out.println("type 1 - Checking Account");
        System.out.println("type 2 - Saving Account");
        System.out.println("type 3 - Exit");
        System.out.println("Choice: ");

        //select the number of switch case
        selection = menuInput.nextInt();

        switch (selection) {
            case 1:
                getChecking();
                break;
            case 2:
                getSaving();
                break;
            case 3:
                System.out.println("thank tou for using this ATM, bye");
                break;
            default:
                System.out.println("\n" + "Invalid Choice." + "\n");
                getAccountType();
        }
    }

    public void getChecking() {
        System.out.println("Checking Account: ");
        System.out.println("Type 1 - View Balance");
        System.out.println("Type 2 - Withdrow Fund");
        System.out.println("Type 3 - Deposit Fund");
        System.out.println("Type 4 - Exit");
        System.out.print("Choice: ");
        selection = menuInput.nextInt();
        switch (selection) {
            case 1:
                System.out.println("Checking Account Balance: " + moneyFormat.format(getCheckingBalance()));
                getAccountType();
                break;
            case 2:
                getCheckingWithdrawInput();
                getAccountType();
                break;
            case 3:
                getCheckingDepositInput();
                getAccountType();
                break;
            case 4:
                System.out.println("thank you for using this atm , bye");
                break;
            default:
                System.out.println("\n" + "invalid choice." + "\n");
                getChecking();
        }
    }

    public void getSaving() {
        System.out.println("saving Account: ");
        System.out.println("Type 1 - view Balance");
        System.out.println("Type 2 - withdraw Fund");
        System.out.println("Type 3 - Deposit Fund");
        System.out.println("type 4 - Exit");

        selection = menuInput.nextInt();
        switch (selection) {
            case 1:
                System.out.println("Saving Account Balance: " + moneyFormat.format(getSavingBalance()));
                getAccountType();
                break;
            case 2:
                getSavingWithdrawInput();
                getAccountType();
                break;
            case 3:
                getSavingDepositInput();
                getAccountType();
                break;
            case 4:
                System.out.println("thank you for using this atm , bye.");
                break;
            default:
                System.out.println("\n" + "Invalid choice." + "\n");
        }
    }
    public class ATM_project1 extends OptionMenu1 {
        public static void main(String[] args) throws IOException {
            OptionMenu1 obj = new OptionMenu1();
            obj.getLogin();
        }
    }
    }