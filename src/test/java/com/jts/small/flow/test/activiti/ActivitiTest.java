package com.jts.small.flow.test.activiti;

import com.jts.small.flow.test.SmallFlowTest;
import org.activiti.engine.RuntimeService;
import org.junit.Test;

import javax.annotation.Resource;

public class ActivitiTest extends SmallFlowTest {

    @Resource
    private RuntimeService runtimeService = null;

    @Test
    public void test(){
        System.out.println("=========");
    }


}
