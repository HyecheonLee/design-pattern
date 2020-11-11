package ex09;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

/**
 * @author hyecheon
 * @email rainbow880616@gmail.com
 */
class IndexTest {
    @DisplayName("예제 2-15")
    @Test
    void test1() {
        final Env env = Env.getInstance();
        env.setting();
    }
}