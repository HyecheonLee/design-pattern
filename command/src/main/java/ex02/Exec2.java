package ex02;

import ex01.Command;

/**
 * @author hyecheon
 * @email rainbow880616@gmail.com
 */
public class Exec2 implements Command {
    Concrete receiver;

    public Exec2(Concrete receiver) {
        this.receiver = receiver;
    }

    @Override
    public void execute() {
        System.out.println("명령2를 실행합니다.");
        //여러 개의 리시버 동작을 처리할 수 있습니다.
        //실체 객체의 명령을 수행합니다.
        receiver.action1();
        receiver.action2();
        //추가 코드 작성
    }
}
