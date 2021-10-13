package racinggame.domain;

import racinggame.ui.Message;
import racinggame.util.GameException;

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

    public String getName() {
        return name;
    }

    public void move(int random) {
        if(random >= 4) {
            this.location++;
        }
    }

    public int getLocation() {
        return location;
    }

    public static class CarBuilder {
        private String name;
        private int location;

        public CarBuilder() {
            this.location = 0;
        }

        public CarBuilder name(String name) {
            if (name.length() > 5) {
                throw new GameException(Message.CAR_NAME_LENGTH.getErrorMessage());
            }
            this.name = name;
            return this;
        }

        public Car build() {
            return new Car(this);
        }
    }
}
