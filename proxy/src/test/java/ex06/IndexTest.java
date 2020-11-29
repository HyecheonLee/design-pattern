package ex06;

import org.junit.jupiter.api.Test;

/**
 * @author hyecheon
 * @email rainbow880616@gmail.com
 */
class IndexTest {
    @Test
    void test01() {
        final ProxyFactory factory = new ProxyFactory();
        final Subject proxy = factory.getObject();

        System.out.println(proxy.action1());
        System.out.println(proxy.action2());
    }
}