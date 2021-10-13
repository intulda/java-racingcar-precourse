package racinggame.ui;

public enum Message {
    INPUT_CAR_NAME("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)"),
    INPUT_ATTEMPTS("시도할 회수는 몇회인가요?"),
    ACTIVE_RESULT("실행 결과"),
    WINNERS_PREFIX("최종 우승자는 "),
    WINNERS_SUFFIX("입니다."),
    ERROR_PREFIX("[ERROR] : "),
    CAR_NAME_SEPARATOR(","),
    CAR_NAME_LENGTH("이름은 5글자 이하만 가능합니다."),
    ERROR_SUFFIX_MISS_INPUT("잘못 된 입력입니다.");

    private String message;

    Message(String message) {
        this.message = message;
    }

    public void getMessage() {
        System.out.println(this.message);
    }

    public String getValue() {
        return this.message;
    }

    public String getErrorMessage() {
        return ERROR_PREFIX.getValue() + this.message;
    }
}
