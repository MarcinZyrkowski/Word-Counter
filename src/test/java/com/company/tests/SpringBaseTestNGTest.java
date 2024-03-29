package com.company.tests;

import com.company.WordCounterApp;
import com.company.conf.SpringConfiguration;
import com.company.serviceinterface.CounterServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
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

    // runs app
    @BeforeSuite
    public void run() {
        SpringApplication wordCounterApp = new SpringApplication(WordCounterApp.class);
        wordCounterApp.run();
    }
}
