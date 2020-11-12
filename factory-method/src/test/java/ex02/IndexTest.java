package ex02;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

/**
 * @author hyecheon
 * @email rainbow880616@gmail.com
 */
class IndexTest {
    @DisplayName("예제 3-4")
    @Test
    void test01() {
        final Factory factory = new Factory();
        final LgProduct product = factory.create();
        Assertions.assertThat(product.name()).isEqualTo("LG Gram laptop");
    }
}