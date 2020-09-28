package duke.tasklist;

import duke.tasklist.tasks.Task;

import java.util.ArrayList;

public class TaskList {

    private static ArrayList<Task> list;

    public TaskList() {
        list = new ArrayList<>();
    }

    public void addTask(Task task) {
        list.add(task);
    }

    public void removeTask(int index) {
        list.remove(index);
    }

    public Task getTask(int index) {
        return list.get(index);
    }

    public int size() {
        return list.size();
    }

    public ArrayList<Task> getAllTasks() {
        return list;
    }

}
