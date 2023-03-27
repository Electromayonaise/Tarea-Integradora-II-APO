package model;
import model.Capsules;
import java.util.Scanner;

public class Proyects {

    private String name;
    private String client;
    private String datePlanedEnd;
    private String datePlannedBegin;
    private Double budget;
    private String nameManagerCompany;
    private String nameManagerClient;
    private String phoneManagerCompany;
    private String phoneManagerClient;
    private int stage=1;
    private String realDateBegin;
    private String realDateEnd;
    private int positionArray;

    Capsules [] capsule = new Capsules [50];

    static void print(Object a) {
        System.out.println(a);
    }

    static Scanner input = new Scanner(System.in);
    

    public Proyects(String name, String client, String datePlanedEnd, String datePlannedBegin, Double budget, String nameManagerCompany, String nameManagerClient, String phoneManagerCompany, String phoneManagerClient) {
        this.name = name;
        this.client = client;
        this.datePlanedEnd = datePlanedEnd;
        this.datePlannedBegin = datePlannedBegin;
        this.budget = budget;
        this.nameManagerCompany = nameManagerCompany;
        this.nameManagerClient = nameManagerClient;
        this.phoneManagerCompany = phoneManagerCompany;
        this.phoneManagerClient = phoneManagerClient;
        int [] monthsPerStage = new int [6];
        for (int i = 0; i < monthsPerStage.length; i++){
            print("Please enter the number of months for the stage " + (i+1));
            monthsPerStage[i] = input.nextInt();
            }
        print("The project " + name + " has been created");

    }

    public void culminateStage(String realDateEnd){
        this.realDateEnd = realDateEnd;
        if (this.stage == 1){
            setStage(2);
            print("The beginning stage was culminated succesfully on " + realDateEnd);
            print("Enter the real date of the beginning of the analysis stage");
            realDateBegin = input.next();
        } else if (this.stage == 2){
            print("The analysis stage was culminated succesfully on " + realDateEnd);
            print("Enter the real date of the beginning of the design stage");
            realDateBegin = input.next();
        } else if (this.stage == 3){
            print("The design stage was culminated succesfully on " + realDateEnd);
            print("Enter the real date of the beginning of the implementation stage");
            realDateBegin = input.next();
        } else if (this.stage == 4){
            print("The implementation stage was culminated succesfully on " + realDateEnd);
            print("Enter the real date of the beginning of the closing stage");
            realDateBegin = input.next();
        } else if (this.stage == 5){
            print("The closing stage was culminated succesfully on " + realDateEnd);
            print("Enter the real date of the beginning of the follow up and control stage");
            realDateBegin = input.next();
        } else if (this.stage == 6){
            print("The follow up and control stage was culminated succesfully on " + realDateEnd);
            print("The project has been culminated succesfully");
        } else {
            print("The stage entered is not valid");
        }
    }

    public void regCapsule(int positionArray, String proyectName, int stage, String type, String identifier, String description, String collaboratorName, String collaboratorPost, String situation, String status){

        // Make an array of stages that contains an array of capsules
        Capsules [][] Capsules = new Capsules [6][50];
        Capsules[positionArray][stage] = new Capsules(stage, type, identifier, description, collaboratorName, situation,status);
        print("The capsule has been registered succesfully, in the project " + proyectName + " in the stage " + stage + "and is ready to be aproved");
    }


    public void aproveCapsule(String identifier){
        for (int i = 0; i < capsule.length; i++){
            if (capsule[i].getIdentifier().equals(identifier)){
                capsule[i].setStatus("Aproved");
                print("The capsule has been aproved succesfully");
            } else {
                print("The capsule has not been found");
            }
        }
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

    public String getNameManagerCompany() {
        return nameManagerCompany;
    }

    public void setNameManagerCompany(String nameManagerCompany) {
        this.nameManagerCompany = nameManagerCompany;
    }

    public String getNameManagerClient() {
        return nameManagerClient;
    }

    public void setNameManagerClient(String nameManagerClient) {
        this.nameManagerClient = nameManagerClient;
    }

    public String getPhoneManagerCompany() {
        return phoneManagerCompany;
    }

    public void setPhoneManagerCompany(String phoneManagerCompany) {
        this.phoneManagerCompany = phoneManagerCompany;
    }

    public String getPhoneManagerClient() {
        return phoneManagerClient;
    }

    public void setPhoneManagerClient(String phoneManagerClient) {
        this.phoneManagerClient = phoneManagerClient;
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
