# 명령 패턴

---

## 1. 명령 처리

> 작업하는 동작 자체를 다른 객체에 전달하는 경우 명령 패턴은 객체로 캡슐화 하여 전달

#### 1.1 명령 클래스

> 객체지향 프로그래밍에서는 데이터와 행위를 하나의 객체로 묶어 캡슐화  
> 객체는 '동작의 행위'와 '행위를 실행하는 호출 메서드'를 합께 만드는데 이렇게 구현 하는 방법을 작업의 객체화
> 명령 패턴에서는 동작 명령을 하나의 클래스 형태로 표현하며 수행하는 동작을 메서드 형태가 아닌 객체 형태로 별도로 생성  
> 명령 패턴은 유사한 동작을 하나의 객체로 묶어 실행하는 행위 패턴

#### 1.2 객체 전달

> 명령 패턴은 동작을 하나의 객체로 캡슐화하여 행위를 실행, 명령 패턴은 실제 작업을 수행하는 객체와 이를 실행하는 객체로 분리하여 설계

---

## 2. 명령 패턴의 구성과 특징

#### 2.1 구성 요소

> 명령 패턴은 복수의 명령을 처리하기 위해 객체 간 관계를 정의

* 인터페이스
* 명령
* 리시버
* 인보커

#### 2.2 매개변수

> 명령 패턴은 동작을 객체화하여 매개변수 형태로 전달 명령 객체로 프로퍼티에 저장한 후 임의의 시점에서 일괄 실행하는 형태
> 명령 패턴은 객체의 실행 동작 시점을 분리하여 지연  
> 명령 패턴은 객체지향적인 콜백 처리와 같다.

#### 2.3 시점 제어

> 명령 패턴은 작업의 요청과 처리를 분리하고 요청하는 작업들을 객체로 캡슐화 객체의 실제 동작과 호출 실행 부분을 분리하면 동작의 실행 시점을 제어할 수 있다.  
> 실행 시점을 미리 설정한 후 실행하는 것, 명령 패턴을 이용하면 동작 실행의 예약 처리

#### 2.4 복구

#### 2.5 저장

---

## 3. 인터페이스

> 명령 패턴은 동일한 명령 구조와 호출을 위해 인터페이스를 정의

#### 3.1 일관된 동작

> 실체 객체의 동작을 실행하는 방법이 클래스마다 다르다면 코드 재사용이 어렵다.  
> 객체를 실행할 때는 통일화된 동작이 필요  
> 명령 패턴은 일관적인 코드 실행과 재사용을 위해 실행 메서드 호출을 하나로 통일  
> 인터페이스는 선언된 메서드를 클래스에서 반드시 구현해야 하는 의무

#### 3.2 인터페이스 설계

```java
//명령 패턴 : 인터페이스
public interface Command {
    //실행 메서드
    public void execute();
}
```

---

## 4. 명령

> 명령으로 실행되는 실체 객체를 구현. 명령 객체는 일급 객체로 분류

#### 4.1 실행 메서드

> 실행되는 모든 객체는 Command 인터페이스를 적용 인터페이스에는 통일화된 실행 메서드가 선언

#### 4.2 명령 객체

> 객체는 명령에 따라 별개의 독립된 객체로 작성 명령 객체는 실행을 호출하는 메서드를 통일하기 위해 Command 인터페이스를 적용

```java
//명령 객체
public class Exec1 implements Command {
    // 인터페이스 적용
    // 실행 메서드 구현
    @Override
    public void execute() {
        System.out.println("명령1을  실행합니다.");
        //추가 코드 작성
    }
}
```

#### 4.3 실행 메서드

> 모든 실행 객체는 인터페이스에서 정의도니 실행 메서드를 갖고있다.
> 캡슐화된 실행 객체의 execute() 메서드만 호출하면 객체를 실행할 수 있다.

```java
class IndexTest {
    @Test
    void test01() {
        //명령 객체를 생성
        final Exec1 exec1 = new Exec1();
        // 객체를 실행
        exec1.execute();
    }
}
```

---

## 5. 리시버

> 명령의 실행 동작을 내부적으로 구현하는 것과 달리 외부로부터 객체를 위임 받아 대신 호출

#### 5.1 실제 동작

```java
public class Concrete {
    public void action1() {
        System.out.println("동작1: 안녕하세요.");
    }

    public void action2() {
        System.out.println("동작2: 즐거운 시간 되세요.");
    }
}
```

#### 5.2 객체 인자

> 명령 객체를 생성할 때는 실행 동작을 직접 구현하지 않고 외부로부터 동작을 위임 받아 처리

```java
public class Exec2 implements Command {
    Concrete receiver;

    public Exec2(Concrete receiver) {
        this.receiver = receiver;
    }

    @Override
    public void execute() {
        System.out.println("명령2를 실행합니다.");
        //여러 개의 리시버 동작을 처리할 수 있습니다.
        //실체 객체의 명령을 수행합니다.
        receiver.action1();
        receiver.action2();
        //추가 코드 작성
    }
}
```

#### 5.3 리시버 연결

