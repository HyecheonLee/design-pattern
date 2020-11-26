package ex01;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * @author hyecheon
 * @email rainbow880616@gmail.com
 */
class IndexTest {
    @Test
    void test01() {
        final Hello hello = new Hello();
        hello.msg = "hello world";
        Assertions.assertThat(hello.msg).isEqualTo("hello world");
    }

    @Test
    void test02() {
        final Korean korean = new Korean();
        Assertions.assertThat(korean.hello()).isEqualTo("안녕하세요");
        final English english = new English();
        Assertions.assertThat(english.hello()).isEqualTo("hello");
    }
}