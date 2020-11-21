package ex05;

/**
 * @author hyecheon
 * @email rainbow880616@gmail.com
 */
public class Message extends Language {
    public Message(Hello language) {
        this.language = language;
    }

    @Override
    public String greeting() {
        return language.greeting();
    }
}
