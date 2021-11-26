Reflection의 사용이유, 사용방법을 작성하는 곳입니다.
==============

Reflection의 사용 이유 
-------------------------------
코드의 간결성, 코드의 확장성
---------------------------
좋은 코드란??
-------------------------------
     남들이 보기 쉬운 코드가 아닌, 확장성이 좋은 코드 !!! (오픈소스 개발자, Library 개발자 기준)
------------------
    TEST
    뭐지?
    테스트해볼까


# Reflection을 사용하는 이유를 코드를 통해 알아보겠습니다.
## first step : if문 로직을 사용하여 구현
```java
public class Main {
    public static void main(String[] args) {
        String input = "Dog";

        if (input.equals("Dog")){
            (new Dog()).sound();
        }
        else if (input.equals("Cat")){
            (new Cat()).sound();
        }
        else if (input.equals("Tiger")){
            (new Tiger()).sound();
        }         
    }
}

class Dog{
    public void sound(){
        System.out.println("멍! 멍!");
    }
}

class Cat{
    public void sound(){
        System.out.println("야~옹!");
    }
}

class Tiger{
    public void sound(){
        System.out.println("어~흥!");
    }
}
```
    이렇게 사용하면, 객체가 새로 추가될 때 계속 if문이 추가되면서 기하급수적으로 코드가 늘어난다.

### second step : interface를 사용하여 코드를 한줄로 줄임
#### third step : Reflection을 활용하여 최적화
##### H5
###### H6

이건 제목
=============================================

    Java 문법 하이라이팅까지 하는법...!
```java
public class BootSpringBootApplication {
  public static void main(String[] args) {
    System.out.println("Hello, Honeymon");
  }
}
```