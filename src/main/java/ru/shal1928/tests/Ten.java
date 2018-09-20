package ru.shal1928.tests;

public class Ten implements Runnable {
    public static void main(String args[]) {
        Ten run = new Ten();
        Thread t = new Thread(run);
        t.start();
    }

    @Override public void run() {
        System.out.println("TEN");
    }
}
