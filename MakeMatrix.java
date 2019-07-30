import java.util.*;

public class MakeMatrix {
  public static void main(String[] args) {
    int n = 64;
    int[][] matrixA = new int[n][n];
    int[][] matrixB = new int[n][n];
    System.out.println(n);
    for(int i=0; i<n; i++) {
      for(int j=0; j<n; j++) {
        matrixA[i][j] = (int)(Math.random()*10);
        System.out.print(matrixA[i][j] + " ");
      }
      System.out.println();
    }

    for(int i=0; i<n; i++) {
      for(int j=0; j<n; j++) {
        matrixB[i][j] = (int)(Math.random()*10);
        System.out.print(matrixB[i][j] + " ");
      }
      System.out.println();
    }
  }
}
