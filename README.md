# 자동차 경주 게임
## 진행 방법
* 자동차 경주 게임 요구사항을 파악한다.
* 요구사항에 대한 구현을 완료한 후 자신의 github 아이디에 해당하는 브랜치에 Pull Request(이하 PR)를 통해 과제를 제출한다.

## 과제 제출 과정
* [과제 제출 방법](https://github.com/next-step/nextstep-docs/tree/master/precourse)


---

## 기능 요구사항

* 주어진 횟수 동안 n대의 자동차는 전진 또는 멈출 수 있다.
* 각 자동차에 이름을 부여할 수 있다. 전진하는 자동차를 출력할 때 자동차 이름을 같이 출력한다.
* 자동차 이름은 쉼표를 기준으로 구분하며 이름은 5자 이하만 가능하다.
* 사용자는 몇번의 이동을 할 것인지 입력할 수 있어야한다.
* 전진하는 조건은 0에서 9사이에서 random 값을 구한 후 random 값이 4 이상일 경우 저닞ㄴ하고, 3이하의 값이면 멈춘다.
* 자동차 경주 게임을 완료한 후 누가 우승했는지를 알려준다.
* 우승자가 한 명 잇아일 경우, 쉼표,로 이름을 구분해서 출력한다.
* 사용자가 잘못된 값을 입력할 경우 "[ERROR]"로 시작하는 에러 메세지를 출력 후 입력을 다시 받는다.

---

## 구현 클래스

* Car
    - 자동차의 정보를 가지고 있는 클래스
* Field
    - 게임을 전체적으로 관리하는 클래스
* UI
    * Message
        - 메세지 상수 값을 가지고 있는 클래스