package ru.shal1928.tests;

public class Two {

    public static void main(String [] args) {
        Two s = new Two();
        s.start();
    }

    void start() {
        int a = 3;
        int b = 4;

        System.out.print(" " + 7 + 2 + " ");
        System.out.print(a + b);
        System.out.print(" " + a + b + " ");
        System.out.print(foo() + a + b + " ");
        System.out.println(a + b + foo());
    }

    String foo() {
        return "foo";
    }
}
