package ex04;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author hyecheon
 * @email rainbow880616@gmail.com
 */
class FacadeTest {
    @Test
    void test01() {
        //파사드
        final Facade facade = new Facade();
        facade.processAll();
    }
}