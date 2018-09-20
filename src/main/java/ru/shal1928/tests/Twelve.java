package ru.shal1928.tests;

public class Twelve extends Thread {

    Twelve() {

    }

    Twelve(Runnable r) {
        super(r);
    }

    public void run() {
        System.out.print("Inside Thread ");
    }
}

class MyRunnable implements Runnable {

    public void run(){
        System.out.print(" Inside Runnable");
    }
}

class Test {

    public static void main(String[] args) {
        new Twelve().start();
        new Twelve(new MyRunnable()).start();
    }
}
