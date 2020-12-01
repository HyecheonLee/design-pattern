package ex03;

import ex01.Command;
import ex01.Exec1;
import ex02.Concrete;
import ex02.Exec2;
import org.junit.jupiter.api.Test;

/**
 * @author hyecheon
 * @email rainbow880616@gmail.com
 */
class IndexTest {
    @Test
    void test01() {
        //명령 객체를 생성
        final Exec1 exec1 = new Exec1();
        final Concrete receiver = new Concrete();
        //명령 객체를 생성
        final Exec2 exec2 = new Exec2(receiver);
        //인보커
        final Invoker invoker = new Invoker();
        invoker.setCommand("cmd1", exec1);
        invoker.setCommand("cmd2", exec2);
        //객체를 실행
        invoker.execute("cmd1");
        invoker.execute("cmd2");

    }

    @Test
    void test02() {
        final Invoker invoker = new Invoker();
        invoker.setCommand("cmd1", new Command() {
            @Override
            public void execute() {
                System.out.println("명령1을 실행합니다.");
            }
        });
        invoker.setCommand("cmd2", () -> System.out.println("명령2을 실행합니다."));
        invoker.executeAll();
    }
}