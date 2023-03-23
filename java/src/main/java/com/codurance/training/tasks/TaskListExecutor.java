package com.codurance.training.tasks;

import com.codurance.training.tasks.TaskList;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

public class TaskListExecutor implements Runnable{
    private static final String QUIT = "quit";
    private TaskList taskList;
    private CommandCreator commandCreator;
    private CommandInvoker commandInvoker;
    BufferedReader in;
    PrintWriter out;
    public TaskListExecutor(TaskList taskList) {
        this.in = new BufferedReader(new InputStreamReader(System.in));
        this.out = new PrintWriter(System.out);
        commandCreator = new CommandCreator(taskList,out);
        commandInvoker = new CommandInvoker();
    }

    @Override
    public void run() {
        while(true) {
            out.print("> ");
            out.flush();
            String commandString = null;
            Command command = null;
            try {
                commandString = in.readLine();
                if (commandString.equals(QUIT)) {
                    break;
                }
                commandInvoker.setCommand(commandCreator.getCommand(commandString));
                commandInvoker.invoke();
            } catch(IOException ioException) {
                out.println(ioException.getMessage());
            }

        }
    }

}
