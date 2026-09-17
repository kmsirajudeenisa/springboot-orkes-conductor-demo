package com.revamp.Spring.boot.app;

import org.springframework.stereotype.Component;

import com.netflix.conductor.client.worker.Worker;
import com.netflix.conductor.common.metadata.tasks.Task;
import com.netflix.conductor.common.metadata.tasks.TaskResult;

@Component
public class PaymentWorker implements Worker {
    @Override
    public String getTaskDefName() {
        return "payment";
    }

    @Override
    public TaskResult execute(Task task) {
        TaskResult result = new TaskResult(task);
        result.addOutputData("status", "payment processed");
        result.setStatus(TaskResult.Status.COMPLETED);
        return result;
    }
}
