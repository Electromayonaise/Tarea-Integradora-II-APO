package model;

public class Capsules {

    

    private int stage;
    private String type;
    private String identifier;
    private String description;
    private String collaboratorName;
    private String situation;
    private String status;


    public Capsules(int stage, String type, String identifier, String description, String collaboratorName, String situation, String status) {
        this.stage = stage;
        this.type = type;
        this.identifier = identifier;
        this.description = description;
        this.collaboratorName = collaboratorName;
        this.situation = situation;
        this.status = status;
    }

    public int getStage() {
        return stage;
    }

    public void setStage(int stage) {
        this.stage = stage;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getIdentifier() {
        return identifier;
    }

    public void setIdentifier(String identifier) {
        this.identifier = identifier;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCollaboratorName() {
        return collaboratorName;
    }

    public void setCollaboratorName(String collaboratorName) {
        this.collaboratorName = collaboratorName;
    }

    public String getSituation() {
        return situation;
    }

    public void setSituation(String situation) {
        this.situation = situation;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
    




    
}
