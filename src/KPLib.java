/**
 * My library of useful methods
 *
 * @author Katelyn Nova Powers
 * @version 1.0
 */


import java.util.Random;
import java.util.Scanner;

public class KPLib {

    /**
     * Make a bar of a specified length
     * @param charLength the length of the bar
     * @param maxLength the maximum length of the bar
     * @return A string with the bar
     */
    public static String barLength(int charLength, int maxLength)
    {

        int extraLength = 0;
        String output = "";

        if (charLength > maxLength)
        {
            extraLength = charLength - maxLength;
            charLength = maxLength;
        }
        int saveCharLength = charLength;

        saveCharLength /= 8;

        while (saveCharLength > 0)
        {
            output += ("█");
            saveCharLength--;
        }

        charLength %= 8;

        switch (charLength)
        {
            case 0:
                output += ("");
                break;
            case 1:
                output += ("▏");
                break;
            case 2:
                output += ("▎");
                break;
            case 3:
                output += ("▍");
                break;
            case 4:
                output += ("▌");
                break;
            case 5:
                output += ("▋");
                break;
            case 6:
                output += ("▊");
                break;
            case 7:
                output += ("▉");
                break;

        }
        if (extraLength != 0)
        {
            output += (" + " + extraLength);
        }

        return output;
    }

    /**
     * Resizes an integer array by the specified amount.
     *
     * @param array      The array to resize.
     * @param changeSize The amount to resize the array by.
     * @return The resized array.
     */
    public static int[] resizeIntArray(int[] array, int changeSize) {
        if (changeSize == 0) {
            return array;
        }
        int[] newArray = new int[array.length + changeSize];
        int elementsToCopy = Math.min(array.length, newArray.length);
        for (int i = 0; i < elementsToCopy; i++) {
            newArray[i] = array[i];
        }
        return newArray;
    }

    /**
     * Resizes a double array by the specified amount.
     *
     * @param array      The array to resize.
     * @param changeSize The amount to resize the array by.
     * @return The resized array.
     */
    public static double[] resizeDoubleArray(double[] array, int changeSize) {
        if (changeSize == 0) {
            return array;
        }
        double[] newArray = new double[array.length + changeSize];
        int elementsToCopy = Math.min(array.length, newArray.length);
        for (int i = 0; i < elementsToCopy; i++) {
            newArray[i] = array[i];
        }
        return newArray;
    }

    /**
     * Resizes a string array by the specified amount.
     *
     * @param array      The array to resize.
     * @param changeSize The amount to resize the array by.
     * @return The resized array.
     */
    public static String[] resizeStringArray(String[] array, int changeSize) {
        if (changeSize == 0) {
            return array;
        }
        String[] newArray = new String[array.length + changeSize];
        int elementsToCopy = Math.min(array.length, newArray.length);
        for (int i = 0; i < elementsToCopy; i++) {
            newArray[i] = array[i];
        }
        return newArray;
    }
}
