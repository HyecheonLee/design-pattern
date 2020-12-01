package ex02;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author hyecheon
 * @email rainbow880616@gmail.com
 */
class IndexTest {
    @Test
    void test01() {
        final Concrete concrete = new Concrete();
        //명령 객체를 생성합니다.
        final Exec2 cmd = new Exec2(concrete);
        //객체를 실행합니다.
        cmd.execute();
    }
}