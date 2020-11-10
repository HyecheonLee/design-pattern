package ex01;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class IndexTest {

    @DisplayName("예제 1-2")
    @Test
    void test1() {
        final Hello hello = new Hello();
        System.out.println(hello.greeting());
        Assertions.assertThat(hello.greeting()).isEqualTo("안녕하세요");
    }
}