package own.jadezhang.learning.redis.connection;

import java.util.List;

/**
 * Created by 伟君子 on 2018/3/11.
 */
public interface RedisListCommands {

    <T> Long rPush(String key, T... values);

}
