package com.revamp.Spring.boot.app;

import com.netflix.conductor.client.automator.TaskRunnerConfigurer;
import com.netflix.conductor.client.http.ConductorClient;
import com.netflix.conductor.client.http.TaskClient;
import com.netflix.conductor.client.worker.Worker;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import java.util.List;

@Configuration
public class WorkerConfig {

    @Bean
    public TaskClient taskClient() {
        ConductorClient client = new ConductorClient("http://localhost:8080/api");
        return new TaskClient(client);
    }

    @Bean
    public TaskRunnerConfigurer taskRunnerConfigurer(List<Worker> workers, TaskClient taskClient) {
        TaskRunnerConfigurer configurer = new TaskRunnerConfigurer.Builder(taskClient, workers)
                .withThreadCount(workers.size())
                .build();
        configurer.init();
        return configurer;
    }
}