package com.codurance.training.tasks;

import com.codurance.training.tasks.TaskList;

import java.io.PrintWriter;

public class ViewCommand implements Command{
    private final TaskList taskList;
    private PrintWriter out;
    private String arguments;

    public ViewCommand(String arguments, TaskList taskList, PrintWriter out) {
        this.taskList = taskList;
        this.out = out;
        this.arguments = arguments;
    }

    @Override
    public void execute() {
        view(this.arguments);
    }

    public void view(String arguments) {
        String[] subcommandRest = arguments.split(" ", 3);
        String subcommandString = subcommandRest[1];

        SubCommand sub = null;
        if (subcommandString.equals("deadline")) {
            sub = new ViewDeadlineSubCommand(this.taskList, this.out);
        } else if (subcommandString.equals("date")) {
            if(subcommandRest.length>2)
                sub = new ViewDateSubCommand(subcommandRest[2], this.taskList, this.out);
            else
                out.println("Please provide date");
        } else if(subcommandString.equals("project")) {
            new ShowCommand(this.taskList, this.out).execute();

        }
        if(sub!=null)
            sub.execute();
    }
}

