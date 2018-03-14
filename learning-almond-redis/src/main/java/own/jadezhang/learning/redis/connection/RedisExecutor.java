package own.jadezhang.learning.redis.connection;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisCluster;
import redis.clients.jedis.JedisCommands;

/**
 * Created by 伟君子 on 2018/3/13.
 */
public abstract class RedisExecutor<T> {

    private final JedisCommands connection;

    public RedisExecutor(JedisCommands connection) {
        this.connection = connection;
    }

    public abstract T execute(JedisCommands connection, String key);

    public T run(String key) {
        try {
            return execute(connection, key);
        } catch (Exception e) {
            return null;
        } finally {
            releaseConnection(connection);
        }
    }

    private void releaseConnection(JedisCommands connection) {
        if (connection instanceof Jedis) {
            ((Jedis) connection).close();
        } else if (connection instanceof JedisCluster) {
            try {
                ((JedisCluster) connection).close();
            } catch (Exception e) {

            }
        }
    }

}
