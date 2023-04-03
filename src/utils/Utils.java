package utils;
import java.util.Scanner;

// Class that contains the methods that are used in more than one class, such as the validation methods and the print method 
public class Utils {



    public static Scanner input = new Scanner(System.in);

    /*
     * Method that prints the given object
     * @param a object to be printed
     */
     public static void print(Object a) {
        System.out.println(a);
    }

    /*
     * Method that validates the inputed String contains a hashtag
     */
    public static String validateHashtag(){
        // Check if the input has a initial # and final #
        String hashtag = input.next();
        while (hashtag.indexOf("#") == hashtag.lastIndexOf("#")) {
            print("Enter a valid hashtag");
            hashtag = input.next();
        }
        return hashtag;
    }

    /*
     * Method that validates the inputed value is an integer
     */
    public static int validateIntInput() {
        // Check if the input is an integer
        while (!input.hasNextInt()) {
          input.next();
          print("Enter a valid value");
        }
        return input.nextInt();
      }
    
    /*
     * Method that validates the inputed value is a double
     */
    public static double validateDoubleInput() {
        // Check if the input is a double
        while (!input.hasNextDouble()) {
          input.next();
          print("Enter a valid value");
        }
        return input.nextDouble();
      }

    /*
     * Method that validates the inputed value is a valid stage
     */
    public static int validateStageInput(){
        // Check if the input is a valid stage
        int stage = validateIntInput();
        while (stage < 1 || stage > 6) {
            print("Enter a valid stage");
            stage = validateIntInput();
        }
        return stage;
    }

    /*
     * Method that validates the inputed value is a valid capsule type
     */
    public static String validateCapsuleType(){
        // Check if the input is a valid capsule type (tecnical, managment, domain, or experiences)
        String capsuleType = input.next();
        capsuleType = capsuleType.toUpperCase();
        while (!capsuleType.equals("TECNICAL") && !capsuleType.equals("MANAGEMENT") && !capsuleType.equals("DOMAIN") && !capsuleType.equals("EXPERIENCES")) {
            print("Enter a valid capsule type");
            capsuleType = input.next();
            capsuleType = capsuleType.toUpperCase();
        }
        return capsuleType;
    }
    
}
