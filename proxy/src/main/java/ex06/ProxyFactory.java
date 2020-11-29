package ex06;

/**
 * @author hyecheon
 * @email rainbow880616@gmail.com
 */
public class ProxyFactory {
    public Subject getObject() {
        final RealSubject realSubject = new RealSubject();
        return new Proxy(realSubject);
    }
}
