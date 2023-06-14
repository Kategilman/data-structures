public class accountclass {
        protected int balance;
        private String name;
    
        // default constructor
        public accountclass(){
            this.balance = 0;
            this.name = "default";
        }
    
        public accountclass(String name, int balance){
            this.balance = balance;
            this.name = name;
        }
        
        public int getBalance(){
            return balance;
        }
    
        public void setBalance(int balance){
            this.balance = balance;
        }
    
        public String getName(){
            return this.name;
        }
    
        public void setName(String name){
            this.name = name;
        }
    
        public boolean withdraw(int amount){
            if(this.balance< amount){
                return false;
            }else{
                this.balance-= amount;
                return true;
            }
    
        }
        public static void main (String [] args){
            accountclass myAccount = new accountclass ("Joni",100);
            System.out.println(myAccount.name);
            System.out.println(myAccount.balance);
        }
    }
