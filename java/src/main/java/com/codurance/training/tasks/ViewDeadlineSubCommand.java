package com.codurance.training.tasks;

import com.codurance.training.tasks.Task;
import com.codurance.training.tasks.TaskList;

import java.io.PrintWriter;
import java.util.List;
import java.util.Map;

public class ViewDeadlineSubCommand implements SubCommand {

    private TaskList taskList;
    private PrintWriter out;
    public ViewDeadlineSubCommand(TaskList taskList, PrintWriter out) {
        this.taskList = taskList;
        this.out = out;
    }

    @Override
    public void execute() {
        viewByDeadline();
    }

    public void viewByDeadline() {
        Map<String, List<Long>> deadlineMap = this.taskList.getTaskByDeadline();

        for(Map.Entry<String, List<Long>> map : deadlineMap.entrySet()) {
            out.println(map.getKey());
            for(Long l: map.getValue()) {
                Task task = this.taskList.getTask(String.valueOf(l));
                out.printf("    [%c] %s: %s%n", (task.isDone() ? 'x' : ' '), this.taskList.getCustomId().getCustomTaskIdIfPresent(task.getId()), task.getDescription());
            }
            out.println();
        }
    }



}
