package own.jadezhang.learning.redis;


import own.jadezhang.learning.redis.connection.ValueConverter;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisCommands;
import redis.clients.util.Pool;

/**
 * Created by 伟君子 on 2018/2/4.
 */
public class JRedisConnection extends AbstractJedisConnection {
    private final Pool<Jedis> pool;

    public JRedisConnection(Pool<Jedis> pool, ValueConverter valueConverter) {
        super(valueConverter);
        this.pool = pool;
    }

    @Override
    public JedisCommands getConnection() {
        if (pool != null) {
            return pool.getResource();
        } else {
            throw new IllegalStateException();
        }
    }
}
