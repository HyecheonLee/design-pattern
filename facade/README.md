# 파사드 패턴

> 파사드 패턴은 프로그래밍 언어에서 관심사를 분리하는 패턴, 객체지향은 추상적인 개념을 도입해 객체를 캡슐화

---

## 1. 협업을 위한 분리 작업

> 파사드는 시스템 결합과 사용이 용이하도록 관심사를 분리

#### 1.1 복잡한 구조의 개발 작업

> 대형 시스템을 효율적으로 개발하려면 기능을 모듈별로 분리하고 분리된 묘듈을 공동으로 개발하는 것이 좋다.

#### 1.2 분리된 모듈의 결합

> 객제지향 개발 방식에서는 하나의 모듈을 작게 분리하고 클래스로 캡슐화하며, 작게 분리된 모듈은 다른 기능을 구현에도 재사용
> 수많은 클래스 객체가 생성되고 객체는 복잡한 구조의 관계를 가짐

#### 1.3 느슨한 결합

> 파사드 패턴은 강력한 결합 구조를 해결하기 위해 코드의 의존성을 줄이고 느슨한 결합으로 구조를 변경
> 파사드 패턴은 메인 시스템과 서브 시스템 중간에 위치, 새로운 인터페이스 계층을 추가하여 시스템 간 의존성을 해결

#### 1.4 간접 접근

> 파사드는 각각의 모듈 객체에 직접 접근해서 호출을 하지 않고 파사드의 인터페이스 계층을 통해 간접적으로 접근.
> 파사드의 인터페이스 계층은 접근할 수 있는 하나의 통로 역할만 담당

---

## 2. 파사드 패턴을 응요한 API

> 파사드 패턴은 클라우드, 서비스API를 구축할 때 응용되는 패턴

#### 2.1 구조

> 파사드 패턴은 어떤 기능에 접근할 수 있는 단일화된 추상 클래스를 만든다.
> 파사드는 시스템에 접근할 수 있는 통로

#### 2.2 인터페이스

> 파사드는 서브 시스템을 호출, 결합할 수 있는 인터페이스를 제공

#### 2.3 최상의 인터페이스

> 파사드는 통합 인터페이스 복잡하게 얽힌 서브 시스템의 로직을 쉽게 사용할 수 있도록 상위 레벨 인터페이스로 재정
> 상위 레벨의 인터페이스는 캡슐화하여 하위 시스템에 접근

---

## 3. 파사드를 이용한 단순화

> 파사드 패턴은 연관된 서브 시스템의 메서드 결합이라고 할 수 있습니다. 복잡한 서브 시스템의 동작을 하나로 묶어서 이를 싱행할 수 있도록 제공하는 계층

#### 3.1 단순화

> 파사드 패턴은 서브 기능을 쉽게 사용할 수 있도록 단순화

#### 3.2 캡슐화 배제

> 파사드는 단순한 인터페이스 내부의 복잡한 기능은 숨긴 채 간단히 서브 시스템을 사용할 수 있는 외부 인터페이스만 제공

#### 3.3 복잡성 해결

> 파사드는 서브 시스템을 구조화하여 복잡성을 해결하는 데 도움
> 파사드는 인터페이스를 이용하여 실제 구현부를 분리하므로 서브 시스템을 계층화하여 처리

#### 3.4 의존성 감소

> 서브 시스템의 객체가 다른 객체에 의존성을 요구하는 경우, 특정한 서브 시스템의 계층에 접근하기 위해 의존하는 객체를 미리 생성하는 과정이 필요
> 파사드 패턴을 응용할 경우 이러한 객체의 읜존 관계를 사전에 해결

---

## 4. 최소 지식 원칙

> 파사드 패턴ㅇ는 객체지향의 최소 지식 원칙이 적용 데메테르의 법칙

#### 4.1 최소 지식

> 어떤 작업을 할 때 많은 지식이 있어야 한다면 코드를 쉽게 수정하기 어렵다.
> 최소 지식만 적용해 객체의 상호 작용을 설정하면 유지 보수가 용이해짐

#### 4.2 잘못된 예

```java
//서브 시스템
public class Thermometer {
    public Float temp;

    public Float getTemperature() {
        return temp;
    }
}

// 파사드
public class Temperature {
    Thermometer station;

    public Temperature(Thermometer station) {
        this.station = station;
    }

    public Float getTemp() {

        // 인스턴스를 저장
        final Thermometer thermometer = getThermometer();

        // 인스턴스를 통하여 메서드를 실행
        return thermometer.getTemperature();
    }

    // 불필요한 객체 호출(생성)
    public Thermometer getThermometer() {
        return station;
    }
}
```

