package main.com.company.MenuPackage.CommandsPackage.DepositsPackage;

public class AccumulateDeposit extends Deposit{
    public AccumulateDeposit (String name, double sum, int term, double percentage) {
        super(name, sum, term, percentage);
    }

    public AccumulateDeposit (Deposit deposit, int term, double sum) {
        super(deposit.name, sum, term, deposit.percentage);
    }
}
