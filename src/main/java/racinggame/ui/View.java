package racinggame.ui;

import nextstep.utils.Console;
import racinggame.domain.Car;
import racinggame.service.Field;

import java.util.ArrayList;
import java.util.List;

/**
 * 전체적인 View를 담담하는 클래스
 */
public class View {

    /**
     * 게임 시작 메세지 유저 이름 정하기
     */
    public String printGameStart() {
        Message.INPUT_CAR_NAME.getMessage();
        return Console.readLine();
    }

    /**
     * 몇 번의 이동을 할 것인지 입력
     * @return
     */
    public String printAttempt() {
        Message.INPUT_ATTEMPTS.getMessage();
        return Console.readLine();
    }

    /**
     * 실행 결과 view만들어주는 메소드
     * @param cars
     */
    public void getRoundResult(List<Car> cars) {
        for (Car car : cars) {
            System.out.println(car.getName() + " : " + Field.numberFormatDash(car.getLocation()));
        }
        System.out.println("");
    }

    /**
     * 승리자 출력 리스트
     * @param winners
     */
    public void getWinners(List<Car> winners) {
        List<String> names = new ArrayList<>();

        for (Car car : winners) {
            names.add(car.getName());
        }

        String joinSeparate = String.join(Message.CAR_NAME_SEPARATOR.getValue(), names);
        System.out.println(Message.WINNERS_PREFIX.getValue() + joinSeparate + " " + Message.WINNERS_SUFFIX.getValue());
    }
}
