package com.jts.small.flow;

import org.camunda.bpm.spring.boot.starter.annotation.EnableProcessApplication;
import org.camunda.bpm.spring.boot.starter.event.PostDeployEvent;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.event.EventListener;

@SpringBootApplication(exclude = {
        org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration.class
})
@EnableProcessApplication
public class SmallFlowMain {

    public static void main(String[] args) {
        SpringApplication.run(SmallFlowMain.class, args);
    }

    @EventListener
    private void processPostDeploy(PostDeployEvent event){
        System.out.println(event.getProcessEngine().getName());
        //runtimeService.startProcessInstanceByKey("Process_1");
    }
}
