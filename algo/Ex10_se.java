import java.util.*;

public class Ex10_se {
  public static void main(String[] args) {
		Ex10_se obj = new Ex10_se();
	}

	Scanner sc = new Scanner(System.in);
	final int N = 8;
	//matrix
	int[] row = new int[N];
	boolean[] col = new boolean[N];
	boolean[] dpos = new boolean[2*N-1];
	boolean[] dneg = new boolean[2*N-1];
	//input
	int k, r, c;

	public Ex10() {
		Arrays.fill(row, -1);
		k = sc.nextInt();
		for(int i=0; i<k; i++) {
			r = sc.nextInt();
			c = sc.nextInt();
			row[r] = c;
			col[c] = dpos[r+c] = dneg[r-c+N-1] = true;
		}
    // Solve 8-queen problem and output result.
		putQueen(0);
	}

	public void putQueen(int i) {
		if(i == N) {
			output();
			return;
		}
		if(row[i] != -1) putQueen(i+1);

		for(int j=0; j<N; j++) {
			if(row[i] !=-1 || col[j] || dpos[i+j] || dneg[i-j+N-1]) continue;
			row[i] = j;
			col[j] = dpos[i+j] = dneg[i-j+N-1] = true;
			putQueen(i+1);
			row[i] = -1;
			col[j] = dpos[i+j] = dneg[i-j+N-1] = false;
		}
	}

	public void output() {
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				if(row[i] == j) System.out.print("Q");
        else System.out.print(".");
			}
			System.out.println();
		}
	}
}
