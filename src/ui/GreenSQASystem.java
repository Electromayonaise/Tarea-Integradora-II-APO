// Make a menu that contains the following options: 1. Create a proyect 2. Culminate a stage of a proyect 3. Register a capsule 4. Aprove a capsule 5. Publish a capsule 
// 6. Inform the user the number of registered capsules by their type (tecnical, managment, domain, and experiences) 7. Inform the user a list of lerned lessons related to 
// the capsules registered in proyects on a particular stage 8. Inform the user the name of the proyect with the most registered capsules 9, Inform the user if a collaborator 
// (by inputing the name) has registered capsules in any proyect 10. Inform the user the situations and essons learned from the aproved and published capsules, according to a search
// chain given by himself 11. Exit
package ui;
import model.Green;
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

    private static Green[] greenController=new Green[10]; // Proyects class

    private static int projectCounter = 0; // Counter for the number of proyects created

    private static String answer = "";

    /*
     * This is the main method of the program, it contains the menu switch and the options of the menu
    */
    public static void main (String [] args){
        int option;
        do {
            menu();
            option = Utils.input.nextInt();
            switch (option){
                // Proyect creation: needs name of the proyect, name of the client, date planed for the beginning of the proyect, date planed for the end of the proyect, 
                // the value of the budget, and the name and corresponding phone number of the proyect managers from boath sides (client and company). When the proyect is created
                // it is automatically set to the first stage (1) (out of the 6 stages that a proyect can have: 1. Beginning, 2. Analysis, 3. Design, 4. Implementation, 5. Closing, 6. Follow up and control of the proyect)
                // each stage has a planned date for the begining and end, and a real date for the begining and end. For asigning the planned dates, the user must enter the 
                // number of months that each stage will take (array of 6 positions, each position is a stage, and the value is the number of months that the stage will take)
                case 1:
                    projectCreation();
                    break;
                //  Culminate a stage of a proyect: Stage culmination is done by registering the aprovement of the stage by the client, and the real date of the end of the stage. 
                // The user must enter the name of the proyect, the stage that he wants to culminate, and the real date of the end of the stage, as well as the real date of the beginning of the new stage
                case 2:
                    // Check if there is any existing proyect to culminate a stage
                    if (greenController[0] == null){
                        Utils.print("There are no proyects to culminate a stage");
                        break;
                    }
                    stageCulmination();
                    break;
                // Register a capsule: The user must enter the name of the proyect, the stage in which the capsule will be registered, the type of capsule (tecnical, managment, domain, or experiences),
                // a unique identifier, a description of the capsule, the name of the collaborator who registered the capsule, the date of the capsule, and the situation and lesson learned from the capsule
                // the inputed text on the description must have the keywords between hashtags (#) related to an atributte of the capsules called "tags"
                case 3:

                    // Check if there is any existing proyect to register a capsule
                    if (greenController[0] == null){
                        Utils.print("There are no proyects to register a capsule");
                        break;
                    }
                    registerCapsule();
                    break;
                // Aprove a capsule: The user must enter the name of the proyect, and the unique identifier of the capsule that he wants to aprove, 
                //then the status of the capsule will change to "Aproved"
                case 4:
                    // Check if there is any existing proyect to aprove a capsule
                    if (greenController[0] == null){
                        Utils.print("There are no proyects to aprove a capsule");
                        break;
                    }
                    capsuleAprobation();
                    break;
                
                // Publish a capsule: The user must enter the name of the proyect, and the unique identifier of the capsule that he wants to publish,
                // then same as the last case, the status of the capsule will change to "Published"
                case 5:
                    // Check if there is any existing proyect to publish a capsule
                    if (greenController[0] == null){
                        Utils.print("There are no proyects to publish a capsule");
                        break;
                    }
                    capsulePublishing();
                    break;

                case 6:
                    // Check if there is any existing proyect to count the number of capsules
                    if (greenController[0] == null){
                        Utils.print("There are no proyects to count the number of capsules");
                        break;
                    }
                    capsuleTypeCounterPerProject();
                    break;
                
                case 7:
                    // Check if there is any existing proyect to create a list of lessons learned
                    if (greenController[0] == null){
                        Utils.print("There are no proyects to create a list of lessons learned");
                        break;
                    }
                    lessonsLearnedList();
                    break;
                
                case 8:
                    // Check if there is any existing proyect to inform the proyect with the most capsules
                    if (greenController[0] == null){
                        Utils.print("There are no proyects to inform the proyect with the most capsules");
                        break;
                    }
                    projectWithMostCapsules();
                    break;

                case 9:
                    // Check if there is any existing proyect to search a collaborator
                    if (greenController[0] == null){
                        Utils.print("There are no proyects to search a collaborator");
                        break;
                    }
                    searchIfCollaboratorCapsules();
                    break;
                
                case 10:
                    // Check if there is any existing proyect to inform the situations and lessons learned from published capsules
                    if (greenController[0] == null){
                        Utils.print("There are no proyects to inform the situations and lessons learned from published capsules");
                        break;
                    }
                    searchByString();
                    break;
                default:
                    Utils.print("Please enter a valid option");
                    break;
            }
    
        } while (option != 11);
    }
    /*
     * This method contains the menu of the program
     */
        public static void menu (){
            Utils.print("Welcome to the GreenSQA system, please select the option you want to use");
            Utils.print("1. Create a proyect");
            Utils.print("2. Culminate a stage of a project");
            Utils.print("3. Register a capsule");
            Utils.print("4. Aprove a capsule");
            Utils.print("5. Publish a capsule");
            Utils.print("6. How many capsules of each type are registered on a project");
            Utils.print("7. Create a list of lessons learned from all the projects in a particular stage");
            Utils.print("8. What is the project with the most capsules registered");
            Utils.print("9. Search if a determined collaborator has registered a capsule in any project");
            Utils.print("10. Situations and lessons learned from published capsules by inputing a search string");
            Utils.print("11. Exit");
        }

    /*
     * This method creates a proyect, it asks the user for the name of the proyect, the name of the client, the date planed for the beginning of the proyect, the date planed for the end of the proyect, 
     * the value of the budget, and the name and corresponding phone number of the proyect managers from boath sides (client and company). When the proyect is created by calling the Green constructor
     *  it asks the user wether he wants to create another proyect or not
     */
        public static void projectCreation (){
            do{
                Utils.print("Please enter the name of the project");
                proyectName = Utils.input.next();
                Utils.print("Please enter the name of the client");
                String clientName = Utils.input.next();
                Utils.print("Please enter the date planed for the beginning of the project (YYYY/MM/DD)");
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
                greenController[projectCounter] = new Green(clientManagers, companyManagers, proyectName, clientName, datePlanedBegin, datePlanedEnd, budget, projectCounter);
                Utils.print("Do you want to create another proyect? (Y/N)");
                answer = Utils.input.next();
                answer = answer.toUpperCase();
                if (answer.equals("Y")){
                    projectCounter++;
                    continue;
                } else {
                    Utils.print("The projects created are:");
                    for (int j = 0; j <= projectCounter; j++) {
                        if (greenController[j]!=null){
                            Utils.print(greenController[j].getName());
                        }
                    }
                    break;
                }
            } while (answer.equals("Y")||projectCounter==10);
        }

        /*
         * This method culminates a stage of a proyect, it asks the user for the name of the proyect, the stage that he wants to culminate, the real date for the end
         * of the stage is set to the current date. Then it calls the method stageCulmination from the Green class
         */
        public static void stageCulmination (){
            Utils.print("Please enter the name of the proyect");
            proyectName = Utils.input.next();
            String realDateEnd = new SimpleDateFormat("dd/MM/yyyy").format(calendar.getTime());
            Green.stageCulmination(proyectName, realDateEnd, projectCounter); 
        }

        /*
         * This method registers a capsule, it asks the user for the name of the proyect, the stage in which the capsule will be registered, the type of capsule (tecnical, managment, domain, or experiences),
         * a unique identifier, a description of the capsule, the name of the collaborator who registered the capsule, the date of the capsule, and the situation and lesson learned from the capsule
         * the inputed text on the lesson must have the keywords between hashtags (#) 
         */
        public static void registerCapsule(){
            Utils.print("Please enter the name of the proyect");
            proyectName = Utils.input.next();
            Utils.print("Please enter the stage in which the capsule will be registered");
            int stage = Utils.validateStageInput();
            Green.stageValidation(proyectName, stage, projectCounter);
            Utils.print("Please enter the type of capsule (tecnical, managment, domain, or experiences)");
            String type = Utils.validateCapsuleType();
            Utils.print("Please enter a unique identifier");
            String identifier = Utils.input.next();
            Utils.print("Please enter a description of the capsule");
            String description = Utils.input.next();
            Utils.print("Please enter the name of the collaborator who registered the capsule");
            String collaboratorName = Utils.input.next();
            Utils.print("Please enter the post of the collaborator who registered the capsule");
            String collaboratorPost = Utils.input.next();
            Utils.print("Please enter the situation and lesson learned from the capsule that contains the kwywords between hashtags (#)");
            String situation = Utils.validateHashtag();
            String status="Pending";
            Green.registerCapsule(proyectName, stage, type, identifier, description, collaboratorName, collaboratorPost, situation, status, projectCounter);
        }

        /*
         * This method aproves a capsule, it asks the user for the name of the proyect and the unique identifier of the capsule that he wants to aprove, the date of the aproval is set to the current date
         */
        public static void capsuleAprobation(){
            Utils.print("Please enter the name of the proyect");
            proyectName = Utils.input.next();
            Utils.print("Please enter the unique identifier of the capsule that you want to aprove");
            String identifier = Utils.input.next();
            // Give the identifier to the method aproveCapsule in the class Proyects
            String aprovationDate = new SimpleDateFormat("dd/MM/yyyy").format(calendar.getTime());
            Green.aproveCapsule(proyectName, identifier, aprovationDate, projectCounter);
        }

        /*
         * This method publishes a capsule, it asks the user for the name of the proyect and the unique identifier of the capsule that he wants to publish
         */
        public static void capsulePublishing(){
            Utils.print("Please enter the name of the proyect");
            proyectName = Utils.input.next();
            Utils.print("Please enter the unique identifier of the capsule that you want to publish");
            String identifier = Utils.input.next();
            // Give the identifier to the method publishCapsule in the class green if the capsule is aproved
            Green.publishCapsule(proyectName,identifier, projectCounter);
        }

        /*
         * This method asks the user for the name of the project, then ir calls the method capsuleTypeCounterPerProject from the Green class
         */
        public static void capsuleTypeCounterPerProject(){
            Utils.print("Please enter the name of the proyect");
            proyectName = Utils.input.next();
            Green.capsuleTypeCounterPerProject(proyectName, projectCounter);
        }

        /*
         * This method asks the user for the stage of wich he wants to see the lessons learned in all the projects, then it calls the method lessonsLearnedList from the Green class
        */
        public static void lessonsLearnedList(){
            Utils.print("Please enter the stage of wich you want to see the lessons learned in all the projects");
            int stage = Utils.validateStageInput();
            Green.lessonsLearnedList(stage, projectCounter);
        }

        /*
         * This method directly calls the method projectWithMostCapsules from the Green class
         */
        public static void projectWithMostCapsules(){
            if (projectCounter==0){
                Utils.print("There is only one project, so it is the one with the most capsules, with the name " + greenController[0].getName());
            } else {
                Green.projectWithMostCapsules(projectCounter);
            }
        }

        /*
         * This method asks the user for the name of the collaborator, then it calls the method searchIfCollaboratorCapsules from the Green class
         */
        public static void searchIfCollaboratorCapsules(){
            Utils.print("Please enter the name of the collaborator");
            String collaboratorName = Utils.input.next();
            Green.searchIfCollaboratorCapsules(collaboratorName, projectCounter);
        }

        /*
         * This method asks the user for the keywords to be searched, then sends the inputed string to the method searchByString from the Green class
         */
        public static void searchByString(){
            Utils.print("Please enter the search string, by including keywords");
            String searchString = Utils.input.next();
            Green.searchByString(searchString, projectCounter);
        }
    }









