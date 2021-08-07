package Java.Generics;

public class Printer {
    /* Declare a generic printArray method of type inputType,
     * accepting an array of type inputType */
    public <inputType> void printArray(inputType[] array) {
        /* Loop thru the array */
        for (int i = 0; i < array.length; i++) {
            /* Print out each element of the array on a new line */
            System.out.println(array[i]);
        }
    }
}
