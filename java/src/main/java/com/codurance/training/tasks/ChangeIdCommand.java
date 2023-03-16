package com.codurance.training.tasks;

import com.codurance.training.tasks.TaskList;

import java.io.PrintWriter;

public class ChangeIdCommand implements Command {
    private final TaskList taskList;
    private PrintWriter out;
    private String arguments;
    public ChangeIdCommand(String arguments, TaskList taskList, PrintWriter out) {
        this.taskList = taskList;
        this.arguments = arguments;
        this.out = out;
    }

    @Override
    public void execute() {
        changeId(this.arguments);
    }

    public void changeId(String arguments) {
        String[] subcommandRest = arguments.split(" ", 3);
        long id = Long.valueOf(subcommandRest[1]);
        CustomId customId = this.taskList.getCustomId();
        customId.setId(id,subcommandRest[2]);

    }
}
