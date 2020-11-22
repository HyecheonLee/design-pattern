package ex04;

import java.util.HashMap;
import java.util.Map;

/**
 * @author hyecheon
 * @email rainbow880616@gmail.com
 */
public class Composite extends Component {
    public Map<String, Component> children = new HashMap<>();

    public Composite(String name) {
        setName(name);
    }

    public void addNode(Component folder) {
        final String name = folder.getName();
        children.put(name, folder);
    }

    public void removeNode(Component component) {
        final String name = component.getName();
        children.remove(name);
    }

    public boolean isNode(Component component) {
        return children.containsKey(component.getName());
    }
}
