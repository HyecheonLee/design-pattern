package ex03;

import ex01.Command;

import java.util.HashMap;
import java.util.Map;

/**
 * @author hyecheon
 * @email rainbow880616@gmail.com
 */
//명령 패턴
public class Invoker {
    public Map<String, Command> cmd = new HashMap<>();

    //명령 객체를 저장합니다.
    public void setCommand(String key, Command command) {
        cmd.put(key, command);
    }

    //명령 객체를 삭제 합니다.
    public void remove(String key) {
        cmd.remove(key);
    }

    //명령 객체를 실행합니다.
    public void execute(String key) {
        if (cmd.containsKey(key)) {
            cmd.get(key).execute();
        }
    }

    //객체를 실행합니다.
    public void executeAll() {
        cmd.forEach((s, command) -> command.execute());
    }
}
