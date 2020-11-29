# 프록시 패턴

> 프록시 패턴은 객체 접근을 제어하기 위해 중간 단계에 대리자를 위치시키는 패턴
---

## 1. 객체를 대행하는 프록시

> 프록시는 일을 직접 처리하지 않고 대리자를 내세워 처리를 위임

#### 1.1. 프록시의 특징

> 프록시의 특징은 하나의 객체를 두개로 나눠 재구성한다는 것. 직접적인 접근을 막고 대리할 객체를 구현하기 위해서 분리한다.

#### 1.2 다양한 프록시

1. 원격 프록시
2. 가상 프록시
3. 보호 프록시
4. 스마트 프록시

---

## 2 객체 가로채기

> 프록시는 실체 객체를 호출하면 행위를 중간에 가로채서 다른 동작을 수행하는 객체로 변경

#### 2.1 실체 객체

```java
// 실체 객체
public class RealSubject {
    public void action1() {
        System.out.println("action1 을 호출합니다.");
    }

    public void action2() {
        System.out.println("action2 을 호출합니다.");
    }
}
```

#### 2.2 객체 호출

```java
class IndexTest {
    @Test
    void test01() {
        final RealSubject obj = new RealSubject();
        obj.action1();
        obj.action2();
    }
}
```

---

## 3. 객체분리

> 객체를 정교하게 제어해야 하거나 객체 참조가 필요한 경우 프록시 패턴을 사용

#### 3.1 대리자

> 프록시는 대리인을 의미, 실체 객체에 직접 접근하지 않고 똑같이 동작하는 대리자를 생성  
> 프록시는 대리자 객체를 통해 실체 객체를 가로챈 후 대리자 객체로 우회한 접근을 허용

#### 3.2 인터페이스

> 프록시는 동일한 역할을 수행하는 대리자를 생성, 대리자는 원본 객체와 동일한 인터페이스를 적용해 투명성을 갖도록 설계

```java
// 프록시 생성을 위한 인터페이스를 정의합니다.
public interface Subject {
    public void action1();

    public void action2();
}
```

#### 3.3 인터페이스 적용

```java
// 실체 객체
public class RealSubject implements Subject {
    @Override
    public void action1() {
        System.out.println("action1 을 호출합니다.");
    }

    @Override
    public void action2() {
        System.out.println("action2 을 호출합니다.");
    }
}
```

---

## 4. 프록시 생성

#### 4.1 기능 분리

> 프록시는 실체 객체의 역할을 대신 수행 프록시는 실체 객체를 대신해 행위를 처리하므로 실체 객체의 정보가 필요

#### 4.2 프록시 객체

> 인터페이스를 이용해 프록시의 객체를 구현하면 실체 객체와 동일한 메서드를 갖게 된다.
> 프록시는 실체 객체와 분리된 별개의 객체

 ```java
// 프록시 객체
public class Proxy implements Subject {
    @Override
    public void action1() {
        System.out.println("프록시 action1 작업을 처리합니다.");
    }

    @Override
    public void action2() {
        System.out.println("프록시 action2 작업을 처리합니다.");
    }
}
```

#### 4.3 실체 객체 위임

> 프록시에서 위임은 프록시 객체와 실체 객체를 연결하는 고리  
> 프록시 객체가 실체 객체로 행위를 위임

```java
public class Proxy implements Subject {
    public Subject realSubject;

    public Proxy(Subject realSubject) {
        this.realSubject = realSubject;
    }

    @Override
    public void action1() {
        realSubject.action1();
    }

    @Override
    public void action2() {
        realSubject.action2();
    }
}
```

#### 4.4 프록시 출력

```java
class IndexTest {
    @Test
    void test01() {
        final RealSubject real = new RealSubject();
        final Proxy proxy = new Proxy(real);
        proxy.action1();
        proxy.action2();
    }
}
```

#### 4.5 투과적 특성

> 프록시의 객체는 실체 객체와 동일한 동작을 수행   
> 프록시는 투과적 특성만 갖는다. 실제 동작을 다시 호출하는 역할만 수행

---

## 5. 행위를 처리하는 핸들러

> java 객체에서 구현이 어려워서 생략한다.

#### 5.1 간접 통로

#### 5.2 핸들러 설계

#### 5.3 실체 객체 변경

#### 5.4 핸들러 실습

---

## 6. 동적 프록시

> 프록시에는 실체 객체를 숨기는 효과 객체를 호출하는 쪽에서는 실행되는 객체가 실체 객체인지 프록시인지 몰라야 한다.

#### 6.1 동적 클래스

> 프록시와 실체 객체를 구별하지 않고 접근하는 객체의 인스턴스를 만들 수 있다.  
> 팩토리 패턴을 같이 사용해서 객체를 동적으로 생성

#### 6.2 팩토리 패턴

```java
//프록시 팩토리
public class ProxyFactory {
    public Subject getObject() {
        final RealSubject realSubject = new RealSubject();
        return new Proxy(realSubject);
    }
}
```

