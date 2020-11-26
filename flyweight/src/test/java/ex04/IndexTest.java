package ex04;

import org.junit.jupiter.api.Test;

/**
 * @author hyecheon
 * @email rainbow880616@gmail.com
 */
class IndexTest {
    @Test
    void test01() {
        final Factory factory = new Factory();
        String name = "goooogllleee";
        for (int i = 0; i < name.length(); i++) {
            final char c = name.charAt(i);
            System.out.print(c + " => ");
            factory.getCode(c + "").code();
        }
    }
}