#### 4.3 최소 지식 객체

1. 자기 자신만의 객체 사용
2. 메서드에 전달된 매개변수 사용
3. 메서드에서 생성된 객체 사용
4. 객체에 속하는 메서드 사용

```java
public class Car {
    // 1. 클래스의 구성 요소
    //구성 요소의 메서드는 호출해도 된다
    private Engine engine;

    public Car(Engine engine) {
        this.engine = engine;
    }

    public void start(Key key) {
        //3. 새로운 객체 생성
        //내부에서 생성된 객체의 메서드는 호출해도 된다.
        final Doors doors = new Doors();

        //2. 매개변수로 전달된 객체의 메서드는 호출해도 된다.
        final boolean authorized = key.turns();
        if (authorized) {

            //1. 객체의 구성 요소의 메서드는 호출해도 된다.
            engine.start();

            //4. 객체 내에 있는 메서드는 호출해도 된다.
            updateDashboardDisplay();

            //3. 직접 생성하거나 인스턴스를 만든 객체의 메서드는 호출해도 된다.
            doors.lock();
        }

    }

    public void updateDashboardDisplay() {

    }
}
```

---

## 5. 기본 실습

#### 5.1 서브 시스템

> 파사드는 복잡한 구조의 서브 시스템을 간단하게 호출할 수 있도록 하는 인터페이스 모음

```java
public class Package1 {
    public void process() {
        System.out.println("패키지1 작업을 진행합니다.");
    }
}

public class Package2 {
    public void process() {
        System.out.println("패키지2 작업을 진행합니다.");
    }
}

public class Package3 {
    public void process() {
        System.out.println("패키지3 작업을 진행합니다.");
    }
}
```

#### 5.2 직접 접근

> 복잡한 서브 시스템에 각각의 클래스를 직접 생성해 접근할 수 있다.

 ```java
class IndexTest {
    @Test
    void test01() {
        final Package1 package1 = new Package1();
        package1.process();
        final Package2 package2 = new Package2();
        package2.process();
        final Package3
                package3 = new Package3();
        package3.process();
    }
}

```

#### 5.3 파사드 생성

```java
public class Facade {
    private Package1 package1;
    private Package2 package2;
    private Package3 package3;

    public Facade() {
        package1 = new Package1();
        package2 = new Package2();
        package3 = new Package3();
    }

    public void processAll() {
        package1.process();
        package2.process();
        package3.process();
    }
}

class FacadeTest {
    @Test
    void test01() {
        //파사드
        final Facade facade = new Facade();
        facade.processAll();
    }
}
```

---

## 6. 파사드 패턴의 효과

> 파사드를 통해 서브 시스템을 구조화하면 복잡성을 해결하는 데 도움

#### 6.1 서브 시스템 보호

> 파사드 패턴을 활용하면 서브 시스템의 구성 요소를 보호.
> 서브 시스템의 구성 요소를 직접 호출하지 않으므로 잘못된 사용을 방지

#### 6.2 확장성

> 변화되는 코드를 파사드 형태로 제공하면 보다 쉽게 변경 및 확장할 수 있다.
> 파사드는 확장성을 고려하면서 서브 시스템의 기능을 유지할 수 있도록 완충하는 역할을 수행

#### 6.3 결합도 감소

> 서브 시스템이 복잡하고 종속성이 강할 때는 파사드 패턴을 이용
> 파사드 패턴을 활용하면 서브 시스템과 결합도를 낮출 수 있다.

#### 6.4 계층화

> 파사드는 서브 시스템에 간접적으로 접근 , 계층화된 구조를 갖더라도 계층 단계별로 접근하여 행위를 호출
> 계층적 구조의 접근 포인트를 생성하고 단순화할 수 있으므로 서브 시스템이 좀 더 독립적이고 자유로워 진다.

#### 6.5 이식성

> 파사드 패턴은 코드의 결합도를 약하게 하는 효과, 코드 결합도가 약해지면 다른 응용프로그램에서 코드를 쉽게 재사용 가능 이식성을 향상

#### 6.6 공개 인터페이스

> 파사드를 사용하면 필요한 행위만 노출하고 그 외의 코드를 비공개로 숨길 수 있다.
> 파사드는 인터페이스를 제공함과 동시에 서브 시스템의 기능을 캡슐화한다.
> 인터페이스를 활용한 캡슐화를 통해 공개할 부분과 공개하지 않을 부분을 결정
