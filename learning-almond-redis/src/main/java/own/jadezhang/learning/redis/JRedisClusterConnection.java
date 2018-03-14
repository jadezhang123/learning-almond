package own.jadezhang.learning.redis;

import own.jadezhang.learning.redis.connection.ValueConverter;
import redis.clients.jedis.JedisCluster;
import redis.clients.jedis.JedisCommands;

/**
 * Created by 伟君子 on 2018/3/14.
 */
public class JRedisClusterConnection extends AbstractJedisConnection {

    private final JedisCluster jedisCluster;

    public JRedisClusterConnection(JedisCluster jedisCluster, ValueConverter valueConverter) {
        super(valueConverter);
        this.jedisCluster = jedisCluster;
    }

    @Override
    public JedisCommands getConnection() {
        return jedisCluster;
    }
}
