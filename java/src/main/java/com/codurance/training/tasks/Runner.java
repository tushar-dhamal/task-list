package com.codurance.training.tasks;

import com.codurance.training.tasks.TaskList;

public class Runner {
    private static final String QUIT = "quit";

    public static void main(String[] args) {

        TaskList taskList = new TaskList();

        new TaskListExecutor(taskList).run();

    }
}
