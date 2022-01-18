package com.jts.small.flow.test;

import com.jts.small.flow.SmallFlowMain;
import org.junit.Before;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = SmallFlowMain.class,webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
public class SmallFlowTest {

    @Before
    public void before(){
        System.out.println("============Before===========");
    }

}
