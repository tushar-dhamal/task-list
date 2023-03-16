package com.codurance.training.tasks;

import com.codurance.training.tasks.TaskList;

import java.io.PrintWriter;

public class DeleteCommand implements Command {

    private final TaskList taskList;
    private static long lastId = 0;
    private PrintWriter out;
    private String arguments;
    public DeleteCommand(String arguments, TaskList taskList, PrintWriter out) {
        this.taskList = taskList;
        this.arguments = arguments;
        this.out = out;
    }
    @Override
    public void execute() {
        delete(this.arguments);
    }

    public void delete(String arguments) {
        int id = Integer.parseInt(arguments);
        this.taskList.deleteTask((long) id);
        out.println("deleted task "+id);
    }
}
