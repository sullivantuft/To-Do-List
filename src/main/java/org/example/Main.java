package org.example;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        //Initializes menu, taskUpdater class and scanner
        boolean menu = true;
        TaskUpdater updater = new TaskUpdater();
        Scanner input = new Scanner(System.in);
        //Menu system that handles input and ensures valid integer input
        while (menu) {
            System.out.println("To-Do List Application");
            System.out.println("1. Add Task");
            System.out.println("2. Delete Task");
            System.out.println("3. Update Task");
            System.out.println("4. Display all tasks");
            System.out.println("5. Exit");

            int option = getValidInteger(input);
            switch (option) {
                case 1:
                    updater.addTask();
                    break;
                case 2:
                    updater.removeTask();
                    break;
                case 3:
                    updater.updateTask();
                    break;
                case 4:
                    updater.printTasks();
                    break;
                case 5:
                    menu = false;
                    break;
            }

        }
    }
    //Function is responsible for verifying valid input
    private static int getValidInteger(Scanner scanner){
        while(!scanner.hasNextInt()){
            System.out.println("Please enter a valid integer");
            scanner.next();
        }
        return scanner.nextInt();
    }
}