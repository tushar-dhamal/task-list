package com.codurance.training.tasks;

import com.codurance.training.tasks.TaskList;

import java.io.PrintWriter;

public class HelpCommand implements Command {

    private final TaskList taskList;
    private PrintWriter out;

    public HelpCommand(TaskList taskList, PrintWriter out) {
        this.out = out;
        this.taskList = taskList;
    }

    @Override
    public void execute() {
        help();
    }


    public void help() {
        out.println("Commands:");
        out.println("  show");
        out.println("  add project <project name>");
        out.println("  add task <project name> <task description>");
        out.println("  check <task ID>");
        out.println("  uncheck <task ID>");
        out.println("  deadline <task ID> <date> (dd/MM/yyyy)");
        out.println("  today");
        out.println("  delete <task ID>");
        out.println("  view by deadline");
        out.println("  view by date");
        out.println("  view by project");
        out.println("  change id <task ID> <new ID> (strings allowed -> special charachters not allowed)");

        out.println();
    }

}
