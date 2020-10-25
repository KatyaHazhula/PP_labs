package com.company;

/**
 * Task 4
 * @author Katya Hazhula
 * */

public class Fibonacci {
   static private int firstEl, secondEl;

    static void SetElements(int first,int second){
        firstEl=first;
        secondEl=second;
    }

    int GetFirst(){
        return firstEl;
    }
    int GetSecond(){
        return secondEl;
    }
    /**
     * The method that creates a fibonacci row and then calls BiggestNum method.
     * @param setSize - the amount of fibonacci nums.
     */

    public void FibonacciRow(int setSize)
    {
        int [] fibonacciArr = new int [setSize];

        try
        {
            fibonacciArr[0] = firstEl;
            fibonacciArr[1] = secondEl;
            System.out.print(fibonacciArr[0]+" "+fibonacciArr[1]+" ");

            for (int i = 2; i < fibonacciArr.length; i++)
            {
                fibonacciArr[i] = fibonacciArr[i - 1] + fibonacciArr[i - 2];
                System.out.print(fibonacciArr[i] + " ");
            }

            System.out.println();
            BiggestNum(fibonacciArr);
        }
        catch (ArrayIndexOutOfBoundsException e)
        {
            System.out.println("The biggest odd number is " + secondEl + ". 100% of odd nums.");
        }
    }

    /**
     * The help method for Fibonacci method. The method finds the biggest even and odd fibonacci num.
     * @param fibonacciArr - the array of fibonacci nums.
     */
    private void BiggestNum(int[] fibonacciArr)
    {
//        boolean bigOdd = false, bigEven = false;
//        int maxEven = 0, maxOdd = 0;
        int countEven = 0;

        for (int i = fibonacciArr.length - 1; i!=-1; i--)
        {
            if ((fibonacciArr[i] & 1) == 0)
            {

                countEven++;
            }

        }

        double evenPart = ((double) countEven / fibonacciArr.length * 100);

        System.out.println("The percentage is " + evenPart + "% of even nums and " + (100 - evenPart) + "% of odd nums.");
    }



}
