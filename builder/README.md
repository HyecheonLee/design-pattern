# 빌더 패턴

---
## 1.건축물
#### 1.1 객체 생성
> 생성 패턴의 주요 목적은 객체의 생성 과정을 한 곳에 집중화하는 것  
> 패턴을 사용하여 객체를 생성 관리하는 이유는 인스턴스화 과정에서 발생하는 강력한 의존 관계를 해소하기 위해서  
> 객체의 종류는 크게 단일 객체와 복합 객체 2가지  

#### 1.2 복합객체 
> 상속은 상위 클래스를 is-a 관계로 포괄하여 큰 규모의 객체를 생성하는 기법  
> 상속에는 강력한 상하 결합 관계와 불필요한 모든 행위까지 포함된다는 단점  
> 객체지향에서는 상속의 단점을 개선하기 위해서 의존성 주입을 사용 의존성을  통해 복합객체를 생성하여 사용하는 것을 권장  
* 복합 객체란 하나의 객체가 다른 객체를 포함하는 관계 구조
> 복합 객체는 객체가 생성된 후에도 다른 객체와 관계를 설정해 동적 확장할 수 있다는 장점

#### 1.3 복잡한 객체
> 복합 객체는 내부적으로 다른 클래스의 객체를 포함  
> 빌더 패턴은 복잡한 구조의 복합 객체를 생성하는 로직을 별도로 분리하여 객체를 생성처리

---

## 2. 객체 실습
> 복합 객체는 하나의 객체가 다른 클래스의 객체를 포함한다는 특징

#### 2.1 기본 클래스
```java
// 기본 객체
public class Computer {
    public Cpu cpu;
    public List<Memory> rams = new ArrayList<>();
    public List<Storage> storages = new ArrayList<>();
    public int memory() {
        int size = 0;
        for (Memory ram : rams) {
            size += ram.getSize();
        }
        return size;
    }
    public int storage() {
        int size = 0;
        for (Storage storage : storages) {
            size += storage.getSize();
        }
        return size;
    }
    public Cpu getCpu() {
        return cpu;
    }
    public void setCpu(Cpu cpu) {
        this.cpu = cpu;
    }   
    public void addMemory(Memory memory) {
        rams.add(memory);
    }
    public void addStorage(Storage storage) {
        storages.add(storage);
    }
    @Override
    public String toString() {
        return "Computer{" +
                "cpu=" + cpu.getModel() +
                ", rams=" + memory() +
                ", storages=" + storage() +
                '}';
    }
}
```

#### 2.2 객체의 구성
> 복합 객체는 다른 클래스의 객체를 포함, 복합 객체가 다른 객체를 갖는 다양한 방법
1. 내부적으로 직접 관련된 클래스의 객체를 생성
2. 객체 생성자를 통해 관련 있는 객체들을 생성 결합
3. 팩토리 패턴과 같이 메서드를 활요해 관련된 객체를 생성
4. 외부로부터 객체의 의존성을 전달

#### 2.3 부속 클래스
```java
public class Memory {
    private int size;
    public Memory(int size) {
        this.size = size;
    }
    public int getSize() {
        return size;
    }
}
```
```java
public class Storage {
    private int size;
    public Storage(int size) {
        this.size = size;
    }
    public int getSize() {
        return size;
    }
}
```

---
## 3. 빌더
> 빌더 패턴은 복잡한 구조를 가진 복합 객체의 생성 과정을 분리하여 처리하는 패턴  
> 복합 객체의 생성관정을 단계별로 분리함으로써 복합 객체의 생성을 일반화 한다.

#### 3.1 빌더 패턴
> 각 구조에 맞게 생성을 처리할 수 있도록 과정을 분리하여 처리하는 패턴

#### 3.2 생성로직
> 복잡한 구조를 가진 복합 객체를 한 단계로만 생성할 수는 없다. 복합 객체의 내부 구조에 맞게 단계별로 객체 생성을 분리하고 관계를 결합하는 과정이 필요  
> 복합 객체의 구조는 종속적이기 때문에 종속된 순서의 역순으로 객체를 생성하여 결합  
> 복합 객체의 생성 로직을 일반 코드로 작성하면 객체 생성 과정을 효율적으로 관리하기 어렵다.

#### 3.3 빌더 추상화
> 빌더 패턴은 추상화를 통해 다양한 종류의 복합 객체를 생성 관리
```java
abstract public class Builder {
    protected Algorithm algorithm;
    public Builder setAlgorithm(Algorithm algorithm) {
        //빌드할 객체의 알고리즘 객체를 저장합니다.
        this.algorithm = algorithm;
        return this;
    }
    public Computer getInstance() {
        return algorithm.getInstance();
    }
    abstract public Builder build();
}
```

