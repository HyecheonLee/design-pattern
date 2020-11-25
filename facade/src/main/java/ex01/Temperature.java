package ex01;

/**
 * @author hyecheon
 * @email rainbow880616@gmail.com
 */
public class Temperature {
    Thermometer station;

    public Temperature(Thermometer station) {
        this.station = station;
    }

    public Float getTemp() {

        // 인스턴스를 저장
        final Thermometer thermometer = getThermometer();

        // 인스턴스를 통하여 메서드를 실행
        return thermometer.getTemperature();
    }

    // 불필요한 객체 호출(생성)
    public Thermometer getThermometer() {
        return station;
    }
}
