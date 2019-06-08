// Create a function to find the most occurence of an integer given
// an integer array

import java.util.Arrays;

public class MostOccurence {

    public static void main(String[] args) {

        // for this unsorted array, six repeats the most times
        int[] myArray1 = {1,1,2,3,4,3,6,6,6,7,7,2,8,9};

        findOccurence(myArray1);
    }

    // find and print number of occurences of each int in the array
    public static void findOccurence(int[] myArray1){

        // first let's sort the array in ascending order
        Arrays.sort(myArray1);

        // a new array with the length of our current one
        int[] count = new int[myArray1.length];

        // for temporarily holding value of certain myArray1 index
        int temp = 0;

        /* as we go thru each array member, we will store it in a temp variable
        * This variable will be the index value for the count array, which will
        * keep track of the number of times each element occurs.
        **/
        for (int i = 0; i < myArray1.length; i++) {
            temp = myArray1[i];
            count[temp]++;
        }

        // now we must print out the occurence of each element
        for (int i = 0; i < count.length; i++) {
            if(count[i] > 0) {
                System.out.println(i + " occurs " + count[i] + " times");
            }
        } // end for
    } // end findOccurence

} // end class
