package ex05;

/**
 * @author hyecheon
 * @email rainbow880616@gmail.com
 */
public class Leaf implements Component {
    private final String data;

    public Leaf(String data) {
        this.data = data;
    }

    public String getData() {
        return data;
    }

    @Override
    public void print() {
        System.out.println("File :" + getData());
    }
}
