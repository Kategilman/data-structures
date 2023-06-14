public class InvestmentAccount extends accountclass {
    //public private

    private double interestRate = 1.5;
    public InvestmentAccount() {
        super();
    }
    public InvestmentAccount(String name, int balance) {
        this.name = name;
        this.balance = balance;
    }
    void applyInterest() {
        this.balance += this.balance * (1 + InterestRate/100);
    }
    @Override
    public boolean withdraw(int amount){
        return false;
    }
}