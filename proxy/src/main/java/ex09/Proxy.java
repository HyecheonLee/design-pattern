package ex09;

import ex07.RealSubject;
import ex07.Subject;

/**
 * @author hyecheon
 * @email rainbow880616@gmail.com
 */
public class Proxy implements Subject {
    public Subject realSubject;
    public boolean isPermit;
    public int action1;

    public Proxy(boolean isPermit) {
        this.isPermit = isPermit;
    }

    @Override
    public String action1() {
        //추가 동작
        action1++;
        return "action1 작업을 처리합니다.";
    }

    @Override
    public String action2() {
        if (isPermit) {
            if (realSubject == null) {
                real();
            }
            return realSubject.action2();
        } else {
            return "action2 실행 권한이 없습니다.";
        }
    }

    private void real() {
        this.realSubject = new RealSubject();
    }
}
