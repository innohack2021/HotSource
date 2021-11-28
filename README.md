# HotSource
오픈소스 [json-simple](https://github.com/fangyidong/json-simple)라이브러리를 더 사용하기 쉽도록 경량화한 버전입니다.



##기능
HotSource는 다음과 같은 코드의 간편화를 제공합니다.
예제 코드의 클래스는  HotSource의 [테스트 코드](https://github.com/innohack2021/HotSource/tree/main/src/test/java/com/innohotsource/hotjson/Json)기반으로 작성되었습니다.
<br/>
다음의 json 형식을 가진 jsonObject변수가 있다 가정
```
{"name":"testName","id":1,"subSample":{"subId":2,"sub":{"subSubName":"sub"},"subName":"aaaa"}}
```

####json 파일 인스턴스로 받기
|json-simple|HotSource|
|:---|:---|
|```java
Sample sample = new Sample();
sample.name = (String) json.get("name");
sample.id = (Long) json.get("id");

...//json 중간에 리스트가 있으면 매우 복잡

```|
```java
Sample sample =  JsonToObject.fromJson(jsonObject, Sample.class);
```|

####인스턴스를 json형태로 저장
|json-simple|HotSource|
|:---|:---|
|```java
JSONObject json = new JSONObject();
json.put("name", testSample.name);
json.put("id, testSample.id);

JSONArray list = new JSONArray();
list.add("HotSource01");
list.add("HotSource02");
list.add("HotSource03");

json.put("subSample", list);
```|
```java
JSONObject json = ObjectToJson.toJson(testSample);
```|

####그 외 etc 기능
```
```

##Download
```
dependencies {
    testImplementation 'org.junit.jupiter:junit-jupiter-api:5.7.0'
    testRuntimeOnly 'org.junit.jupiter:junit-jupiter-engine:5.7.0'
    implementation 'com.github.innohack2021:HotSource:1.0'
}
```


##License
```
MIT License

Copyright (c) 2021 HotSource

Permission is hereby granted, free of charge, to any person obtaining a copy
of this software and associated documentation files (the "Software"), to deal
in the Software without restriction, including without limitation the rights
to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
copies of the Software, and to permit persons to whom the Software is
furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in all
copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
SOFTWARE.

```