package org.example;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.File;
import java.io.IOException;
import java.util.List;


public class TaskStorage {
    private static final String TASKS_FILE = "tasks.json"; //Content declaration

    //Function is responsible for savings tasks to a JSON file
    public static void saveTasks(List<Task> tasks) {
        try{
            ObjectMapper mapper = new ObjectMapper(); //ObjectMapper class used to read/write JSON
            mapper.writeValue(new File(TASKS_FILE), tasks); //Serializes the tasks list into JSON format
            System.out.println("Tasks saved");
        }
        catch(IOException e){
            System.out.println("Error saving tasks: " + e.getMessage());
        }
    }

    //Function is responsible for loading the tasks from a JSON file
    public static List<Task> loadTasks() {

        try{
            ObjectMapper mapper = new ObjectMapper();
            File file = new File(TASKS_FILE); //Creates a file object for where the files are saved.
            if(file.exists()){
                return mapper.readValue(file, mapper.getTypeFactory().constructCollectionType(List.class, Task.class)); //Reads tasks from file

            }
        }
        catch(IOException e){
            System.out.println("Error loading tasks: " + e.getMessage());
        }
        return null;
    }

}
