package own.jadezhang.learning.almond.security.jvm;

public class Tester {
    public static void main(String[] args) {
        System.out.println(test());
        System.out.println(testA().a);
    }

    static int test() {
        int x = 0;
        try {
            return -1;
        } finally {
            ++x;
            return x;
        }
    }

    static A testA() {
        A a = new A();
        try {
            return a;
        } finally {
            ++a.a;
        }
    }
}

class A {
    int a = 0;
}