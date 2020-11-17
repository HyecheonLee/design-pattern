import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

/**
 * @author hyecheon
 * @email rainbow880616@gmail.com
 */
class IndexTest {
    @DisplayName("예제 7-4")
    @Test
    void test01() {
        final Objects obj = new Objects();
        Assertions.assertThat(obj.twiceOf(5)).isEqualTo(10);
        Assertions.assertThat(obj.halfOf(4)).isEqualTo(2);
    }
}