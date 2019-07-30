import java.util.*;

public class Ex3 {
  Scanner sc = new Scanner(System.in);
  final int WHITE = 0;
  final int BLACK = 1;
  final int GRAY = -1;

  int time;

  // number of node is 6.
  int[][] list = new int[6][6];
  int[] discover = new int[6];
  int[] finish = new int[6];
  int[] color = new int[6];

  public Ex3() {
    for(int i=0; i<6; i++) {
      int u = sc.nextInt(); // ID of the vertex
      int k = sc.nextInt(); // denotes its degree
      while(k > 0) {
        int v = sc.nextInt(); // IDs of vertices adjacent to u
        list[u-1][v-1] = 1;
        k--;
      }
    }
    sc.close();
  }

  // From pseudo code
  public void dfs() {
    for(int i=0; i<6; i++) color[i] = WHITE;
    time = 0;
    for(int i=0; i<6; i++) if(color[i] == WHITE) dfs_visit(i);
  }

  // From pseudo code
  public void dfs_visit(int u) {
    color[u] = GRAY;
    discover[u] = ++time;
    for(int i=0; i<6; i++) { if(color[i] == WHITE && list[u][i]==1) dfs_visit(i); }
    color[u] = BLACK;
    finish[u] = ++time;
  }

  public void output() {
    for(int i=0; i<6; i++) System.out.println(i+1+": dis: "+discover[i]+" fin: "+finish[i]);
  }

  public static void main(String[] args) {
    Ex3 obj = new Ex3();
    obj.dfs();
    obj.output();
  }
}
