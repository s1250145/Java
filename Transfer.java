public class Transfer {
	public Transfer(Bank bank, int from, int max_amount) {
		bank_ = bank;
		from_ = from;
		max_ = max_amount;
	}

	void solve() {
		int amount = (int)((max_+1)*Math.random()); // 送金額(random)
		int num = bank_.getNumberAccounts(); // 銀行の数
		int to = (int)((num)*Math.random()); // 送金先
		// 送金処理
		bank_.transfer(from_, to, amount);
	}

	private Bank bank_;
	private int from_;
	private int max_;
}
