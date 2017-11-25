package own.jadezhang.learning.almond.security.asymmetry;

import org.apache.commons.io.IOUtils;
import org.apache.commons.net.util.Base64;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.security.Key;

/**
 * Created by Zhang Junwei on 2017/11/25.
 */
public class AESCryptUtil {
    private static final Logger logger = LoggerFactory.getLogger(AESCryptUtil.class);

    public static final String KEY_ALGORITHM = "AES";
    public static final String CIPHER_ALGORITHM = "AES/ECB/PKCS5Padding";

    private static final String KEY_PATH = "e:\\secretKey.key";

    private static Key key;
    private static Cipher cipher;

    static {
        saveKeyBytes(false);

        try {
            key = new SecretKeySpec(loadKeyBytes(), KEY_ALGORITHM);
            cipher = Cipher.getInstance(CIPHER_ALGORITHM);
        } catch (Exception e) {
            logger.error("init key and cipher occur an ERROR", e);
            System.exit(0);
        }
    }

    private AESCryptUtil() {
    }

    public static byte[] encrypt(String src) throws Exception {

        cipher.init(Cipher.ENCRYPT_MODE, key);

        return cipher.doFinal(src.getBytes());

    }

    public static String decrypt(byte[] cipherText) throws Exception {

        cipher.init(Cipher.DECRYPT_MODE, key);

        byte[] result = cipher.doFinal(cipherText);

        return new String(result);
    }

    private static void saveKeyBytes(boolean cover) {
        File keyFile = new File(KEY_PATH);
        if (!cover || keyFile.exists()) {
            return;
        }
        try {
            KeyGenerator keyGenerator = KeyGenerator.getInstance(KEY_ALGORITHM);
            SecretKey secretKey = keyGenerator.generateKey();
            FileOutputStream out = new FileOutputStream(KEY_PATH);
            out.write(secretKey.getEncoded());
            out.close();
        } catch (Exception e) {
            logger.error("saving key to {} occur an ERROR", KEY_PATH, e);
            System.exit(0);
        }
    }

    private static byte[] loadKeyBytes() throws Exception {
        try {
            return IOUtils.toByteArray(new FileInputStream(KEY_PATH));
        } catch (Exception e) {
            logger.warn("load keyBytes from " + KEY_PATH + " occur an ERROR", e);
            saveKeyBytes(true);
            return IOUtils.toByteArray(new FileInputStream(KEY_PATH));
        }
    }

    public static void main(String[] args) throws Exception {
        String src = "jadezhang";
        byte[] result = AESCryptUtil.encrypt(src);
        System.out.println("encrypt: " + Base64.encodeBase64String(result));
        System.out.println("decrypt: " + AESCryptUtil.decrypt(result));
    }

}
