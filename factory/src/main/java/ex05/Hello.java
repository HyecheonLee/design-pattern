package ex05;

/**
 * @author hyecheon
 * @email rainbow880616@gmail.com
 */
public class Hello {
    public String greeting(String type) {
        final Language language = Factory.getInstance(type);
        return language.text();
    }
}
