package org.example;

public class Task {

    //Var declaration
    private String taskID;   //no longer than 10 char not null and not updatable
    private String taskName;   //no longer than 20 char not null
    private String taskDescription;    //no longer than 50 char not null

    //lengths
    private static final int IDLENGTH = 10;
    private static final int NAMELENGTH = 20;
    private static final int DESCRIPTIONLENGTH = 30;

    //constructor
    public Task(){
        this.taskID = "init";
        this.taskName = "init";
        this.taskDescription = "init";
    }

    public Task(String taskID, String taskName, String taskDescription){
        setTaskID(taskID);
        setTaskName(taskName);
        setTaskDescription(taskDescription);
    }

    public String getTaskDescription() {
        return taskDescription;
    }

    public void setTaskDescription(String taskDescription) {
        if (taskDescription == null) {
            throw new IllegalArgumentException("Task Description cannot be empty");
        }
        else if (taskDescription.length()>DESCRIPTIONLENGTH){
            throw new IllegalArgumentException("Task Description cannot be longer than " + DESCRIPTIONLENGTH + " chars");
        }
        else {
            this.taskDescription = taskDescription;
        }
    }

    public String getTaskName() {
        return taskName;
    }

    public void setTaskName(String taskName) {
        if (taskName == null) {
            throw new IllegalArgumentException("Task Name cannot be empty");
        }
        else if (taskName.length()>NAMELENGTH){
            throw new IllegalArgumentException("Task Name cannot be longer than " + NAMELENGTH + " chars");
        }
        else {
            this.taskName = taskName;
        }
    }

    public String getTaskID() {
        return taskID;
    }

    public void setTaskID(String taskID) {
        if (taskID == null) {
            throw new IllegalArgumentException("Task ID cannot be empty");
        }
        else if (taskID.length()>IDLENGTH){
            throw new IllegalArgumentException("Task ID cannot be longer than " + IDLENGTH + " chars");
        }
        else {
            this.taskID = taskID;
        }
    }
}
