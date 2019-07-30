// Exercise 4 - Problem 2
// Using Kruskal's algorithm to create MST (Minimum Spanning Tree).

import java.util.*;

public class Ex4 {
  class Road {
    int start, goal, weight;

    Road(int start, int goal, int weight) {
      this.start = start;
      this.goal = goal;
      this.weight = weight;
    }
  }

  class Graph {
    int n; // number of node
    ArrayList<Road> roads = new ArrayList<>();

    Graph(int n) {
      this.n = n;
    }

    public void addRoad(int start, int goal, int weight) {
      Road road = new Road(start, goal, weight);
      roads.add(road);
    }
  }

  public static void main(String[] args) {
    Ex4 obj = new Ex4();
    obj.process();
    obj.output();
  }

  ArrayList<Road> mst = new ArrayList<Road>(); // MST
  PriorityQueue<Road> w; // weight matrix
  int [] parent = new int[8]; // 1 to 7

  public Ex4() {
    w = new PriorityQueue<Road>(7, Comparator.comparingInt(o -> o.weight));
    Graph g = new Graph(7); // number of node is 7.

    g.addRoad(1, 4, 5);
    g.addRoad(1, 2, 7);
    g.addRoad(2, 3, 8);
    g.addRoad(2, 4, 9);
    g.addRoad(2, 5, 7);
    g.addRoad(3, 5, 5);
    g.addRoad(4, 5, 15);
    g.addRoad(4, 6, 6);
    g.addRoad(5, 6, 8);
    g.addRoad(5, 7, 9);
    g.addRoad(6, 7, 11);

    for(int i=0; i<g.roads.size(); i++) w.add(g.roads.get(i));

    make_set(parent);
  }

  public void process() {
    int idx = 0;
    while(idx < 6) {
      Road road = w.poll();
      int u = find(parent, road.start);
      int v = find(parent, road.goal);

      if(u != v) {
        mst.add(road);
        union(parent, u, v);
        idx++;
      }
    }
  }

  public void output() {
    System.out.println("MST");
    for(int i=0; i<mst.size(); i++) {
      Road road = mst.get(i);
      System.out.println("start: " + road.start + ", goal: " + road.goal
      + ", weight: " + road.weight);
    }
  }

  public void make_set(int[] parent) {
    for(int i=1; i<8; i++) parent[i] = i;
  }

  public int find(int[] p, int v) {
    if(p[v] != v) return find(p, p[v]);
    return v;
  }

  public void union(int[] p, int u, int v) {
    int _u = find(p, u);
    int _v = find(p, v);
    parent[_v] = _u;
  }
}
