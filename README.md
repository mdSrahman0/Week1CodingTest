# Week1CodingTest

Problem 1 - Create a singleton class that's thread safe

    public class Singleton
    {
        // we make the instance private so only the getInstance() method can access it.
        private static Singleton instance;

        // a private constructor.
        private Singleton() {
        }

        // a synchronized method to ensure that multiple
        // threads don't access it simultaneously.
        synchronized public static Singleton getInstance() {
            // if instance is null, initialize
            if (instance == null) {
                instance = new Singleton();
            }
            return instance;
        }
    } 
    
    
Problem 2 - Create a function to find the most occurence of an integer given an integer array


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


Problem 3 - Java Program to check or find if a number is Armstrong number or not. An Armstrong number of
 three digit is a number whose sum of cubes of its digit is equal to its number.
 For example 153 is an Armstrong number of 3 because 1^3+5^3+3^3 or 1+125+27=153
 
    public class Armstrong {
    public static void main(String[] args) {
        int num = 371;
        int saveNum = num; // save the number because it will be changed later
        int temp = 0; // will store each digit of num starting from end
        int total = 0; // will store running total of each digit's cube

        // while num still has a value, get the rightmost digit, cube it, and add it to total
        while (num > 0) {
            temp = num % 10;
            total = total + (temp * temp * temp);
            num = num / 10; // get rid of rightmost digit
        }

        if (saveNum == total){
            System.out.println("Is armstrong number");
        }
        else{
            System.out.println("Not armstrong number");
        }
    }
  }

Problem 4 - Infected Room Problem


    public class Room {
    public final boolean isInfected;
    public boolean visited = false;

    Room(boolean infected){
        isInfected = infected;
    }
  }

 class Outbreak{

    // taking a new floor object, we must keep track of the max number of infected rooms
    public static boolean isOutBreakRoom(Room[][] floor) {
        int result = 0;
        // we need a nested for loop so we can check the status of every single element
        // in the 2D array.
        for (int i = 0; i < floor.length; i++){
            for (int j = 0; j < floor[i].length; j++) {
                // this method passes in every element of the 2D array to see if it is infected.
                // if it is, add it to our temporary variable
                int temp = checkroom(0,floor,i,j);
                if(temp>=result){
                    result=temp;
                }
            } // end inner for
        } // end outer for
    System.out.println("Infected Rooms: " + result);
        return result >= 5;
    } // end isOutBreakRoom

    // a recursive method which will be called for every element in our 2d array. Checks to see
    // if a room is infected. If it is, increment a result variable and call this method again
    // with all the elements to the left, right, top and bottom of the array.
    public static int checkroom(int temp, Room[][] floor, int row, int col){
        int result = temp;

        // if the rows and columns are less than 0 or greater than the length of the array,
        // we are out of bounds, so return 0;
        if (row < 0 || row >= floor.length) return 0;
        if (col < 0 || col >= floor.length) return 0;

        // if we already visited this element in a prior recursion, do not count it,
        if((floor[row][col]).visited==true) return 0;

        // if this element is not infected, return 0;
        if((floor[row][col]).isInfected==false) return 0;

        // set this element's visited value to true, because if we've come to this point it means
        // it is an element we have not visited AND it is infected.
        floor[row][col].visited=true;

        // also increment the result.
        result += 1;

        // concatenate the result with another checkroom call, passing in every element adjacent to the
        // current ont
        return result + checkroom(0, floor, row+1, col) + checkroom(0,floor, row-1, col)
                + checkroom(0, floor, row, col+1) + checkroom(0, floor, row, col-1);
    } // end checkroom

    // in our main method, we create an example Room object and test if there is an object
    public static void main(String[] args) {
        Room[][] verticalTrue = new Room[][] {
                {new Room(false), new Room(false), new Room(false), new Room(false), new Room(false), new Room(false), new Room(false), new Room(false), new Room(false) },
                {new Room(false), new Room(false), new Room(false), new Room(false), new Room(false), new Room(false), new Room(false), new Room(false), new Room(false) },
                {new Room(false), new Room(false), new Room(false), new Room(false), new Room(false), new Room(false), new Room(false), new Room(false), new Room(false) },
                {new Room(false), new Room(true), new Room(false), new Room(true), new Room(true), new Room(false), new Room(false), new Room(false), new Room(false) },
                {new Room(false), new Room(true), new Room(false), new Room(false), new Room(false), new Room(false), new Room(false), new Room(false), new Room(false) },
                {new Room(false), new Room(true), new Room(false), new Room(false), new Room(false), new Room(false), new Room(false), new Room(false), new Room(false) },
                {new Room(false), new Room(true), new Room(false), new Room(false), new Room(false), new Room(false), new Room(false), new Room(false), new Room(false) },
                {new Room(false), new Room(true), new Room(false), new Room(false), new Room(false), new Room(false), new Room(false), new Room(false), new Room(false) },
                {new Room(false), new Room(false), new Room(false), new Room(false), new Room(false), new Room(false), new Room(false), new Room(false), new Room(false) },
                {new Room(false), new Room(false), new Room(false), new Room(false), new Room(false), new Room(false), new Room(false), new Room(false), new Room(false)}};

        Room[][] noInfection = new Room[][] {
                {new Room(true), new Room(false), new Room(true), new Room(false), new Room(false), new Room(false), new Room(false), new Room(false), new Room(false) },
                {new Room(false), new Room(true), new Room(false), new Room(true), new Room(false), new Room(false), new Room(false), new Room(false), new Room(false) },
                {new Room(true), new Room(false), new Room(true), new Room(false), new Room(false), new Room(false), new Room(false), new Room(false), new Room(false) },
                {new Room(false), new Room(true), new Room(false), new Room(true), new Room(false), new Room(true), new Room(false), new Room(false), new Room(false) },
                {new Room(false), new Room(true), new Room(false), new Room(false), new Room(true), new Room(false), new Room(false), new Room(false), new Room(false) },
                {new Room(false), new Room(false), new Room(false), new Room(false), new Room(false), new Room(true), new Room(false), new Room(false), new Room(false) },
                {new Room(false), new Room(false), new Room(false), new Room(false), new Room(false), new Room(false), new Room(true), new Room(false), new Room(false) },
                {new Room(false), new Room(false), new Room(false), new Room(false), new Room(false), new Room(false), new Room(false), new Room(false), new Room(false) },
                {new Room(false), new Room(false), new Room(false), new Room(false), new Room(false), new Room(false), new Room(false), new Room(false), new Room(false) },
                {new Room(false), new Room(false), new Room(false), new Room(false), new Room(false), new Room(false), new Room(false), new Room(false), new Room(false) }
        };
        // pass in our test-array into our isOutBreakRoom method, which will return true if there is an infection
        boolean isInfected1 = isOutBreakRoom(verticalTrue);
        System.out.println(isInfected1);

        System.out.println();
        boolean isInfected2 = isOutBreakRoom(noInfection);
        System.out.println(isInfected2);
        } // end main
  } // end outbreak class

