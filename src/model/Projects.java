package model;
import utils.Utils;


public class Projects {

    private String name;
    private String client;
    private String datePlanedEnd;
    private String datePlannedBegin;
    private Double budget;
    private String [] clientManagerNames;
    private String [] clientManagerPhones;
    private String [] companyManagerNames;
    private String [] companyManagerPhones;
    private int stage=1; // the stage is 1 by default because the project begins in the beginning stage
    private String realDateBegin;
    private String realDateEnd;
    private int positionArray;
    private int activeStage;

    Capsules [][] Capsules = new Capsules [6][50];

    
    /*
     * This method is the constructor of the class Proyects
     * @param name is the name of the project
     * @param client is the name of the client
     * @param datePlanedEnd is the date when the project is planed to end
     * @param datePlannedBegin is the date when the project is planed to begin
     * @param budget is the budget of the project
     * @param nameManagerCompany is the name of the manager of the company
     * @param nameManagerClient is the name of the manager of the client
     * @param phoneManagerCompany is the phone number of the manager of the company
     * @param phoneManagerClient is the phone number of the manager of the client
     */
    public Projects(String name, String client, String datePlanedEnd, String datePlannedBegin, Double budget, String [] clientManagerNames, String [] clientManagerPhones, String [] companyManagerNames, String [] companyManagerPhones) {
        this.name = name;
        this.client = client;
        this.datePlanedEnd = datePlanedEnd;
        this.datePlannedBegin = datePlannedBegin;
        this.budget = budget;
        this.clientManagerNames = clientManagerNames;
        this.clientManagerPhones = clientManagerPhones;
        this.companyManagerNames = companyManagerNames;
        this.companyManagerPhones = companyManagerPhones;
        int [] monthsPerStage = new int [6];
        for (int i = 0; i < monthsPerStage.length; i++){
            Utils.print("Please enter the number of months for the stage " + (i+1));
            monthsPerStage[i] = Utils.validateIntInput();
            }
        Utils.print("The project " + name + " has been created");
    }

    /*
     * This method is used to culminate a stage of the project and to activate the next stage
     * @param realDateEnd is the real date when the stage ended
     */
    public void culminateStage(String realDateEnd){
        this.realDateEnd = realDateEnd;
        if (this.stage == 1){
            setStage(2);
            setStageActivation(2);
            Utils.print("The beginning stage was culminated succesfully on " + realDateEnd);
            Utils.print("Enter the real date of the beginning of the analysis stage");
            realDateBegin = Utils.input.next();
            Utils.print("The active stage is now the analysis stage");
        } else if (this.stage == 2){
            setStage(3);
            setStageActivation(3);
            Utils.print("The analysis stage was culminated succesfully on " + realDateEnd);
            Utils.print("Enter the real date of the beginning of the design stage");
            realDateBegin = Utils.input.next();
            Utils.print("The active stage is now the design stage");
        } else if (this.stage == 3){
            setStage(4);
            setStageActivation(4);
            Utils.print("The design stage was culminated succesfully on " + realDateEnd);
            Utils.print("Enter the real date of the beginning of the implementation stage");
            realDateBegin = Utils.input.next();
            Utils.print("The active stage is now the implementation stage");
        } else if (this.stage == 4){
            setStage(5);
            setStageActivation(5);
            Utils.print("The implementation stage was culminated succesfully on " + realDateEnd);
            Utils.print("Enter the real date of the beginning of the closing stage");
            realDateBegin = Utils.input.next();
            Utils.print("The active stage is now the closing stage");
        } else if (this.stage == 5){
            setStage(6);
            setStageActivation(6);
            Utils.print("The closing stage was culminated succesfully on " + realDateEnd);
            Utils.print("Enter the real date of the beginning of the follow up and control stage");
            realDateBegin = Utils.input.next();
            Utils.print("The active stage is now the follow up and control stage");
        } else if (this.stage == 6){
            Utils.print("The follow up and control stage was culminated succesfully on " + realDateEnd);
            Utils.print("The project has been culminated succesfully");
        } else {
            Utils.print("The stage entered is not valid");
        }
    }

