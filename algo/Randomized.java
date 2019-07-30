import java.util.*;

public class Randomized {
	public static void main(String[] args) {
		int N = 1000000;
		Randomized r = new Randomized();
		System.out.println("N = " + N + ", 100 times average: " + r.time_avg(N) + "ms");
	}

	public double time_avg(int N) {
		int sum = 0;
		for(int i=0; i<100; i++) {
			ArrayList<Integer> S = rand(N); // Generate N random numbers.
			long s = System.currentTimeMillis();
			randam_quick(S);
			long e = System.currentTimeMillis();
			sum += (e - s);
		}
		return (double)sum/100;
	}

	public void randam_quick(ArrayList<Integer> S) {
		if(S.size() == 0) return;
		int idx = (int)(Math.random()*S.size());
		int a_i = S.get(idx);
		ArrayList<Integer> T = new ArrayList<Integer>(); // S-
		ArrayList<Integer> U = new ArrayList<Integer>(); // S+
		for(int i=0; i<S.size(); i++) {
			if(S.get(i) < a_i) T.add(S.get(i));
			if(S.get(i) > a_i) U.add(S.get(i));
		}
		randam_quick(T);
		randam_quick(U);
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
