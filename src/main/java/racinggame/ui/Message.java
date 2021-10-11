package racinggame.ui;

public enum Message {
    INPUT_CAR_NAME("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)"),
    INPUT_ATTEMPTS("시도할 회수는 몇회인가요?"),
    ACTIVE_RESULT("실행 결과"),
    ERROR_PREFIX("[ERROR] : ");

    private String message;

    Message(String message) {
        this.message = message;
    }

    public void getMessage() {
        System.out.println(this.message);
    }
}
