# Spring 파일 업로드 프로젝트
- gallery-01 에서는 이미지를 base64로 변환하여
DB table 에 저장했다.
- 이러한 방식은 오래전에 파일의 크기가 크지 않을때는 괜찮은 방법이었다.
- 요즘은 카메라 성능 등이 월등히 좋아져 이미지 크기가 매우 큰 경우가 많다.
- 일반적으로 2MB 이하의 이미지는 Table에 저장해도 큰 무리가 가지 않지만 그 이상되는 이미지를 Table에 저장하면 전체 DBMS 시스템 자체의 성능이 매우 불안정하고 느려지게 된다.
- 이미지 파일은 파일 자체를 서버에 업로드하여 서버의 폴더에 저장하고, DB table에는 파일에 대한 정보(파일이름)만 저장하는 형태로 구현한다.
- 이미지 파일(또는 기타 파일)을 업로드 하는 여러가지 도구를 활용해야한다.
## 도구 설치
- `fileUpload` 를 위한 dependency 설정
```xml
<!-- https://mvnrepository.com/artifact/commons-fileupload/commons-fileupload -->
<dependency>
    <groupId>commons-fileupload</groupId>
    <artifactId>commons-fileupload</artifactId>
    <version>1.5</version>
</dependency>

```

- `commons-fileupload` 를 `dependency` 에 설정 후 `maven dependencies` 를 확인하여 `commons-io` 항목이 없으면 

```xml
<!-- https://mvnrepository.com/artifact/commons-io/commons-io -->
<dependency>
    <groupId>commons-io</groupId>
    <artifactId>commons-io</artifactId>
    <version>2.16.1</version>
</dependency>
```