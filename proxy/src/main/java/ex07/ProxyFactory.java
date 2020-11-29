package ex07;

/**
 * @author hyecheon
 * @email rainbow880616@gmail.com
 */
public class ProxyFactory {
    public Subject getObject() {
        return new Proxy();
    }
}
