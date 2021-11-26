# step3 : JsonParser
해당 문서는 청자가 JSON의 기본 구조를 알고 있다고 가정한 상태에서 문서를 작성하였습니다.<br/>
JSON에 대한 기초는 [다음](https://developer.mozilla.org/ko/docs/Learn/JavaScript/Objects/JSON)을 참고하십시오.<br/>
해당 문서는 json-simple 라이브러리를 바탕으로 작성하였습니다.<br/>

## Json-Simple 설명
JSON 데이터를 처리하기 위한 자바 라이브러리이며, 타사 라이브러리에 대한 의존성이 없어 매우 가벼운 API이며, 간단한 JSON 데이터를 처리하기 위해 적합한 라이브러리입니다.

## Json-Simple 자주 쓰는 함수 및 예제

1. JSONObject().put() 함수<br/>
Json형태로 만드는 함수이다.<br/>
key와 value를 넣어 json자료형을 만들 수 있다.<br/>
ex) JSONObject().put("key", "value");<br/>

```java
import org.json.simple.JSONObject;

public class Main {
    public static void main(String[] args) {

        JSONObject obj = new JSONObject();
        obj.put("name", "HotSource");
        obj.put("age", 2021);
        obj.put("fork", 5);

        System.out.print(obj);
    }
}
```

출력결과
```
{"fork":5,"name":"HotSource","age":2021}
```

<br/>
2. JSONArray().add() 함수<br/>
Json에 리스트를 넣을 때 쓰는 함수이다. 아래 예제를 참고하자.<br/>

```java
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

public class Main {
    public static void main(String[] args) {

        JSONObject obj = new JSONObject();
        obj.put("name", "HotSource");

        JSONArray list = new JSONArray();
        list.add("human1");
        list.add("human2");
        list.add("human3");
        obj.put("humans", list);

        System.out.print(obj);
    }
}
```

출력결과
```
{"name":"HotSource","humans":["human1","human2","human3"]}
```


3. JSONArray().get() 함수<br/>
위의 2예제에서 만들어진 가상의 JSON을 담은 obj가 그대로 있다고 가정하자.<br/>
해당 JSON에서 값을 가져올 수 있도록 해주는 함수이다.<br/>

```java
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

public class Main {
    public static void main(String[] args) {

        JSONObject obj = new JSONObject();
        obj.put("name", "HotSource");
        JSONArray list = new JSONArray();
        list.add("human1");
        list.add("human2");
        list.add("human3");
        obj.put("humans", list);

		//3. JSONArray().get() 함수 코드 시작
        String name = (String) obj.get("name"); //JSON에서 key가 "name"인 value를 반환
        System.out.println(name);

        JSONArray msg = (JSONArray) obj.get("humans");//JSON에서 key가 "humans"인 list를 반환
        System.out.println(msg);
    }
}
```

출력결과
```
HotSource
["human1","human2","human3"]
```

##### 참고 사이트
https://github.com/fangyidong/json-simple