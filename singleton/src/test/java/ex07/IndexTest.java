package ex07;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

/**
 * @author hyecheon
 * @email rainbow880616@gmail.com
 */
class IndexTest {
    @DisplayName("예제 2-10")
    @Test
    void test1() {
        Config.set("hello");
        final String conf = Config.get();
        Assertions.assertThat(conf).isEqualTo("hello");
    }
}