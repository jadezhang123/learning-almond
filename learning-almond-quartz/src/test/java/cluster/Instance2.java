package cluster;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.quartz.JobDataMap;
import org.quartz.Scheduler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import own.jadezhang.learning.almond.quartz.ScheduleJobManager;

import java.util.concurrent.TimeUnit;

/**
 * Created by 伟君子 on 2018/4/8.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:spring-quartz.xml"})
public class Instance2 {
    @Autowired
    private ScheduleJobManager scheduleJobManager;
    @Test
    public void name() throws Exception {

        JobDataMap dataMap = new JobDataMap();
        dataMap.put("sender", "jack");
        dataMap.put("content", "hello, how is it going?");
        dataMap.put("receiver", "frank");
        scheduleJobManager.triggerJob("quartz:test:sendEmail", Scheduler.DEFAULT_GROUP, dataMap);

        TimeUnit.DAYS.sleep(1);

    }
}
