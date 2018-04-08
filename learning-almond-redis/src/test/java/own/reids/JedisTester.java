package own.reids;

import org.apache.commons.pool2.impl.GenericObjectPoolConfig;
import own.concurrent.ConcurrentMocker;
import own.jadezhang.learning.redis.JRedisConnection;
import own.jadezhang.learning.redis.connection.SerializableValueConverter;
import own.mock.Mocker;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.util.Pool;

/**
 * Created by 伟君子 on 2018/3/15.
 */
public class JedisTester {
    public static void main(String[] args) {
        GenericObjectPoolConfig poolConfig = new GenericObjectPoolConfig();
        poolConfig.setMaxTotal(10);
        poolConfig.setMaxIdle(5);
        poolConfig.setMinIdle(0);
        Pool<Jedis> pool = new JedisPool(poolConfig, "192.168.64.129", 6379, 36000, "04093x");

        final JRedisConnection connection = new JRedisConnection(pool, new SerializableValueConverter());
        String key = "same_key";

        // System.out.println("response:" + connection.set(key, new Mocker(2, "jack")));

        System.out.println("value:" + connection.get(key, String.class));

        ConcurrentMocker mocker = new ConcurrentMocker(50);

        mocker.startConcurrentThread(mocker.new ConcurrentRunnable() {
            @Override
            public void runTask() {
                for (int i = 0; i < 10; i++) {
                    Thread.yield();
                    connection.set("same_key", "index" + i);
                }
            }
        });
    }
}
