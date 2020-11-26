package ex03;

import java.util.HashMap;
import java.util.Map;

/**
 * @author hyecheon
 * @email rainbow880616@gmail.com
 */
public class Factory {
    public Hello make() {
        return new Hello();
    }

    public Hello make2() {
        return SingletonHello.getInstance();
    }

    private Map<String, Object> pool = new HashMap<>();

    public Hello make3(String name) {
        if (!pool.containsKey(name)) {
            final Hello instance = SingletonHello.getInstance();
            pool.put(name, instance);
        }
        return (Hello) pool.get(name);
    }
}
