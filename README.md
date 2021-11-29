# HotSource
오픈소스 [json-simple](https://github.com/fangyidong/json-simple)라이브러리를 더 사용하기 쉽도록 경량화한 버전입니다.<br/>
코드분석에 어려움을 느낀다면 [여기를 클릭](https://github.com/innohack2021/HotSource/tree/main/GUIDELINE) 해 가이드라인을 통한 학습을 하시길 바랍니다.
<br/><br/>

## 기능
HotSource는 다음과 같은 코드의 간편화를 제공합니다.<br/>
예제 코드의 클래스는  HotSource의 [테스트 코드](https://github.com/innohack2021/HotSource/tree/main/src/test/java/com/innohotsource/hotjson/Json)기반으로 작성되었습니다.
<br/>

#### json 파일 인스턴스로 받기
다음의 json 형식을 가진 jsonObject변수와 json 파일을 받을 수 있는 모델 클래스 Sample이 있다고 가정해 봅시다.
```
{"name":"testName","id":1,"subSample":{"subId":2,"sub":{"subSubName":"sub"},"subName":"aaaa"}}
```
##### json-simple 예제
```java
Sample sample = new Sample();
sample.name = (String) jsonObject.get("name");
sample.id = (Long) jsonObject.get("id");

???...//json 중간에 리스트 때문에 코드 작성의 어려움 발생

```
##### HotSource 예제
```java
Sample sample =  JsonToObject.fromJson(jsonObject, Sample.class);
```
<br/><br/>

#### 인스턴스를 json형태로 저장
Sample 클래스 인스턴스를 이용해 다음의 json 형식을 가진 jsonObject를 만들어 봅시다.
```
{"name":"tHotSource","id":2021,"subSample":{"HotSource01","HotSource02","HotSource03"}}
```
##### json-simple
```java
JSONObject json = new JSONObject();
json.put("name", testSample.name);
json.put("id", testSample.id);

JSONArray list = new JSONArray();
list.add("HotSource01");
list.add("HotSource02");
list.add("HotSource03");

json.put("subSample", list);
```
##### HotSource
```java
JSONObject json = ObjectToJson.toJson(testSample);
```

<br/><br/>

#### 그 외 etc 기능
```java
//String 형태의 json과 클래스 형식을 넣었을 때, 해당 클래스 인스턴스에 json값을 넣어 반환
public static <T> T fromJsonString(String json, Class<T> clazz)
//예시
Sample sample = JsonToObject.fromJson(string, Sample.class);
```
```java
//json파일 읽어와 해당 클래스에 값을 넣어 인스턴스 반환
FileToObject file = new FileToObject(String pwd));
public <T> T getFile(Class<T> clazz);
//예시
String pwd = "./src/test/java/com/innohotsource/hotjson/Json/samplefile/Sample.json";
FileToObject file = new FileToObject(pwd);
Sample sample = file.getFile(Sample.class);
```

## build.gradle
다음 코드를 Gradle 파일에 추가하시면 됩니다.
```
repositories {
    maven { url "https://jitpack.io" }
}

dependencies {
    implementation 'com.github.innohack2021:HotSource:1.0'
}
```

## 기여 튜토리얼
해당 오픈소스에는 json을 file에 저장하는 기능을 지원하지 않습니다.<br/>
오픈소스 코드를 분석해 ObjectToFile클래스를 만들어 기여 해보세요.<br/>
코드 분석에 어려움이 있다면 [GUIDELINE](https://github.com/innohack2021/HotSource/tree/main/GUIDELINE)을 참고해 보세요.<br/>


## License
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