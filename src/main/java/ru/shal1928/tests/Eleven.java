package ru.shal1928.tests;

public class Eleven extends Thread {

    public static void main(String [] args) {

        Eleven t = new Eleven();

        t.start();
        System.out.print("one. ");

        t.start();
        System.out.print("two. ");
    }

    public void run() {
        System.out.print("Thread ");
    }

}
