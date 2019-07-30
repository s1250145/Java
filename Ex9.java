// https://github.com/munif/paa-2/blob/master/161702/presentation/07%20-%20Dynamic%20Programming%204/Matrix%20Chain%20Multi.cpp
// https://sites.google.com/site/ahmednausheen/assignment-1
import java.util.*;

public class Ex9 {
  final static int INF = Integer.MAX_VALUE;
  public static void main(String[] args) {
    Ex9 ex = new Ex9();
  }

  public Ex9() {
    Scanner sc = new Scanner(System.in);
    System.out.print("Input size of r > ");
    int n = sc.nextInt();
    int[] r = new int[n];
    System.out.print("Input list of matrices dimensions > ");
    for(int i=0; i<n; i++) r[i] = sc.nextInt();
    matrix_chain_order(r);
  }

  public void matrix_chain_order(int[] r) {
    int n = r.length - 1;
    int[][] m = new int[n+1][n+1];
    int[][] s = new int[n+1][n+1];

    for(int i=1; i<=n; i++) m[i][i] = 0;

    for(int l=2; l<=n; l++) {
      for(int i=1; i<=n-l+1; i++) {
        int j = i + l - 1;
        m[i][j] = INF;
        for(int k=i; k<=j-1; k++) {
          int q = m[i][k] + m[k+1][j] + r[i-1]*r[k]*r[j];
          if(q < m[i][j]) {
            m[i][j] = q;
            s[i][j] = k;
          }
        }
      }
    }

    print_optimal_parens(s, 1, n);
    System.out.println();
  }

  public void print_optimal_parens(int[][] s, int i, int j) {
    if(i == j) {
      System.out.print("A" + i);
    } else {
      System.out.print("(");
      print_optimal_parens(s, i, s[i][j]);
      print_optimal_parens(s, s[i][j] + 1, j);
      System.out.print(")");
    }
  }
}
