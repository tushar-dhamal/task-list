package com.codurance.training.tasks;

public class CommandInvoker{

    private Command command;

    public void setCommand(Command command) {
        this.command = command;
    }

    public void invoke(){
        this.command.execute();
    }

}
