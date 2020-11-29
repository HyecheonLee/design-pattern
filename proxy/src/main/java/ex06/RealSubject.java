package ex06;

/**
 * @author hyecheon
 * @email rainbow880616@gmail.com
 */
public class RealSubject implements Subject {
    @Override
    public String action1() {
        return "action1 을 호출합니다.";
    }

    @Override
    public String action2() {
        return "action2 을 호출합니다.";
    }
}
