package own.jadezhang.learning.almond.quartz.listener;

import org.quartz.listeners.JobListenerSupport;

/**
 * Created by Zhang Junwei on 2017/3/26.
 */
public class JobListenerAdapter extends JobListenerSupport{
    @Override
    public String getName() {
        return this.getClass().getName();
    }
}
