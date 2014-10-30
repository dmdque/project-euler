import java.io.*;
import java.util.*;
import java.lang.Math;
import java.lang.StringBuilder;

public class P2 {

  public static int modifiedFibb(int n) {
    if(n == 1) return 0;
    if(n == 2) return 2;
    int last = 2;
    int secondLast = 1;
    int sum = 0;
    for(int i = 2; i <= n && last < 4000000; i++) {
      if(i % 2 == 0) {
        sum += last;
      }
      int temp = last;
      last = last + secondLast;
      secondLast = temp;
    }
    return sum;
  }

  public static int[] fibb2(int n) {
    int[] fibs = new int[n];
    fibs[0] = 1;
    fibs[1] = 2;
    if(n == 1) return fibs;
    if(n == 2) return fibs;
    int last = 2;
    int secondLast = 1;
    for(int i = 2; i < n; i++) {
      int temp = last;
      last = last + secondLast;
      secondLast = temp;
      fibs[i] = last;
    }
    return fibs;
  }

  public static int fibb(int n) {
    if(n == 1) return 1;
    if(n == 2) return 2;
    int last = 2;
    int secondLast = 1;
    for(int i = 2; i < n; i++) {
      int temp = last;
      last = last + secondLast;
      secondLast = temp;
    }
    return last;
  }

  public static void main(String[] args) throws Exception {
    int answer = 0;
    for(int i = 1; i <= 32; i++) {
      answer = modifiedFibb(i);
      //answer = fibb(i);
      System.out.println(i + ": " + answer);
    }
    //for(int i = 1; answer < 4000000; i++) {
      ////answer = modifiedFibb(i);
      //answer = fibb(i);
      //System.out.println(i + ": " + answer);
    //}
    answer = modifiedFibb(32);
    System.out.println(answer);

    int[] fibs = fibb2(32);
    int sum = 0;
    for(int i = 0; i < fibs.length; i++) {
      if(fibs[i] % 2 == 0) {
        sum += fibs[i];
      }
      System.out.println(i + 1 + ": " + fibs[i]);
    }
    System.out.println("answer: " + sum);
  }

}


