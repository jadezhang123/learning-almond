package own.jadezhang.learning.redis;

import own.jadezhang.learning.redis.connection.RedisCommands;
import own.jadezhang.learning.redis.connection.RedisExecutor;
import own.jadezhang.learning.redis.connection.ValueConverter;
import redis.clients.jedis.JedisCommands;

/**
 * Created by 伟君子 on 2018/3/13.
 */
public abstract class AbstractJedisConnection implements RedisCommands {

    public abstract JedisCommands getConnection();

    protected ValueConverter valueConverter;

    public AbstractJedisConnection(ValueConverter valueConverter) {
        this.valueConverter = valueConverter;
    }

    @Override
    public <T> T get(String key, final Class<T> type) {
        return new RedisExecutor<T>(getConnection()) {
            @Override
            public T execute(JedisCommands connection, String key) {
                String data = connection.get(key);
                return valueConverter.toValue(data, type);
            }
        }.run(key);
    }

    @Override
    public <T> String set(String key, final T value) {
        return new RedisExecutor<String>(getConnection()) {
            @Override
            public String execute(JedisCommands connection, String key) {
                return connection.set(key, valueConverter.toString(value));
            }
        }.run(key);
    }

    @Override
    public <T> Boolean setNX(String key, final T value) {
        return new RedisExecutor<Boolean>(getConnection()) {
            @Override
            public Boolean execute(JedisCommands connection, String key) {
                return connection.setnx(key, valueConverter.toString(value)) > 0;
            }
        }.run(key);
    }

    @Override
    public Long incr(String key) {
        return null;
    }

    @Override
    public <T> Long rPush(String key, T... values) {
        JedisCommands connection = getConnection();
        return null;
    }

}
