package ex02;

/**
 * @author hyecheon
 * @email rainbow880616@gmail.com
 */
public class Hello {
    public String greeting(String lang) {
        if ("Korean".equals(lang)) {
            return "안녕하세요";
        } else {
            return "Hello";
        }
    }
}
