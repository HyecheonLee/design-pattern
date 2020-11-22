package ex02;

/**
 * @author hyecheon
 * @email rainbow880616@gmail.com
 */
public class Computer {
    public Monitor monitor;
    public Disk disk;
    public Memory memory;
    public String name = "구성";

    public void setMonitor(Monitor monitor) {
        this.monitor = monitor;
    }

    public void setDisk(Disk disk) {
        this.disk = disk;
    }

    public void setMemory(Memory memory) {
        this.memory = memory;
    }

}
