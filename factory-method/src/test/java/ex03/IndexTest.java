package ex03;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * @author hyecheon
 * @email rainbow880616@gmail.com
 */
class IndexTest {
    @Test
    void test01() {
        final ProductFactory fac = new ProductFactory();
        final Product product = fac.createProduct();
        final String name = product.name();
        System.out.println(name);
        Assertions.assertThat(name).isEqualTo("LG Gram laptop");
    }
}