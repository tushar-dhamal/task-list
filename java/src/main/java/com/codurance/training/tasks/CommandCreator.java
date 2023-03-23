package com.codurance.training.tasks;

import java.io.PrintWriter;

public class CommandCreator {

    private final TaskList taskList;
    private final PrintWriter out;
    public CommandCreator(TaskList taskList, PrintWriter out){
        this.taskList = taskList;
        this.out = out;
    }


    public Command getCommand(String commandString) {
        Command command;
        String[] commandRest = commandString.split(" ", 2);
        switch (commandRest[0]) {
            case "show":
                command = new ShowCommand(taskList, out);
                break;
            case "add":
                //add(commandRest[1]);
                command = new AddCommand(commandRest[1],taskList,out);
                break;
            case "check":
                command = new CheckCommand(commandRest[1],taskList,out);
                break;
            case "uncheck":
                command = new UncheckCommand(commandRest[1],taskList,out);
                break;
            case "help":
                command = new HelpCommand(taskList,out);
                break;
            case "deadline":
                command = new DeadlineCommand(commandRest[1],taskList,out);
                break;
            case "today":
                command = new TodayCommand(taskList,out);
                break;
            case "delete":
                command = new DeleteCommand(commandRest[1],taskList,out);
                break;
            case "view":
                command = new ViewCommand(commandRest[1],taskList,out);
                break;
            case "change":
                command = new ChangeIdCommand(commandRest[1],taskList,out);
                break;
            default:
                command = new ErrorCommand(commandRest[0],taskList,out);
                break;
        }

        return command;
    }

}
