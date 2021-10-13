package racinggame;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racinggame.domain.Car;
import racinggame.util.GameException;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class CarTest {

    private List<Car> carList;

    @BeforeEach
    void setUp() {
        carList = new ArrayList<>();
        carList.add(new Car.CarBuilder()
                .name("kia")
                .build()
        );
        carList.add(new Car.CarBuilder()
                .name("hyun")
                .build()
        );
        carList.add(new Car.CarBuilder()
                .name("chevo")
                .build()
        );
    }

    @DisplayName("생성한 CarList가 맞게 생성되는지 확인")
    @Test
    void createCarTest() {
        for (int i = 0; i < carList.size(); i++) {
            assertThat(carList.get(i))
                    .isInstanceOf(Car.class);
        }
    }

    @DisplayName("생성할 당시 이름이 5글자까지 생성되는지 확인")
    @Test
    void carNameLengthTest() {
        assertThatThrownBy(() -> new Car.CarBuilder()
                .name("abcdef")
                .build())
                .isInstanceOf(GameException.class)
                .hasMessageContaining("[ERROR] : 이름은 5글자 이하만 가능합니다.");
    }
}
