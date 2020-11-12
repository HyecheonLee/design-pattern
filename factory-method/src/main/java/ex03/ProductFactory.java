package ex03;

/**
 * @author hyecheon
 * @email rainbow880616@gmail.com
 */
public class ProductFactory extends Factory {
    //추상 메서드 오버라이딩
    @Override
    Product createProduct() {
        return new LgProduct();
    }
}
