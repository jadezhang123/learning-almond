package redis;


import java.util.List;

public interface ValueConverter {

    /**
     * 将redis存储的字符串值转化为对象
     *
     * @param data
     * @param type
     * @param <T>
     * @return 当转化出现异常返回null
     */
    <T> T toValue(String data, Class<T> type);

    /**
     * 将redis存储的字符串值转化为数组类对象
     *
     * @param data
     * @param type
     * @return 当转化出现异常返回null
     */
    <T> List<T> toArrayValue(String data, Class<T> type);

    /**
     * 将对象转化为字符串值便于redis存储
     *
     * @param value
     * @param <T>
     * @return 当转化出现异常返回null
     */
    <T> String toString(T value);
}
