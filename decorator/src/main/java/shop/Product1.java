package shop;

/**
 * @author hyecheon
 * @email rainbow880616@gmail.com
 */
public class Product1 implements Component {
    @Override
    public String product() {
        return "원피스";
    }

    @Override
    public int price() {
        return 20000;
    }
}
