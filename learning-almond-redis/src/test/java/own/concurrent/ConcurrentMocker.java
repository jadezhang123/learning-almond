package own.concurrent;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.*;

/**
 * Created by 伟君子 on 2018/2/3.
 */
public class ConcurrentMocker {

    private static final Logger logger = LoggerFactory.getLogger(ConcurrentMocker.class);

    private int concurrencyLevel;

    private CountDownLatch latch;

    private ExecutorService exeService;

    public ConcurrentMocker(int concurrencyLevel) {
        this.concurrencyLevel = concurrencyLevel;
        this.latch = new CountDownLatch(concurrencyLevel);
        this.exeService = new ThreadPoolExecutor(concurrencyLevel, concurrencyLevel, 60L, TimeUnit.SECONDS, new SynchronousQueue<Runnable>());
    }

    public void startConcurrentThread(ConcurrentRunnable runnable) {
        for (int i = 0; i < concurrencyLevel; i++) {
            latch.countDown();
            exeService.execute(runnable);
        }
        exeService.shutdown();
    }

    public abstract class ConcurrentRunnable implements Runnable {

        @Override
        public void run() {
            try {
                latch.await();
            } catch (InterruptedException e) {
                logger.error("");
            }
            runTask();
        }

        public abstract void runTask();

    }

}
