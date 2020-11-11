package ex06;

/**
 * @author hyecheon
 * @email rainbow880616@gmail.com
 */
public class Config {
    private static Config instance;

    private Config() {
    }

    public static Config getInstance() {
        if (instance == null) {
            instance = new Config();
        }
        return instance;
    }
}
