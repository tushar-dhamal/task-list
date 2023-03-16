package com.codurance.training.tasks;

import com.codurance.training.tasks.Task;
import com.codurance.training.tasks.TaskList;

import java.io.PrintWriter;

public class DeadlineCommand implements Command {

    private TaskList taskList;
    private PrintWriter out;
    private String arguments;

    public DeadlineCommand(String arguments,TaskList taskList, PrintWriter out) {
        this.arguments = arguments;
        this.taskList = taskList;
        this.out = out;
    }

    @Override
    public void execute() {
        String[] deadLineTask = arguments.split(" ", 2);
        addDeadline(deadLineTask[0],deadLineTask[1]);
    }

    public void addDeadline(String taskId, String deadlineDate) {
        //int id = Integer.parseInt(taskId);
        Task task = this.taskList.getTask(taskId);
        if(task!=null) {
            this.taskList.getDeadlines().put(task.getId(),deadlineDate);
        } else {
            out.printf("Could not find a task with an ID of %d.", taskId);
            out.println();
        }
    }
}
