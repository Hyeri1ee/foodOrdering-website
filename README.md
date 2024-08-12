# **MarketCurly shoppingMall**
- marketCurly(마켓컬리) 를 모티브로 하여 설계한 쇼핑몰 웹사이트입니다.
- 개발 기간 : 24.08.08 ~ <br>
- 참여 인원 : 1명<br>

- Swagger 문서는 여기서 확인할 수 있습니다 ->
[Swagger 문서 확인하러 가기]()

# 기술 스택
- Language : Java<br>
- Framework : Springboot 3.3.2<br>
- JDK : 17<br>
- BuildTool : Gradle<br>
- DB : MySQL<br>
- Server : <br>
- CI / CD : <br>


# 아키텍처
<img src=""  width="650" height="330">

# 프로젝트 구조
<img src=""  width="260" height="530">

# ERD
<img src=""  width="800" height="470">


# 기능설명


<details>
<summary>회원</summary>
 
- 사이트를 통해 회원 가입 및 로그인
- 소셜 로그인(카카오) 인증 후 로그인

    +프론트에서 로그인 소셜 타입을 전달받아 사용 EX ) NO_SOCIAL / KAKAO 

- 로그인 시, 로그인 기록 저장 ( 매일 자정에 데이터 초기화 )
- 아이디 중복 체크
- 회원 정보 확인
- 회원 정보 수정
- 회원 탈퇴
    
    +공통 : 탈퇴 시, DB 에서 삭제되지 않으며 DeleteAt 필드 값이 현재 시간으로 초기화
    
    +USER : 회원이 가지고 있는 장바구니 데이터 삭제
    
    +SELLER : 등록한 상품에 연관된 데이터 삭제
    
    +ADMIN : 해당 없음
</details>





# 시퀀스 다이어그램

[시퀀스 다이어그램]()

# 테스트 진행 여부
<img src=""  width="610" height="470">

# 기술적 도전



# 트러블 슈팅


    
# 프로젝트를 진행하면서 학습한 내용과 에러 조치


### 학습 내용정리

[FK 필드 1:N 연관관계 매핑](https://velog.io/@xeropise1/JPA-%EC%96%B4%EB%85%B8%ED%85%8C%EC%9D%B4%EC%85%98-%EC%A0%95%EB%A6%AC)

[jpa에 setter 사용 x](https://velog.io/@langoustine/setter-%EC%A7%80%EC%96%91-%EC%9D%B4%EC%9C%A0)

[자바 코드로 스프링 빈 수동 주입](https://m42-orion.tistory.com/100)

[HttpEntity response로 사용 예시](https://velog.io/@gwichanlee/Spring-HTTP-Header)


### ERROR

[hibernate-ddl-auto 설정 create로 ' Incorrect table definition; there can be only one auto column and it must be defined as a key 오류' 해결](https://velog.io/@deannn/Spring-Boot-Blog-Project-DB-%ED%85%8C%EC%9D%B4%EB%B8%94-%EB%A7%8C%EB%93%A4%EA%B8%B0)

# 프로젝트를 하면서 느낀 점
