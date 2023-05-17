package com.company.medznmore;



class Solution {
  public int solution(int N) {
    // Implement your solution here
    int max_gap = 0;
    int current_gap_size = 0;
    char currentChar = 0;
    char previousChar;
    boolean inGap = false;

    String binaryString = Integer.toBinaryString(N);
    System.out.println("value:"+N);
    System.out.println("binaryString:"+binaryString);
    for(int i=0; i<binaryString.length();i++){
      char bin = binaryString.charAt(i);
        if(i==0){
          currentChar = bin;
          if(bin == '1') {
            inGap = true;
          }
        } else {
          previousChar = currentChar;
          currentChar = bin;

          if( (!inGap && currentChar == '1' && previousChar=='1') ||(!inGap && currentChar == '0' && previousChar=='0')) {
          //System.out.println("gap not started  previous gap size:"+max_gap);
          }
          if(!inGap && currentChar == '0' && previousChar == '1') {
            if(max_gap <= current_gap_size) {
              max_gap = current_gap_size;
            }
            inGap = true;
          }
          if(inGap && ((currentChar =='0' && previousChar == '1') || (currentChar =='0' && previousChar == '0'))) {
            current_gap_size ++;
          }
          if(inGap && currentChar =='1' && previousChar == '0') {
            inGap = false;
            if(max_gap <= current_gap_size) {
              max_gap = current_gap_size;
            }
            current_gap_size = 0;
          }
        }
      }
      return max_gap;
    }

    private void shifting(){
      int value = 12;
      int leftShift = value << 4;
      System.out.println(leftShift+" : "+(leftShift == 48));
    }

  }


public class BinaryGap {
  public static void main(String[] args) {

      Solution s = new Solution();
    long startTime = System.nanoTime();
      int maxGap = s.solution(2147483647);
    long endTime = System.nanoTime();
    long totalTime= endTime - startTime;
    System.out.println("totalTime: "+totalTime);
    System.out.println(maxGap);
    ;
  }
}
