package own.reids;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import own.concurrent.ConcurrentMocker;
import own.jadezhang.learning.redis.IRedisRepository;


/**
 * Created by 伟君子 on 2017/12/25.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:spring-test.xml"})
public class RedisTester {

    @Autowired
    private IRedisRepository<String, String> redisRepository;

    @Test
    public void redis() throws Exception {

        String key = "mobile";

        if (!redisRepository.exists(key)) {
            redisRepository.set(key, "手机");
        }

        System.out.println("mobile: " + redisRepository.get(key));

    }

    @Test
    public void concurrent() throws Exception {

        ConcurrentMocker mocker = new ConcurrentMocker(100);

        mocker.startConcurrentThread(mocker.new ConcurrentRunnable() {
            @Override
            public void runTask() {
            }
        });

    }
}
