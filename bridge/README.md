# 브리지 패턴
> 브리지 패턴은 객체의 확장성을 향상하기 위한 패턴, 객체 동작을 처리하는 구현부와 확장을 위한 추상부를 분리   
> 다른 용어로 핸들 패턴 또는 구현부 패턴
---

## 1. 복잡한 코드
#### 1.1 유지 보수
> 추가 요청에 의해 기존에 완성된 코드를 변경 작업ㅇ하는 것을 유지 보수.

#### 1.2 코드의 변길
> 새로운 변경 사항이 발생하면 기존 코드를 수정
```java
//최초 설계 인사말
public class Hello {
    public String greeting() {
        return "hello";
    }
}
```
```java
//코드의 변질
public class Hello {
    public String greeting(String lang) {
        if ("Korean".equals(lang)) {
            return "안녕하세요";
        } else {
            return "Hello";
        }
    }
}
```
---

## 2. 상속
> 객체지향은 요구되는 행위를 객체화하여 처리

#### 2.1 상속확장
> 객체지향에서 상복은 부모와 자식 형태의 관계로 설명 상속은 기존의 모든 기능을 갖고 있으며 새로운 기능을 추가하는 확장 개념으로 생각
```java
//새로운 인사말 기능을 추가
public class Greeting extends Hello {
    public String ko() {
        return "안녕하세요";
    }
}
```

#### 2.2 계층
> 상속은 클래스를 통한 객체의 확장, 클래스가 또 다른 클래스를 상속받는다는 의미는 클래스 간 계층을 만든다는 것.

#### 2.3 상속의 문제점
> 클래스를 상속하면 구현과 추상 개념이 영구적으로 결합됨.  
> 상속으로 확장하면 최종 클래스가 무거워진다.

---

## 3. 패턴 설계 1
> 상속읜 문제점은 브리지 패턴을 응용하여 해결, 브리지 패턴을 적용하려면 4개의 구성요가 필요
1. Implementor
2. ConcreteImplementor
3. Abstract
4. refinedAbstract

#### 3.1 종속
> 상속을 이용해 확장할 경우 상위 클래스와 하위 클래스 사이에 강력한 결합 관계가 발생  
> 작성한 코드를 다양하게 사용하기 위해서는 독립적인 확장이 가능하도록 설계
> 강력한 결합 관계를 줄이고 느슨한 결합 관계로 변경
> 느슨한 결합 관계로 변경하는 방법 중 대표적인 것이 위임. 위임을 통해 객체의 구성을 복합 객체 구조로 리팩터링

#### 3.2 계층 분리
> 기능과 구현을 정리 인터페이스를 이용하여 계층화된 클래스를 분리  
```java
// 공통 인터페이스
public interface Hello {
    public String greeting();
}
public class English implements Hello {
    @Override
    public String greeting() {
        return "hello";
    }
}
public class Korean implements Hello {
    @Override
    public String greeting() {
        return "안녕하세요";
    }
}
```

#### 3.3 복합 구조
```java
public class Language {
    public Korean korean;
    public English english;

    public void setKorean(Korean korean) {
        this.korean = korean;
    }

    public void setEnglish(English english) {
        this.english = english;
    }
}
```

---

## 4. 패턴 설계 2
#### 4.1 추상 계층
> 하나의 계층만으로 설계된 복합 객체는 브리지 패턴이라고 하지 않는다
> 브리지 패턴은 복합 객체를 다시 재정의하여 추상 계층화된 구조

#### 4.2 계층 연결
> 브리지는 구현 계층과 추상 계층 두 곳을 연결하는 다리라는 의미.
> 클래스를 확장하는 방법은 상속에 의한 방식과 구현에 의한 방식, 브리지는 상속대신 구현을 이용해 분리된 객체를 연결

#### 4.3 추상 재설계
> 추상 클래스는 상위 클래스와 하위 클래스 사이에서 역할을 분담
> 역할을 분담하는 추상 클래스의 계층은 새로운 기능을 생성하는 것이 아니라 기존의 기능을 분리하여 계층화
```java
// 1. Implementor
public interface Hello {
    public String greeting();
}
// 2. ConcreteImplementor
public class English implements Hello {
    @Override
    public String greeting() {return "hello";}
}
// 2. ConcreteImplementor
public class Korean implements Hello {
    @Override
    public String greeting() {return "안녕하세요";}
}
// 3. abstract 부분
abstract public class Language {
    protected Hello language;
    abstract public String greeting(); // 추상 메서드
}
// 4. refinedAbstract 부분
public class Message extends Language {
    public Message(Hello language) {this.language = language;}
    @Override
    public String greeting() {return language.greeting();}
}
```

#### 4.4 브리지 의미
> 2개의 객체는 추상화를 구현에서 분리하여 매우 독립적으로 사용할 수 있어야 한다.

---

## 5. 장점과 단점
> 브리지 패턴은 기존 시스템에 부수적인 새로운 기능들을 지속적으로 추가할 때 사용하면 유용한 패턴
> 브리지 패턴은 새로운 인터페이스를 정의하여 기존 프로그램의 변경 없이 기능을 확장

#### 5.1 장점
> 클래스 계층을 분리할 때는 완전한 인터페이스로 결합하지 않습니다.
> 클래스에서 구현과 추상 부분을 2개의 계층으로 분리할 수 있으며, 분리된 2개의 추상 계층과 구현 계층은 독립적인 확장이 가능

#### 5.2 단점
> 브리지 패턴은 하나의 클래스가 추상 계층과 구현 계층으로 분리
> 추상화를 통해 코드를 분리할 경우 코드 디자인 설계가 복잡해진다는 단점.