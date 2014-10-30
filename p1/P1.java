import java.io.*;
import java.util.*;
import java.lang.Math;
import java.lang.StringBuilder;

public class P1 {

  public static void main(String[] args) throws Exception {
    int sum = 0;
    for(int i = 0; i < 1000; i++) {
      if(i % 3 == 0 || i % 5 == 0) {
        sum += i;
      }
    }
    System.out.println(sum);
  }

}

