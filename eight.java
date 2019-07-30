/*
アルゴリズムとデータ構造１
*/

import java.util.*;
import java.io.*;

class eight{
  static int A[] = new int[2000000];
  static int H = 0;
  public static void main(String args[])throws Exception{
    Scanner sc = new Scanner(System.in);
    int max,max2;
    for(int i = 0; i<500000; i++){
      int n = sc.nextInt();
      insert(n);
    }
    while(H>3){
      max = heapExtractMax(A);
      max2 = heapExtractMax(A);
      insert((max+max2)%1000000000);
    }
    System.out.println(heapExtractMax(A)+" "+heapExtractMax(A)+" "+heapExtractMax(A));
  }
  static void insert(int key){
    H++;
    A[H] = (int)Double.NEGATIVE_INFINITY;
    heapIncreaseKey(A, H, key);
  }

  static void heapIncreaseKey(int A[], int i, int key){
    int tmp = 0;
    if(key<A[i]){
      return;
    }
    A[i] = key;
    while(i >1 && A[parent(i)]< A[i]){
      tmp = A[i];
      A[i] = A[parent(i)];
      A[parent(i)] = tmp;
      i = parent(i);
    }
  }

  static int heapExtractMax(int A[]){
    if(H<1){
      System.out.println("under flow");
      return (int)Double.NEGATIVE_INFINITY;
    }
    int max = A[1];
    A[1] = A[H--];
    maxHeapify(A, 1);

    return max;
  }

  static void maxHeapify(int A[], int i ){
    int l =i*2;
    int r = i*2+1;
    int largest = 0;
    int tmp;

    if(l<=H && A[l] > A[i]) largest = l;
    else largest = i;

    if(r<=H && A[r] > A[largest] ) largest = r;

    if(largest != i){
      tmp = A[i];
      A[i] = A[largest];
      A[largest] = tmp;
      maxHeapify(A, largest);
    }
  }
  static int parent(int i){
    return i/2;
  }

}