#### 6.3 프록시 확인

---

## 7. 원격 프록시

> 원격 프록시는 주로 데이터 전달을 목적으로 사용

#### 7.1 프록시 vs 어댑터

> 두 개의 객체를 이어준다는 역할적 측면에서 두 패턴은 서로 유사합니다.

#### 7.2 캐싱 처리

```java
public class Proxy implements Subject {
    public Subject realSubject;

    public Proxy(Subject realSubject) {
        this.realSubject = realSubject;
    }

    @Override
    public String action1() {
        return realSubject.action1();
    }

    @Override
    public String action2() {
        final String msg = realSubject.action2();
        if (!msg.isEmpty()) {
            return msg;
        } else {
            return "실체 객체에서 문자열을 반환 받지 못하였습니다.";
        }
    }
}
```

#### 7.4 대체 처리

> 프록시 패턴을 적용할 때는 실체 객체와 프록시 객체로 분리

#### 7.5 객체의 대리

> 프록시는 어떠한 일을 대신해서 처리, 객체의 동작을 위힘할 수도 있고 변경된 행위를 대신할 수도 있다.
> 대리로 처리할 수 없는 동작은 본래의 객체로 접근해서 처리

---

## 8.가상 프록시

> 가상 프록시는 프로그램의 실행 속도를 개선하기 위한 패턴

#### 8.1 초기화 로딩

> 가상 프록시 패턴은 실제로 동작하는 객체를 생성하지 않고, 필요 시점에서 객체를 동적으로 생성하도록 프록시 객체로 대신 연결  
> 가상 프록시는 게으른 초기화와 유사

#### 8.2 게으른 초기화

> 가상 프록시는 프로그램에 껍데기만 있는 객체를 전달. 가상 프록시를 통해 실체 객체의 접근이 필요할 때 원본 객체를 동적으로 생성하여 프록시와 연결

#### 8.3 속도 개선

> 객체를 생성하는 연산량에 따라서 약간의 지연 시간이 발생, 가상 프록시를 사용하면 즉시 싱행이 필요한 객체를 제외하고는 객체의 실행 시간을 줄일 수 있다.

#### 8.4 실습

#### 8.5 플라이웨이트 패턴 결합

> 가상 프록시는 내부적으로 의존된 객체를 생성하도록 설계

```java
public class Proxy implements Subject {
    public Subject realSubject;

    @Override
    public String action1() {
        return "action1 작업을 처리합니다.";
    }

    @Override
    public String action2() {
        //게으른 객체 생성
        if (realSubject == null) {
            real();
        }
        return realSubject.action2();
    }

    private void real() {
        this.realSubject = new RealSubject();
    }
}
```

#### 8.6 결과 확인

#### 8.7 프레임워크 응용

---

## 9. 보호용 프록시

> 객체 접근을 제어하기 위해 객체의 대리자 또는 표시자를 제공

#### 9.1 통제

> 프록시를 통해 먼저 제어권을 확인한 후 실제적인 객체를 성성

#### 9.2 권한 추가

```java
public class Proxy implements Subject {
    public Subject realSubject;
    public boolean isPermit;

    public Proxy(boolean isPermit) {
        this.isPermit = isPermit;
    }

    @Override
    public String action1() {
        return "action1 작업을 처리합니다.";
    }

    @Override
    public String action2() {
        if (isPermit) {
            if (realSubject == null) {
                real();
            }
            return realSubject.action2();
        } else {
            return "action2 실행 권한이 없습니다.";
        }
    }

    private void real() {
        this.realSubject = new RealSubject();
    }
}
```

#### 9.3 보호용 프록시 vs 장식자

---

## 10. 스마트 참조자

> 프록시는 실체 객체에 접근할 때 추가 행위를 부여하여 호출  
> 스마트 참조자는 장식자 패턴과 유사하게 객체를 동적으로 확장 응용하는 기법

#### 10.1 확장

> 실체 객체를 호출하여 행동을 수행하기 전에 프록시 내부에 어떤 작업을 같이 추가해서 실행

#### 10.2 응용

> 기존에 동작을 처리하던 실체 객체가 동작을 수행하기 전 또는 후에 추가
> 프록시 패턴을 이용하면 실제 코드를 변경하지 않고도 추가 작업을 부여

```java
public class Proxy implements Subject {
    public Subject realSubject;
    public boolean isPermit;
    public int action1;

    public Proxy(boolean isPermit) {
        this.isPermit = isPermit;
    }

    @Override
    public String action1() {
        //추가 동작
        action1++;
        return "action1 작업을 처리합니다.";
    }

    @Override
    public String action2() {
        if (isPermit) {
            if (realSubject == null) {
                real();
            }
            return realSubject.action2();
        } else {
            return "action2 실행 권한이 없습니다.";
        }
    }

    private void real() {
        this.realSubject = new RealSubject();
    }
}
```