package ex05;

import java.util.ArrayList;
import java.util.List;

/**
 * @author hyecheon
 * @email rainbow880616@gmail.com
 */
public class Composite implements Component {
    private final String name;
    public List<Component> children = new ArrayList<>();

    public Composite(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void addNode(Component folder) {
        children.add(folder);
    }

    public void removeNode(Component component) {
        children.remove(component);
    }

    public Boolean isNode() {
        return !children.isEmpty();
    }

    @Override
    public void print() {
        System.out.print("Folder : " + this.getName());
        if (isNode()) {
            System.out.println();
            children.forEach(Component::print);
        } else {
            System.out.println("... 노드 없음");
        }
    }
}