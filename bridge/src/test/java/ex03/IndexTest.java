package ex03;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

/**
 * @author hyecheon
 * @email rainbow880616@gmail.com
 */
class IndexTest {
    @DisplayName("예제 8-7")
    @Test
    void test01() {
        final Greeting greeting = new Greeting();
        Assertions.assertThat(greeting.ko()).isEqualTo("안녕하세요");
        Assertions.assertThat(greeting.greeting()).isEqualTo("hello");
    }
}