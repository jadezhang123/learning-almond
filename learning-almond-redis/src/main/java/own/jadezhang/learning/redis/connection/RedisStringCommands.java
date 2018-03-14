package own.jadezhang.learning.redis.connection;

/**
 * Created by 伟君子 on 2018/3/11.
 */
public interface RedisStringCommands {

    <T> T get(String key, Class<T> type);

    <T> String set(String key, T value);

    <T> Boolean setNX(String key, T value);

    Long incr(String key);
}
