// Exercise 11 - Problem2(a)
// This code is for Problem2(a) and Problem2(b)

import java.util.*;

public class Rand2 {
	int[] arr = new int[10]; // For Problem2-(b) : Count number.
	final static int n = 1000000; // Value of N.

	public static void main(String[] args) {
		Rand2 r = new Rand2();
		ArrayList<Integer> answer = r.rand2(n);
		r.display();
	}

	public void display() {
		for(int num : arr) System.out.print(num*100/n + "% ");
		System.out.println();
	}

	public ArrayList<Integer> rand2(int n) {
		int x = 1;
		final int A = 48271;
		final int M = 2147483647;
		int Q = M / A;
		int R = M % A;

		ArrayList<Integer> seq = new ArrayList<Integer>();

		for(int i=1; i<=n; i++) {
			x = A * (x % Q) - R * (x / Q);
			if(x < 0) x += M;

			seq.add(x);
			count(x);
		}

		// For Problem2-(a) : Output random number.
		// for(int i=0; i<n; i++) System.out.print(seq.get(i) + " ");
		// System.out.println();

		return seq;
	}

	public void count(int x) {
		double r = (double)x / 2147483647;
		if(0.0 <= r && r < 0.1) arr[0]++;
		else if(0.1 <= r && r < 0.2) arr[1]++;
		else if(0.2 <= r && r < 0.3) arr[2]++;
		else if(0.3 <= r && r < 0.4) arr[3]++;
		else if(0.4 <= r && r < 0.5) arr[4]++;
		else if(0.5 <= r && r < 0.6) arr[5]++;
		else if(0.6 <= r && r < 0.7) arr[6]++;
		else if(0.7 <= r && r < 0.8) arr[7]++;
		else if(0.8 <= r && r < 0.9) arr[8]++;
		else if(0.9 <= r && r < 1.0) arr[9]++;
	}
}
