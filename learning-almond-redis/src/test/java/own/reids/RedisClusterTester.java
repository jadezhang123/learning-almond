package own.reids;

import com.alibaba.fastjson.parser.ParserConfig;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import redis.clients.jedis.JedisCluster;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Zhang Junwei on 2017/7/16.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:spring-test.xml"})
public class RedisClusterTester {
    @Autowired
    private JedisCluster jedisCluster;

    @Test
    public void testCluster() throws Exception {
        String key = "foo";

        String value = jedisCluster.get(key);

        System.out.println("#############foo:"+value);

        Map<String, String> map = new HashMap<>();
        map.put("k1", "v1");
        map.put("k2", "4");
        jedisCluster.hmset("map", map);

        List<String> map1 = jedisCluster.hmget("map", "k1");
        System.out.println(map1);

        while (true){
            //jedisCluster.set()
        }

    }
}
