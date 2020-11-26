package ex03;

/**
 * @author hyecheon
 * @email rainbow880616@gmail.com
 */
public class English {
    private final Hello hello;

    public English(Hello hello) {
        this.hello = hello;
    }

    public String hello() {
        return hello.browser("hello");
    }
}
