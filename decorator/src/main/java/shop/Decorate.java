package shop;

/**
 * @author hyecheon
 * @email rainbow880616@gmail.com
 */
abstract public class Decorate implements Component {
    @Override
    abstract public String product();

    @Override
    abstract public int price();
}
