package ex02;

/**
 * @author hyecheon
 * @email rainbow880616@gmail.com
 */
public class RealSubject implements Subject {
    @Override
    public void action1() {
        System.out.println("action1 을 호출합니다.");
    }

    @Override
    public void action2() {
        System.out.println("action2 을 호출합니다.");
    }
}
