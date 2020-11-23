package shop;

/**
 * @author hyecheon
 * @email rainbow880616@gmail.com
 */
public class Ssd256 extends Decorate {
    public Component base;

    public Ssd256(Component base) {
        this.base = base;
    }

    @Override
    public String product() {
        return base.product() + ",ssd256";
    }

    @Override
    public int price() {
        return base.price() + 110000;
    }
}
