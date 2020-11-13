package ex01.tire;

/**
 * @author hyecheon
 * @email rainbow880616@gmail.com
 */
public class StateTireProduct extends TireProduct {
    @Override
    public void makeAssemble() {
        System.out.println("미국형 타이어 장착");
    }
}
