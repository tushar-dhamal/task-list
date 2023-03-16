package com.codurance.training.tasks;

import com.codurance.training.tasks.TaskList;

import java.io.PrintWriter;

public class ErrorCommand implements Command {

    private final TaskList taskList;

    private String arguments;
    private PrintWriter out;

    public ErrorCommand(String arguments, TaskList taskList, PrintWriter out) {
        this.arguments = arguments;
        this.taskList = taskList;
        this.out = out;
    }

    @Override
    public void execute() {
        error(this.arguments);
    }


    public void error(String command) {
        out.printf("I don't know what the command \"%s\" is.", command);
        out.println();
    }

}
