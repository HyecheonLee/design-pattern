package ex03;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author hyecheon
 * @email rainbow880616@gmail.com
 */
class IndexTest {
    @Test
    void test01() {
        final Package1 package1 = new Package1();
        package1.process();
        final Package2 package2 = new Package2();
        package2.process();
        final Package3 package3 = new Package3();
        package3.process();
    }
}