// Make a menu that contains the following options: 1. Create a proyect 2. Culminate a stage of a proyect 3. Register a capsule 4. Aprove a capsule 5. Publish a capsule 
// 6. Inform the user the number of registered capsules by their type (tecnical, managment, domain, and experiences) 7. Inform the user a list of lerned lessons related to 
// the capsules registered in proyects on a particular stage 8. Inform the user the name of the proyect with the most registered capsules 9, Inform the user if a collaborator 
// (by inputing the name) has registered capsules in any proyect 10. Inform the user the situations and essons learned from the aproved and published capsules, according to a search
// chain given by himself 11. Exit
package ui;
import model.Projects;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import utils.Utils;


/*  
 * This class is the main class of the program, it contains the main method and the menu of the program
 */
public class GreenSQASystem {

        private static String proyectName = "";
    /* 
     * This method abreviates the System.out.println() to print()
     * @param a is the object that will be printed
    */

    public static Calendar calendar = Calendar.getInstance();

    private static Projects[] projectController; // Proyects class

    /*
     * This is the main method of the program, it contains the menu switch and the options of the menu
    */
    public static void main (String [] args){
        int option;
        do {
            menu();
            option = Utils.input.nextInt();
            projectController = new Projects[10];
            switch (option){
                
                // Proyect creation: needs name of the proyect, name of the client, date planed for the beginning of the proyect, date planed for the end of the proyect, 
                // the value of the budget, and the name and corresponding phone number of the proyect managers from boath sides (client and company). When the proyect is created
                // it is automatically set to the first stage (1) (out of the 6 stages that a proyect can have: 1. Beginning, 2. Analysis, 3. Design, 4. Implementation, 5. Closing, 6. Follow up and control of the proyect)
                // each stage has a planned date for the begining and end, and a real date for the begining and end. For asigning the planned dates, the user must enter the 
                // number of months that each stage will take (array of 6 positions, each position is a stage, and the value is the number of months that the stage will take)


                case 1:
                    
                    String answer = "Y";
                    int projetCounter = 0;
                    do { 

                        projetCounter+=-1;
                        Utils.print("Please enter the name of the proyect");
                        proyectName = Utils.input.next();
                        Utils.print("Please enter the name of the client");
                        String clientName = Utils.input.next();
                        Utils.print("Please enter the date planed for the beginning of the proyect (YYYY/MM/DD)");
                        String datePlanedBegin = Utils.input.next();
                        Utils.print("Please enter the date planed for the end of the proyect (YYYY/MM/DD)");
                        String datePlanedEnd = Utils.input.next();
                        Utils.print("Please enter the value of the budget");
                        double budget = Utils.validateDoubleInput();
                        Utils.print("Please enter the number of managers from the client side");
                        int clientManagers = Utils.validateIntInput();
                        Utils.print("Please enter the number of managers from the company side");
                        int companyManagers = Utils.validateIntInput();
                        // Create the arrays for the names and phone numbers of the managers from both sides
                        String[] clientManagerNames = new String[clientManagers];
                        String[] clientManagerPhones = new String[clientManagers];
                        String[] companyManagerNames = new String[companyManagers];
                        String[] companyManagerPhones = new String[companyManagers];
                        // Ask the user for the names and phone numbers of the managers from both sides
                        for (int j = 0; j < clientManagers; j++) {
                            Utils.print("Please enter the name of the manager number " +(j+1)+ " from the client side");
                            clientManagerNames[j] = Utils.input.next();
                            Utils.print("Please enter the phone number of the manager number " +(j+1)+ " from the client side");
                            clientManagerPhones[j] = Utils.input.next();
                        }
                        for (int j = 0; j < companyManagers; j++) {
                            Utils.print("Please enter the name of the manager number " +(j+1)+ " from the company side");
                            companyManagerNames[j] = Utils.input.next();
                            Utils.print("Please enter the phone number of the manager number " +(j+1)+ "from the company side");
                            companyManagerPhones[j] = Utils.input.next();
                        }
                        // Create the proyect
                        projectController[projetCounter] = new Projects(proyectName, clientName, datePlanedBegin, datePlanedEnd, budget, clientManagerNames, clientManagerPhones, companyManagerNames, companyManagerPhones);
                        Utils.print("Do you want to create another proyect? (Y/N)");
                        answer = Utils.input.next();
                        answer = answer.toUpperCase();
                        if (answer.equals("Y")){
                            continue;
                        } else {
                            Utils.print("The proyects created are:");
                            for (int j = 0; j <= projetCounter; j++) {
                                Utils.print(projectController[j].getName());
                            }
                            main(args);
                        }
                        break;
                    } while (answer.equals("Y")||projetCounter==10);
                //  Culminate a stage of a proyect: Stage culmination is done by registering the aprovement of the stage by the client, and the real date of the end of the stage. 
                // The user must enter the name of the proyect, the stage that he wants to culminate, and the real date of the end of the stage, as well as the real date of the beginning of the new stage
                case 2:
                    // Check if there is any existing proyect to culminate a stage
                    if (projectController[0] == null){
                        Utils.print("There are no proyects to culminate a stage");
                        break;
                    }
                    Utils.print("Please enter the name of the proyect");
                    proyectName = Utils.input.next();
                    String realDateEnd = new SimpleDateFormat("dd/MM/yyyy").format(calendar.getTime());
                    for (int i = 0; i <= 10; i++) {
                        if (projectController[i].getName().equals(proyectName)){
                            projectController[i].culminateStage(realDateEnd);
                        }
                    }
                    break;
                // Register a capsule: The user must enter the name of the proyect, the stage in which the capsule will be registered, the type of capsule (tecnical, managment, domain, or experiences),
                // a unique identifier, a description of the capsule, the name of the collaborator who registered the capsule, the date of the capsule, and the situation and lesson learned from the capsule
                // the inputed text on the description must have the keywords between hashtags (#) related to an atributte of the capsules called "tags"
                case 3:

                    // Check if there is any existing proyect to register a capsule
                    if (projectController[0] == null){
                        Utils.print("There are no proyects to register a capsule");
                        break;
                    }
                    Utils.print("Please enter the name of the proyect");
                    proyectName = Utils.input.next();
                    Utils.print("Please enter the stage in which the capsule will be registered");
                    int stage = Utils.validateIntInput();
                    if (stage > 6 || stage < 1){
                        Utils.print("The stage must be between 1 and 6");
                        break;
                    }
                    for (int i = 0; i <= 10; i++) {
                        if (projectController[i].getName().equals(proyectName)){
                            if (projectController[i].getStage() < stage){
                                Utils.print("The stage must be the current stage or a previous stage");
                                break;
                            }
                        }
                    }
                    Utils.print("Please enter the type of capsule (tecnical, managment, domain, or experiences)");
                    String type = Utils.input.next();
                    Utils.print("Please enter a unique identifier");
                    String identifier = Utils.input.next();
                    Utils.print("Please enter a description of the capsule that contains the kwywords between hashtags (#)");
                    String description = Utils.input.next();
                    Utils.print("Please enter the name of the collaborator who registered the capsule");
                    String collaboratorName = Utils.input.next();
                    Utils.print("Please enter the post of the collaborator who registered the capsule");
                    String collaboratorPost = Utils.input.next();
                    Utils.print("Please enter the situation and lesson learned from the capsule");
                    String situation = Utils.input.next();
                    String status="Pending";
                    for (int positionArray = 0; positionArray <= 10; positionArray++) {
                        if (projectController[positionArray].getName().equals(proyectName)){
                            projectController[positionArray].regCapsule( positionArray, proyectName,stage, type, identifier, description, collaboratorName, collaboratorPost, situation, status);
                        }
                    }
                    break;
                // Aprove a capsule: The user must enter the name of the proyect, and the unique identifier of the capsule that he wants to aprove, 
                //then the status of the capsule will change to "Aproved"
                case 4:
                    // Check if there is any existing proyect to aprove a capsule
                    if (projectController[0] == null){
                        Utils.print("There are no proyects to aprove a capsule");
                        break;
                    }
                    Utils.print("Please enter the name of the proyect");
                    proyectName = Utils.input.next();
                    Utils.print("Please enter the unique identifier of the capsule that you want to aprove");
                    identifier = Utils.input.next();
                    // Give the identifier to the method aproveCapsule in the class Proyects
                    for (int i = 0; i < 10; i++) {
                        if (projectController[i].getName().equals(proyectName)){
                            projectController[i].aproveCapsule(identifier);
                            break;
                        }
                    }
                    break;
                
                // Publish a capsule: The user must enter the name of the proyect, and the unique identifier of the capsule that he wants to publish,
                // then same as the last case, the status of the capsule will change to "Published"
                case 5:
                    // Check if there is any existing proyect to publish a capsule
                    if (projectController[0] == null){
                        Utils.print("There are no proyects to publish a capsule");
                        break;
                    }
                    Utils.print("Please enter the name of the proyect");
                    proyectName = Utils.input.next();
                    Utils.print("Please enter the unique identifier of the capsule that you want to publish");
                    identifier = Utils.input.next();
                    // Give the identifier to the method publishCapsule in the class Proyects if the capsule is aproved
                    for (int i = 0; i <= 10; i++) {
                        if (projectController[i].getName().equals(proyectName)){
                            projectController[i].publishCapsule(identifier);
                            break;
                        }
                    }
                    break;


            }
    
        } while (option != 11);
    }

        public static void menu (){
            Utils.print("Welcome to the GreenSQA system, please select the option you want to use");
            Utils.print("1. Create a proyect");
            Utils.print("2. Culminate a stage of a proyect");
            Utils.print("3. Register a capsule");
            Utils.print("4. Aprove a capsule");
            Utils.print("5. Publish a capsule");
            Utils.print("6. Inform the user the number of registered capsules by their type (tecnical, managment, domain, and experiences)");
            Utils.print("7. Inform the user a list of lerned lessons related to the capsules registered in proyects on a particular stage");
            Utils.print("8. Inform the user the name of the proyect with the most registered capsules");
            Utils.print("9. Inform the user if a collaborator (by inputing the name) has registered capsules in any proyect");
            Utils.print("10. Inform the user the situations and lessons learned from the aproved and published capsules, according to a search chain given by himself cointained by the hashtags (#)");
            Utils.print("11. Exit");
        }


}


