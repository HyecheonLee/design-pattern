package ex08;

import org.junit.jupiter.api.Test;

/**
 * @author hyecheon
 * @email rainbow880616@gmail.com
 */
class IndexTest {
    @Test
    void test01() {
        final Proxy proxy = new Proxy(true);
        System.out.println(proxy.action1());
        System.out.println(proxy.action2());
    }
}