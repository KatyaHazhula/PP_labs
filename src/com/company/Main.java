package com.company;

import java.util.Scanner;

/**
 * Task 1
 * @author Katya Hazhula
 * */

public class Main {

      /**
       * The main method
       * @param args - arguments from terminal
       */

  public static void main(String[] args) {
        int start, end,size;

        System.out.println("Hello world");

        Initialization obj=new Initialization();
        obj.print();

        Arguments obj2=new Arguments(args);


        Scanner in=new Scanner(System.in);

        System.out.println("Enter interval:");
        start = in.nextInt();
        end = in.nextInt();

        Interval obj3= new Interval();
        obj3.SetStart(start);
        obj3.SetEnd(end);
        obj3.odd_and_even();

        System.out.println("Enter size of Fibonacci row: ");

        size=in.nextInt();
        Fibonacci obj4=new Fibonacci();
        obj4.FibonacciRow(size);
    }
}
