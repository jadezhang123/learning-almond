package own.jadezhang.learning.redis.connection;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class SerializableValueConverter implements ValueConverter {
    private static final Logger logger = LoggerFactory.getLogger(SerializableValueConverter.class);

    public static final String DEFT_ENCODING = "ISO-8859-1";

    @Override
    public <T> T toValue(String data, Class<T> type) {
        ObjectInputStream ois = null;
        ByteArrayInputStream bais = null;
        try {
            if (StringUtils.isNotBlank(data)) {
                bais = new ByteArrayInputStream(data.getBytes(DEFT_ENCODING));
                ois = new ObjectInputStream(bais);
                return (T) ois.readObject();
            }
        } catch (Exception e) {
            logger.error("convert string to value occur an ERROR", e);
        } finally {
            closeInStream(ois, bais);
        }
        return null;
    }

    @Override
    public <T> String toString(T value) {
        ObjectOutputStream oos = null;
        ByteArrayOutputStream baos = null;
        try {
            if (value != null) {
                baos = new ByteArrayOutputStream();
                oos = new ObjectOutputStream(baos);
                oos.writeObject(value);
                return new String(baos.toByteArray(), DEFT_ENCODING);
            }
        } catch (Exception e) {
            logger.error("convert value to string occur an ERROR", e);
        } finally {
            closeOutStream(oos, baos);
        }
        return null;
    }

    private void closeOutStream(ObjectOutputStream oos, ByteArrayOutputStream baos) {
        try {
            oos.close();
            baos.close();
        } catch (Exception e) {
            // ignore
        }
    }

    private void closeInStream(ObjectInputStream ois, ByteArrayInputStream bais) {
        try {
            ois.close();
            bais.close();
        } catch (Exception e) {
            // ignore
        }
    }
}
