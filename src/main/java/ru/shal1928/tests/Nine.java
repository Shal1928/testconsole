package ru.shal1928.tests;

import java.util.HashSet;

public class Nine {
    public void display(){
        final int num = 23;
        abstract class Inner{
            public void print() {
                System.out.println("This is method inner class " + num);
            }
        }

    }
    
    public static void main(String args[]){
        Nine outer = new Nine();
        outer.display();
    }
}
