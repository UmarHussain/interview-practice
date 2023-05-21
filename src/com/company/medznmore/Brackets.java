package com.company.medznmore;

import java.util.LinkedList;

// A string S consisting of N characters is considered to be properly nested if any of the following
// conditions is true:
//
// S is empty;
// S has the form "(U)" or "[U]" or "{U}" where U is a properly nested string;
// S has the form "VW" where V and W are properly nested strings.
// For example, the string "{[()()]}" is properly nested but "([)()]" is not.
//
// Write a function:
//
// class Solution { public int solution(String S); }
//
// that, given a string S consisting of N characters, returns 1 if S is properly nested and 0
// otherwise.
//
// For example, given S = "{[()()]}", the function should return 1 and given S = "([)()]", the
// function should return 0, as explained above.
//
// Write an efficient algorithm for the following assumptions:
//
// N is an integer within the range [0..200,000];
// string S is made only of the following characters: '(', '{', '[', ']', '}' and/or ')'.
class BracketsSolution {
  public int solution(String S) {
    // Implement your solution here
    LinkedList<Character> charStack = new LinkedList<>();
    for(int i = 0; i<S.length(); i++) {
      if(S.charAt(i) == '{' || S.charAt(i) == '[' || S.charAt(i) == '(') {
        charStack.add(S.charAt(i));
      }
      if(S.charAt(i) == '}' || S.charAt(i) == ']' || S.charAt(i) == ')') {
        Character startingBracket = charStack.peekLast();
        if(startingBracket!=null &&((startingBracket.equals('{') && S.charAt(i) == '}')
                || (startingBracket.equals('[') && S.charAt(i) == ']')
                || (startingBracket.equals('(') && S.charAt(i) == ')'))) {
          charStack.removeLast();

        } else {
          return 0;
        }
      }

    }
    if(charStack.isEmpty()) {
      return 1;
    }
    return 0;
  }
}

public class Brackets {
  public static void main(String[] args) {
    BracketsSolution b = new BracketsSolution();
    System.out.println(b.solution(")("));
  }
}
