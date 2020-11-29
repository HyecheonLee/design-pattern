package ex07;

/**
 * @author hyecheon
 * @email rainbow880616@gmail.com
 */
public class Proxy implements Subject {
    public Subject realSubject;

    @Override
    public String action1() {
        return "action1 작업을 처리합니다.";
    }

    @Override
    public String action2() {
        if (realSubject == null) {
            real();
        }
        return realSubject.action2();
    }

    private void real() {
        this.realSubject = new RealSubject();
    }
}
