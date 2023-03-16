package com.codurance.training.tasks;

import com.codurance.training.tasks.Task;
import com.codurance.training.tasks.TaskList;

import java.io.PrintWriter;
import java.util.List;
import java.util.Map;

public class ShowCommand implements Command{

    private final com.codurance.training.tasks.TaskList taskList;
    private PrintWriter out;

    public ShowCommand(TaskList taskList, PrintWriter out) {
        this.out = out;
        this.taskList = taskList;
    }

    @Override
    public void execute() {
        show();
    }

    public void show() {
        for (Map.Entry<String, List<com.codurance.training.tasks.Task>> project : this.taskList.getTasks().entrySet()) {
            out.println(project.getKey());
            for (Task task : project.getValue()) {
                out.printf("    [%c] %s: %s%n", (task.isDone() ? 'x' : ' '), this.taskList.getCustomId().getCustomTaskIdIfPresent(task.getId()), task.getDescription());
            }
            out.println();
        }
    }

}
