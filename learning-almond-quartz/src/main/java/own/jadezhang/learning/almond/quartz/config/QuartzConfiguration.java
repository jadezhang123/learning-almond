package own.jadezhang.learning.almond.quartz.config;

import org.springframework.context.annotation.Configuration;
import own.jadezhang.learning.almond.quartz.ScheduleJobManager;
import own.jadezhang.learning.almond.quartz.ScheduleJobManagerImpl;

/**
 * Created by Zhang Junwei on 2017/5/5.
 */
@Configuration
public class QuartzConfiguration {

    //@Bean
    ScheduleJobManager scheduleJobManager(){

        return new ScheduleJobManagerImpl();
    }
}
