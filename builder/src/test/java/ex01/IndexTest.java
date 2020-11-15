package ex01;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

/**
 * @author hyecheon
 * @email rainbow880616@gmail.com
 */
class IndexTest {
    @DisplayName("예제 5-8")
    @Test
    void test() {
        // 알고리즘을 생성
        final Algorithm algorithm = new ProductModel();
        //빌더 객체 생성
        final Factory factory = new Factory(algorithm);
        final Computer computer = factory.build().getInstance();
        System.out.println(computer);
    }
}