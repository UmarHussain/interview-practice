package com.company.medznmore;


import java.util.HashMap;
import java.util.Map;

class FindUnPairedNumberSolution{
  public int solution(int[] A) {
    // Implement your solution here
    Map<Integer,Integer> frequency = new HashMap<>();
    Integer number = 0;
    for(int i = 0; i<A.length; i++){
        Integer iFrequency= frequency.get(A[i]);
        if(iFrequency == null) {
          frequency.put(A[i],1);
        }else{
          iFrequency +=1;
          frequency.put(A[i],iFrequency);
        }
    }

    for(Map.Entry<Integer,Integer> entry : frequency.entrySet()){
      if(entry.getValue().equals(1)){
        number  = entry.getValue();
        break;
      }
    }

    return number;
  }
}

public class FindUnPairedNumber {
  public static void main(String[] args) {

  }
}


