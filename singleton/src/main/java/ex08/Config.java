package ex08;

/**
 * @author hyecheon
 * @email rainbow880616@gmail.com
 */
public class Config {
    protected static Config instance;

    protected Config() {
    }

    public static Config getInstance() {
        if (instance == null) {
            instance = new Config();
        }
        return instance;
    }
}
