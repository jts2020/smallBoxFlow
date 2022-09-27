package com.jts.small.flow;

import lombok.extern.log4j.Log4j2;
import org.camunda.bpm.engine.HistoryService;
import org.camunda.bpm.engine.ProcessEngine;
import org.camunda.bpm.engine.RuntimeService;
import org.camunda.bpm.engine.TaskService;
import org.camunda.bpm.engine.runtime.ProcessInstance;
import org.camunda.bpm.engine.task.Task;
import org.camunda.bpm.engine.task.TaskQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Objects;
import java.util.Optional;

@Log4j2
@RestController
@RequestMapping("flow")
public class EchoController {

    @Autowired
    private ProcessEngine processEngine;

    @Autowired
    private RuntimeService runtimeService;

    @Autowired
    private TaskService taskService;

    @Autowired
    private HistoryService historyService;

    @GetMapping("index")
    public String index() {
        String res = String.valueOf(System.nanoTime());
        System.out.println(res);
        return res;
    }

    @GetMapping("start")
    public String start() {

        ProcessInstance instance = runtimeService.startProcessInstanceByKey("Process_1");
        String instanceId = instance.getId();
        TaskQuery taskQuery = taskService.createTaskQuery().processInstanceId(instanceId);
        Task task;
        do {
            task = taskQuery.singleResult();
            Optional.ofNullable(task).map(Task::getId).ifPresent(taskId -> {
                taskService.complete(taskId);
                log.info("start:instanceId[{}],taskId[{}] commit.", instanceId, taskId);
            });
        } while (Objects.nonNull(task));

        historyService.createHistoricActivityInstanceQuery()
                .processInstanceId(instanceId)
                .orderByHistoricActivityInstanceStartTime()
                .asc()
                .list()
                .stream()
                .forEach(System.out::println);
        return "ok";
    }

    @GetMapping("start0")
    public String start0() {
        ProcessInstance instance = runtimeService.startProcessInstanceByKey("Process_1");
        String instanceId = instance.getId();
        TaskQuery taskQuery = taskService.createTaskQuery().processInstanceId(instanceId);
        Task task = taskQuery.singleResult();
        Optional.ofNullable(task)
                .map(Task::getId)
                .ifPresent(taskId ->
                    log.info("start0:instanceId[{}],taskId[{}] commit.", instanceId, taskId));
        return "ok";
    }

    @GetMapping("start1")
    public String start1() {
        ProcessInstance instance = runtimeService.startProcessInstanceByKey("Process_1");
        String instanceId = instance.getId();
        TaskQuery taskQuery = taskService.createTaskQuery().processInstanceId(instanceId);
        Task task = taskQuery.singleResult();
        Optional.ofNullable(task)
                .map(Task::getId)
                .ifPresent(taskId -> {
                    taskService.complete(taskId);
                    log.info("start1:instanceId[{}],taskId[{}] commit.", instanceId, taskId);
        });
        return "ok";
    }

}
