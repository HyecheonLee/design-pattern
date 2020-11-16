/**
 * @author hyecheon
 * @email rainbow880616@gmail.com
 */
public class Hello implements Cloneable {
    private String message;

    public Hello() {
    }

    public Hello(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }


}
