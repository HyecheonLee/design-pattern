package shop;

/**
 * @author hyecheon
 * @email rainbow880616@gmail.com
 */
public class I7 extends Decorate {
    private Component base;

    public I7(Component base) {
        this.base = base;
    }

    @Override
    public String product() {
        return base.product() + ",i7";
    }

    @Override
    public int price() {
        return base.price() + 475000;
    }
}
