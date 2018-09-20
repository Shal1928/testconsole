package ru.shal1928.tests;

public class Thirteen implements Runnable

{

    int x, y;

    public void run()

    {

        for(int i = 0; i < Integer.MAX_VALUE; i++)

            synchronized(this)

            {

                x = 12;

                y = 12;

            }

        System.out.print(x + " " + y + " ");

    }

    public static void main(String args[])

    {

        Thirteen run = new Thirteen();

        Thread t1 = new Thread(run);

        Thread t2 = new Thread(run);

        t1.start();

        t2.start();

    }

}
