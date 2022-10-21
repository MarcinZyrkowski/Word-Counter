package com.company.tests;

import com.company.conf.SpringConfiguration;
import com.company.serviceinterface.CounterServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.annotations.BeforeSuite;

@ContextConfiguration(classes = SpringConfiguration.class)
public class SpringBaseTestNGTest extends AbstractTestNGSpringContextTests {

    @Autowired
    protected CounterServiceInterface counterServiceInterface;

    @BeforeSuite(alwaysRun = true)
    @Override
    protected void springTestContextPrepareTestInstance() throws Exception {
        super.springTestContextPrepareTestInstance();
    }
}
