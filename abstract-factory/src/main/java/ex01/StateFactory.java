package ex01;

import ex01.door.DoorProduct;
import ex01.door.StateDoorProduct;
import ex01.tire.StateTireProduct;
import ex01.tire.TireProduct;

/**
 * @author hyecheon
 * @email rainbow880616@gmail.com
 */
public class StateFactory extends Factory {
    @Override
    public TireProduct createTire() {
        return new StateTireProduct();
    }

    @Override
    public DoorProduct createDoor() {
        return new StateDoorProduct();
    }
}
