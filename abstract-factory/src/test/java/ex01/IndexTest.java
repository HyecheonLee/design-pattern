package ex01;

import ex01.door.DoorProduct;
import ex01.tire.TireProduct;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

/**
 * @author hyecheon
 * @email rainbow880616@gmail.com
 */
class IndexTest {
    @DisplayName("예제 4-10")
    @Test
    void test() {
        final KoreaFactory korea = new KoreaFactory();
        final TireProduct tire = korea.createTire();
        tire.makeAssemble();

        final DoorProduct door = korea.createDoor();
        door.makeAssemble();

        final StateFactory state = new StateFactory();
        state.createTire().makeAssemble();
        state.createDoor().makeAssemble();
    }
}