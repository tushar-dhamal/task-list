package com.codurance.training.tasks;

import com.codurance.training.tasks.TaskList;

import java.io.PrintWriter;

public class AddCommand implements Command {

    private final TaskList taskList;
    private static long lastId = 0;
    private PrintWriter out;
    private String arguments;
    public AddCommand(String arguments, TaskList taskList, PrintWriter out) {
        this.taskList = taskList;
        this.arguments = arguments;
        this.out = out;
    }

    @Override
    public void execute() {
        add(this.arguments);
    }

    public void add(String commandLine) {
        String[] subcommandRest = commandLine.split(" ", 2);
        String subcommand = subcommandRest[0];
        SubCommand subCommand = null;
        if (subcommand.equals("project")) {
            //addProject(subcommandRest[1]);
            subCommand = new AddProjectSubCommand(subcommandRest[1], this.taskList);
        } else if (subcommand.equals("task")) {
            subCommand = new AddTaskSubCommand(subcommandRest[1], this.taskList, this.out);

        }
        subCommand.execute();
    }


}
