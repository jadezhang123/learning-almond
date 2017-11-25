package own.jadezhang.learning.almond.security.base64;

import org.apache.commons.codec.binary.Base64;
import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

/**
 * Created by Zhang Junwei on 2017/11/25.
 */
public class SecurityBase64 {


    /**
     * BASE64解密
     * @param key
     * @return
     * @throws Exception
     */
    public static byte[] jdkDecryptBASE64(String key) throws Exception {
        return (new BASE64Decoder()).decodeBuffer(key);
    }

    /**
     * BASE64加密
     * @param key
     * @return
     * @throws Exception
     */
    public static String jdkEncryptBASE64(byte[] key) throws Exception {
        return (new BASE64Encoder()).encodeBuffer(key);
    }

    /**
     * BASE64解密
     * @param key
     * @return
     * @throws Exception
     */
    public static byte[] ccDecryptBASE64(String key) throws Exception {
        byte[] bytes = Base64.decodeBase64(key.getBytes());
        return (new BASE64Decoder()).decodeBuffer(key);
    }

    /**
     * BASE64加密
     * @param key
     * @return
     * @throws Exception
     */
    public static String ccEncryptBASE64(byte[] key) throws Exception {
        return (new BASE64Encoder()).encodeBuffer(key);
    }



}
