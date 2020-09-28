package duke.tasklist;

import duke.tasklist.tasks.Task;

import java.util.ArrayList;

/**
 * Represents the entire tasks in Duke. Contains the data of the Task List.
 */
public class TaskList {

    private static ArrayList<Task> list;

    /**
     * Creates an empty Task List.
     */
    public TaskList() {
        list = new ArrayList<>();
    }

    /**
     * Adds a task to Task List.
     */
    public void addTask(Task task) {
        list.add(task);
    }

    /**
     * Removes a task from the Task List.
     */
    public void removeTask(int index) {
        list.remove(index);
    }

    /**
     * Returns the task in the Task List base on the index.
     *
     * @param index Position of the task.
     * @return Task object.
     */
    public Task getTask(int index) {
        return list.get(index);
    }

    /**
     * Returns the size of the TaskList ArrayList.
     *
     * @return Current size of the ArrayList.
     */
    public int size() {
        return list.size();
    }

    /**
     * Returns the entire list.
     *
     * @return ArrayList of Task.
     */
    public ArrayList<Task> getAllTasks() {
        return list;
    }
}
