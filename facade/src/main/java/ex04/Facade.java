package ex04;

import ex03.Package1;
import ex03.Package2;
import ex03.Package3;

/**
 * @author hyecheon
 * @email rainbow880616@gmail.com
 */
public class Facade {
    private Package1 package1;
    private Package2 package2;
    private Package3 package3;

    public Facade() {
        package1 = new Package1();
        package2 = new Package2();
        package3 = new Package3();
    }

    public void processAll() {
        package1.process();
        package2.process();
        package3.process();
    }
}
