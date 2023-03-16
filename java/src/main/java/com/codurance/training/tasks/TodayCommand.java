package com.codurance.training.tasks;

import com.codurance.training.tasks.Task;
import com.codurance.training.tasks.TaskList;

import java.io.PrintWriter;
import java.util.Date;
import java.util.Map;

import static com.codurance.training.tasks.DateUtils.*;

public class TodayCommand implements Command {
    private TaskList taskList;
    private PrintWriter out;

    public TodayCommand(TaskList taskList, PrintWriter out) {
        this.out = out;
        this.taskList = taskList;
    }
    @Override
    public void execute() {
        today();
    }

    public void today() {
        Date date = null;
        try {
            for (Map.Entry<Long, String> deadline : this.taskList.getDeadlines().entrySet()) {
                String deadlineDate = deadline.getValue();

                if(deadlineDate.equals(dateToString(new Date()))) {
                    out.println("deadline date: "+ deadlineDate);
                    Task task = this.taskList.getTask(String.valueOf(deadline.getKey()));
                    out.printf("    [%c] %d: %s%n", (task.isDone() ? 'x' : ' '), task.getId(), task.getDescription());
                }
            }
        } catch (Exception e) {
            out.println("Enter the corrct Date format : (dd/MM/yyyy) --->"+ e.getMessage());
        }

    }
}
