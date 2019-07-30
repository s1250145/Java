// Exercise 6 - Problem 1
// ID: s1250145
// Name: Mizuho Yamaguchi

import java.util.*;

public class Warshal {
  int v;
  int[][] g;
  boolean[][] tc;
  Scanner sc = new Scanner(System.in);

  public static void main(String[] args) {
    Warshal obj = new Warshal();
    obj.solve();
    obj.out();
  }

  public Warshal() {
    System.out.print("Enter number of vertices\n> ");
    v = sc.nextInt();
    System.out.println("Enter matrix");
    g = new int[v][v];
    for(int i=0; i<v; i++) { for(int j=0; j<v; j++) g[i][j] = sc.nextInt(); }
  }

  // From Warshal's algorithm
  public void solve() {
    int v = g.length;
    tc = new boolean[v][v];

    for(int i=0; i<v; i++) {
      for(int j=0; j<v; j++) {
        if(g[i][j] != 0) tc[i][j] = true;
      }
      tc[i][i] = true;
    }

    for(int i=0; i<v; i++) {
      for(int j=0; j<v; j++) {
        if(tc[j][i]) {
          for(int k=0; k<v; k++) { if(tc[j][i] && tc[i][k]) tc[j][k] = true; }
        }
      }
    }
  }

  public void out() {
    System.out.println("Transitive closure:");
    System.out.print(" ");
    for(int i=0; i<v; i++) { System.out.print("  " + i); }

    System.out.println();

    for(int i=0; i<v; i++) {
      System.out.print(i + " ");
      for(int j=0; j<v; j++) {
        if(tc[i][j]) System.out.print(" * ");
        else System.out.print("   ");
      }
      System.out.println();
    }
  }
}
