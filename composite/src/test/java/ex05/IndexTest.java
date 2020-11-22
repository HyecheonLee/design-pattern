package ex05;

import org.junit.jupiter.api.Test;

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

        root.print();
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

        root.print();
    }
}