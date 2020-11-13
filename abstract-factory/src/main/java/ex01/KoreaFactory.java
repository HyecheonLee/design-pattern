package ex01;

import ex01.door.DoorProduct;
import ex01.door.KoreaDoorProduct;
import ex01.tire.KoreaTireProduct;
import ex01.tire.TireProduct;

/**
 * @author hyecheon
 * @email rainbow880616@gmail.com
 */
public class KoreaFactory extends Factory {
    @Override
    public TireProduct createTire() {
        return new KoreaTireProduct();
    }

    @Override
    public DoorProduct createDoor() {
        return new KoreaDoorProduct();
    }
}
