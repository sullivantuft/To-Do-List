package org.example;

import java.util.ArrayList;
import java.util.List;
public class TaskManager {
    private List<Task> tasks;
    private static int nextTaskID = 1;

    //Constructor: Returns loaded list or null if not found
    public TaskManager(){

        tasks= TaskStorage.loadTasks();
        if (tasks == null){
            tasks = new ArrayList<>();
            System.out.println("No tasks loaded");
        }
    }

    //Function is responsible for creating a task and adding it to the list of tasks
    public void addTask(String name, String description){
        Task task = new Task(nextTaskID, name, description, false);
        tasks.add(task);
        TaskStorage.saveTasks(tasks);
        System.out.println("Task successfully added");
        updateTaskIDs();
    }

    //Function is responsible for ensuring there is a task to remove and then removing the task
    public void removeTask(int id){
        boolean removed = tasks.removeIf(task -> task.getId() == id); //Checks if the task was removed
        if(removed){
            System.out.println("Task successfully removed");
            TaskStorage.saveTasks(tasks);
            updateTaskIDs();
        }
        else{
            System.out.println("Task not found");
        }
    }

    //This function is responsible for printing all tasks into the CLI
    public void printTasks(){
        //Ensures tasks are not empty
        if(tasks.isEmpty()){
            System.out.println("No tasks found");
            return;
        }
        System.out.println("Here is a list of all tasks:");
        for(Task task : tasks){
            String status = task.getCompleted() ? "Completed" : ""; //Ternary operator

            System.out.println(task.getId() + ": " + task.getName() + " - " + task.getDescription() + " - "+ status);
            }
    }

    //Function is responsible for marking tasks as completed
    public void markTaskCompleted(int id){
        for(Task task : tasks){
            if(task.getId() == id){
                task.setCompleted();
                TaskStorage.saveTasks(tasks);
                System.out.println("Task successfully completed");
                return;
            }
        }
        System.out.println("Task could not be marked as completed");
    }
    //Function is responsible for updating the ID of a task
    public void updateTaskIDs(){
        for(int i = 0; i < tasks.size(); i++){
            tasks.get(i).setId(i+1);
        }
    }

}