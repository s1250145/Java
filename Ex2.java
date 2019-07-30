import java.util.*;

public class Ex2 {

  int[] A;

  public static void main(String[] args) {
    Ex2 obj = new Ex2();
    obj.output();
  }

  public Ex2() {
    // Input
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    A = new int[n];
    for(int i = 0; i<n; i++) A[i] = sc.nextInt();
  }

  public void heapBottomUp(int[] A) {
    int heap_size = A.length;
    for(int i = A[heap_size/2-1]; i>=0; i--) maxHeapify(A, i);
  }

  public void maxHeapify(int[] A, int i) {
    int left = 2 * i;
    int right = 2 * i + 1;
    int largest;

    if(left < A.length && A[left] > A[i]) largest = left;
    else largest = i;

    if(right < A.length && A[right] > A[largest]) largest = right;

    if(largest != i) {
      // swap(A[i], A[largest])
      int swap = A[i];
      A[i] = A[largest];
      A[largest] = swap;
      maxHeapify(A, largest);
    }
  }

  public void output() {
    heapBottomUp(A);
    for(int n : A) System.out.print(n + " ");
    System.out.println();
  }
}
