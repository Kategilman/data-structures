public class ConceptTester{

	
	public static void main(String[] args) {
		Account a = new Account("Joni", 100000);
		Account b = new Account();
        Account c = new Account();
        Account d = new Account();
        Account e = new Account();
        Account f = new Account();
        Account g = new Account();
        Account h = new Account();
        Account i = new Account();

		Random balanceGenerator = new Random(); 
        int someMoney = balanceGenerator.nextInt(10001); 
		a.setBalance(50);
		
		boolean result = b.withdraw(1000000);
		
		if(result) {
			System.out.println("I'm rich now");
		}
		else {
			System.out.println("Ooooohhh, not yet");
		}
	}
}