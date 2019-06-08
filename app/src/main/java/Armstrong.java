/**
 Java Program to check or find if a number is Armstrong number or not. An Armstrong number of
 three digit is a number whose sum of cubes of its digit is equal to its number.
 For example 153 is an Armstrong number of 3 because 1^3+5^3+3^3 or 1+125+27=153
 */

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
