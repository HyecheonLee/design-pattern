package ex01;

import java.util.List;

/**
 * @author hyecheon
 * @email rainbow880616@gmail.com
 */
public class ProductModel extends Algorithm {

    public ProductModel() {
        composite = new Computer();
    }

    @Override
    ProductModel setCpu(String cpu) {
        composite.setCpu(new Cpu(cpu));
        return this;
    }

    @Override
    Algorithm setRam(List<Memory> rams) {
        for (Memory memory : rams) {
            composite.addMemory(memory);
        }
        return this;
    }

    @Override
    Algorithm setStorage(List<Storage> storages) {
        for (Storage storage : storages) {
            composite.addStorage(storage);
        }
        return this;
    }
}
