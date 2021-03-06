# 싱글턴 패턴
> 싱글턴은 자원 공유를 위해 객체 생성 개수를 1개로 제한
---

## 1 객체 생성
> 클래스는 선언 후 객체를 생성해야 사용할 수 있습니다.

#### 1.1 new 키워드
> 선언된 클래스를 객체로 생성하는 과정을 인스턴스화  
> 인스턴스화는 객체를 생성해 메모리에 할당하는 작업을 수행

#### 1.2 객체의 중복
> 객체 생성이란 선언된 클래스에 따라 객체를 메모리에 할당하는 동작  
> 객체 생성 과정은 new 키워드를 통해 반복 생성 new 키워드를 이용해  
> 클래스의 동일한 객체를 여러 개 생성할 수 있습니다.

---

## 2 유일한 객체
> 객체지향에서는 하나의 클래스를 이용하여 객체를 무제한 생성  
> 이런한 객체지향의 특징은 장점이면서 때로 단점

#### 2.1 자원 공유
> 객체지향에서 new 키워드로 생성한 객체는 각각 독립된 자원. 독립된 자원이란 서로다른 메모리 영역을 차지하고 있다는 것

#### 2.2 스코프
> 프로그램에서는 변수를 크게 전역 변수와 로컬 변수로 구분. 변수가 접근할 수 있는 영역을 구분하는 것  
> 접근 영역 구분을 스코프라고 한다.

---

## 3 싱글턴
> 전역  변수처럼 생성한 객체를 공유하려면 하나의 객체만 존재. 싱글턴은 다른 생성 패턴과 달리 하나의 객체만 생성을 제한하는 패턴 생성된 객체는 공유되어 어디서든 접근 

#### 3.1 유일한 객체
> 싱글턴 패턴의 유용한 상황
+ 공유자원 접근
+ 복수의 시스템이 하나의 자원에 접근할 때
+ 유일한 객체가 필요할 때
+ 값의 캐시가 필요할 때

#### 3.2 전역 객체
> 전역으로 선언된 변수는 하나만 존재하므로 값을 공유하기가 편하다.  
> 단일 객체는 여러 곳에서 접근을 시도해도 결국은 동일한 객체를 사용 모든 객체는 상호 관계 속에서 작용하며 동작하고, 객체의 상호 관계 속에는 공유 객체도 존재  
> 서로 다른 객체가 값을 공유할 때나 중복되는 자원을 줄일 때 싱글턴 패턴을 적용

## 4 싱글턴 설계

#### 4.1 객체 생성과정
> 객체를 생성할 때 선언된 클래스의 생성자를 호출

#### 4.2 접근 권한
> 객체지향에는 클래스의 접근 제어할 수 있는 3가지 속성
+ public 
+ private
+ protected

#### 4.3 생성자 제한
> 다른 객체에서 생성자에 접근하지 못하게 접근 속성을 private로 변경  
> 싱글턴 패턴은 생성자를 제어하는 부분부터 시작
```java
public class Config {
    private Config() {
    }
}
```

---

## 5  인스턴스 생성

#### 5.1 생성 메서드
> 싱글턴에서는 객체를 생성하는 것이 아니라 객체 생성을 요청한다.
```java
public class Config {
    private Config() {
    }

    public static Config getInstance() {
        return new Config();
    }
}
```

#### 5.2 참조체
> 내부적으로 하나의 객체만 보장하기 위해 자체 객체를 저장하는 참조체를 갖고 있다.
```java
public class Config {
    
    private static Config instance; // 참조체

    private Config() {
    }

    public static Config getInstance() {
        if (instance == null) {
            instance = new Config();
        }
        return instance;
    }
}
```

#### 5.3 플라이웨이트 패턴 
> 생성한 객체를 공유하는 패턴으로 플라이웨이트 패턴존재  
> 싱글턴 패턴은 가장 간단한 형태의 플라이웨이트 패턴이 결합한 형태

#### 5.4 2가지 책임
> 싱글턴 패턴은 2가지 책임
1. 클래스의 설계는 본연의 목적을 해결하기 위해 고유한 처리 로직  
2. 중복된 객체 생성을 방지하기 위한 책임

---

## 6 정적 클래스
> 싱글턴 패턴을 사용하지 않고 정적 클래스를 이용해 전역 변수처럼 객체를 공유하는 경우

#### 6.1 정적
> 정적이라는 용어는 프로그래밍 언어에서 변수를 선언할 때 자주 등장  
> 정적 클래스는 객체 생성 없이 클래스 선언을 통해 프로그램을 실행 
> 정적 클래스는 소스 코드를 이용하기 때문에 여러 개의 객체로  인식 되지 않습니다.

#### 6.2 static 선언
```java
public class Config {
    public static String conf;

    public static void set(String conf) {
        Config.conf = conf;
    }

    public static String get() {
        return conf;
    }
}
```

#### 6.3 차이점과 한계
+ 정적 클래스는 객체를 메모리에 생성하지 않으므로 메모리 관리 차원에서 보면 효율적인 관리 방법
+ 싱글턴 패턴은 메모리 자원에 할당하여 동적 객체를 생성
+ 정적 클래스는 코드가 실행되면서 고정으로 바인딩
> 정적 클래스와 일반 클래스의 차이는 메모리의 상주와 비동적 차이의 여부  
> 일반 클래스와 정적 클래스를 구분하여 처리하는 이유는 객체지향의 다형성 때문  
> 싱글턴 패턴을 사용하지 않고 정적 클래스만 사용한다면, 필요한 모든 동작 기능이 정적 클래스 안에 존재해야 한다.

--- 

## 7 싱글턴 확장

#### 7.1 제한 범위
> 싱글턴으로 변형된 클래스는 직접 상속받을 수 없다.

#### 7.2 protected 속성
> 싱글턴의 생성자 속성을 변경하면 싱글턴으로 변경된 클래스를 상속
```java
public class Config {
    protected static Config instance;

    protected Config() {
    }

    public static Config getInstance() {
        if (instance == null) {
            instance = new Config();
        }
        return instance;
    }
}
```
#### 7.3 상속
```java
public class Config {
    protected static Config instance;
    protected Config() {
    }
}
```
```java
public class Env extends Config {
    public void setting() {
        System.out.println("시스템 환경을 설정합니다.");
    }
    public static Env getInstance() {
        if (instance == null) {
            instance = new Env();
        }
        return (Env) instance;
    }
}
```

---

## 8 자원 처리

#### 8.1 경합 조건
> 단일 객체 생성을 보장하지 못하는 경우, 멀티 스레드 환경에서 싱글턴 패턴을 사용할 때는 주의

#### 8.2 메모리
> 자원이 필요할 때 동적으로 할당받을 수 있지만, 정적으로 생성된 자원을 해제하여 반환하기는 어렵다.  
> 생성한 자원은 프로그램이 종료될 때까지 메모리에 상주 