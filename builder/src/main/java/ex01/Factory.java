package ex01;

import java.util.Arrays;

/**
 * @author hyecheon
 * @email rainbow880616@gmail.com
 */
public class Factory extends Builder {

    public Factory(Algorithm algorithm) {
        this.algorithm = algorithm;
    }

    @Override
    public Builder build() {
        algorithm.setCpu("i7")
                .setRam(Arrays.asList(new Memory(8), new Memory(8)))
                .setStorage(Arrays.asList(new Storage(256), new Storage(512)));
        return this;
    }
}
