package ex03;

/**
 * @author hyecheon
 * @email rainbow880616@gmail.com
 */
public class SingletonHello {
    private static Hello instance;

    public static Hello getInstance() {
        System.out.println("객체를 생성합니다.");
        if (instance == null) {
            instance = new Hello();
        }
        return instance;
    }

    public String console(String msg) {
        return msg + "\n";
    }

    public String browser(String msg) {
        return msg + "<br/>";
    }
}
