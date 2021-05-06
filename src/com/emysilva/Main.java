package com.emysilva;

public class Main {

    static int smallestPositiveInteger(int[] arrayOfIntegers) {

        int firstPositiveInteger = 0;

        int arrayLength = arrayOfIntegers.length;

        // check if there is a positive integer in the array
        for (int arrayOfInteger : arrayOfIntegers) {
            if (arrayOfInteger == 1) {
                firstPositiveInteger = 1;
                break;
            }
        }

        // if there is no positive integer found
        if (firstPositiveInteger == 0)
            return 1;

        // change integer to 1 if integer is <= 0 or > size of array
        for(int i = 0; i < arrayLength; i++)
            if (arrayOfIntegers[i] <= 0 || arrayOfIntegers[i] > arrayLength)
                arrayOfIntegers[i] = 1;

        // Updating indices according to integers
        for(int i = 0; i < arrayLength; i++)
            arrayOfIntegers[(arrayOfIntegers[i] - 1) % arrayLength] += arrayLength;

        // Finding which array index has integer less than size of array
        for(int i = 0; i < arrayLength; i++)
            if (arrayOfIntegers[i] <= arrayLength)
                return (i + 1);

        // If array has integers from 1 to the size of array
        return (arrayLength + 1);

    }

    public static void main(String[] args) {
	    // write your code here
        System.out.println(smallestPositiveInteger(new int[]{-1, -3}));
    }
}
