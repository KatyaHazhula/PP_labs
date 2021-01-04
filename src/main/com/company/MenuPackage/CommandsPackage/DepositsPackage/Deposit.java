package main.com.company.MenuPackage.CommandsPackage.DepositsPackage;

public abstract class Deposit implements Comparable<Deposit>{
    protected String name;
    protected double sum;
    protected int term;
    protected double percentage;
    protected int sortBy;
    protected int dod=-1;



    public Deposit(String name, double sum, int term, double percentage) {
        this.name = name;
        this.term = term;
        this.percentage= percentage;
        this.sum = sum;
        sortBy = 1;
    }
    public void setDod(int dod){
        this.dod=dod;
    }
    public int getDod(){
        return dod;
    }
    public int getSortPriority() {
        return sortBy;
    }

    public void setSortPriority(int sortBy) {
        this.sortBy = sortBy;
    }

    public String getName() {
        return name;
    }

    public double getSum() {
        return sum;
    }
    public void setSum(double sum){
        this.sum=sum;
    }

    public double getPercentage() {
        return percentage;
    }
    public void setPercentage(double percentage){
        this.percentage=percentage;
    }

    public int getTerm() {
        return term;
    }
    public void setTerm(int term){
        this.term=term;
    }

    @Override
    public int compareTo(Deposit element) {
        switch (Math.abs(sortBy)) {
            case 1: {
                if(sortBy > 0) {
                    return name.compareTo(element.name);
                }
                else {
                    return name.compareTo(element.name) * -1;
                }

            }
            case 2: {
                if(sortBy > 0) {
                    return Double.compare(sum, element.sum);
                }
                else {
                    return Double.compare(sum, element.sum) * -1;
                }

            }
            case 3: {
                if(sortBy > 0) {
                    return Double.compare(percentage, element.percentage);
                }
                else {
                    return Double.compare(percentage, element.percentage) * -1;
                }

            }
            case 4: {
                if(sortBy > 0) {
                    return Integer.compare(term, element.term);
                }
                else {
                    return Integer.compare(term, element.term) * -1;
                }
            }
            default: {
                return 0;
            }
        }
    }//>0 якщо викликає об'єкт більше об'єкта, переданого в якості параметра;
    //<0, якщо викликає об'єкт менше об'єкта, переданого в якості параметра;
    //=0, якщо об'єкти рівні.

}
