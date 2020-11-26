package ex03;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * @author hyecheon
 * @email rainbow880616@gmail.com
 */
class IndexTest {
    @Test
    void test01() {
        final Runtime runtime = Runtime.getRuntime();

        System.out.println("메모리 사용량 =" + ((runtime.totalMemory() - runtime.freeMemory())) + "Byte");

        final Korean ko = new Korean(new Hello());
        Assertions.assertThat(ko.hello()).isEqualTo("안녕하세요<br/>");


        final English english = new English(new Hello());
        Assertions.assertThat(english.hello()).isEqualTo("hello<br/>");

        System.out.println("메모리 사용량 =" + ((runtime.totalMemory() - runtime.freeMemory())) + "Byte");

    }

    @Test
    void test02() {
        final Runtime runtime = Runtime.getRuntime();

        System.out.println("메모리 사용량 =" + ((runtime.totalMemory() - runtime.freeMemory())) + "Byte");

        final Hello hello = new Hello();
        final Korean ko = new Korean(hello);
        Assertions.assertThat(ko.hello()).isEqualTo("안녕하세요<br/>");


        final English english = new English(hello);
        Assertions.assertThat(english.hello()).isEqualTo("hello<br/>");

        System.out.println("메모리 사용량 =" + ((runtime.totalMemory() - runtime.freeMemory())) + "Byte");
    }

    @Test
    void test03() {
        final Hello hello1 = new Factory().make();

        final Hello hello2 = new Factory().make();

        Assertions.assertThat(hello1).isNotEqualTo(hello2);
    }

    @Test
    void test04() {
        final Hello hello1 = new Factory().make2();

        final Hello hello2 = new Factory().make2();

        Assertions.assertThat(hello1).isEqualTo(hello2);
    }

    @Test
    void test05() {
        final Factory factory = new Factory();
        final Hello hello1 = factory.make3("Hello");

        final Hello hello2 = factory.make3("Hello");

        Assertions.assertThat(hello1).isEqualTo(hello2);
    }
}