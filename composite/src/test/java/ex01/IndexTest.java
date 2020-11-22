package ex01;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * @author hyecheon
 * @email rainbow880616@gmail.com
 */
class IndexTest {
    @Test
    void test01() {
        final Computer computer = new Computer();
        computer.setMonitor(new Monitor());

        Assertions.assertThat(computer.name).isEqualTo("구성");
        Assertions.assertThat(computer.monitor.name).isEqualTo("모니터");
    }
}