package com.company.medznmore;


import java.util.Arrays;

class SolutionCyclicRotation {

  public int[] solution(int[] A, int K) {
    // Implement your solution here
    for(int i = 0; i <K;i++){
      int last_value = A[A.length-1];
      for(int j = (A.length-1);j>0; j--)
      {
          A[j] = A[j-1];
      }
      A[0] = last_value;
    }
    return A;
  }
}

public class CyclicRotation {
  public static void main(String[] args) {
    SolutionCyclicRotation s = new SolutionCyclicRotation();
    int [] A = {1,2,3,5,6,7,8,9,0};
    int k = 10;
    System.out.println("starting state "+ Arrays.toString(A) +" before K rotations :"+k);
    int B[] = s.solution(A,k);
    System.out.println("ending state "+ Arrays.toString(B) +" after K rotations :"+k);
  }
}
