# 장식자 패턴

> 장식자 패턴은 객체에 동적 기능을 추가하기 위해 구조를 개선하는 패턴
---

## 1. 기능 추가

> 새로운 기능을 추가하기 위해 클래스를 확장하는 방법은 상속과 구성 두가지.

#### 1.1 상속

> 객체지향에서 새로운 기능을 추가하기 위해 상속을 이용  
> 상속은 클래스를 확장하는 대표적인 구현 기법, 단점은 상위 클래스와 하위 클래스 간에 강력한 결합 관계가 생성  
> 클래스 간 강력한 결합은 객체의 유연한 확장을 어렵게 한다.

#### 1.2 오버라이드

> 오버라이드는 상위 클래스의 메서드를 재설정하는 기능
> 오버라이드했다고 해서 상위 클래스의 메서드가 없어지는 것은 아니고 대체될 뿐이다.

#### 1.3 상속조합

> 상속으로 조건을 조합해 특정 행위만으로 구성된 객체를 생성하는 것은 매우 복잡
> 기능별로 조합하고 하위 클래스도 개별적으로 생성

---

## 2. 조건 추가

> 하나의 단일 행위만 처리하는 것과 달리 여러 행위를 처리해야 하는 경우가 있다.
> 여러 행위를 구분하기 위해 조건을 추가.

#### 2.1 옵션

> 하나의 동작에 부수적인 기능을 추가하는 경우가 있으며, 추가 기능을 처리하려면 객체의 행위를 확장

#### 2.2 동적 확장을 위한 구성

> 구성은 위임을 활용해 객체를 확장하는 방법 객체를 실행하는 도중에도 동적으로 다른 객체를 결합해 확장 가능하다는 장점
> 장식자 패턴은 동적으로 객체를 결합하기 위해서 객체지향의 구성을 통해 확장합니다.

#### 2.3 확장을 통한 객체 변경

> 완성된 코드에 새로운 기능을 추가하려면 객체를 확장해야 하며 이를 위해 기존 코드를 수정해야 한다.
> 코드를 수정하는 도중에는 코드 상태가 일시적으로 불안정해진다.
> 새로운 기능을 추가할 때는 변경이 아닌 확장을 통해 처리 확장하면 기존의 안정적인 코드 상태를 유지하면서 새로운 기능을 추가

#### 2.4 OCP

> 객체를 확장할 때는 개방-폐쇄 원칙을 기반 OCP는 새로운 기능을 추가할 경우 확장을 허용하지만 기존 내용은 변경하지 못하게 한다.
> 객체지향에서는 OCP 원칙을 유지하기 위해 구성을 사용.
> 객체 구성은 기존의 코드를 변경하지 않아도 객체에 새로운 기능을 추가 할 수 있다.

---

## 3. 확장

> 장식자 패턴은 객체에 새로운 부가 기능을 동적으로 추가. 동적은 실시간으로 변하는 객체에 새로운 행위를 추가한는 것을 의미

#### 3.1 처리 분담

> 하나의 클래스에 많은 기능을 집ㅈ붕하는 것은 좋지 않으며 객체의 책임을 여러 클래스에 분산해 설계하는 것이 좋다.
> 분산된 각각의 클래스는 작은 객체로 생성되며 더 큰 객체로 결합해 사용 가능.
> 장식자 패턴은 새로운 기능을 결합할 때 유용, 객체의 동적 조합이 많은 경우에도 편리

#### 3.2 융통성

> 상속은 강한 결합ㅂ 구조를 가지며 기능을 확장하기 위해 복잡한 조건을 추가 장식자 패턴은 상속에서 처리하기 힘든 설계 변경을 해결

#### 3.3 동적 추가

> 위임을 통해 객체를 확장하면 동적객체 확장을하며, 런타임으로 객체에 새로운 책임을 추가

#### 3.4 단일화

> 장식자는 기존의 객체에 새로운 부가 행위를 추가하며 추가하는 행위는 단위별로 분리
> 장식자 패턴은 많은 종류의 작은 객체를 단일화해서 결합

#### 3.5 축소

> 장식자는 새로운 기능을 추가하는 것 외에 어떤 기능을 제거하기 위해서도 사용

---

## 4. 객체에 추가 장식하기

> 장식자 패턴은 기존 객체를 확장하기 위해 무언가를 추가 장식, 장식자는 기본 베이스의 객체를 시작점으로 장식을 추가해 객체를 확장

#### 4.1 객체를 감싸는 래퍼

> 장식자는 기본이 되는 객체를 감싸서 새로운 객체를 확장
> 행위가 추기될 때 객체를 또 다른 행위로 꾸미는 형태를 보이므로 장식이라는 말로 불린다.

#### 4.2 객체의 투명성

> 장식자는 객체를 감싸면서 또 다른 객체로 파생, 장식자 패턴으로 확장된 파생 객체는 요청된 행위를 중간에서 가로채 더 확장된 행위로 대신 처리
> 확장된 객체는 동일한 인터페이스를 적용 클라이언트는 요청된 객체가 원본 객체인지 파생된 객체인지 모른다.
> 동일한 인터페이스를 사용해 객체의 투명성을 부여한다.

---

## 5. 기본 실습

#### 5.1 구성요소

1. Component:인터페이스를 정의
2. ConcreteComponent:인터페이스에 정의 실제를 구현
3. Decorator: 컴포넌트를 참조하며 인터페이스를 일치화한다.
4. ConcreteDecorator: 확장 및 추가되는 기능을 작성

#### 5.2 인터페이스

```java
// 인터페이스
public interface Component {
    public String product();

    public int price();
}
```

#### 5.3 컴포넌트

```java
public class Product1 implements Component {
    @Override
    public String product() {
        return "원피스";
    }

    @Override
    public int price() {
        return 20000;
    }
}

public class Product2 implements Component {
    @Override
    public String product() {
        return "블라우스";
    }

    @Override
    public int price() {
        return 25000;
    }
}
```

#### 5.4 장식자

```java
abstract public class Decorate implements Component {
    @Override
    abstract public String product();

    @Override
    abstract public int price();
}

```

#### 5.5 구체적 장식

```java
public class I7 extends Decorate {
    private Component base;

    public I7(Component base) {
        this.base = base;
    }

    @Override
    public String product() {
        return base.product() + ",i7";
    }

    @Override
    public int price() {
        return base.price() + 475000;
    }
}

public class Ssd256 extends Decorate {
    public Component base;

    public Ssd256(Component base) {
        this.base = base;
    }

    @Override
    public String product() {
        return base.product() + ",ssd256";
    }

    @Override
    public int price() {
        return base.price() + 110000;
    }
}
```

#### 5.6 실행

```java
class IndexTest {
    @Test
    void test01() {
        final Component p = new Product1();
        Component spec = new I7(p);
        spec = new Ssd256(spec);

        Assertions.assertThat(spec.product()).isEqualTo("원피스,i7,ssd256");
        Assertions.assertThat(spec.price()).isEqualTo(605000);
    }
}
```

---

## 6. 장단점 및 결과

> 장식자 패턴은 기존의 객체에 영향을 주지 않고 새로운 기능을 동적으로 추가

#### 6.1 장점

> 상속 형태의 확장보다 더 융통성 있게 설계 가능. 객체 실행 중에도 동적으로 기능을 추가
> 새로운 부가 기능을 추가하는 가장 효과적인 방법

#### 6.2 단점

> 작은 단위의 객체가 많이 생성 된다. 하지만 작은 코드로 이루어진 객체는 보다 이해하기 쉬우며 상호 작용을 통해 다른 객체를 생성할 수 있어 무조건 단점이라고 할 순 없다.