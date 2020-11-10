package ex03;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

/**
 * @author hyecheon
 * @email rainbow880616@gmail.com
 */
class IndexTest {
    @DisplayName("예제 1-6")
    @Test
    void test01() {
        final Korean korean = new Korean();

        final Hello hello = new Hello(korean);

        Assertions.assertThat(hello.greeting()).isEqualTo("안녕하세요");
        System.out.println(hello.greeting());
    }
}