package quartz.listener;

import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import own.jadezhang.learning.almond.quartz.listener.JobListenerAdapter;

/**
 * Created by Zhang Junwei on 2017/3/26.
 */
public class JobProcessListener extends JobListenerAdapter {
    private static final Logger logger = LoggerFactory.getLogger(JobProcessListener.class);
    @Autowired
    //private SimpMessagingTemplate simpMessagingTemplate;

    @Override
    public void jobWasExecuted(JobExecutionContext context, JobExecutionException jobException) {
        Object result = context.getResult();

        logger.debug("job was executed with the result;", result);
        //发送消息
        //simpMessagingTemplate.convertAndSend("/topic/task", result);

        //simpMessagingTemplate.convertAndSendToUser("testUser", "/queue/music-updates", result);
    }
}
