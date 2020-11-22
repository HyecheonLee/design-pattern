# 복합체 패턴

> 복합체 패턴은 객체 간의 계층적 구조화를 통해 객체를 확장하는 패턴
> 복합체는 재귀적으로 결합된 계층화된 트리 구조의 객체

---

## 1. 객체를 포함하는 객체

> 복합 객체는 객체가 또 다른 객체를 포함하는 것, 복합적인 객체 관계를 복합화 또는 집단화 라고 한다.

#### 1.1 복합 객체로 구조 확장하기

> 객체의 복합화는 객체를 더 큰 구조의 객체로 확장하는 방법.
> 복합 객체는 강력한 결합 구조를 가진 상속과 달리 느슨한 결합을 갖고 있으며, 복합 객체의 결합은 의존체 주입방식을 사용  
> 복합 객체는 하나의 객체가 다른 객체를 포함하는 구조

```java
public class Computer {
    public Monitor monitor;
    public String name = "구성";

    public void setMonitor(Monitor monitor) {
        this.monitor = monitor;
    }
}

public class Monitor {
    public String name = "모니터";
}
```

#### 1.2 수평으로 객체를 확장하기

> 복합 객체의 특징은 다른 객체 정보를 포함하면서 수평적으로 확장, 객체는 여러 객체 정보를 동시에 가질 수 있다.
> 집단화된 객체는 부분-전체 계층구조 객체들은 트리 구조형태의 계층화 구조를 가진다.

```java
public class Computer {
    public Monitor monitor;
    public Disk disk;
    public Memory memory;
    public String name = "구성";

    public void setMonitor(Monitor monitor) {
        this.monitor = monitor;
    }

    public void setDisk(Disk disk) {
        this.disk = disk;
    }

    public void setMemory(Memory memory) {
        this.memory = memory;
    }
}

public class Disk {
    public String name = "디스트";
}

public class Memory {
    public String name = "메모리";
}

public class Monitor {
    public String name = "모니터";
}
```

#### 1.3 수직으로 객체 확장하기

> 수평으로 확장하는 것은 하나의 객체가 여러 객체를 포함하는 것  
> 자식이 하나씩만 존재. 자식 객체로는 일반 객체뿐만 아니라 복합 객체도 확장 가능  
> 복합 객체를 자식 객체로 사용할 때는 수직적 확장 구조, 복합 객체는 수직적 확장을 통해 계층적이고 복잡한 트리 구조

```java
public class Monitor {
    public List<Monitor> screen = new ArrayList<>();
    public String name = "모니터";

    public void addMonitor(Monitor monitor) {
        screen.add(monitor);
    }

    public void show() {
        screen.forEach(part -> {
            System.out.println(part.name);
        });
    }
}

public class Monitor32 extends Monitor {
    public String name = "32인치";
}
```

---

## 2. 복합체의 구조적 특징

> 복합 객체는 하나의 객체가 다른 객체를 포함. 복합체 패턴은 복합 객체의 특성을 이용한 구조적 패턴

#### 2.1 재귀적 결합

> 재귀적인 데이터의 구조를 표헌할 때 트리 구조를 자주 사용  
> 복합 객체는 객체들을 서브 하위 객체로 그룹화하는 특징. 객체 그룹화를 통해 더 큰 집단의 객체로 확장 집단화  
> 복합체는 객체를 재귀적으로 결합할 때 마지막 노드인지 또는 다른 객체를 포함하는 복합객체인지 판단하는데, 이를 판단하기 위해서는 복잡한 조건 처리가 필요하다.

#### 2.2 구성 요소

> 복합체는 하나의 구조 안에 또 다른 구조를 가진 모델을 설계할 때 많이 사용.

1. Component
2. Composite
3. Leaf
4. Client

---

## 3. 투명성을 활용한 동일한 설계

> 복합체는 일반 객체, 복잡 객체 구분 없이 재귀적 결합이 가능. 모두 동일한 객체로 처리하여 트리 구조를 쉽게 활용

#### 3.1 투명성

> 복합체 패턴은 Component 인터페이스를 이용하여 Composite 객체와 Leaf 객체를 서로 구별 하지 않고 동일한 동작으로 처리
> 이를 투명성, 투명성은 복합체 패턴의 특징

#### 3.2 동일한 방법

