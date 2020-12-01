package ex05;

/**
 * @author hyecheon
 * @email rainbow880616@gmail.com
 */
//명령 패턴: 인터페이스
public interface Command {
    //실행 메서드
    public void execute();

    //취소 명령
    public void undo();
}
