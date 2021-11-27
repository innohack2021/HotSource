# step2 : Annotation(어노테이션)

예제 코드 이해시 step1_reflection 이해 필요

## 어노테이션 설명
어노테이션이란 사전적의미로 주석을 의미하지만, 컴파일단계나, 런타임시 사용자의 조작으로 기능을 사용할 수 가 있다.


## 어노테이션 기능설명
어노테이션의 기본 구조는 다음과 같다.

```java
@Target({ElementType.[적용대상]})
@Retention(RetentionPolicy.[정보유지되는 대상])
public @interface [어노테이션명]{
	public 타입 elementName() [default 값]
    ...
}
```

@Target의 ElementType 적용대상은 아래 표와 같으며, 여기서 선언한 결과를 토대로 어노테이션의 적용대상을 정할 수 있다.
어노테이션을 선언할 떄 변수를 선언하는 것이 아닌 어노테이션을 사용하는 클래스의 변수, 함수 등이 타겟이 되는 것이다.

|ElementType|적용대상|
|:---|:---:|
|TYPE|클래스, 인터페이스, 열거 타입|
|ANNOTATION_TYPE|어노테이션|
|FIELD|필드|
|CONSTRUCTOR|생성자|
|METHOD|메소드|
|LOCAL_VARIABLE|로컬 변수|
|PACKAGE|패키지|

@Target에서 어노테이션을 적용할 대상을 정했다면 @Retention에서는 적용한 대상의 어노테이션을 언제까지 적용시킬지를 정하는 단계이다.
기본적으로 제공되는 빌트인 어노테이션은 컴파일시점에 이용되자만, 사용자가 만든 어노테이션은 메타어노테이션의 일부로 런타임시점에서 사용하기 때문에
적용시점을 정해 주어야 한다.
정리한 표는 다음과 같다.
|RetentionPolicy|설명|
|:---|:-----:|
|SOURCE|소스상에서만 어노테이션 정보를 유지한다. <br/>소스 코드를 분석할 때만 의미가 있으며, 바이트 코드 파일에는 정보가 남지 않는다.|
|CLASS|바이트 코드 파일까지 어노테이션 정보를 유지한다.<br/>하지만 리플렉션을 이용해서 어노테이션 정보를 얻을 수는 없다.|
|RUNTIME|바이트 코드 파일까지 어노테이션 정보를 유지하면서 <br/>리플렉션을 이용해서 런타임에 어노테이션 정보를 얻을 수 있다.|

@interface에서는 사용자가 사용할 어노테이션 이름을 정해주면 된다.
이후에 내부 함수에는 사용자가 어노테이션을 사용할 시에 필요한 함수들을 구현하면 된다.

## 예제 코드

ExAnnotation.java
```java
package ex.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
public @interface ExAnnotation {
    String star() default "*";
    int number() default 1;
}
```

MyStar.java
``` java
package ex.annotation;

public class MyStar {
    @ExAnnotation
    public void method1() {
        System.out.println("저 별을 줄께");
    }

    @ExAnnotation(star = "#", number = 20)
    public void method2() {
        System.out.println("저 별들을 줄께");
    }

    @ExAnnotation(star = "@")
    public void method3() {
        System.out.println("저 별을 따서 줄께");
   	}
}
```

Main.java
``` java
package ex.annotation;

import java.lang.reflect.Method;

public class Main {
    public static void main(String[] args) {
        Method[] methodList=MyStar.class.getMethods();

        for (Method m : methodList) {
            if (m.isAnnotationPresent(ExAnnotation.class)) {
                System.out.println(m.getName());
                ExAnnotation annotation=m.getDeclaredAnnotation(ExAnnotation.class);

                String star=annotation.star();
                int number=annotation.number();

                for (int i = 0; i < number; i++)
                    System.out.print(star);
                System.out.println();
            }
        }
    }
}
```


출력결과
```
method1
*
method2
####################
method3
@
```


##### 참고 사이트
http://tutorials.jenkov.com/java-reflection/annotations.html