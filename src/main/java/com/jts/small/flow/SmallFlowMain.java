package com.jts.small.flow;

import org.camunda.bpm.application.PostDeploy;
import org.camunda.bpm.engine.RuntimeService;
import org.camunda.bpm.spring.boot.starter.annotation.EnableProcessApplication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.event.EventListener;

@SpringBootApplication(exclude = {
        org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration.class
})
@EnableProcessApplication
public class SmallFlowMain {

    @Autowired
    private RuntimeService runtimeService;

    public static void main(String[] args) {
        SpringApplication.run(SmallFlowMain.class, args);
    }

    @EventListener
    private void processPostDeploy(PostDeploy postDeploy){
        System.out.println(postDeploy);
        //runtimeService.startProcessInstanceByKey("Process_1");
    }
}
