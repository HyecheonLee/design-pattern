package ex01;

import ex01.door.DoorProduct;
import ex01.tire.TireProduct;

/**
 * @author hyecheon
 * @email rainbow880616@gmail.com
 */
//추상클래스
abstract public class Factory {
    abstract public TireProduct createTire();

    abstract public DoorProduct createDoor();
}
