// Infected Room Problem

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

