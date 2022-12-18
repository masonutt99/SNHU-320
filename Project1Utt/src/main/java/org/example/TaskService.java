package org.example;

import java.util.ArrayList;
import java.util.List;

public class TaskService {

    private ArrayList<Task> tasks; //list of tasks

    public TaskService(){tasks = new ArrayList<>();}

    //The task service shall be able to add tasks with a unique ID.
    public void addTask(Task task) throws Exception{
        boolean exists = false;
        for (Task t:tasks){
            if (t.getTaskID().equals(task.getTaskID())){
                exists = true;
                break;
            }
        }
        if (exists){
            throw new Exception("Task with that ID already exists.");
        }else {
            tasks.add(task);
        }
    }

    //The task service shall be able to delete tasks per task ID.
    public void deleteTask(String ID) throws Exception {
        Task t = taskAtID(ID);
        tasks.remove(t);
    }

    //The task service shall be able to update task fields per task ID. The following fields are updatable:
    //Name
    //Description

    public void updateTaskName(String ID, String name) throws Exception {
        Task t = taskAtID(ID);
        t.setTaskName(name);
    }

    public void updateTaskDesc(String ID, String desc) throws Exception {
        Task t = taskAtID(ID);
        t.setTaskDescription(desc);
    }

    public Task taskAtID(String ID) throws Exception{
        for (Task t : tasks) {
            if (ID.equals(t.getTaskID())) {
                return t;
            }
        }
        throw new Exception("Task ID does not exist");
    }

    public List<Task> getList(){
        return tasks;
    }
}
