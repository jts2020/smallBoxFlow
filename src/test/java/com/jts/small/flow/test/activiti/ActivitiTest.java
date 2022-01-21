package com.jts.small.flow.test.activiti;

import com.jts.small.flow.test.SmallFlowTest;
import org.activiti.engine.RuntimeService;
import org.activiti.engine.TaskService;
import org.activiti.engine.runtime.ProcessInstance;
import org.activiti.engine.task.Task;
import org.junit.Test;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class ActivitiTest extends SmallFlowTest {

    @Resource
    private RuntimeService runtimeService = null;

    @Resource
    private TaskService taskService = null;

    @Test
    public void test(){
        System.out.println("=========");
        String instanceKey = "Process_1";
        Map<String,Object> map = new HashMap<>();
        map.put("userId","0001");
        ProcessInstance instance = runtimeService.startProcessInstanceByKey(instanceKey);

        System.out.println(instance.getId());
        System.out.println(instance.getProcessDefinitionId());
    }

    @Test
    public void test1(){
        System.out.println("=========");
        String instanceKey = "Process_1";
        Map<String,Object> map = new HashMap<>();
        map.put("userId","0001");
        ProcessInstance instance = runtimeService.startProcessInstanceByKey(instanceKey);

        String instanceId = instance.getId();
        System.out.println("Task:"+taskService.createTaskQuery().count());
        Task task = taskService.createTaskQuery().processInstanceId(instanceId).singleResult();
        if(Objects.nonNull(task)){
            Map<String,Object> map2 = new HashMap<>();
            map2.put("userId","0002");
            taskService.complete(task.getId(),map2);
            System.out.println("Task:"+task.getId());
        }else{
            System.out.println("No found id "+instanceId);
        }

    }

}
