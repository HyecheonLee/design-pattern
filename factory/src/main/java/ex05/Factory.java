package ex05;


/**
 * @author hyecheon
 * @email rainbow880616@gmail.com
 */
public class Factory {

    public static final String KO = "ko";
    public static final String EN = "en";

    public static Language getInstance(String type) throws RuntimeException {
        if (KO.equals(type)) {
            return new Korean();
        } else if (EN.equals(type)) {
            return new English();
        }
        throw new RuntimeException("지원하지 않는 타입니다.");
    }
}
