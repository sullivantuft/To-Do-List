package org.example;

import java.util.Scanner;
public class TaskUpdater {
    private TaskManager taskManager;
    private Scanner scanner;

    //Constructor
    public TaskUpdater() {
        this.taskManager = new TaskManager();
        this.scanner = new Scanner(System.in);
    }
    //Function handles the user input of creating a task and calls the task manager to create the task
    public void addTask(){

        System.out.println("What is the name of the task?");
        String name = scanner.nextLine();
        System.out.println("What is the description of the task?");
        String description = scanner.nextLine();
        taskManager.addTask(name, description);

    }
    //Function handles the user input of removing a task
    public void removeTask(){
        taskManager.printTasks();
        System.out.println("What is the ID of the task you would like to remove?");
        int id = scanner.nextInt();
        taskManager.removeTask(id);
    }
    public void updateTask(){
        taskManager.printTasks();
        System.out.println("What is the ID of the task?");
        int id = scanner.nextInt();
        taskManager.markTaskCompleted(id);
    }
    public void printTasks(){
        taskManager.printTasks();
    }
}