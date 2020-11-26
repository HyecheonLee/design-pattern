package ex03;

/**
 * @author hyecheon
 * @email rainbow880616@gmail.com
 */
public class Korean {
    private final Hello hello;

    public Korean(Hello hello) {
        this.hello = hello;
    }

    public String hello() {
        return hello.browser("안녕하세요");
    }
}
