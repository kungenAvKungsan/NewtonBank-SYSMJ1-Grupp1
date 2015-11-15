package BankAccount;

import javax.swing.*;
import java.awt.*;
import java.util.Random;

public class SavingsAccount
{
    private double balance;
    private double rate;
    private int accountNr;
    private String description;

    public SavingsAccount(double balance, double rate, int accountNr, String description)
    {
        this.accountNr = accountNr;
        setBalance(balance);
        setRate(rate);
        setDescription(description);
    }

    public void setBalance(double balance)
    {
        this.balance = balance;
    }
    public void setRate(double rate)
    {
        this.rate = rate;
    }
    public void setDescription(String desc)
    {
        this.description = desc;
    }

    public int getAccountNr()
    {
        return accountNr;
    }
    public String getAccountName()
    {
        return description;
    }
    public double getRate()
    {
        return rate;
    }
    public double getBalance()
    {
        return balance;
    }

    public void deposit(double amount) {
        balance += amount;
    }

    public boolean withdraw(double amount) {
        if (balance > amount) {
            balance -= amount;
            return true;
        }
        return false;
    }

    public double getBalanceInclusiveRate() {
        return balance * (rate / 100);
    }

    public String toString()
    {
        return getBalance() + " " + getRate() + " " + getAccountNr() + " " + getAccountName();
    }
}
