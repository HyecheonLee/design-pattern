package ex04;

/**
 * @author hyecheon
 * @email rainbow880616@gmail.com
 */
public class ProductFactory extends Factory {
    @Override
    public Product createProduct(String model) {
        if (model.equals("LG")) {
            return new LgProduct();
        }
        if (model.equals("SAMSUNG")) {
            return new SamsungProduct();
        }
        throw new RuntimeException("잘못된 모델명 입니다.");
    }
}
