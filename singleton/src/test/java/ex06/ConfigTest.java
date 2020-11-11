package ex06;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

/**
 * @author hyecheon
 * @email rainbow880616@gmail.com
 */
class IndexTest {

    @DisplayName("예제 2-9")
    @Test
    void test01() {
        final Config obj1 = Config.getInstance();
        final Config obj2 = Config.getInstance();
        Assertions.assertThat(obj1).isEqualTo(obj2);
    }
}