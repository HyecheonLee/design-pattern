package ex02;

/**
 * @author hyecheon
 * @email rainbow880616@gmail.com
 */
public class Proxy implements Subject {
    @Override
    public void action1() {
        System.out.println("프록시 action1 작업을 처리합니다.");
    }

    @Override
    public void action2() {
        System.out.println("프록시 action2 작업을 처리합니다.");
    }
}
