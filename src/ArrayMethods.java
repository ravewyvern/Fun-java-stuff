/********************************************
*	AUTHOR:	<name>
* COLLABORATORS: <names>
*	COURSE:	CS 111 Intro to CS I - Java
*	LAST MODIFIED: <date>
********************************************/

/********************************************
*	ArrayMethods
*********************************************
*	PROGRAM DESCRIPTION:
*	Collection of useful methods for int arrays.
*********************************************
*	ALGORITHM:
*	TODO: <Pseudocode for selection sort here>
*********************************************

/* UML CLASS DIAGRAM:
-----------------------------------------
ArrayMethods
-----------------------------------------
-----------------------------------------
+ arrayString(array : int[]) : String //static
+ swap(array : int[], a : int, b : int) : void //static
+ indexOfMin(array : int[], startIndex : int) : int //static
+ reverse(array : int[]) : void //static
+ selectionSort(array : int[]) : void //static
-----------------------------------------
*/

public class ArrayMethods
{
  /**DESCRIPTION: */
  //replace with a for-each loop
  public static String arrayString(int[] a) {
    String output = "";
    for (int i = 0; i < a.length; i++) {
      output += a[i];
      if (i < a.length - 1) {
        output += ", ";
      }
    }
    return "{ " + output + " }";
  }
  
  /**DESCRIPTION: */
  public static void swap(int[] array, int a, int b)
  {
    int temp = array[a];
    array[a] = array[b];
    array[b] = temp;
  }
	
	/**DESCRIPTION: */
  public static int indexOfMin(int[] array, int startIndex)
  {
    int index = startIndex, min = 2147483647, minIndex = 0;

    while (index < array.length)
    {
      if (array[index] < min) {
        min = array[index];
        minIndex = index;
      }
      index++;
    }
    return minIndex;
  }

	/**DESCRIPTION: */
  public static void reverse(int[] array)
  {
    int index = 0;
    while (index < array.length / 2)
    {
      swap(array, index, array.length - 1 - index);
      index++;
    }
  }

	/**DESCRIPTION: */
  public static void selectionSort(int[] array)
  {
    for (int i = 0; i < array.length; i++)
    {
      swap(array, i, indexOfMin(array, i));
    }

  }

}