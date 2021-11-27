Reflection 적용방법   
==============           
<br/><br/><br/><br/>
<br/><br/>                                  

Reflection의 사용 이유 
-------------------------------
**==> 코드의 간결성, 코드의 확장성**

<br/><br/><br/>

좋은 코드란??
-------------------------------
**==> 남들이 보기 쉬운 코드가 X, 확장성이 좋은 코드 !!! (오픈소스 개발자, Library 개발자 기준)**

<br/><br/><br/><br/><br/>

# Reflection을 사용하는 이유를 코드를 통해 알아보겠습니다.

<br/><br/><br/>

## First step : if문 로직을 사용하여 구현
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

<br/><br/><br/><br/><br/>

## Second step : interface를 사용하여 코드를 한줄로 줄임

    Java 문법 하이라이팅까지 하는법...!
```java
public class Main {
    public static void main(String[] args) {
        String input = "Tiger";

        Animal[] Animals = {new Dog(), new Cat(), new Tiger()}; // 클래스 추가시 마다 계속 객체를 추가해줘야함.
        for (Animal a : Animals) {
           if (input.equals(a.getName())) {
               a.sound();
           }
        }
    }
}

interface Animal{
    public void sound();
    public String getName();
}

class Dog implements Animal{
    public void sound(){
        System.out.println("멍! 멍!");
    }
    public String getName(){
        return "Dog";
    }
}

class Cat implements Animal{
    public void sound(){
        System.out.println("야~~옹!");
    }
    public String getName(){
        return "Cat";
    }
}

class Tiger implements Animal{
    public void sound(){
        System.out.println("어~~~흥!");
    }
    public String getName() {
        return "Tiger";
    }
}

```
    
    interface 활용 시 코드는 크게 늘어나지 않지만, 클래스가 추가될 때마다 객체를 injection 또는 하드코딩으로 추가해줘야함


<br/><br/><br/><br/><br/>

## Third step : Reflection을 사용하여 최종적으로 최적화

```java
import java.lang.reflect.Method;

public class Main {
    public static void main(String[] args) throws Exception {
        String input = "Tiger";
        Class<?> clz = Class.forName(input);
        Object o = clz.newInstance();
        Method m = clz.getMethod("sound");
        m.invoke(o,null);
    }
}

interface Animal{
    public void sound();
}

class Dog implements Animal{
    public void sound(){
        System.out.println("멍! 멍!");
    }
}

class Cat implements Animal{
    public void sound(){
        System.out.println("야~~옹!");
    }
}

class Tiger implements Animal{
    public void sound(){
        System.out.println("어~~~흥!");
    }
}
```
    객체 정보가 추가돼도, 코드는 하나도 바꾸지 않아도 된다.

결론적으로 리플렉션을 사용하여 객체를 분석하여, 코드변경없이 확장성 좋은 라이브러리를 만드는 것이 목표입니다.
===================