#### 3.4 ConcreteBuilder 
> 추상 클래스로 설계된 빌더는 자체적으로 객체를 생성할 수 없어 추상 클래스를 상속하는 하위 클래스가 필요.
> 하위 클래스는 실제 복합 객체의 생성 과정을 위임 , 빌더 로직을 구체화하는 하위 클래스는 상위 추상 클래스를 상속  
> 추상화를 적용하면 여러 개의 하위 클래스를 만들어 다형성을 적용 다형성을 이용해 다양한 복합 객체의 생성 로직을 하위 클래스로 구현
```java
// 외부에서 알로리즘을 전달
public class Factory extends Builder {

    // 알고리즘 의존성을 주입
    public Factory(Algorithm algorithm) {
        this.algorithm = algorithm;
    }
    // 단계별 빌더 메서드를 호출
    @Override
    public Builder build() {
        algorithm.setCpu("i7")
                .setRam(Arrays.asList(new Memory(8), new Memory(8)))
                .setStorage(Arrays.asList(new Storage(256), new Storage(512)));
        return this;
    }
}
```

#### 3.5 추상메서드 
> 복합 객체의 생성 로직을 직접 클라이언트 코드로 구현하거나 메서드를 호출하지 않으며, 돌립적인 단계별 구축 공정을 분리하여 처리

---
## 4. 알고리즘
#### 4.1 전략패턴
> 빌더 패턴은 분리된 처리 로직을 객체화하여 전달, 빌더 패턴은 전략 패턴과 결합된 형태를 갖게 된다.
```java
    public Factory(Algorithm algorithm) {
        this.algorithm = algorithm;
    }
```

#### 4.2 추상화
> 다양한 객체를 생성 및 처리하기 위해서는 다형성을 적용하는 것이 좋은데, 빌더 패턴은 일관적인 알고리즘을 적용하면서 다형성을 유지하기 위해 추상화 구조를 적용
> 빌더 패턴은 추상 팩토리를 확장한 패턴, 알고리즘은 다시 추상화를 통해 생성 과정을 단계별로 갭슐화
```java
//알고리즘의 공통된 동작을 위하여 추상 클래스를 선업합니다.
//각 알고리즘으로 개정의되는 추상 메서드를 선업합니다.
abstract public class Algorithm {
    //빌더 객체를 저장합니다.
    protected Computer composite;
    abstract Algorithm setCpu(String cpu);
    abstract Algorithm setRam(List<Memory> rams);
    abstract Algorithm setStorage(List<Storage> storages);
    public Computer getInstance() {
        return composite;
    }
}
```

#### 4.3 하위 클래스
```java
//알고리즘의 하위 클래스를 구현
public class ProductModel extends Algorithm {
    public ProductModel() {
        composite = new Computer();
    }
    // 빌더 단계별 메서드
    @Override
    ProductModel setCpu(String cpu) {
        composite.setCpu(new Cpu(cpu));
        return this;
    }
    // 빌더 단계별 메서드
    @Override
    Algorithm setRam(List<Memory> rams) {
        for (Memory memory : rams) {
            composite.addMemory(memory);
        }
        return this;
    }
    // 빌더 단계별 메서드
    @Override
    Algorithm setStorage(List<Storage> storages) {
        for (Storage storage : storages) {
            composite.addStorage(storage);
        }
        return this;
    }
}
```

#### 4.4 교환 가능성
> 객체지향에서는 복합 객체의 구조가 너무 다양하기 때문에 활용하기 어렵다. 빌더 패턴에서는 이를 보완하기 위해 생성과 처리 로직을 분리 했고,
> 처리 로직을 분리할 때 전략 패턴을 사용  
> 빌더 클래스는 어떤 복합 객체가 만들어지는지 구체적으로 알지 못한다, 약속된 동작으로만 객체 생성 과정을 호출하고, 실체 객체는 알고리즘에 의해 생성

#### 4.5 빌더 선택
> 빌더 패턴은 추상화의 다형성을 이용해 그룹별로 복합 객체의 종류를 설계. 추상화는 객체의 생성 그룹 A와 그룹 B 형태로 분리

---

## 5. 생성 요청
#### 5.1 알고리즘 생성
```java
// 알고리즘을 생성
final Algorithm algorithm = new ProductModel();
```
#### 5.2 빌더 객체
```java
//빌더 객체 생성
final Factory factory = new Factory(algorithm);
```

#### 5.3 빌드
```java
    void build() {
        // 알고리즘을 생성
        final Algorithm algorithm = new ProductModel();
        //빌더 객체 생성
        final Factory factory = new Factory(algorithm);
        //생성 요철
        // 빌드 생성된 객체를 전달 받습니다.
        final Computer computer = factory.build().getInstance();
        System.out.println(computer);
    }
```
 
 ---
 
## 6. 정리
> 추상 팩토리 패턴을 확장하고, 복잡한 단계를 가진 복합 객체를 생성할 수 있다.
> 생성 단계를 중점으로 설계한다.  
> 만들고자 하는 부품들이 모여야 의미가 있다.