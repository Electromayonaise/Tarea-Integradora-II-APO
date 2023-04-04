package model;
import utils.Utils;

public class Green {

    private String name; 
    private static Projects[] projectController= new Projects [10] ; // Proyects class array

    /*
     * Constructor for the Green class that creates a new project by calling the constructor of the Projects class
     * @param clientManagers number of managers from the client side
     * @param companyManagers number of managers from the company side
     * @param proyectName name of the project
     * @param clientName name of the client
     * @param datePlanedBegin date when the project is planed to begin
     * @param datePlanedEnd date when the project is planed to end
     * @param budget budget of the project
     * @param projectCounter number of projects created
     */
    public Green( int clientManagers, int companyManagers, String proyectName, String clientName, String datePlanedBegin, String datePlanedEnd, double budget, int projectCounter) {
        this.name = proyectName;
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
            Utils.print("Please enter the phone number of the manager number " +(j+1)+ " from the company side");
            companyManagerPhones[j] = Utils.input.next();
        }
        // Create the proyect
        projectController[projectCounter] = new Projects(proyectName, clientName, datePlanedBegin, datePlanedEnd, budget, clientManagerNames, clientManagerPhones, companyManagerNames, companyManagerPhones);
        
    }

    /*
     * Method that calls the stage culmination method from the Projects class after it finds the project
     * @param proyectName name of the project
     * @param realDateEnd real date when the project ended
     * @param projectCounter number of projects created
     */
    public static void stageCulmination(String proyectName, String realDateEnd, int projectCounter){
        for (int i = 0; i <= projectCounter; i++) {
            if (projectController[i].getName().equals(proyectName)){
                projectController[i].culminateStage(realDateEnd);
            }
        }
    }


    /*
     * Method that validates the given stage is the current stage or a previous stage
     * @param proyectName name of the project
     * @param stage stage to validate
     * @param projectCounter number of projects created
     */
    public static int stageValidation(String proyectName, int stage, int projectCounter){
        for (int i = 0; i <= projectCounter; i++) {
            if (projectController[i].getName().equals(proyectName)){
                while (projectController[i].getStage() < stage){
                    Utils.print("The stage must be the current stage or a previous stage");
                    stage = Utils.input.nextInt();
                }
            }
        }
        return stage;
    }

    /*
     * Method that calls the register capsule method from the Projects class after it finds the project
     * @param proyectName name of the project
     * @param stage stage of the capsule
     * @param type type of the capsule
     * @param identifier identifier of the capsule
     * @param description description of the capsule
     * @param collaboratorName name of the collaborator
     * @param collaboratorPost post of the collaborator
     * @param situation situation of the capsule
     * @param status status of the capsule
     * @param projectCounter number of projects created
     */
    public static void registerCapsule(String proyectName, int stage, String type, String identifier, String description, String collaboratorName, String collaboratorPost, String situation, String status, int projectCounter){
        for (int positionArray = 0; positionArray <= projectCounter; positionArray++) {
            if (projectController[positionArray].getName().equals(proyectName)){
                projectController[positionArray].regCapsule( positionArray, proyectName,stage, type, identifier, description, collaboratorName, collaboratorPost, situation, status);
            }
        }
    }

    /*
     * Method that calls the approve capsule method from the Projects class after it finds the project
     * @param proyectName name of the project
     * @param identifier identifier of the capsule
     * @param aprovationDate date when the capsule was approved
     * @param projectCounter number of projects created
     */
    public static void aproveCapsule(String proyectName, String identifier, String aprovationDate, int projectCounter){
        for (int i = 0; i <= projectCounter; i++) {
            if (projectController[i].getName().equals(proyectName)){
                projectController[i].aproveCapsule(identifier, aprovationDate);
                break;
            }
        }
    }

    /*
     * Method that calls the publish capsule method from the Projects class after it finds the project
     * @param proyectName name of the project
     * @param identifier identifier of the capsule
     * @param projectCounter number of projects created
     */
    public static void publishCapsule(String proyectName, String identifier, int projectCounter){
        for (int i = 0; i <= projectCounter; i++) {
            if (projectController[i].getName().equals(proyectName)){
                projectController[i].publishCapsule(identifier);
                break;
            }
        }
    }

    /*
     * Method that calls the capsule type counter method from the Projects class after it finds the project
     * @param proyectName name of the project
     * @param projectCounter number of projects created
     */
    public static void capsuleTypeCounterPerProject(String proyectName, int projectCounter){
        for (int i = 0; i <= projectCounter; i++) {
            if (projectController[i].getName().equals(proyectName)){
                projectController[i].capsuleTypeCounterPerProject();
                break;
            }
        }
    }

    /*
     * Method that calls the capsule lessons learned method from the Projects class for each project created
     * @param stage stage of which the user wishes to know lessons of
     * @param projectCounter number of projects created
     */
    public static void lessonsLearnedList(int stage, int projectCounter){
        for (int i = 0; i <= projectCounter; i++) {
            projectController[i].lessonsLearnedList(stage);
        }
    }

    /*
     * This method finds the project with the most capsules created by calling the getNumberOfCapsules method from the Projects class for each project created
     * @param projectCounter number of projects created
     */
    public static void projectWithMostCapsules(int projectCounter){
        int[] capsulesPerProject = new int[projectCounter];
        for (int i = 0; i <= projectCounter; i++) {
            capsulesPerProject[i] = projectController[i].getNumberOfCapsules();
        }
        int max = capsulesPerProject[0];
        int position = 0;
        for (int i = 0; i < capsulesPerProject.length; i++) {
            if (capsulesPerProject[i] > max){
                max = capsulesPerProject[i];
                position = i;
            }
        }
        Utils.print("The project with the most capsules is " +projectController[position].getName()+ " with " +max+ " capsules");
    }

    /*
     * This method calls the searchIfCollaboratorCapsules method from the Projects class for each project created
     * @param collaboratorName name of the collaborator
     * @param projectCounter number of projects created
     */
    public static void searchIfCollaboratorCapsules(String collaboratorName, int projectCounter){
        for (int i = 0; i <= projectCounter; i++) {
            String projectName=projectController[i].getName();
            projectController[i].searchIfCollaboratorCapsules(collaboratorName, projectName );
        }
    }

    /*
     * This method calls the searchByString method from the Projects class for each project created
     * @param searchString string to search
     * @param projectCounter number of projects created
     */
    public static void searchByString(String searchString, int projectCounter){
        for (int i = 0; i <= projectCounter; i++) {
            String projectName=projectController[i].getName();
            projectController[i].searchByString(searchString, projectName);
        }
    }

    public String getName() {
        return name;
    }




}
