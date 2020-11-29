package ex03;

import org.junit.jupiter.api.Test;

/**
 * @author hyecheon
 * @email rainbow880616@gmail.com
 */
class IndexTest {
    @Test
    void test01() {
        final RealSubject real = new RealSubject();
        final Proxy proxy = new Proxy(real);
        proxy.action1();
        proxy.action2();
    }

    @Test
    void test02() {
        final ProxyFactory factory = new ProxyFactory();
        final Subject proxy = factory.getObject();
        proxy.action1();
        proxy.action2();
    }
}