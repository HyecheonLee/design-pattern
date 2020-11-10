package ex04;

import ex03.Korean;

/**
 * @author hyecheon
 * @email rainbow880616@gmail.com
 */
public class Factory {
    public static Korean getInstance() {
        return new Korean();
    }
}
