package com.codurance.training.tasks;


import com.codurance.training.tasks.Task;

import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public final class TaskList {

    private final Map<String, List<com.codurance.training.tasks.Task>> tasks = new LinkedHashMap<>();
    private final Map<Long, String> deadlines = new LinkedHashMap<>();

    private CustomId customId = new CustomId();

    public Map<String, List<com.codurance.training.tasks.Task>> getTasks() {
        return this.tasks;
    }

    public Map<Long, String> getDeadlines() {
        return this.deadlines;
    }

    public com.codurance.training.tasks.Task getTask(String taskId) {
        Long id = getIdentificationKey(taskId);
        for (Map.Entry<String, List<com.codurance.training.tasks.Task>> project : this.tasks.entrySet()) {
            for (com.codurance.training.tasks.Task task : project.getValue()) {
                if (task.getId() == id) {
                    return task;
                }
            }
        }
        return null;
    }

    private Long getIdentificationKey(String taskId) {
        boolean numberFlag = false;
        if(StringUtils.isNumber(taskId))
            numberFlag = true;

        if(numberFlag) return Long.valueOf(taskId);
        else {
            Long l = this.customId.getKeyId(taskId);
            return l;
        }

    }

    public void deleteTask(Long taskId) {
        for (Map.Entry<String, List<com.codurance.training.tasks.Task>> project : this.tasks.entrySet()) {
            Iterator iterator = project.getValue().iterator();
            while(iterator.hasNext()) {
                com.codurance.training.tasks.Task task = (Task) iterator.next();
                if (task.getId() == taskId) {
                    iterator.remove();
                }
            }
        }
    }

    public Map<String, List<Long>> getTaskByDeadline() {
        return this.deadlines.entrySet().stream().
                collect(Collectors.groupingBy(s->s.getValue(),Collectors.mapping(s->s.getKey(),Collectors.toList())));
    }

    public CustomId getCustomId() {
        return this.customId;
    }
}