    /*
     * This method is used to register a capsule in a stage of a project
     * @param positionArray is the position of the project in the array of projects
     * @param proyectName is the name of the project
     * @param stage is the stage where the capsule will be registered
     * @param type is the type of the capsule
     * @param identifier is the identifier of the capsule
     * @param description is the description of the capsule
     * @param collaboratorName is the name of the collaborator of the capsule
     * @param collaboratorPost is the post of the collaborator of the capsule
     * @param situation is the situation of the capsule
     * @param status is the status of the capsule
     */
    public void regCapsule(int positionArray, String proyectName, int stage, String type, String identifier, String description, String collaboratorName, String collaboratorPost, String situation, String status){

        // Make an array of stages that contains an array of capsules
        
        Capsules[stage][positionArray] = new Capsules(stage, type, identifier, description, collaboratorName, situation,status);
        Utils.print("The capsule has been registered succesfully, in the project " + proyectName + " in the stage " + stage + " and is ready to be aproved");
    }

    /*
     * This method is used to approve a capsule
     * @param identifier is the identifier of the capsule
     */
    public void aproveCapsule(String identifier, String aprovationDate){
    for (int s = 0; s < 6; s++){
        for (int i = 0; i < 50; i++){
            if (Capsules[s][i]!=null){
                if (Capsules[s][i].getIdentifier().equals(identifier)){
                    Capsules[s][i].setStatus("Aproved");
                    Utils.print("The capsule has been aproved succesfully on " + aprovationDate);
                } else {
                    Utils.print("The capsule has not been found");
                }
            }
        }
    }
    }

    /*
     * This method is used to publish a capsule
     * @param identifier is the identifier of the capsule
     */
    public void publishCapsule(String identifier){
        for (int s = 0; s < 6; s++){
            for (int i = 0; i < 50; i++){
                if (Capsules[s][i]!=null){
                    if (Capsules[s][i].getIdentifier().equals(identifier)){
                        if (Capsules[s][i].getStatus().equals("Aproved")){
                            Capsules[s][i].setStatus("Published");
                            Utils.print("The capsule has been published succesfully with the url: www.capsule.com/" + Capsules[s][i].getIdentifier() + ".html");
                         } else {
                            Utils.print("The capsule has not been aproved yet");
                         }
                } else {
                    Utils.print("The capsule has not been found");
                }
            }
            }
        }
    }

    public void getClientManagerNames(){
        for (int i = 0; i < clientManagerNames.length; i++){
            Utils.print(clientManagerNames[i]);
        }
    }

    public void getClientManagerPhones(){
        for (int i = 0; i < clientManagerPhones.length; i++){
            Utils.print(clientManagerPhones [i]);
        }
    }

    public void getCompanyManagerNames(){
        for (int i = 0; i < companyManagerNames.length; i++){
            Utils.print(companyManagerNames[i]);
        }
    }

    public void getCompanyManagerPhones(){
        for (int i = 0; i < companyManagerPhones.length; i++){
            Utils.print(companyManagerPhones[i]);
        }
    }

    public int getStageActivation(){
        return activeStage;
    }

    public void setStageActivation(int activeStage){
        this.activeStage = activeStage;
    }

    public int getStage(){
        return stage;
    }

    public void setStage(int stage){
        this.stage = stage;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getClient() {
        return client;
    }

    public void setClient(String client) {
        this.client = client;
    }

    public String getDatePlanedEnd() {
        return datePlanedEnd;
    }

    public void setDatePlanedEnd(String datePlanedEnd) {
        this.datePlanedEnd = datePlanedEnd;
    }

    public String getDatePlannedBegin() {
        return datePlannedBegin;
    }

    public void setDatePlannedBegin(String datePlannedBegin) {
        this.datePlannedBegin = datePlannedBegin;
    }

    public Double getBudget() {
        return budget;
    }

    public void setBudget(Double budget) {
        this.budget = budget;
    }


    public String getRealDateBegin() {
        return realDateBegin;
    }

    public void setRealDateBegin(String realDateBegin) {
        this.realDateBegin = realDateBegin;
    }

    public String getRealDateEnd() {
        return realDateEnd;
    }

    public void setRealDateEnd(String realDateEnd) {
        this.realDateEnd = realDateEnd;
    }

    public int getPositionArray() {
        return positionArray;
    }

    public void setPositionArray(int positionArray) {
        this.positionArray = positionArray;
    }

}
