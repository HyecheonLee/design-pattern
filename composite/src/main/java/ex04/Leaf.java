package ex04;

/**
 * @author hyecheon
 * @email rainbow880616@gmail.com
 */
public class Leaf extends Component {
    private String price;

    public Leaf(String name) {
        setName(name);
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }
}
