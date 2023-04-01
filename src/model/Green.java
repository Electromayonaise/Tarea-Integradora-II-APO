package model;
import utils.Utils;

public class Green {

    private String name; 
    private static Projects[] projectController= new Projects [10] ; // Proyects class

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

    public static void stageCulmination(String proyectName, String realDateEnd, int projectCounter){
        for (int i = 0; i <= projectCounter; i++) {
            if (projectController[i].getName().equals(proyectName)){
                projectController[i].culminateStage(realDateEnd);
            }
        }
    }

    public static void stageValidation(String proyectName, int stage, int projectCounter){
        for (int i = 0; i <= projectCounter; i++) {
            if (projectController[i].getName().equals(proyectName)){
                if (projectController[i].getStage() < stage){
                    Utils.print("The stage must be the current stage or a previous stage");
                    break;
                }
            }
        }
    }

    public static void registerCapsule(String proyectName, int stage, String type, String identifier, String description, String collaboratorName, String collaboratorPost, String situation, String status, int projectCounter){
        for (int positionArray = 0; positionArray <= projectCounter; positionArray++) {
            if (projectController[positionArray].getName().equals(proyectName)){
                projectController[positionArray].regCapsule( positionArray, proyectName,stage, type, identifier, description, collaboratorName, collaboratorPost, situation, status);
            }
        }
    }

    public static void aproveCapsule(String proyectName, String identifier, String aprovationDate, int projectCounter){
        for (int i = 0; i <= projectCounter; i++) {
            if (projectController[i].getName().equals(proyectName)){
                projectController[i].aproveCapsule(identifier, aprovationDate);
                break;
            }
        }
    }

    public static void publishCapsule(String proyectName, String identifier, int projectCounter){
        for (int i = 0; i <= projectCounter; i++) {
            if (projectController[i].getName().equals(proyectName)){
                projectController[i].publishCapsule(identifier);
                break;
            }
        }
    }



    public String getName() {
        return name;
    }




}
