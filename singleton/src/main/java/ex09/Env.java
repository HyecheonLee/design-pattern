package ex09;

/**
 * @author hyecheon
 * @email rainbow880616@gmail.com
 */
public class Env extends Config {
    public void setting() {
        System.out.println("시스템 환경을 설정합니다.");
    }

    public static Env getInstance() {
        if (instance == null) {
            instance = new Env();
        }
        return (Env) instance;
    }
}
