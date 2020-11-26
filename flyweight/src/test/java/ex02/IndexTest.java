package ex02;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author hyecheon
 * @email rainbow880616@gmail.com
 */
class IndexTest {
    @Test
    void test01() {
        final Korean korean = new Korean();
        Assertions.assertThat(korean.hello()).isEqualTo("안녕하세요\n");
        final English english = new English();
        Assertions.assertThat(english.hello()).isEqualTo("hello\n");
    }
}