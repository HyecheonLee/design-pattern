package ex04;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

/**
 * @author hyecheon
 * @email rainbow880616@gmail.com
 */
class IndexTest {
    @DisplayName("예제 1-9")
    @Test
    void test1() {
        final Hello hello = new Hello();
        final String greeting = hello.greeting();
        Assertions.assertThat(greeting).isEqualTo("안녕하세요");
        System.out.println(greeting);
    }
}
