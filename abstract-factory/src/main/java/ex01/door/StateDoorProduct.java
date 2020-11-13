package ex01.door;

/**
 * @author hyecheon
 * @email rainbow880616@gmail.com
 */
public class StateDoorProduct extends DoorProduct {
    @Override
    public void makeAssemble() {
        System.out.println("미국형 도어 장착");
    }
}
