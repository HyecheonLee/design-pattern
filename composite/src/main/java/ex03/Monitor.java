package ex03;

import java.util.ArrayList;
import java.util.List;

/**
 * @author hyecheon
 * @email rainbow880616@gmail.com
 */
public class Monitor {
    public List<Monitor> screen = new ArrayList<>();
    public String name = "모니터";

    public void addMonitor(Monitor monitor) {
        screen.add(monitor);
    }

    public void show() {
        screen.forEach(part -> {
            System.out.println(part.name);
        });
    }
}
