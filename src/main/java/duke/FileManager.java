package duke;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.FileWriter;
import java.util.Scanner;


public class FileManager {

    private static String fileName;
    private static String directory;
    private static File file;
    private static String fileDirectory;

    public FileManager(String name, String directory) {
        this.fileName = name;
        this.directory = directory;
        fileDirectory = directory + '/' + fileName;
        try {
            createFile();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    private static void createFile() throws FileNotFoundException {
        file = new File(fileDirectory);
        if (!file.exists()) {
            try {
                if (!file.getParentFile().exists()) {
                    file.getParentFile().mkdirs();
                }
                file.createNewFile();
                System.out.println("Save file created at: " + file.getAbsolutePath());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static int loadSavedFile(Task list[], int taskCount) throws FileNotFoundException {
        Scanner s = new Scanner(file);
        while (s.hasNext()) {
            String line = s.nextLine();
            String[] task = line.split("\\|");
            switch (task[0].trim()) {
            case "[T]":
                list[taskCount] = new Todo(task[2].trim());
                list[taskCount].isDone = convertIsDone(task[1].trim());
                break;
            case "[E]":
                list[taskCount] = new Event(task[2].trim(), task[3].trim());
                list[taskCount].isDone = convertIsDone(task[1].trim());
                break;
            case "[D]":
                list[taskCount] = new Deadline(task[2].trim(), task[3].trim());
                list[taskCount].isDone = convertIsDone(task[1].trim());
                break;
            }
            taskCount++;
        }
        return taskCount;
    }

    public static boolean convertIsDone(String isDone) {
        if (isDone.equals("1")) {
            return true;
        } else {
            return false;
        }
    }

    public static void writeToFile(Task list[], int taskCount) throws IOException {
        FileWriter fw = new FileWriter(fileDirectory);
        try {
            for (int i = 0; i < taskCount; i++) {
                fw.write(list[i].writeFileFormat() + System.lineSeparator());
            }
            fw.close();
        } catch (IOException e) {
            System.out.println("Unable to write to file.");
        }
    }

    public static void appendToFile(Task task) throws IOException {
        FileWriter fw = new FileWriter(fileDirectory, true); // create a FileWriter in append mode
        fw.write(task.writeFileFormat() + System.lineSeparator());
        fw.close();
    }

}

