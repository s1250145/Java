public class BankTest {
	public static final int N_ACCOUNTS = 5;
	public static final int INIT_BALANCE = 1000;
	// N_ACCOUNTS個の転送スレッド

	public static void main(String args[]) {
		Bank bank = new Bank(N_ACCOUNTS, INIT_BALANCE);
		try {
			for(;;) {
				int from = (int)((N_ACCOUNTS)*Math.random());
				Transfer work = new Transfer(bank, from, 10000);
				work.solve();
				Thread.sleep(1000);
			}
		} catch(InterruptedException e) {
			
		}
	}
}
