package ex03;

/**
 * @author hyecheon
 * @email rainbow880616@gmail.com
 */
public abstract class Factory {
    public final Product create() {
        return this.createProduct();
    }

    /*
     * 추상 메서드 선언
     * */
    abstract Product createProduct();
}
