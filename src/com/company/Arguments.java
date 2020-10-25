package com.company;

/**
 * Task 3
 * @author Katya Hazhula
 * */


public class Arguments {
    public Arguments(String[] args)
    {
        try
        {
            System.out.println("Arguments are: " + args[0] + " " + args[1] + " " + args[2]);
        }
        catch (ArrayIndexOutOfBoundsException e)
        {
            System.out.println("Too few arguments!");
        }
    }

}
