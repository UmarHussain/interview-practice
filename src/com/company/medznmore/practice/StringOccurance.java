package com.company.medznmore.practice;

import java.util.HashMap;
import java.util.Map;

public class StringOccurance {

  public int solution(String a,char c) {
    int occurance = 0;
    for(int i = 0; i<a.length();i++) {
      if(a.charAt(i)==c){
        occurance++;
      }
    }
    return occurance;
  }

  public int recursive(int index,int occarence,String a, char c){
    if(index == a.length()-1){
      return occarence;
    }
    if(a.charAt(index)==c) {
      occarence++;
    }
    index++;
    return recursive(index,occarence,a,c);
  }

  public int recursive(int index,String a, char c){

    int count = 0;
    if(index == a.length()){
      return 0;
    }
    if(a.charAt(index)== c) {
      count = 1;
    }
      return count+recursive(index+1,a,c);

  }

  public long lambda(String a,char ch){
    return a.chars().mapToObj(c->(char) c).filter(c -> c=='a').count();
  }

  public static void main(String[] args) {

//    Map<String,Integer> map = new HashMap<>();
//    for (Integer in : map.values()) {}

    StringOccurance stringOccurance = new StringOccurance();
    ///System.out.println(stringOccurance.recursive(0,0,"mmmmmmm",'m'));

    System.out.println(stringOccurance.recursive(0,"qwmrmerm",'m'));
  }
}
