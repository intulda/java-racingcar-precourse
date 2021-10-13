package racinggame.service;

import nextstep.utils.Randoms;
import racinggame.domain.Car;
import racinggame.util.GameException;
import racinggame.ui.Message;
import racinggame.ui.View;

import java.util.ArrayList;
import java.util.List;

/**
 * 자동차 경주 게임의 전체적인 서비스를 담당하는 클래스
 */
public class Field {
    private View view;
    private List<Car> cars;
    private List<Car> result;
    private final String NUMBER_CHECK_EXP = "[+-]?\\d*(\\.\\d+)?";
    private int roundNumber = 0;
    private int max = 0;

    public Field() {
        this.view = new View();
        this.result = new ArrayList<>();
    }

    /**
     * 게임시작 함수
     */
    public void gameStart() {
        this.cars = getInputCar();
        this.roundNumber = getInputRound();
        gameStream();
    }

    /**
     * 유저가 입력한 자동차의 이름으로 자동차를 만드는 함수
     */
    private List<Car> getInputCar() {
        try {
            String cars = view.printGameStart();
            return createCar(cars);
        } catch (GameException gameException) {
            System.out.println(Message.CAR_NAME_LENGTH.getErrorMessage());
            return getInputCar();
        }
    }

    /**
     * 유저가 입력한 라운드를 가져오는 함수
     */
    private int getInputRound() {
        try {
            String round = createRound();
            return isNumberValid(round);
        } catch (GameException gameException) {
            System.out.println(Message.ERROR_SUFFIX_MISS_INPUT.getErrorMessage());
            return getInputRound();
        }
    }

    /**
     * 숫자를 대시(-)로 바꿔주는 함수
     * @param location
     * @return
     */
    public static String numberFormatDash(int location) {
        String value = "";
        for (int i = 0; i < location; i++) {
            value += "-";
        }
        return value;
    }

    /**
     * 게임의 진행함수
     */
    private void gameStream() {
        Message.ACTIVE_RESULT.getMessage();
        for (int i = 0; i < this.roundNumber; i++) {
            moveCar();
            view.getRoundResult(this.cars);
            this.max = maxCount();
        }
        List<Car> winners = getWinUsers();
        view.getWinners(winners);
    }

    public List<Car> getWinUsers() {
        List<Car> result = new ArrayList<>();
        for (Car car : cars) {
            if (car.getLocation() >= this.max) {
                result.add(car);
            }
        }
        return result;
    }

    /**
     * 최대 사거리를 구하는 함수
     * @return
     */
    public int maxCount() {
        int max = 0;
        for (Car car : this.cars) {
            max = Math.max(max, car.getLocation());
        }
        return max;
    }

    /**
     * 자동차를 움직이는 함수
     */
    private void moveCar() {
        for (Car car : this.cars) {
            car.move(randomMove());
        }
    }

    /**
     * 유저(자동차)를 생성하는 함수
     * @param names
     * @return
     */
    private List<Car> createCar(String names) {
        ArrayList<Car> cars = new ArrayList<>();
        String[] users = names.split(",");
        for (String name : users) {
            Car car = new Car.CarBuilder()
                    .name(name)
                    .build();
            cars.add(car);
        }
        return cars;
    }

    /**
     * 랜덤 값을 리턴하는 함수
     * @return
     */
    private int randomMove() {
        return Randoms.pickNumberInRange(0, 9);
    }

    /**
     * 문자열이 숫자인지 체크하는 함수
     * @param number
     * @return
     */
    private int isNumberValid(String number) {
        if(!number.matches(NUMBER_CHECK_EXP)) {
            throw new IllegalArgumentException();
        }
        return Integer.parseInt(number);
    }

    /**
     * 라운드 생성 / 사용자의 입력값 받아오기
     * @return
     */
    private String createRound() {
        return view.printAttempt();
    }
}
