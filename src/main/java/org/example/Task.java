package org.example;

public class Task{
    private int id;
    private String name;
    private String description;
    private Boolean completed;

    public Task() {}
    public Task(int id, String name, String description, Boolean isCompleted){
        this.id = id;
        this.name = name;
        this.description = description;
        this.completed = false;
    }
    //Setters and Getters
    public int getId(){
        return id;
    }
    public String getName(){
        return name;
    }
    public String getDescription(){
        return description;
    }
    public Boolean getCompleted(){
        return completed;
    }
    public void setCompleted(){
        completed = true;
    }
    public void setId(int id){
        this.id = id;
    }
}