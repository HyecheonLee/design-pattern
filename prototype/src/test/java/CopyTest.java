import com.esotericsoftware.kryo.Kryo;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

/**
 * @author hyecheon
 * @email rainbow880616@gmail.com
 */
class CopyTest {
    @DisplayName("예제 6-4")
    @Test
    void copy() {
        //객체를 생성합니다.
        final Hello obj = new Hello("안녕하세요");
        System.out.println(obj.getMessage());

        //객체를 복사합니다.
        Hello obj2 = obj;
        obj2.setMessage("Hello world");

        //원본 객체와 복제 객체의 메시지를 출력합니다.
        System.out.println(obj2.getMessage());
        System.out.println(obj.getMessage());
    }

    @Test
    void copy2() {
        final Kryo kryo = new Kryo();
        kryo.register(Hello.class);

        //객체를 생성합니다.
        final Hello obj = new Hello("안녕하세요");
        System.out.println(obj.getMessage());

        //객체를 복사합니다.
        Hello obj2 = kryo.copy(obj);
        obj2.setMessage("Hello world");

        //원본 객체와 복제 객체의 메시지를 출력합니다.
        System.out.println(obj2.getMessage());
        System.out.println(obj.getMessage());
    }
}