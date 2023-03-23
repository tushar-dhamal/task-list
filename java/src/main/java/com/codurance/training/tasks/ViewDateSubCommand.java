package com.codurance.training.tasks;

import com.codurance.training.tasks.Task;
import com.codurance.training.tasks.TaskList;

import java.io.PrintWriter;
import java.util.List;
import java.util.Map;

public class ViewDateSubCommand implements SubCommand {

    private com.codurance.training.tasks.TaskList taskList;

    private PrintWriter out;
    private String arguments;

    public ViewDateSubCommand(String arguments, TaskList taskList, PrintWriter out) {
        this.arguments = arguments;
        this.taskList = taskList;
        this.out = out;
    }
    @Override
    public void execute() {
        viewByDate(arguments);
    }

    public void viewByDate(String date) {
        Map<String, List<Long>> deadlineMap = this.taskList.getTaskByDeadline();
        for(Map.Entry<String, List<Long>> map : deadlineMap.entrySet()) {
            if(map.getKey().equals(date)) {
                for(Long l: map.getValue()) {
                    Task task = this.taskList.getTask(String.valueOf(l));
                    out.printf("    [%c] %s: %s%n", (task.isDone() ? 'x' : ' '), this.taskList.getCustomId().getCustomTaskIdIfPresent(task.getId()), task.getDescription());
                }
            }
        }
    }
}
