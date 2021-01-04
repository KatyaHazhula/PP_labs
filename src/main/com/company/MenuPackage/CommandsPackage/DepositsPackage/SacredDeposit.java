package main.com.company.MenuPackage.CommandsPackage.DepositsPackage;

public class SacredDeposit extends Deposit{
    public SacredDeposit (String name, double sum, int term, double percentage) {
        super(name, sum, term, percentage);
    }

    public SacredDeposit (Deposit deposit, int term, double sum) {
        super(deposit.name, sum, term, deposit.percentage);
    }
}
