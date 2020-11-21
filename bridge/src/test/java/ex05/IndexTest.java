package ex05;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * @author hyecheon
 * @email rainbow880616@gmail.com
 */
class IndexTest {

    @Test
    void test01() {
        final Message message = getMessage("english");
        Assertions.assertThat(message.greeting()).isEqualTo("hello");
        final Message message2 = getMessage("Korean");
        Assertions.assertThat(message2.greeting()).isEqualTo("안녕하세요");

    }

    private Message getMessage(String language) {
        final Message message;
        if (language.equals("Korean")) {
            message = new Message(new Korean());
        } else {
            message = new Message(new English());
        }
        return message;
    }
}