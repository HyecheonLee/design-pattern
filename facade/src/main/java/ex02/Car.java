package ex02;

/**
 * @author hyecheon
 * @email rainbow880616@gmail.com
 */
public class Car {
    // 1. 클래스의 구성 요소
    //구성 요소의 메서드는 호출해도 된다
    private Engine engine;

    public Car(Engine engine) {
        this.engine = engine;
    }

    public void start(Key key) {
        //3. 새로운 객체 생성
        //내부에서 생성된 객체의 메서드는 호출해도 된다.
        final Doors doors = new Doors();

        //2. 매개변수로 전달된 객체의 메서드는 호출해도 된다.
        final boolean authorized = key.turns();
        if (authorized) {

            //1. 객체의 구성 요소의 메서드는 호출해도 된다.
            engine.start();

            //4. 객체 내에 있는 메서드는 호출해도 된다.
            updateDashboardDisplay();

            //3. 직접 생성하거나 인스턴스를 만든 객체의 메서드는 호출해도 된다.
            doors.lock();
        }

    }

    public void updateDashboardDisplay() {

    }
}
