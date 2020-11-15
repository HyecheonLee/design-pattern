package ex01;

import java.util.ArrayList;
import java.util.List;

/**
 * @author hyecheon
 * @email rainbow880616@gmail.com
 */
public class Computer {
    public Cpu cpu;
    public List<Memory> rams = new ArrayList<>();
    public List<Storage> storages = new ArrayList<>();


    public int memory() {
        int size = 0;
        for (Memory ram : rams) {
            size += ram.getSize();
        }
        return size;
    }

    public int storage() {
        int size = 0;
        for (Storage storage : storages) {
            size += storage.getSize();
        }
        return size;
    }

    public Cpu getCpu() {
        return cpu;
    }

    public void setCpu(Cpu cpu) {
        this.cpu = cpu;
    }

    public List<Memory> getRams() {
        return rams;
    }

    public List<Storage> getStorages() {
        return storages;
    }

    public void addMemory(Memory memory) {
        rams.add(memory);
    }

    public void addStorage(Storage storage) {
        storages.add(storage);
    }

    @Override
    public String toString() {
        return "Computer{" +
                "cpu=" + cpu.getModel() +
                ", rams=" + memory() +
                ", storages=" + storage() +
                '}';
    }
}
