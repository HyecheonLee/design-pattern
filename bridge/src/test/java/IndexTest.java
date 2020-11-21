import ex01.Hello;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

/**
 * @author hyecheon
 * @email rainbow880616@gmail.com
 */
class IndexTest {

    @DisplayName("예제 8-2")
    @Test
    void test() {
        final Hello hello = new Hello();
        Assertions.assertThat(hello.greeting()).isEqualTo("hello");
        System.out.println("hello.greeting() = " + hello.greeting());
    }
}