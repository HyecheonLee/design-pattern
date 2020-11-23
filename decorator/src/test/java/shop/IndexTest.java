package shop;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * @author hyecheon
 * @email rainbow880616@gmail.com
 */
class IndexTest {
    @Test
    void test01() {
        final Component p = new Product1();
        Component spec = new I7(p);
        spec = new Ssd256(spec);

        Assertions.assertThat(spec.product()).isEqualTo("원피스,i7,ssd256");
        Assertions.assertThat(spec.price()).isEqualTo(605000);
    }
}