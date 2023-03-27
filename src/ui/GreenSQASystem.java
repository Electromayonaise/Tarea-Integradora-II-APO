// Make a menu that contains the following options: 1. Create a proyect 2. Culminate a stage of a proyect 3. Register a capsule 4. Aprove a capsule 5. Publish a capsule 
// 6. Inform the user the number of registered capsules by their type (tecnical, managment, domain, and experiences) 7. Inform the user a list of lerned lessons related to 
// the capsules registered in proyects on a particular stage 8. Inform the user the name of the proyect with the most registered capsules 9, Inform the user if a collaborator 
// (by inputing the name) has registered capsules in any proyect 10. Inform the user the situations and essons learned from the aproved and published capsules, according to a search
// chain given by himself 11. Exit
package ui;
import model.Proyects;
import java.util.Scanner;



public class GreenSQASystem {

    private static String proyectName = "";

    static void print(Object a) {
        System.out.println(a);
    }
    static Scanner input = new Scanner(System.in);
    private static Proyects[] proyectController; // Proyects class

    public static void main (String [] args){
        int option;
        do {
            menu();
            option = input.nextInt();
            proyectController = new Proyects[10];
            switch (option){
                
                // Proyect creation: needs name of the proyect, name of the client, date planed for the beginning of the proyect, date planed for the end of the proyect, 
                // the value of the budget, and the name and corresponding phone number of the proyect managers from boath sides (client and company). When the proyect is created
                // it is automatically set to the first stage (1) (out of the 6 stages that a proyect can have: 1. Beginning, 2. Analysis, 3. Design, 4. Implementation, 5. Closing, 6. Follow up and control of the proyect)
                // each stage has a planned date for the begining and end, and a real date for the begining and end. For asigning the planned dates, the user must enter the 
                // number of months that each stage will take (array of 6 positions, each position is a stage, and the value is the number of months that the stage will take)


                case 1:
                    
                    String answer = "n";
                    for (int i = 0; i <= 10; i++) { 

                        print("Please enter the name of the proyect");
                        proyectName = input.next();
                        print("Please enter the name of the client");
                        String clientName = input.next();
                        print("Please enter the date planed for the beginning of the proyect (YYYY/MM/DD)");
                        String datePlanedBegin = input.next();
                        print("Please enter the date planed for the end of the proyect (YYYY/MM/DD)");
                        String datePlanedEnd = input.next();
                        print("Please enter the value of the budget");
                        double budget = input.nextDouble();
                        print("Please enter the name of the proyect manager from the client side");
                        String clientManagerName = input.next();
                        print("Please enter the phone number of the proyect manager from the client side");
                        String clientManagerPhone = input.next();
                        print("Please enter the name of the proyect manager from the company side");
                        String companyManagerName = input.next();
                        print("Please enter the phone number of the proyect manager from the company side");
                        String companyManagerPhone = input.next();
                        proyectController[i] = new Proyects(proyectName, clientName, datePlanedBegin, datePlanedEnd, budget, clientManagerName, clientManagerPhone, companyManagerName, companyManagerPhone);
                        print("Do you want to create another proyect? (Y/N)");
                        answer = input.next();
                        answer = answer.toUpperCase();
                        if (answer.equals("Y")){
                            continue;
                        } else {
                            print("The proyects created are:");
                            for (int j = 0; j <= i; j++) {
                                print(proyectController[j].getName());
                            }
                            break;
                        }
                    } 
                //  Culminate a stage of a proyect: Stage culmination is done by registering the aprovement of the stage by the client, and the real date of the end of the stage. 
                // The user must enter the name of the proyect, the stage that he wants to culminate, and the real date of the end of the stage, as well as the real date of the beginning of the new stage
                case 2:
                    // Check if there is any existing proyect to culminate a stage
                    if (proyectController[0] == null){
                        print("There are no proyects to culminate a stage");
                        break;
                    }
                    print("Please enter the name of the proyect");
                    proyectName = input.next();
                    print("Please enter the real date of the end of the stage that you want to culminate  (YYYY/MM/DD)");
                    String realDateEnd = input.next();
                    for (int i = 0; i < 10; i++) {
                        if (proyectController[i].getName().equals(proyectName)){
                            proyectController[i].culminateStage(realDateEnd);
                        }
                    }
                    break;
                // Register a capsule: The user must enter the name of the proyect, the stage in which the capsule will be registered, the type of capsule (tecnical, managment, domain, or experiences),
                // a unique identifier, a description of the capsule, the name of the collaborator who registered the capsule, the date of the capsule, and the situation and lesson learned from the capsule
                // the inputed text on the description must have the keywords between hashtags (#) related to an atributte of the capsules called "tags"
                case 3:

                    // Check if there is any existing proyect to register a capsule
                    if (proyectController[0] == null){
                        print("There are no proyects to register a capsule");
                        break;
                    }
                    print("Please enter the name of the proyect");
                    proyectName = input.next();
                    print("Please enter the stage in which the capsule will be registered");
                    int stage = input.nextInt();
                    if (stage > 6 || stage < 1){
                        print("The stage must be between 1 and 6");
                        break;
                    }
                    for (int i = 0; i < 10; i++) {
                        if (proyectController[i].getName().equals(proyectName)){
                            if (proyectController[i].getStage() < stage){
                                print("The stage must be the current stage or a previous stage");
                                break;
                            }
                        }
                    }
                    print("Please enter the type of capsule (tecnical, managment, domain, or experiences)");
                    String type = input.next();
                    print("Please enter a unique identifier");
                    String identifier = input.next();
                    print("Please enter a description of the capsule that contains the kwywords between hashtags (#)");
                    String description = input.next();
                    print("Please enter the name of the collaborator who registered the capsule");
                    String collaboratorName = input.next();
                    print("Please enter the post of the collaborator who registered the capsule");
                    String collaboratorPost = input.next();
                    print("Please enter the situation and lesson learned from the capsule");
                    String situation = input.next();
                    String status="Pending";
                    for (int positionArray = 0; positionArray < 10; positionArray++) {
                        if (proyectController[positionArray].getName().equals(proyectName)){
                            proyectController[positionArray].regCapsule( positionArray, proyectName,stage, type, identifier, description, collaboratorName, collaboratorPost, situation, status);
                        }
                    }
                    break;
                case 4:
                    // Check if there is any existing proyect to aprove a capsule
                    if (proyectController[0] == null){
                        print("There are no proyects to aprove a capsule");
                        break;
                    }
                    print("Please enter the name of the proyect");
                    proyectName = input.next();
                    print("Please enter the unique identifier of the capsule that you want to aprove");
                    identifier = input.next();
                    // Give the identifier to the method aproveCapsule in the class Proyects
                    for (int i = 0; i < 10; i++) {
                        if (proyectController[i].getName().equals(proyectName)){
                            proyectController[i].aproveCapsule(identifier);
                        }
                    }
                    break;

            }
    
        } while (option != 11);
    }

        public static void menu (){
            print("Welcome to the GreenSQA system, please select the option you want to use");
            print("1. Create a proyect");
            print("2. Culminate a stage of a proyect");
            print("3. Register a capsule");
            print("4. Aprove a capsule");
            print("5. Publish a capsule");
            print("6. Inform the user the number of registered capsules by their type (tecnical, managment, domain, and experiences)");
            print("7. Inform the user a list of lerned lessons related to the capsules registered in proyects on a particular stage");
            print("8. Inform the user the name of the proyect with the most registered capsules");
            print("9. Inform the user if a collaborator (by inputing the name) has registered capsules in any proyect");
            print("10. Inform the user the situations and essons learned from the aproved and published capsules, according to a search chain given by himself");
            print("11. Exit");
        }

}


