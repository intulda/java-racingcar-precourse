package racinggame.ui;

import racinggame.domain.Car;

import java.util.List;

/**
 * 전체적인 View를 담담하는 클래스
 */
public class View {

    /**
     * 게임 시작 메세지 및 인풋
     */
    public void printGameStart() {
        Message.INPUT_CAR_NAME.getMessage();
    }

    /**
     * 에러타입에 따른 메세지 출력
     * @param type
     */
    public void printErrorMessage(String type) {
        Message.valueOf(type).getErrorMessage();
    }

    /**
     * 승리자 출력 리스트
     * @param winners
     */
    public void getWinners(List<Car> winners) {
        StringBuilder sb = new StringBuilder();
        for (Car car : winners) {
            sb.append(car.getName());
        }
        String joinSeparate = String.join(Message.CAR_NAME_SEPARATOR.name(), sb);
        System.out.println(Message.WINNERS_PREFIX + joinSeparate + Message.WINNERS_SUFFIX);
    }
}
