package duke.storage;

import duke.tasklist.tasks.Deadline;
import duke.tasklist.tasks.Event;
import duke.tasklist.TaskList;
import duke.tasklist.tasks.Todo;
import duke.ui.TextUi;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.FileWriter;
import java.time.LocalDate;
import java.util.Scanner;


public class Storage {
    private static final String DONE_TRUE = "1";
    private static final String FILE_NAME = "duke.txt";
    private static final String FILE_DIRECTORY = "data";
    private static final String DEFAULT_FILE_PATH = "data/duke.txt";
    private static File file;

    public Storage() {
        try {
            createFile();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void createFile() throws FileNotFoundException {
        file = new File(DEFAULT_FILE_PATH);
        if (!file.exists()) {
            try {
                if (!file.getParentFile().exists()) {
                    file.getParentFile().mkdirs();
                }
                file.createNewFile();
                TextUi.printLines();
                System.out.println("New file created at: " + file.getAbsolutePath());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public void loadSavedFile(TaskList taskList) throws FileNotFoundException {
        Scanner s = new Scanner(file);
        while (s.hasNext()) {
            String line = s.nextLine();
            String[] task = line.split("\\|");
            switch (task[0].trim()) {
            case Todo.TODO_CATEGORY:
                taskList.addTask(new Todo(task[2].trim()));
                taskList.getTask((taskList.size()) - 1).setIsDone(convertIsDone(task[1].trim()));
                break;
            case Event.EVENT_CATEGORY:
                taskList.addTask(new Event(task[2].trim(), task[3].trim()));
                taskList.getTask((taskList.size()) - 1).setIsDone(convertIsDone(task[1].trim()));
                break;
            case Deadline.DEADLINE_CATEGORY:
                taskList.addTask(new Deadline(task[2].trim(), LocalDate.parse(task[3].trim())));
                taskList.getTask((taskList.size()) - 1).setIsDone(convertIsDone(task[1].trim()));
                break;
            }
        }
    }

    public boolean convertIsDone(String isDone) {
        if (isDone.equals(DONE_TRUE)) {
            return true;
        } else {
            return false;
        }
    }

    public void writeToFile(TaskList taskList) throws IOException {
        FileWriter fw = new FileWriter(DEFAULT_FILE_PATH);
        try {
            for (int i = 0; i < taskList.size(); i++) {
                fw.write(taskList.getTask(i).writeFileFormat() + System.lineSeparator());
            }
            fw.close();
        } catch (IOException e) {
            System.out.println("Unable to write to file.");
        }
    }


}

