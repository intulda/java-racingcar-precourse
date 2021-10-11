package racinggame.domain;

/**
 * 자동차(유저)의 정보를 담고 있는 도메인 클래스
 *
 */
public class Car {
    private String name;
    private int location;

    public Car(CarBuilder carBuilder) {
        this.name = carBuilder.name;
        this.location = carBuilder.location;
    }

    public static class CarBuilder {
        private String name;
        private int location;

        public CarBuilder(String name, int location) {
            this.name = name;
            this.location = location;
        }

        public Car build() {
            return new Car(this);
        }
    }
}
