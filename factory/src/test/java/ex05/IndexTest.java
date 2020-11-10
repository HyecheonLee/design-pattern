package ex05;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

/**
 * @author hyecheon
 * @email rainbow880616@gmail.com
 */
public class IndexTest {
    @DisplayName("예제 1-13")
    @Test
    void test01() {
        final Hello hello = new Hello();
        final String en = hello.greeting("en");
        final String ko = hello.greeting("ko");
        Assertions.assertThat(en).isEqualTo("hello world");
        System.out.println(en);
        Assertions.assertThat(ko).isEqualTo("안녕하세요");
        System.out.println(ko);
    }

    @DisplayName("예제 1-15")
    @Test
    void test02() {
        final Hello hello = new Hello();
        final String en = hello.greeting(Factory.EN);
        final String ko = hello.greeting(Factory.KO);
        Assertions.assertThat(en).isEqualTo("hello world");
        System.out.println(en);
        Assertions.assertThat(ko).isEqualTo("안녕하세요");
        System.out.println(ko);
    }
}
