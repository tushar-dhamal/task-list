package com.codurance.training.tasks;

import com.codurance.training.tasks.Task;
import com.codurance.training.tasks.TaskList;

import java.io.PrintWriter;
import java.util.List;

public class AddTaskSubCommand implements SubCommand {
    private static long lastId = 0;
    private TaskList taskList;
    private String subArguments;
    private  PrintWriter out;

    public AddTaskSubCommand(String subArguments, TaskList taskList, PrintWriter out) {
        this.taskList = taskList;
        this.subArguments = subArguments;
        this.out = out;
    }

    @Override
    public void execute() {
        String[] projectTask = subArguments.split(" ", 2);
        addTask(projectTask[0], projectTask[1]);
    }

    private void addTask(String project, String description) {
        List<com.codurance.training.tasks.Task> projectTasks = this.taskList.getTasks().get(project);
        if (projectTasks == null) {
            out.printf("Could not find a project with the name \"%s\".", project);
            out.println();
            return;
        }
        projectTasks.add(new Task(nextId(), description, false));
    }

    private long nextId() {
        return ++lastId;
    }
}
