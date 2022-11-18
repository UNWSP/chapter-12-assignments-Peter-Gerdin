import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;


public class distanceFromAverageWithExceptionHandling {
    static boolean continueVar = false;

    public static void main(String[] arg) {
        Scanner inputDevice = new Scanner(System.in);
        int arraySize = 0;
        double avg = 0;
        double total = 0;
        double input = 0;
        double QUIT = 999;
        int counter = 0;
        ArrayList<Double> numArray;


        while (!continueVar)
        {
            try
            {
                System.out.println("Please enter the size of the array (int) or '999' to quit >>");
                arraySize = Integer.parseInt(inputDevice.nextLine());
                continueVar = true;
            }
            catch (NumberFormatException e)
            {
                System.out.println("ERROR:  did not enter an integer for the size of the array");
            }
            // *************************************************************   *******************************
        }
        if(arraySize == QUIT)
        {
            System.exit(0);
        }
        try
        {
            numArray = new ArrayList<Double>(arraySize);
        }
        catch (NegativeArraySizeException e)
        {
            System.out.println("ERROR:  negative size is invalid. \nThe size has been defaulted to five\n");
            arraySize = 5;
            numArray = new ArrayList<Double>(arraySize);
        }
        // *************************************************************   ************************************

        while(counter < arraySize)
        {
            try
            {
                System.out.println("Please enter a number or type 999 to quit >> ");
                input = Double.parseDouble(inputDevice.nextLine());
                if(input==QUIT){
                    System.exit(0);
                }
                numArray.add(input);
                counter++;
            }
            catch(NumberFormatException e)
            {
                System.out.println("ERROR: Did not enter a number");
            }
        }
        for(double num: numArray)
        {
            total += num;
        }
        avg = total/arraySize;
        System.out.println("The average of the " + arraySize+ " numbers is " + avg);
        for(double num: numArray)
        {
            double distance = num - avg;
            System.out.println("the number " + num + " is " + distance + " away from the average");
        }
    }
}
