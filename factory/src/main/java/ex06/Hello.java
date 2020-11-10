package ex06;

import ex05.Korean;
import ex05.Language;

/**
 * @author hyecheon
 * @email rainbow880616@gmail.com
 */
public class Hello {
    public String greeting() {
        final Language language = Hello.factory();
        return language.text();
    }

    public static Language factory() {
        return new Korean();
    }
}
