package ex02;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

/**
 * @author hyecheon
 * @email rainbow880616@gmail.com
 */
class IndexTest {
    @DisplayName("예제 8-4")
    @Test
    void test01() {
        final Hello hello = new Hello();
        Assertions.assertThat(hello.greeting("Korean")).isEqualTo("안녕하세요");
    }
}