package com.company.medznmore;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.atomic.AtomicReference;

public class Main {


    public static void checkIfElseIf() {
        Collection<Integer> integers = new ArrayList<>();
        Collection<Integer> integers1 = new ArrayList<>();

        if (!integers.isEmpty()) {
            System.out.println("if");
        } else if (integers1.isEmpty()) {
            System.out.println("else if");
        }else {
            System.out.println("else");
        }
    }

    public static void atomicReference(){
        // write your code here
        Double a = 10.0;
        List<Double> doubleList = Arrays.asList(a, a, a, a, a, a, a, a, a, a, a, a);

        AtomicReference<Double> sum = new AtomicReference<>(0.0);
        doubleList.forEach(aDouble -> sum.accumulateAndGet(aDouble, Double::sum));

        System.out.println("total:" + sum);
    }
    public static void main(String[] args) {

        //checkIfElseIf();
        atomicReference();
    }
}
