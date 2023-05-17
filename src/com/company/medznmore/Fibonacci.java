package com.company.medznmore;

// A Java program that uses dynamic programming
// to find the nth Fibonacci number
class Fibonacci {

  // Function to return nth Fibonacci number
  static int fib(int n)
  {
    // Create an array to store Fibonacci numbers
    int[] f = new int[n + 2];

    // Initialize base cases
    f[0] = 0;
    f[1] = 1;

    // Fill the array from left to right
    for (int i = 2; i <= n; i++) {
      // Add the previous two numbers
      f[i] = f[i - 1] + f[i - 2];
    }

    // Return the nth Fibonacci number
    return f[n];
  }

  // Driver code
  public static void main(String[] args)
  {
    int n = 9;
    System.out.println("Fibonacci number at index " + n + " is " + fib(n));
  }
}