> 복합체에서 서로 다른 Composite와 Leaf를 동일한 형태로 투명하게 사용하기 위해 클래스의 일반화 작업 실행  
> 클래스를 일반화 하려면 추상 클래스를 상속 또는 인터페이스를 적용

#### 3.3 불필요한 기능

> 클래스의 일반화와 퉁명성은 객체 설계 시 불필요한 기능이 추가된다는 단점  
> 서로 다른 객체의 투명성으로 인해 하나의 객체에 2개 이상의 책임이 부여

#### 3.4 단일 책임

> Component는 Composite 객체와 leaf 객체 모두 투명하게 처리하기 위한 공통 인터페이스
> 복합체의 인터페이스는 기능을 두 가지 이상 탑재  
> 여러 기능이 하나의 클래스 안에 탑재되는 것은 객체의 안정성을 떨어뜨린다.
> 단일 책임 원칙을 위반하여 설계하는 것은 복합체 패턴의 특징인 투명성을 보장하기 위해서.

#### 3.5 안전한 복합체

> 복합체 패턴의 특징인 투명성을 적용하지 않고 서로 다른 인터페이스를 적용하여 설계  
> 다른 인터페이스를 적용하면 불필요한 메서드가 추가되는 것을 방지 단일책임 원칙도 준수

---

## 4. 추상화를 통한 일반화 작업

> 복합 객체를 복합체 패턴으로 재정의하는 목적은 재귀적으로 결합된 노드에 동일한 형태로 접근하기 위해서.

#### 4.1 추상 클래스

> 서로 다른 객체에서 동일한 방법으로 객체의 동작에 접근하기 위해서는 클래스의 일반화 작업이 필요  
> 일반화 작업은 인터페이스를 이용하는 방법, 추상화를 이용하는 방법
> 추상화를 통해 복합체를 설계할 때 중요한 점은 클래스가 담고 있는 컨터이너를 하나의 추상화로 정의  
> 하나의 추상 클래스를 컴포넌트, 추상 클래스로 제작되는 컴포넌트는 인터페이스 역할도 함께 수행

---

## 5. Leaf

> 복합체는 계층적 트리 구조 노드의 제일 마지막 객체를 리프

#### 5.1 마지막 노드

> 계층적 노드의 끝을 리프, 리프는 트리 구조에서 제일 마지막에 존재하며 다른 객체를 포함할 수 없다.  
> 마지막 객체는 리프 객체 말고 복합체 패턴으로도 사용될 수 있으며, 마지막 노드가 복합체 패턴일 경우 객체를 추가로 더 확장할 수 있습니다.

#### 5.2 컴포넌트 상속

> 복합체는 상하 관계를 가진 계층적 구조, 상속 관계인 is-a 관계 처리가 필요

```java
// 컴포넌트 추상화를 적용
public class Leaf extends Component {
    private String data;

    public Leaf(String name) {
        setName(name);
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }
}
```

---

## 6. Composite

#### 6.1 객체 저장

```java
public class Composite extends Component {
    public Map<String, Component> children = new LinkedHashMap<>();

    public Composite(String name) {
        setName(name);
    }

    public void addNode(Component folder) {
        children.put(folder.getName(), folder);
    }

    public void removeNode(Component component) {
        children.remove(component.getName());
    }

    public Boolean isNode() {
        return !children.isEmpty();
    }
}
```

#### 6.2 합성

> 하나의 객체만으로 동작하지 못하고 다른 객체와 같이 이용해야 할 경우 다른 객체들을 합성이라고 표현  
> 복합 객체는 또 다른 객체를 하나의 부품처럼 추가.객체가 확장되는 것이며 하나의 구조를 더 큰 구조로 발전
> 확장을 위해 각 부품에 해당하는 객체 하나 하나를 프로퍼티 형태로 지정.

#### 6.3 부모 포인터

> 부모를 참조하는 사위 포인터를 같이 저장하면 트리 구조를 단순화 하고 상위 노드를 쉽게 조작
> 상위/하위 포인터를 모두 갖고 있을 경우 좀 더 세밀한 구조 관리가 필요

#### 6.4 순서

> 복합체 패턴 중간 노드에는 여러 개의 리프와 또 다른 복합체 패턴이 포함
> 저장되는 하위 객체의 순서를 관리하려면 별도의 추가 로직이 필요

#### 6.5 캐시

