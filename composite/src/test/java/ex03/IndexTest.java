package ex03;

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
        computer.monitor.addMonitor(new Monitor32()); // 모니터 추가1
        computer.monitor.addMonitor(new Monitor32()); // 모니터 추가2

        computer.setDisk(new Disk());
        computer.setMemory(new Memory());

        System.out.println(computer.name);
        System.out.println(computer.monitor.name);
        computer.monitor.show();

        System.out.println(computer.disk.name);
        System.out.println(computer.memory.name);
    }
}