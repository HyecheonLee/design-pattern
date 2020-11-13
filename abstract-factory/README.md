#추상 팩토리 패턴

---

## 1.팩토리 메서드
> 팩토리 메서드는 객체 생성을 담당하는 클래스를 추상화하여 선언과 구현을 분리한 확장 패턴

#### 1.1 패턴 유사성
> 팩토리 패턴과 팩토리 메서드 패턴의 차이는 추상화  
> 팩토리 메서드 패턴과 추상팩토리 패턴의 차이는 추상화된 그룹을 형성하고 관리한느 것

#### 1.2 객체 생성의 종속성
> 하나의 객체가 서브 객체를 직접 생성하면 두 객체 간에는 강한 종속 의존성이 형성  
> 생성 패턴은 객체 간에 존재하는 강력한 종속 관계를 해결하기 위한 기법으로, 객체를 직접 생성하지 않고 다른 클래스로 위임하여 객체를 생성    
> 별도로 분리된 객체에 생성을 요청하면 객체 간의 직접적인 종속 관계를 제거 할 수 있다.

#### 1.3 추상화와 위임 처리
> 팩토리 패턴과 팩토리 메서드 패턴의 주된 차이점은 추상화  
> 팩토리 메서든 패턴은 추상화를 통해 2개의 클래스로 분리  
> 팩토리 메서드의 상위 클래스는 추상적 선언, 추상적 선언은 하위 클래스에 적용 되는 인터페이스와 유사

#### 1.4 상속과 다형성
> 일반적인 상속은 상위 클래스의 내용을 포함하는 객체의 확장 추상 클래스의 상속은 하위 클래스에서 구체적 행위를 규정하는 선언  
> 추상화는 하위 클래스에 객체지향의 다형성을 부여  
> 다형성을 이용하면 형태와 틀은 같지만 실제 처리 내용은 다르게 클래스를 만들 수 있다.  

---

## 2. 그룹
> 추상 팩토리는 여러 개의 팩토리 메서드를 그룹으로 묶은 것과 유사

#### 2.1 추상클래스
> 팩토리 메서드는 팩토리 패턴을 추상화함으로써 클래스의 선언과 구현을 분리
```java
//추상클래스
abstract public class Factory {
    abstract public TireProduct createTire();

    abstract public DoorProduct createDoor();
}
```

#### 2.2 다형성을 이용한 군집 형성
> 추상화는 다형성을 적용해 여러 개의 하위 클래스를 생성  
> 추상 팩토리는 추상화와 다형성을 이용하여 객체 생성군을 형성하고 추상화와 다형성을 이용하여 집합 단위의 객체 생성을 관리

#### 2.3 공장
> 추상 팩토리는 다향한 객체 생성 과정에서 그룹화가 필요할 때 매우 유용한 패턴이며 공장의 개념을 추상화

---

## 3. 팩토리 그룹
> 추상 팩토리의 특징은 추상화를 통해 그룹을 만들 수 있다는 것

#### 3.1 그룹
> 생성 패턴의 목적은 클래스의 객체 생성 처리를 묶어서 관리하는 것

#### 3.2 가상화 관점의 추상화
> 추상 팩토리메서드는 단일 클래스를 추상화 , 추상화를 이용하는 이유는 구체적인 객체 생성 로직을 알지 못하기 때문

#### 3.3 하위 클래스
```java
public class KoreaFactory extends Factory {
    @Override
    public TireProduct createTire() {
        return new KoreaTireProduct();
    }

    @Override
    public DoorProduct createDoor() {
        return new KoreaDoorProduct();
    }
}
```

---

## 4 공장 추가
> 추상 팩토리는 그룹을 통해 복수의 공장을 생성, 복수의 객체 생성을 담당하는 군집을 관리하는것

#### 4.1 프로젝트
> 추상 팩토리의 개념은 생성 패턴을 그룹화하기 위해 도입

#### 4.2 그룹 추가

#### 4.3 하위클래스 
> 추상 팩토리는 여러개의 공장이 있는 생산 단지
```java
public class StateFactory extends Factory {
    @Override
    public TireProduct createTire() {
        return new StateTireProduct();
    }

    @Override
    public DoorProduct createDoor() {
        return new StateDoorProduct();
    }
}
```
#### 4.4 객체 분리를 활용한 은닉성 활용
> 추상 팩토리는 추상 클래스를 으용한 객체 구현 방법을 사용하고 추상 클래스는 실제 구현 내용이 없는 추상 메서드를 선언  
> 추상화는 인터페이스를 전달하고 상속을 통해 실제 로직을 하위 클래스에 구현  
> 추상 팩토리는 객체를 분리함으로써 은닉성을 적용

#### 4.5 목적성
> 특정 클래스에 읜존하지 않고 해결해야 하는 문제에 따라 객체 생성 그룹을 형성  
> 목적이 변경될 경우 필요한 객체를 생성하는 그룹을 교체  

---

## 5. 부품 추가 실습

#### 5.1 부품 추상화
> 추상클래스는 직접 구현하지 않고 하위 클래스에 위임  
> 공통된 인터페이스를 적용하면 은닉성을 보장하면서 목적에 맞는 독립된 성계를 다양하게 진행  
```java
public abstract class TireProduct {
    abstract public void makeAssemble();
}
```
```java
public abstract class DoorProduct {
    abstract public void makeAssemble();
}
```
#### 5.2 KoreaFactory
```java
public class KoreaFactory extends Factory {
    @Override
    public TireProduct createTire() {
        return new KoreaTireProduct();
    }

    @Override
    public DoorProduct createDoor() {
        return new KoreaDoorProduct();
    }
}
```
```java
public class KoreaTireProduct extends TireProduct {
    @Override
    public void makeAssemble() {
        System.out.println("한국형 타이어 장착");
    }
}
```
```java
public class KoreaDoorProduct extends DoorProduct {
    @Override
    public void makeAssemble() {
        System.out.println("한국형 도어 장착");
    }
}
```

#### 5.3 StateFactory
```java
public class StateFactory extends Factory {
    @Override
    public TireProduct createTire() {
        return new StateTireProduct();
    }

    @Override
    public DoorProduct createDoor() {
        return new StateDoorProduct();
    }
}
```
```java
public class StateDoorProduct extends DoorProduct {
    @Override
    public void makeAssemble() {
        System.out.println("미국형 도어 장착");
    }
}

```
```java
public class StateTireProduct extends TireProduct {
    @Override
    public void makeAssemble() {
        System.out.println("미국형 타이어 장착");
    }
}
```

---
## 6. 패턴 결합

#### 6.1 클라이언트
> 복수의 생성 그룹을 적용 각각의 그룹은 목적에 맞는 객체를 독립적으로 생성

#### 6.2 새로운 부품
> 추상 팩토리는 생성 패턴을 그룹화된 구조로 분리, 추상 클래스를 상속받는 하위 클래스를 추가해 새로운 그룹을 쉽게 만들 수 있지만 그룹의 하위 클래스를 추가하는 것은 쉽지 않다.(잘 이해아 안된다 나중에 이해 하자)

---

## 7. 장점과 단점
#### 7.1 장점 
> 코드를 일관적으로 유지하고 셀제 구현을 다르게 실행가능
#### 7.2 단점
> 새로운 종류의 군을 추가하는 것이 쉽지 않다.
