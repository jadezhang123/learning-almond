package own.jadezhang.learning.redis.connection;

import com.alibaba.fastjson.JSON;

import java.util.List;

public class FastJSONValueConverter implements ValueConverter {
    @Override
    public <T> T toValue(String data, Class<T> type) {
        return JSON.parseObject(data, type);
    }

    @Override
    public <T> List<T> toArrayValue(String data, Class<T> type) {
        return JSON.parseArray(data, type);
    }

    @Override
    public <T> String toString(T value) {
        return JSON.toJSONString(value);
    }
}
