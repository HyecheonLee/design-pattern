# 플라이웨이트 패턴

> 플라이 웨이트 패턴은 객체를 공유하기 위해 구조를 변경하는 패턴
> 객체를 공유하면 객체를 재사용할 수 있어 시스템 자원이 절약

---

## 1. 메모리 자원

> 객체는 클래스 선언을 통해 생성되고, 생성된 객체는 시스템의 자원을 할당 받는다.
> 자원은 시스템의 메모리를 의미 한다.

#### 1.1 자원 할당

> 선언된 클래스를 하나의 객체로 생성하기 위해서는 인스턴스화 작업이 필요
> 메모리 자원을 할당 받고, 즉각 호출할 수 있는 객체를 배치
> 객체는 동작을 수행하는 메서드와 데이터를 포함하는 프로퍼티로 구성 인스턴스화하면 객체를 생성하고 메모리에 자원을 참조

#### 1.2 작은 단위

> 클래스를 설계할 때는 객체가 하나의 책임만 갖도록 한다. 이것을 단일 책임 원칙이라고 한다.
> 재사용할 수 있는 유사한 동작들은 별개의 클래스로 분리하여 상속으로 결합

```java
// 유사 기능 분리
public class Hello {
    public String console(String msg) {
        return msg + "\n";
    }

    public String browser(String msg) {
        return msg + "<br/>";
    }
}

// 상속으로 재사용
public class Korean extends Hello {
    public String hello() {
        return console("안녕하세요");
    }
}

// 상속으로 재사용
public class English extends Hello {
    public String hello() {
        return console("hello");
    }
}
```

#### 1.3 중복된 코드의 자원

> 자원을 효율적으로 사용하기 위해서는 최대한 중복을 방지 중복을 제거하고 공유를 통해 자원을 효율적으로 사용
> 객체지향에서 가벼운 객체란 메모리를 적게 사용하는 객체를 말한다. 플라이웨이트 패턴은 중복되는 코드의 객체를 공유함으로써 객체의 메모리 할당을 작게 처리

## 2. 자원공유

> 플라이웨이트 패턴은 객체를 공유하기 위한 패턴
> 생성된 객체를 공유하여 재사용하는 방법을 제시

#### 2.1 객체 재사용

> 객체를 생성하는 것은 시스템의 새로운 자원을 할당 받는것
> 중복된 객체를 재사용하면 메모리를 절약할 수 있다. 재사용은 공유를 의미

#### 2.2 자원 관리

> 많은 객체와의 중복을 방지하려면 관리가 필요
> 객체 생성을 대신 처리하는 Factory 클래스를 만들어 사용하는 것이 좋다.
> 팩토리 패턴을 이용해 객체 생성을 위임하면 자원을 효율적으로 관리 할 수 있다.

```java
public class Hello {
    public String console(String msg) {
        return msg + "\n";
    }

    public String browser(String msg) {
        return msg + "<br/>";
    }
}

public class Factory {
    public Hello make() {
        return new Hello();
    }
}
/*
@Test
void test03() {
    final Hello hello1 = new Factory().make();

    final Hello hello2 = new Factory().make();

    Assertions.assertThat(hello1).isNotEqualTo(hello2);
}
*/

```

#### 2.3 동일 객체

> 팩토리 패턴과 싱글턴 패턴을 같이 결합하여 공유 객체를 생성

```java
public class SingletonHello {
    private static Hello instance;

    public static Hello getInstance() {
        System.out.println("객체를 생성합니다.");
        if (instance == null) {
            instance = new Hello();
        }
        return instance;
    }

    public String console(String msg) {
        return msg + "\n";
    }

    public String browser(String msg) {
        return msg + "<br/>";
    }
}

public class Factory {
    public Hello make2() {
        return SingletonHello.getInstance();
    }
}
/*@Test
void test04() {
    final Hello hello1 = new Factory().make2();

    final Hello hello2 = new Factory().make2();

    Assertions.assertThat(hello1).isEqualTo(hello2);
}*/
```

#### 2.4 공유 저장소

> 객체를 공유한다는 것은 동울한 객체를 생성하고 이를 다시 재사용하는 것.
> 싱글턴 패턴은 단일 인스턴스의 생성을 보장하므로 객체를 공유하는 것이 유용
> 싱글턴 패턴은 유일한 객체를 생성하기 위해서 플라이웨이트 패턴과 결합해 설계
> 효율적인 객체를 관리하기 위해 별도의 저장소를 갖고 있는데 이를 공유 저장소