> 복합체 패턴에서 관리되는 객체와 리프 구조의 크기는 예상할 수 없으며 언제든지 기하급수적으로 커질 수 있다.
> 관리 되는 복합 객체의 크기가 너무 커지면 구조를 분석하고 처리하는 데 많은 자원이 할당, 이를 빠르게 처리하기 위해 별도의 캐시 처리 동작을 만들어둘 수 있다.

---

## 7. 패턴 결합

> 복합체 패턴의 구조를 형성하고 기능을 처리하기 위해 몇 가지 다른 패턴을 결합하여 사용

#### 7.1 템플릿 메서드

> 복합체의 컴포넌트는 추상 클래스로 설계, 추상 클래스로 컴포넌트를 제작할 때는 템플릿 메서드 패턴을 함께 응용

#### 7.2 반복자

---

## 8. 적용 사례

> 컴퓨터 파일 시스템

```java
//추상화로 생성
abstract public class Component {
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

public class Composite extends Component {
    public Map<String, Component> children = new LinkedHashMap<>();

    public Composite(String name) {
        setName(name);
    }

    public void addNode(Component folder) {
        children.put(folder.getName(), folder);
    }

    public void removeNode(Component component) {
        children.remove(component.getName());
    }

    public Boolean isNode() {
        return !children.isEmpty();
    }
}

// 컴포넌트 추상화를 적용
public class Leaf extends Component {
    private String data;

    public Leaf(String name) {
        setName(name);
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }
}
```

```java
class IndexTest {

    @Test
    void test01() {
        //폴더
        final Composite root = new Composite("root");
        final Composite home = new Composite("home");
        final Composite hojin = new Composite("hojin");
        final Composite jiny = new Composite("jiny");
        final Composite users = new Composite("user");
        final Composite temp = new Composite("temp");

        //파일
        final Leaf img1 = new Leaf("img1");
        final Leaf img2 = new Leaf("img2");
        final Leaf img3 = new Leaf("img3");
        final Leaf img4 = new Leaf("img4");

        root.addNode(home);
        root.addNode(users);
        users.addNode(hojin);
        hojin.addNode(img1);
        hojin.addNode(img2);
        hojin.addNode(img3);
        hojin.addNode(img4);
        users.addNode(jiny);
        root.addNode(temp);
        tree(root);
    }

    @Test
    void test2() {
        //폴더
        final Composite root = new Composite("root");
        final Composite home = new Composite("home");
        final Composite hojin = new Composite("hojin");
        final Composite jiny = new Composite("jiny");
        final Composite users = new Composite("user");
        final Composite temp = new Composite("temp");

        //파일
        final Leaf img1 = new Leaf("img1");
        final Leaf img2 = new Leaf("img2");
        final Leaf img3 = new Leaf("img3");
        final Leaf img4 = new Leaf("img4");

        root.addNode(home);
        root.addNode(users);
        users.addNode(hojin);
        hojin.addNode(img1);
        hojin.addNode(img2);
        hojin.addNode(img3);
        hojin.addNode(img4);
        users.addNode(jiny);
        root.addNode(temp);

        users.removeNode(hojin);
        tree(root);
    }

    public void tree(Composite composite) {
        final Map<String, Component> children = composite.children;
        children.forEach((key, value) -> {
            if (value instanceof Composite) {
                System.out.print("Folder = " + key);
                if (((Composite) value).isNode()) {
                    System.out.println();
                    tree((Composite) value);
                } else {
                    System.out.println("... 노드 없음");
                }
            } else if (value instanceof Leaf) {
                System.out.println("File : " + key);
            } else {
                System.out.println("??");
            }
        });
    }
}
```

---

## 9. 적용 사례 2

> 쇼핑몰 분야에서 많이 사용, 복합적인 계층을 가진 주문인 경우 복합체 패턴을 응용해서 처리

---

## 10. 적용 사례 3

> 그래픽을 처리하는 작업에서 많이 사용
> 하나의 도형은 다른 도형을 포함 도형의 정보를 트리화하여 객체를 처리

---

## 11. 장단점 및 결과

> 복합체 패턴은 클래스의 일관된 계정을 정의 코드가 매우 단순해지며 새로운 구성 요소를 추가하거나 삭제하는 것도 편리해짐.

#### 11.1 장점
> 트리 구조를 구현하면 트리를 추가하거나 이동, 삭제하여 전체적인 구조를 유지하는 데 매우 유용

#### 11.2 단점
> 수평적 방향만으로 확장이 가능하도록 Leaf를 제한하는 Composite를 만들기 어렵다.