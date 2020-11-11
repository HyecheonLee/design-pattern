package ex07;

/**
 * @author hyecheon
 * @email rainbow880616@gmail.com
 */
public class Config {
    public static String conf;

    public static void set(String conf) {
        Config.conf = conf;
    }

    public static String get() {
        return conf;
    }
}
