package ex05;

/**
 * @author hyecheon
 * @email rainbow880616@gmail.com
 */
public class Exec1 implements Command {
    @Override
    public void execute() {
        System.out.println("명령1을 실행합니다.");
    }

    @Override
    public void undo() {
        System.out.println("명령1 실행을 취소합니다.");
    }
}
