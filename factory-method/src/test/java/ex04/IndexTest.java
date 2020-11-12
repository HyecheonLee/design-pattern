package ex04;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

/**
 * @author hyecheon
 * @email rainbow880616@gmail.com
 */
class IndexTest {
    @DisplayName("예제 3-12")
    @Test
    void test01() {
        final ProductFactory productFactory = new ProductFactory();

        final Product lg = productFactory.createProduct("LG");
        Assertions.assertThat(lg.name()).isEqualTo("LG Gram laptop");

        final Product samsung = productFactory.createProduct("SAMSUNG");
        Assertions.assertThat(samsung.name()).isEqualTo("Samsung Always laptop");
    }
}