```java
public class Factory {
    private Map<String, Object> pool = new HashMap<>();

    public Hello make3(String name) {
        if (!pool.containsKey(name)) {
            final Hello instance = SingletonHello.getInstance();
            pool.put(name, instance);
        }
        return (Hello) pool.get(name);
    }
}
/*@Test
void test05() {
    final Factory factory = new Factory();
    final Hello hello1 = factory.make3("Hello");

    final Hello hello2 = factory.make3("Hello");

    Assertions.assertThat(hello1).isEqualTo(hello2);
}*/
```

---

## 3. 상태구분

> 객체 공유는 본질적공유와 부가적 공유로 구분

#### 3.1 본질적 상태

> 객체 행동을 처리하는 메서드와 값을 저장하는 프로퍼티로 구성.
> 데이터를 포함한 객체라면 공유 시 문제가 발생. 공유되는 객체의 데이터가 변경되면 참조되는 모든 다른 객체에도 영향을 미치는데 이를 사이드 이펙트라고 한다.
> 어떤 변경도 없이 객체를 있는 그대로 참조해야 사용 이러한 상태를 본질적 상태

#### 3.2 부가적 상태

> 본질적 상태와 반대되는 의미로 부가적 상태, 객체를 공유할 때 상태값에 따라 달라지는 것을 말한다.
> 공유 객체가 상태값에 종속적인 상태면 플라이웨이트 패턴으로 공유할 수 없다.
> 객체 상태가 변경됨으로써 참조하는 다른 객체에 사이드 이펙트 효과가 발생하기 때문이다.

#### 3.3 사이드 이펙트

> 하나의 동작이나 값이 다른 동작과 값에 영향을 줄 경우, 이들은 서로 종속적이며 강력하게 결합돼 있다고 표현

#### 3.4 독립 객체

> 독립 객체는 공유되지 않고 각각의 상황에 맞게 생성된 객체. 독립적인 동작을 수행
> 공유된 객체는 사이드 이펙트 문제에 주의. 부가적 상태로 처리되는 종속 객체는 독립 객체로 처리

---

## 4. 패턴 실습

#### 4.1 Flyweight 인터페이스

```java
public interface Flyweight {
    public void code();
}
```

#### 4.2 ConcreteFlyweight 인터페이스

```java
public class MorseG implements Flyweight {
    @Override
    public void code() {
        System.out.println("**-* ");
    }
}

public class MorseE implements Flyweight {
    @Override
    public void code() {
        System.out.println("* ");
    }
}

public class MorseL implements Flyweight {
    @Override
    public void code() {
        System.out.println("*-** ");
    }
}

public class MorseO implements Flyweight {
    @Override
    public void code() {
        System.out.println("--- ");
    }
}

```

#### 4.3 FlyweightFactory 인터페이스

> 플라이웨이트 패턴에서는 공유되는 객체의 인스턴스를 직접 생성하지 않고 팩토리에게 위임한다.

```java
public class Factory {
    public Map<String, Flyweight> pool = new HashMap<>();

    public Flyweight getCode(String aChar) {
        final String className = "Morse" + aChar.toUpperCase();
        if (!pool.containsKey(className)) {
            try {
                final Class<?> clz = Class.forName("ex04." + className);
                final Constructor<?> constructor = clz.getConstructor();
                pool.put(className, (Flyweight) constructor.newInstance());
            } catch (Exception e) {
                throw new RuntimeException("Error");
            }
        }
        return pool.get(className);
    }
}
```

#### 4.4 Client

```java
class IndexTest {
    @Test
    void test01() {
        final Factory factory = new Factory();
        String name = "goooogllleee";
        for (int i = 0; i < name.length(); i++) {
            final char c = name.charAt(i);
            System.out.print(c + " => ");
            factory.getCode(c + "").code();
        }
    }
}
```

---

*플라이웨이트는 객체의 할당을 적게 하기 위한 패턴이며, 한 번 할당한 자원을 재사용함으로 메모리를 관리 자원을 공유함으로써 낭비를 사전에 막을수 있다.*