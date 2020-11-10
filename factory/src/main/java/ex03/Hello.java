package ex03;

/**
 * @author hyecheon
 * @email rainbow880616@gmail.com
 */
public class Hello {
    private final Korean korean;

    public Hello(Korean korean) {
        this.korean = korean;
    }

    public String greeting() {
        //복합 객체를 호출합니다.
        return this.korean.text();
    }
}
