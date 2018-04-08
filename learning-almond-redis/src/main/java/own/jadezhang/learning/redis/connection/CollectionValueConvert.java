package own.jadezhang.learning.redis.connection;

import java.util.List;
import java.util.Set;

/**
 * Created by 伟君子 on 2018/3/18.
 */
public interface CollectionValueConvert extends ValueConverter {
    <T> T[] toArray(String data, Class<T> type);

    <T> List<T> toList(String data, Class<T> type);

    <T> Set<T> toSet(String data, Class<T> type);
}

