package own.jadezhang.learning.redis;

import org.springframework.dao.DataAccessException;
import own.jadezhang.learning.redis.connection.RedisCommands;

/**
 * Created by 伟君子 on 2018/3/14.
 */
public interface RedisCallback<T> {
    T doInRedis(RedisCommands connection) throws DataAccessException;
}
