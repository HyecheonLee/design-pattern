package ex05;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @author hyecheon
 * @email rainbow880616@gmail.com
 */
public class Composite extends Component {
    public Map<String, Component> children = new LinkedHashMap<>();

    public Composite(String name) {
        setName(name);
    }

    public void addNode(Component folder) {
        children.put(folder.getName(), folder);
    }

    public void removeNode(Component component) {
        children.remove(component.getName());
    }

    public Boolean isNode() {
        return !children.isEmpty();
    }

}
