package utils;
import java.util.Scanner;

public class Utils {



    public static Scanner input = new Scanner(System.in);

     public static void print(Object a) {
        System.out.println(a);
    }

    public static int validateIntInput() {
        // Check if the input is an integer
        while (!input.hasNextInt()) {
          input.next();
          print("Enter a valid value");
        }
        return input.nextInt();
      }
    public static int validateDoubleInput() {
        // Check if the input is a double
        while (!input.hasNextDouble()) {
          input.next();
          print("Enter a valid value");
        }
        return input.nextInt();
      }
    
}
