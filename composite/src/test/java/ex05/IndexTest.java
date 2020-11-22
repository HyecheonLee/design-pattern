package ex05;

import org.junit.jupiter.api.Test;

import java.util.Map;

/**
 * @author hyecheon
 * @email rainbow880616@gmail.com
 */
class IndexTest {

    @Test
    void test01() {
        //폴더
        final Composite root = new Composite("root");
        final Composite home = new Composite("home");
        final Composite hojin = new Composite("hojin");
        final Composite jiny = new Composite("jiny");
        final Composite users = new Composite("user");
        final Composite temp = new Composite("temp");

        //파일
        final Leaf img1 = new Leaf("img1");
        final Leaf img2 = new Leaf("img2");
        final Leaf img3 = new Leaf("img3");
        final Leaf img4 = new Leaf("img4");

        root.addNode(home);
        root.addNode(users);
        users.addNode(hojin);
        hojin.addNode(img1);
        hojin.addNode(img2);
        hojin.addNode(img3);
        hojin.addNode(img4);
        users.addNode(jiny);
        root.addNode(temp);
        tree(root);
    }

    @Test
    void test2() {
        //폴더
        final Composite root = new Composite("root");
        final Composite home = new Composite("home");
        final Composite hojin = new Composite("hojin");
        final Composite jiny = new Composite("jiny");
        final Composite users = new Composite("user");
        final Composite temp = new Composite("temp");

        //파일
        final Leaf img1 = new Leaf("img1");
        final Leaf img2 = new Leaf("img2");
        final Leaf img3 = new Leaf("img3");
        final Leaf img4 = new Leaf("img4");

        root.addNode(home);
        root.addNode(users);
        users.addNode(hojin);
        hojin.addNode(img1);
        hojin.addNode(img2);
        hojin.addNode(img3);
        hojin.addNode(img4);
        users.addNode(jiny);
        root.addNode(temp);

        users.removeNode(hojin);
        tree(root);
    }

    public void tree(Composite composite) {
        final Map<String, Component> children = composite.children;
        children.forEach((key, value) -> {
            if (value instanceof Composite) {
                System.out.print("Folder = " + key);
                if (((Composite) value).isNode()) {
                    System.out.println();
                    tree((Composite) value);
                } else {
                    System.out.println("... 노드 없음");
                }
            } else if (value instanceof Leaf) {
                System.out.println("File : " + key);
            } else {
                System.out.println("??");
            }
        });
    }
}