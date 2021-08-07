package Java.Generics;

import java.lang.reflect.Method;

public class Solution {
    /* Start the program here */
    public static void main(String[] args) {
        /* Create an instance of the Printer class */
        Printer myPrinter = new Printer();

        /* Create Integer and String arrays as test data */
        Integer[] intArray = { 1, 2, 3 };
        String[] stringArray = { "Hello", "World" };

        /* Print the arrays using the generic function printArray */
        myPrinter.printArray( intArray );
        myPrinter.printArray( stringArray );

        /* Test that there is only one generic function handling both
         * integers and strings.  (An alternative method for doing this
         * is function overloading, with one function accepting strings,
         * and the other accepting ints; but this exercise is about
         * doing a single generic function to handle both
         */

        /* Initialize the printArray method count to 0 */
        int printArrayMethodCount = 0;
        /* Loop thru all the methods for the Printer class */
        for (Method method : Printer.class.getDeclaredMethods()) {
            /* Get the name of the method */
            String methodName = method.getName();
            /* Is this method a printArray method */
            if (methodName.equals("printArray")) {
                /* If so, increment the printArrayMethodCount */
                printArrayMethodCount++;
            }
        }
        /* See if we have more than 1 printArray method */
        if (printArrayMethodCount > 1) {
            /* Print out an error message */
            System.out.println("Method overloading is not allowed!");
            assert printArrayMethodCount == 1;
        }
    }
}
