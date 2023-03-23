package com.codurance.training.tasks;


import com.codurance.training.tasks.Task;
import com.codurance.training.tasks.TaskList;

import java.io.PrintWriter;

public class CheckCommand implements Command {

    private final TaskList taskList;
    private String arguments;
    private final PrintWriter out;

    public CheckCommand(String arguments, TaskList taskList, PrintWriter out) {
        this.taskList = taskList;
        this.arguments = arguments;
        this.out = out;
    }

    @Override
    public void execute() {
        check(this.arguments);
    }

    public void check(String idString) {
        setDone(idString, true);
    }

    private void setDone(String idString, boolean done) {
        if(idString.isEmpty())
            out.println("please enter id");
        else {
            Task task = this.taskList.getTask(idString);
            if (task != null) {
                task.setDone(done);
            } else {
                out.printf("Could not find a task with an ID of %d.", idString);
                out.println();
            }
        }
    }
}
