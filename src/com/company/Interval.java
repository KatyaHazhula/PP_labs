package com.company;

/**
 * Task 4
 * @author Katya Hazhula
 * */

public class Interval {
    private int Start,End;
    private int biggestEven, biggestOdd;



    int GetStart(){
        return Start;
    }
    int GetEnd(){
        return End;
    }
    /**
     *   @param start - the min num.
     */
    void SetStart(int start){
        this.Start= start;
    }
    /**
     *   @param end - the min num.
     */
    void SetEnd(int end){
         this.End=end;
    }

    /**
     * Finds the biggest odd and even num in range of start, end.
     */
    public void odd_and_even() {
        int sum = 0;

        System.out.println();

        for (int localEnd = End; localEnd >= Start; localEnd--) {
            if ((localEnd & 1) == 0) {
                System.out.print(localEnd + " ");
                sum += localEnd;


                if (biggestEven == 0) {
                    biggestEven = localEnd;
                }
            }
        }

        System.out.println();
        System.out.println("The sum of even numbers is - " + sum);

        sum = 0;
        for (int localStart = Start; localStart <= End; localStart++) {
            if ((localStart & 1) == 1) {
                System.out.print(localStart + " ");
                sum += localStart;
                biggestOdd = localStart;
            }
        }

        System.out.println();
        System.out.println("The sum of odd numbers is - " + sum);
        System.out.println("Big even" + " " + biggestEven);
        System.out.println("Big odd" + " " + biggestOdd);
        Fibonacci.SetElements(biggestEven, biggestOdd);
    }
    }
