// Exercise 11 - Problem2(a)
// This code is for Problem2(a)

import java.util.*;

public class Rand3 {
	static int[] arr = new int[10]; // 0 to 9
	final static int n = 1000000; // Value of N.

	public static void main(String[] args) {
		Rand3 r = new Rand3();
		r.rand3();
		for(int num : arr) System.out.print(num*100/n + "% ");
		System.out.println();
	}

	public void rand3() {
		int x = 1;
		int next = 0;
		Rand2 r = new Rand2();
		ArrayList<Integer> A = r.rand2(55);
		ArrayList<Integer> seq = new ArrayList<Integer>();

		for(int i=0; i<n; i++) {
			int j = (next + 31) % 55;
			x = A.get(j) - A.get(next);

			if(x < 0) {
				x += 2147483647;
				x++;
			}

			A.set(next, x);
			next = (next + 1) % 55;

			count(x);
			seq.add(x);
		}

		// For Problem2-(a) : Output random number.
		// for(int i=0; i<n; i++) System.out.print(seq.get(i) + " ");
		// System.out.println();
	}

	public void count(int x) {
		double r = (double)x / 2147483647;
		//System.out.printf("%.3f\n",r);
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
