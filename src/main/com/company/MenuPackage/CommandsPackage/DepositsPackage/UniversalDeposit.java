package main.com.company.MenuPackage.CommandsPackage.DepositsPackage;

public class UniversalDeposit extends Deposit{
    public UniversalDeposit (String name, double sum, int term, double percentage) {
        super(name, sum, term, percentage);
    }

    public UniversalDeposit (Deposit deposit, int term, double sum) {
        super(deposit.name, sum, term, deposit.percentage);
    }
}
