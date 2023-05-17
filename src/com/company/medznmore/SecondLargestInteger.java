package com.company.medznmore;

import java.util.ArrayList;
import java.util.Set;
import java.util.Stack;

public class SecondLargestInteger {

  public static void main(String[] args) {

    ArrayList<Integer> integers = new ArrayList<>();

    Integer largest = Integer.MIN_VALUE;
    Integer secondLarges = Integer.MIN_VALUE;

    for(Integer i : integers) {
      if(i>=largest) {
        largest = i;
      }
      if(i>=secondLarges){
        if(secondLarges<=i) {

        }
      }
    }

    //
  }
}
