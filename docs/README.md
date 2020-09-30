# Duke User Guide

Duke is a desktop application that uses Command Line Interface (CLI) to act as a Personal Assistant Chatbot 
that helps to manage tasks such as todo, deadline and events. 

## Table of Contents
* Quick start 
* Features 
  * Adding a todo task: `todo`
  * Adding a deadline task: `deadline`
  * Adding a event task: `event`
  * Listing all tasks: `list`
  * Marking a task as done:`done`  
  * Deleting a task: `delete`
  * Finding a tasks with a keyword:`find`  
  * Exiting Duke: `bye`
* Command summary 


## Quick Start 

1. Ensure you have Java `11` or above installed in your Computer.
2. Download the latest duke.jar file from github and place into an empty folder. 
3. Open `cmd` or `terminal` and navigate to the folder of the duke.jar file.
4. Run command `java -jar duke.jar`
5. Refer to the Features below for details of each command. 

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


## Usage

### `Keyword` - Describe action

Describe action and its outcome.

Example of usage: 

`keyword (optional arguments)`

Expected outcome:

`outcome`