> 리시버는 클라이언트로부터 생성된 Concrete 객체를 보관합니다.
> 명령 객체는 실체 객체를 리시버로 연결해 하나의 객체로 캡슐화, 리시버 동작의 경우 수신자 - 동작이 한 쌍으로 처리

```java
class IndexTest {
    @Test
    void test01() {
        final Concrete concrete = new Concrete();
        //명령 객체를 생성합니다.
        final Exec2 cmd = new Exec2(concrete);
        //객체를 실행합니다.
        cmd.execute();
    }
}
```

---

## 6.인보커

> 인보커는 생성된 명령 객체를 저장하고 관리하는 역할

#### 6.1 요구 저장

> 인보커는 작업을 저장하는 객체. 명령 객체를 생성하여 인보커에 등록하면 저장된 명령 객체를 관리

```java
//명령 패턴
public class Invoker {
    public Map<String, Command> cmd = new HashMap<>();

    //명령 객체를 저장합니다.
    public void setCommand(String key, Command command) {
        cmd.put(key, command);
    }

    //명령 객체를 삭제 합니다.
    public void remove(String key) {
        cmd.remove(key);
    }

    //명령 객체를 실행합니다.
    public void execute(String key) {
        if (cmd.containsKey(key)) {
            cmd.get(key).execute();
        }
    }
}
```

#### 6.2 명령 목록

> 명령의 동작을 다른 마롤 이벤트. 이벤트 명령은 이벤트 목록에 저장되고 명령을 순차적으로 처리

#### 6.3 요청 실행

```java
class IndexTest {
    @Test
    void test01() {
        //명령 객체를 생성
        final Exec1 exec1 = new Exec1();
        final Concrete receiver = new Concrete();
        //명령 객체를 생성
        final Exec2 exec2 = new Exec2(receiver);
        //인보커
        final Invoker invoker = new Invoker();
        invoker.setCommand("cmd1", exec1);
        invoker.setCommand("cmd2", exec2);
        //객체를 실행
        invoker.execute("cmd1");
        invoker.execute("cmd2");
    }
}
```

#### 6.4 매크로 처리

> 인보커에 다수의 명령 객체를 갖고 모든 명령 객체를 한번에 수행할 수 있는 매크로

```
//객체를 실행합니다.
    public void executeAll() {
        cmd.forEach((s, command) -> command.execute());
    }
```

--

## 7. 클라이언트

> 클라이언트는 명령 패턴에서 새로운 명령 객체를 생성하고 생성된 명령 객체를 다시 리시버에 전달하며 인보커에 저장된 명령 객체 실행을 요청

#### 7.1 클라이언트

> 클라이언트는 명령 객체를 생성하고 리시버 객체에 명령 인자값으로 명령 객체를 전달하는 역할

#### 7.2 익명 클래스

```java
class IndexTest {
    @Test
    void test02() {
        //Command 인터페이스를 적용한 익명함수를 저장합니다.
        final Invoker invoker = new Invoker();
        invoker.setCommand("cmd1", new Command() {
            @Override
            public void execute() {
                System.out.println("명령1을 실행합니다.");
            }
        });
        invoker.setCommand("cmd2", () -> System.out.println("명령2을 실행합니다."));
        invoker.executeAll();
    }
}
```

---

## 8. undo

#### 8.1 취소 동작

> 다수의 메서드를 인터페이스 형태로 선언해 다양한 실행 동작을 지정
> 실행 및 취소 기능은 명령 패턴을 응용한 사례

#### 8.2 undo 추가

```java
//명령 패턴: 인터페이스
public interface Command {
    //실행 메서드
    public void execute();

    //취소 명령
    public void undo();
}
```

#### 8.3 undo 기능 구현

```java
public class Exec1 implements Command {
    //인터페이스 적용
    //실행 메서드 구현
    @Override
    public void execute() {
        System.out.println("명령1을 실행합니다.");
    }

    //취소 기능 추가
    @Override
    public void undo() {
        System.out.println("명령1 실행을 취소합니다.");
    }
}
```

#### 8.4 undo 실행

```java
class IndexTest {
    @Test
    void name() {
        //명령 객체를 생성
        final Exec1 exec1 = new Exec1();

        //객체를 실행
        exec1.execute();
        exec1.undo();
    }
}
```

#### 8.5 undo 상태 저장

> 명령 객체의 undo() 메서드는 작업한 객체 실행을 취소하는 동작.
> 여러 개의 명령객체가 순차적으로 실행됐다면 취소 동작도 역순으로 순차 실행
> 복수의 명령 객체를 취소할 때는 인보커를 통해 마지막 으로 실행한 명령 상태를 저장하는 방법 사용

---

## 9. 장단점

> 명령 패턴은 요청과 실행이 서로 의존하지 않는 구조를 만들 때 매우 유용합니다.

#### 9.1 확장성

> 기존의 코드 수정 없이 명령 객체를 추가해 실행 동작을 확장할 수 있다.  
> 여러 개의 명령을 하나의 리스트로 묶어 실행가능.

### 9.2 클래스 개수

> 명령 패턴은 다수의 명령이 존재할 때 클래스의 개수가 증가.  
> 클라이언트는 명령 클래스의 인스턴스를 생성하며 명령 실행은 인보커가 처리