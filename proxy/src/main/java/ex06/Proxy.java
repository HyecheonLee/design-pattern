package ex06;

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
    public String action1() {
        return realSubject.action1();
    }

    @Override
    public String action2() {
        final String msg = realSubject.action2();
        if (!msg.isEmpty()) {
            return msg;
        } else {
            return "실체 객체에서 문자열을 반환 받지 못하였습니다.";
        }
    }
}
