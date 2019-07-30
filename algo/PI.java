// Exercise 12 - problem1

import java.util.*;

public class PI {
	public static void main(String[] args) {
		PI r = new PI();
		int N = 100000;
		// Calculate  π using your program 10 times using N number.
		System.out.println("N = " + N);
		for(int i=0; i<10; i++) System.out.print(r.pi(N) + " ");
		System.out.println();
	}

	public double pi(int N) {
		int inCircle = 0;

		for(int i=0; i<N; i++) {
			double x = Math.random();
			double y = Math.random();
			double x_pow = Math.pow((x - 0.5), 2);
			double y_pow = Math.pow((y - 0.5), 2);
			double d = x_pow + y_pow;
			if(d < 0.25) inCircle++;
		}

		return 4 * (double)inCircle / N;
	}
}
