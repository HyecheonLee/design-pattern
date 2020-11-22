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
        final Computer computer = new Computer();
        computer.setMonitor(new Monitor());
        computer.setDisk(new Disk());
        computer.setMemory(new Memory());

        Assertions.assertThat(computer.name).isEqualTo("구성");
        Assertions.assertThat(computer.monitor.name).isEqualTo("모니터");
        Assertions.assertThat(computer.disk.name).isEqualTo("디스크");
        Assertions.assertThat(computer.memory.name).isEqualTo("메모리");
    }
}