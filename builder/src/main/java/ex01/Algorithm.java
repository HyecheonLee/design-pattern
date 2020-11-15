package ex01;

import java.util.List;

/**
 * @author hyecheon
 * @email rainbow880616@gmail.com
 */
//알고리즘의 공통된 동작을 위하여 추상 클래스를 선업합니다.
//각 알고리즘으로 개정의되는 추상 메서드를 선업합니다.
abstract public class Algorithm {
    protected Computer composite;

    //빌더 객체를 저장합니다.
    public Computer getInstance() {
        return composite;
    }

    abstract Algorithm setCpu(String cpu);

    abstract Algorithm setRam(List<Memory> rams);

    abstract Algorithm setStorage(List<Storage> storages);
}
