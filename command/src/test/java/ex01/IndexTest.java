package ex01;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author hyecheon
 * @email rainbow880616@gmail.com
 */
class IndexTest {
    @Test
    void test01() {
        //명령 객체를 생성
        final Exec1 exec1 = new Exec1();
        // 객체를 실행
        exec1.execute();
    }
}