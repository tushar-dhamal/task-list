package com.codurance.training.tasks;

import com.codurance.training.tasks.Task;
import com.codurance.training.tasks.TaskList;

import java.io.PrintWriter;

public class UncheckCommand implements Command {

    private final TaskList taskList;

    private String arguments;
    private PrintWriter out;

    public UncheckCommand(String arguments, TaskList taskList, PrintWriter out) {
        this.arguments = arguments;
        this.taskList = taskList;
        this.out = out;
    }

    @Override
    public void execute() {
        uncheck(this.arguments);
    }

    public void uncheck(String idString) {
        setDone(idString, false);
    }

    private void setDone(String idString, boolean done) {
        if(idString.isEmpty())
            out.println("please enter id");
        else {
            //int id = Integer.parseInt(idString);
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
