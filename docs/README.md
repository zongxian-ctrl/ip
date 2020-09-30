# Duke User Guide

Duke is a desktop application that uses Command Line Interface (CLI) to act as a Personal Assistant Chatbot 
that helps to manage tasks such as todo, deadline and events. 

## Table of Contents
* Quick start 
* Features 
  * [Adding a todo task: `todo`](#adding-a-todo-task:-todo) 
  * [Adding a deadline task: `deadline`](#adding-a-deadline-task:-`deadline`)
  * [Adding a event task: `event`](#adding-a-event-task:-`event`)
  * [Listing all tasks: `list`](#listing-all-tasks:-`list`)
  * [Marking a task as done: `done`](#marking-a-task-as-done:-`done`)
  * [Deleting a task: `delete`](#deleting-a-task:-`delete`)
  * [Finding a tasks with a keyword: `find`](#finding-a-tasks-with-a-keyword:-`find`)
  * [Exiting Duke: `bye`](#exiting-duke:0`bye`)
  * [Saving the data](#saving-the-data)
* [Command summary](#command-summary)


## Quick Start 

1. Ensure you have Java `11` or above installed in your Computer.
2. Download the latest duke.jar file from github and place into an empty folder. 
3. Open `cmd` or `terminal` and navigate to the folder of the duke.jar file.
4. Run command `java -jar duke.jar`
5. If there is no previous file, Duke will create a new text file at `/data/duke.txt`. 
6. Refer to the Features below for details of each command. 

## Features 

**Take Note:**
  ```
  1. Commands entered are case-sensitive. 
  2. Words in `UPPER_CASE` are the parameters to be supplied by the user.
  3. Data will be saved to after every command and before exiting the application by entering `bye` command. 
 ```
  
### Adding a todo task: `todo`

Adds a 'todo' task to the task list. 

Format: `todo TASK_DESCRIPTION`

Example: `todo English Essay`

### Adding a deadline task: `deadline`

Adds a 'deadline' task to the task list. 

Format: `deadline TASK_DESCRIPTION /by DATE (in yyyy-mm-dd format).`
Example: `deadline English Essay /by 2020-12-11`


### Adding a event task: `event`

Adds a 'event' task to the task list. 

Format: `event TASK_DESCRIPTION /at DATE_TIME` 

Example: `event English Essay /at Monday` 

### Listing all tasks: `list`

Shows a list of all tasks in the task list. 

Format: `list`

### Marking a task as done: `done`

Marks the task which is specified by the index in the `list` function, as done. 

Format: `done INDEX`

Example: `done 2`

### Deleting a task: `delete`

Removes a task from the tasklist specified by the index in the `list` functions. 

Format: `delete INDEX`

Example: `delete 3` 

### Finding a tasks with a keyword: `find`  

Find a task's description in the task list that matches the entered 'keyword'. 

Format: `find KEY_WORD`

Example: `find Essay` 

### Exiting Duke: `bye` 

Exits the program. 

Format: `bye` 

### Saving the data 

Duke's data are saved in the text file automatically after any command that changes the data. 
Hence, there is no need to save the data manually.

## Command Summary 

| Function  | Format | Example |
| --------- | ------ | ------- |
| ToDo | `todo TASK_DESCRIPTION` | `todo English Essay` |
| Deadline | `deadline TASK_DESCRIPTION /by DATE (in yyyy-mm-dd format).` | `deadline English Essay /by 2020-12-11`|
| Event | `event TASK_DESCRIPTION /at DATE_TIME` | `event English Essay /at Monday` |
| List | `list` | `list` |
| Done | `done INDEX`| `done 2` |
| Delete | `delete INDEX` | `delete 3` |
| Find | `find KEY_WORD` | `find Essay` |
| Bye | `bye` | `bye` |

