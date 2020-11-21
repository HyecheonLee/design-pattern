package ex04;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * @author hyecheon
 * @email rainbow880616@gmail.com
 */
class IndexTest {
    @Test
    void test01() {
        final Korean korean = new Korean();
        Assertions.assertThat(korean.greeting()).isEqualTo("안녕하세요");
        final English english = new English();
        Assertions.assertThat(english.greeting()).isEqualTo("hello");
    }

    @Test
    void test02() {
        Language language = new Language();

        language.setEnglish(new English());
        Assertions.assertThat(language.english.greeting()).isEqualTo("hello");

        language.setKorean(new Korean());
        Assertions.assertThat(language.korean.greeting()).isEqualTo("안녕하세요");
    }
}