package utils;
import java.util.Scanner;

public class Utils {



    public static Scanner input = new Scanner(System.in);

     public static void print(Object a) {
        System.out.println(a);
    }

    public static String validateHashtag(){
        // Check if the input has a initial # and final #
        String hashtag = input.next();
        while (hashtag.indexOf("#") != hashtag.lastIndexOf("#")) {
            print("Enter a valid hashtag");
            hashtag = input.next();
        }
        return hashtag;
    }

    public static int validateIntInput() {
        // Check if the input is an integer
        while (!input.hasNextInt()) {
          input.next();
          print("Enter a valid value");
        }
        return input.nextInt();
      }
    public static double validateDoubleInput() {
        // Check if the input is a double
        while (!input.hasNextDouble()) {
          input.next();
          print("Enter a valid value");
        }
        return input.nextDouble();
      }
    
}
