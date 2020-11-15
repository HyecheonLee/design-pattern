package ex01;

/**
 * @author hyecheon
 * @email rainbow880616@gmail.com
 */
abstract public class Builder {
    protected Algorithm algorithm;

    public Builder setAlgorithm(Algorithm algorithm) {
        //빌드할 객체의 알고리즘 객체를 저장합니다.
        this.algorithm = algorithm;
        return this;
    }

    public Computer getInstance() {
        return algorithm.getInstance();
    }

    abstract public Builder build();
}
