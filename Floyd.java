import java.util.*;
import java.lang.*;
import java.io.*;

public class Floyd {
  final static int INF = 9999;
  final static int v = 8; // number of vertices
  int[][] distance = new int[v][v];

  public Floyd() {
    int[][] g = { {  0,  48, INF,   8,  20, INF,  20, INF},
                  {INF,   0,  24, INF,   9, INF,  76,  29},
                  { 97, INF,   0, INF, INF, INF,  18,   1},
                  {INF,  52,  34,   0,  29, INF, INF, INF},
                  {INF, INF, INF, INF,   0,  10, INF, INF},
                  {INF,  10,  85,  43, INF,   0,  41,  29},
                  {INF, INF, INF,  76,  38, INF,   0, INF},
                  { 28,  42, INF,  77,  21, INF,  11,   0}
                };

    for(int i=0; i<v; i++) {
      for(int j=0; j<v; j++) { distance[i][j] = g[i][j]; }
    }
  }

  public static void main(String[] args) {
    Floyd obj = new Floyd();
    obj.solve();
    obj.out();
  }

  public void solve() {
    for(int k=0; k<v; k++) {
      for(int i=0; i<v; i++) {
        for(int j=0; j<v; j++) {
          if(distance[i][k] + distance[k][j] < distance[i][j]) distance[i][j] = distance[i][k] + distance[k][j];
        }
      }
    }
  }

  public void out() {
    System.out.println("Result:");
    for(int i=0; i<v; i++) {
      for(int j=0; j<v; j++) {
        if(distance[i][j] == INF) System.out.print("INF ");
        else System.out.print(distance[i][j] + "  ");
      }
      System.out.println();
    }
  }
}
