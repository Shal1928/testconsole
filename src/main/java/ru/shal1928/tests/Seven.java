package ru.shal1928.tests;

public class Seven {

    public static void aMethod() throws Exception {
        try {
            throw new Exception();
        } finally {
            System.out.print("finally "); /* Line 11 */
        }
    }

    public static void main(String args[]) {
        try {
            aMethod();
        }

        catch (Exception e) /* Line 20 */

        {

            System.out.print("exception ");

        }

        System.out.print("finished"); /* Line 24 */

    }

}
