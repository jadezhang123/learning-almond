package own.jadezhang.learning.almond.security.jvm;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by 伟君子 on 2018/3/18.
 * VM args : -Xms5m -Xmx5m -XX:+HeapDumpOnOutOfMemoryError -XX:HeapDumpPath=d:/a.dump
 * VM args : -Xms100m -Xmx100m -XX:+HeapDumpOnOutOfMemoryError -XX:HeapDumpPath=d:/a.dump -XX:+UseSerialGC
 */
public class HeapOOM {
    static class OOMObject {
        // 64KB
        public byte[] placeholder = new byte[64 * 1024];
    }

    public static void main(String[] args) throws Exception {
        fillHeap(1000);
    }

    public static void fillHeap(int num) throws InterruptedException {
        List<OOMObject> list = new ArrayList<OOMObject>();
        for (int i = 0; i < num; i++) {
            // 稍作延时，令监视曲线变化明显
            Thread.sleep(50);
            list.add(new OOMObject());
        }
    }

}
