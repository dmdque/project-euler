import java.io.*;
import java.util.*;
import java.lang.Math;
import java.lang.StringBuilder;

public class P36 {
  public static void printBinary(int n) {
    for(int i = 0; i < 32; i++)
      System.out.print(ithBit(n, i));
    System.out.println();
  }

  // index starting at 0
  public static int ithBit(int n, int i) {
    int wordSize = 32;
    int bit = n & (1 << (wordSize - i - 1)); // isolate
    bit = bit >> (wordSize - i - 1);
    return bit;
  }

  // O(logn)
  // leading zeroes
  public static boolean isPalindrome2(int n) {
    int wordSize = 32;

    // find start index depending on leading zeroes
    int startIndex = 32;
    for(int i = 0; i < wordSize; i++) {
      if(n >> i == 0) {
        startIndex = i - 1;
        break;
      }
    }

    for(int i = 0; i < startIndex; i++) {
      //System.out.println("n >> " + (wordSize - (startIndex - i) - 1) + ": " + ithBit(n, startIndex - i));
      //System.out.println("n & 1: " + ithBit(n, wordSize - i - 1));
      if(ithBit(n, wordSize - (startIndex - i) - 1) == ithBit(n, wordSize - i - 1)) {
        //System.out.println("true for i = " + i);
      } else {
        //System.out.println("not pal");
        return false;
      }
    }
    return true;
  }

  public static int ithDigit(int n, int i) {
    return Character.getNumericValue(Integer.toString(n).charAt(i));
  }

  // O(logn)
  public static boolean isPalindrome10(int n) {
    int numDigits = (int)Math.ceil(Math.log10((double)n));
    //System.out.println(numDigits);
    for(int i = 0; i < Math.ceil(numDigits / 2); i++) {
      //System.out.println(ithDigit(n, 0));
      //System.out.println(ithDigit(n, numDigits - i - 1));
      if(ithDigit(n, i) == ithDigit(n, numDigits - i - 1)) {
        //System.out.println("equal at i = " + i);
      } else {
        //System.out.println("not");
        return false;
      }
    }
    return true;
  }

  public static void main(String[] args) throws Exception {
    int n = 7447;
    printBinary(n);
    System.out.println(isPalindrome10(n));

    int sum = 0;
    for(int i = 0; i < 1000000; i++) {
      if(isPalindrome10(i)) {
        if(isPalindrome2(i)) {
          System.out.println(i);
          sum += i;
        }
      }
    }
    System.out.println("answer: " + sum);
  }
}

