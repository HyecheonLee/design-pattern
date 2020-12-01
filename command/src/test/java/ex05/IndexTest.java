package ex05;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author hyecheon
 * @email rainbow880616@gmail.com
 */
class IndexTest {
    @Test
    void name() {
        final Exec1 exec1 = new Exec1();
        exec1.execute();
        exec1.undo();
    }
}