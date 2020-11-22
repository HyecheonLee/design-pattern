package ex05;

/**
 * @author hyecheon
 * @email rainbow880616@gmail.com
 */
public class Leaf extends Component {
    private String data;

    public Leaf(String name) {
        setName(name);
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }
}
