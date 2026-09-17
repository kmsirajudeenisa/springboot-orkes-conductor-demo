package com.revamp.Spring.boot.app;

import com.netflix.conductor.common.metadata.tasks.Task;
import org.springframework.stereotype.Component;

import com.netflix.conductor.client.worker.Worker;
import com.netflix.conductor.common.metadata.tasks.TaskResult;

@Component
public class OrderWorker implements Worker {
    @Override
    public String getTaskDefName() {
        return "order";
    }

    @Override
    public TaskResult execute(Task task) {
        TaskResult result = new TaskResult(task);
        result.addOutputData("status", "order placed");
        result.setStatus(TaskResult.Status.COMPLETED);
        return result;
    }
}
