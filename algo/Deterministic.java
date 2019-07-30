import java.util.*;

public class Deterministic {
	public static void main(String[] args) {
		int N = 100;
		Deterministic d = new Deterministic();
		System.out.println("N = " + N + ", 100 times average: " + d.time_avg(N) + "ms");
	}

	public double time_avg(int N) {
		int sum = 0;
		for(int i=0; i<100; i++) {
			ArrayList<Integer> S = rand(N); // Generate N random numbers.
			long s = System.currentTimeMillis();
			determin_sort(S);
			long e = System.currentTimeMillis();
			sum += (e - s);
		}
		return (double)sum / 100;
	}

	// Deterministic quicksort
	public void determin_sort(ArrayList<Integer> S) {
		if(S.size() == 0) return;
		int a_i = S.get(0);
		ArrayList<Integer> T = new ArrayList<Integer>(); // S-
		ArrayList<Integer> U = new ArrayList<Integer>(); // S+
		for(int i=0; i<S.size(); i++) {
			if(S.get(i) < a_i) T.add(S.get(i));
			if(S.get(i) > a_i) U.add(S.get(i));
		}
		determin_sort(T);
		determin_sort(U);
	}

	public ArrayList<Integer> rand(int N) {
		int x = 1;
		final int A = 48271;
		final int M = 2147483647;
		int Q = M / A;
		int R = M % A;

		ArrayList<Integer> seq = new ArrayList<Integer>();

		for(int i=1; i<=N; i++) {
			x = A * (x % Q) - R * (x / Q);
			if(x < 0) x += M;

			seq.add(x);
		}

		return seq;
	}
}
