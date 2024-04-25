/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package eiffelv.csc413_assignment5;

import java.util.Random;

/**
 *
 * @author Eiffel
 */
interface BankAccount {

    void deposit(double amount);

    void withdraw(double amount);

    void transfer(double amount, BankAccount destination);
}

class SavingsAccount implements BankAccount {

    private double balance;
    private String accountNumber;
    private Random rand = new Random();

    public SavingsAccount() {
        this.balance = 0;
        int newNumber = rand.nextInt(1000);
        this.accountNumber = String.valueOf(newNumber);
    }

    public SavingsAccount(double balance) {
        this.balance = balance;
        int newNumber = rand.nextInt(1000);
        this.accountNumber = String.valueOf(newNumber);
    }

    public SavingsAccount(double balance, String accountNumber) {
        this.balance = balance;
        this.accountNumber = accountNumber;
    }

    public double getBalance() {
        return this.balance;
    }

    public String getAccountNumber() {
        return this.accountNumber;
    }

    @Override
    public void deposit(double amount) {
        balance += amount;
        System.out.println("Deposited: " + amount);
    }

    @Override
    public void withdraw(double amount) {
        if (balance >= amount) {
            balance -= amount;
            System.out.println("Withdrawn: " + amount);
        } else {
            System.out.println("Insufficient Funds!");
        }
    }

    @Override
    public void transfer(double amount, BankAccount destination) {
        if (balance >= amount) {
            balance -= amount;
            destination.deposit(amount);
            System.out.println("Transferred: " + amount);
        } else {
            System.out.println("Insufficient Funds!");
        }
    }
}

interface TransactionCommand {

    void execute();
}

class DepositCommand implements TransactionCommand {

    private final BankAccount account;
    private final double amount;

    public DepositCommand(BankAccount account, double amount) {
        this.account = account;
        this.amount = amount;
    }

    @Override
    public void execute() {
        account.deposit(amount);
    }
}

class WithdrawalCommand implements TransactionCommand {

    private final BankAccount account;
    private final double amount;

    public WithdrawalCommand(BankAccount account, double amount) {
        this.account = account;
        this.amount = amount;
    }

    @Override
    public void execute() {
        account.withdraw(amount);
    }
}

class TransferCommand implements TransactionCommand {

    private final BankAccount source;
    private final BankAccount destination;
    private final double amount;

    public TransferCommand(BankAccount source, BankAccount destination, double amount) {
        this.source = source;
        this.destination = destination;
        this.amount = amount;
    }

    @Override
    public void execute() {
        source.transfer(amount, destination);
    }
}
