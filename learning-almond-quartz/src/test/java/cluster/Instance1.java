package cluster;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import own.jadezhang.learning.almond.quartz.ScheduleJobManager;
import quartz.SendMailJob;

import java.util.concurrent.TimeUnit;

/**
 * Created by 伟君子 on 2018/4/8.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:spring-quartz.xml"})
public class Instance1 {
    @Autowired
    private ScheduleJobManager scheduleJobManager;
    @Test
    public void name() throws Exception {

        scheduleJobManager.addJob(SendMailJob.class, "quartz:test:sendEmail");

        TimeUnit.DAYS.sleep(1);


    }
}
