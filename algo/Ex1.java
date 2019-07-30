// Algorythm and Data Structure 2
// Ex1
// MergeSort
import java.util.*;

public class Ex1 {
  Scanner sc = new Scanner(System.in);
  ArrayList<Integer> A = new ArrayList<Integer>();
  ArrayList<Integer> answer;

  public void init() {
    int n = sc.nextInt(); // Size of A[]
    for(int i=0; i<n; i++) A.add(sc.nextInt());
  }

  public void output() {
    answer = mergeSort(A);
    for(int num : answer) System.out.print(num + " ");
    System.out.print("\n");
  }

  // From Pseudo-code
  public ArrayList<Integer> mergeSort(ArrayList<Integer> A) {
    int middle = A.size() / 2;
    ArrayList<Integer> left = new ArrayList<Integer>();
    ArrayList<Integer> love = new ArrayList<Integer>();
    ArrayList<Integer> right = new ArrayList<Integer>();
    ArrayList<Integer> tune = new ArrayList<Integer>();
    if(A.size() != 1) {
      left.clear();
      right.clear();
      for(int i=0; i<middle; i++) left.add(A.get(i));
      for(int i=middle; i<A.size(); i++) right.add(A.get(i));
      love = mergeSort(left);
      tune = mergeSort(right);
      return merge(love, tune);
    } else {
      return A;
    }
  }

  public ArrayList<Integer> merge(ArrayList<Integer> A, ArrayList<Integer> B) {
    ArrayList<Integer> result = new ArrayList<Integer>();
    while(A.size() > 0 || B.size() > 0) {
      if(A.size() > 0 && B.size() > 0) {
        if(A.get(0) <= B.get(0)) {
          result.add(A.get(0));
          A.remove(0);
        } else {
          result.add(B.get(0));
          B.remove(0);
        }
      } else if(A.size() > 0) {
        result.add(A.get(0));
        A.remove(0);
      } else if(B.size() > 0) {
        result.add(B.get(0));
        B.remove(0);
      }
    }
    return result;
  }

  public static void main(String[] args) {
    Ex1 obj = new Ex1();
    obj.init();
    obj.output();
  }
}
