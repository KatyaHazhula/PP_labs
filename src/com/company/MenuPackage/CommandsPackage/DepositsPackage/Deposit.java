package com.company.MenuPackage.CommandsPackage.DepositsPackage;

public class Deposit {
    protected String name;
    protected double sum;
    protected int term;
    protected double percentage;
    protected int sortBy;


    public Deposit(String name, double sum, int term, double percentage) {
        this.name = name;
        this.term = term;
        this.percentage= percentage;
        this.sum = sum;
        sortBy = 1;
    }
    public String getName() {
        return name;
    }

    public double getSum() {
        return sum;
    }

    public double getPercentage() {
        return percentage;
    }

    public int getTerm() {
        return term;
    }


}
