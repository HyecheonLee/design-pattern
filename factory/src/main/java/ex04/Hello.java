package ex04;

import ex03.Korean;

/**
 * @author hyecheon
 * @email rainbow880616@gmail.com
 */
public class Hello {
    public String greeting() {
        final Korean korean = Factory.getInstance();
        return korean.text();
    }
}
