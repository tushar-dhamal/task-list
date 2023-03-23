package com.codurance.training.tasks;

import com.codurance.training.tasks.Task;
import com.codurance.training.tasks.TaskList;

import java.util.ArrayList;

public class AddProjectSubCommand implements SubCommand{

    private TaskList taskList;
    private String subArguments;

    public AddProjectSubCommand(String subArguments, TaskList taskList) {
        this.taskList = taskList;
        this.subArguments = subArguments;
    }

    @Override
    public void execute() {
        addProject(subArguments);
    }

    private void addProject(String name) {
        this.taskList.getTasks().put(name, new ArrayList<Task>());
    }
}
