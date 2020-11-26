package ex04;

import java.lang.reflect.Constructor;
import java.util.HashMap;
import java.util.Map;

/**
 * @author hyecheon
 * @email rainbow880616@gmail.com
 */
public class Factory {
    public Map<String, Flyweight> pool = new HashMap<>();

    public Flyweight getCode(String aChar) {
        final String className = "Morse" + aChar.toUpperCase();
        if (!pool.containsKey(className)) {
            try {
                final Class<?> clz = Class.forName("ex04." + className);
                final Constructor<?> constructor = clz.getConstructor();
                pool.put(className, (Flyweight) constructor.newInstance());
            } catch (Exception e) {
                throw new RuntimeException("Error");
            }
        }
        return pool.get(className);
    }
}
