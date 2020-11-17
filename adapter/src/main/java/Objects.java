/**
 * @author hyecheon
 * @email rainbow880616@gmail.com
 */
public class Objects implements Adapter {
    private Math adapter;

    public Objects() {
        this.adapter = new Math();
    }

    @Override
    public int twiceOf(int num) {
        // 캐스팅을 통해 정수로 변환하여 반환
        return (int) this.adapter.twoTime(num);
    }

    @Override
    public int halfOf(int num) {
        // 캐스팅을 통해 정수로 변환하여 반환
        return (int) this.adapter.halfTime(num);
    }
}
