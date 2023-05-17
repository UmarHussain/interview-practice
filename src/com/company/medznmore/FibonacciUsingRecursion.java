package com.company.medznmore;

public class FibonacciUsingRecursion {

  // function factorial (n is a non-negative integer)
  //    if n is 0 then
  //        return 1 [by the convention that 0! = 1]
  //    else
  //        return factorial(n – 1) times n [recursively invoke factorial
  //                                        with the parameter 1 less than n]
  //    end if
  // end function

  public static Integer fibonacci(Integer value) {

    if(value <= 1 ) {
      return 1;
    }else{
      return fibonacci(value-1) + fibonacci(value-2);
    }
  }

  public static void main(String[] args) {
    System.out.print(fibonacci(0)+" ");
    System.out.print(fibonacci(1)+" ");
    System.out.print(fibonacci(2)+" ");
    System.out.print(fibonacci(3)+" ");
    System.out.print(fibonacci(4)+" ");
    System.out.print(fibonacci(5)+" ");
    System.out.print(fibonacci(6)+" ");
    System.out.print(fibonacci(20)+" ");


  }
}
