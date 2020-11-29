package ex03;

/**
 * @author hyecheon
 * @email rainbow880616@gmail.com
 */
public class Proxy implements Subject {
    public Subject realSubject;

    public Proxy(Subject realSubject) {
        this.realSubject = realSubject;
    }

    @Override
    public void action1() {
        realSubject.action1();
    }

    @Override
    public void action2() {
        realSubject.action2();
    }
}
