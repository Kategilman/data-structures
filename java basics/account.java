public class account {

    //initial amount
    private double balance =0.0;
    public int pin;
    public int password;
    private String name;

    //first constructor knows how much/ an amount in the account
    public account(double balance){
        this.pin =123456;
        this.balance = balance;
        this.name = "kate";
    }
    //doesn't have an amount 
    public account(){
        this.balance = 10000;
        this.name = "kate";

}


public boolean withdraw(double amount){
    if( password != pin){
        return false;

    }
    if (amount > this.balance){
        return false;
    }
       else {
        balance -= amount;
       return true;
    }

}

public double getBalance(){
    System.out.println("Your current balance" + this.balance);
    return this.balance;

}
public String getName (){
    System.out.println("Your name is:" + this.name);
    return this.name;

}

public void deposit(double amount){
    this.balance += amount; 
}

public void setName(String newName) {
    System.out.println ("Your previous name was: " + this.name);

    this.name =newName;
    System.out.println ("Your current name is: " + this.name);
}

    //field balance
   // method to withdraw
    //method to deposit

    public static void main(String[] args){
        account new_account = new account (400.0);
       // new_account.withdraw(50.0, 123456);
        new_account.getBalance();
        new_account.setName("Kiki");
        new_account.getBalance();
        new_account.deposit(200); 
        System.out.println(new_account.balance);
    }
}

