package ex04;

/**
 * @author hyecheon
 * @email rainbow880616@gmail.com
 */
abstract public class Factory {
    public final Product create(String model) {
        //하위 클래스로 위임
        return createProduct(model);
    }

    //추상 메서드 선어
    abstract public Product createProduct(String model);
}
