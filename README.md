### 스프링부트와 클라우드활용 강의용 깃 소스를 스프링부트2 프로젝트를 스프링부트3로 마이그레이션
- 기존 스프링부트2 프로젝트 : https://github.com/kimilguk/kimilguk-boot2
- 마이그레이션 스프링부트3 프로젝트 : https://github.com/kimilguk/kimilguk-boot3
- 참고로, Spring Boot3 버전부터 java17 아래버전으로 컴파일되지 않습니다.
- 2022년 11월에 기존의 Spring framework 5 와 Spring Boot 2.X 버전을 대체하는 Spring framework6 과 Spring Boot3 가 릴리즈 되었습니다.
- 스프링부트3에서 사용방법이 많이 변경된 이유는(아래)
- JavaEE 상표권은 오라클이 갖고 있어서 오픈소스 그룸인 이클립스 재단에서 JavaEE 패키지 이름인 javax.* 를 사용할 수 없습니다.
- 그래서, 이클립스 재단은 JakartaEE 이라 하고, 패키지는 jakarta.* 로 명명했습니다.
- 단, javax.sql.DataSource 이나 javax.crypto.SecretKey 기타등등 과 같은 클래스는 JDK 에 내장되어있는 것들이며 이들은 바뀌지 않았습니다.
- 즉, Spring Boot 3.x 에서는 JavaEE 가 아닌 JakartaEE 를 사용해야 하므로 javax.servlet 대신 jakarta.servlet 으로,  javax.persistence 대신 jakarta.persistence 으로 소스를 변경 해야 합니다. 어떤 경우는 javax.sql 처럼 내장된 라이브러리를 사용하므로 마이그레이션 하기 약간 번거롭습니다.(아래 역순으로 작업 중...)

07_#스프링부트3에서 SecurityConfig.java파일에 기존 로그인 주석 후 메모리용 로그인 @Bean 추가(소스참조)
06_#스프링부트3에서 application.properties파일에 추가: 머스테치 화면의 한글 깨짐처리(아래)
 - server.servlet.encoding.force-response=true
05_스프링부트3 프로젝트와는 상관없는 Java학습용 java파일에 일괄변경된 부분 원상복귀
 - jakarta.imageio -> javax.imageio;
 - jakarta.swing -> javax.swing
04_WebSecurityConfigurerAdapter 는 deprecated 사용제외 되어서, import 구문 삭제
 - SecurityConfig.java 에서 위 어댑터@Override 사용대신 @Bean으로 설정 후 내용 변경처리
03_jakarta 일괄변경에서 제외해야 하는 항목SecurityConfig.java파일에서 jakarta.sql -> 다시 javax.sql 로 변경 처리한다.
02_스프링부트3에는_javax패키지명이_jakarta로변경되어서_소스일괄변경처리.
01_스프링부트3로프로젝트이름변경 (build.gradle, setttings.gradle) + gradle폴더지우고부트3용으로 붙여넣기

Ps. 관련기술참조: 
 - 마이그레이션 일반: https://post.dooray.io/we-dooray/tech-insight-ko/back-end/4173/
 - 마이그레이션 일반: https://techblog.lycorp.co.jp/ko/how-to-migrate-to-spring-boot-3
 - 시큐리티 심화: https://velog.io/@pizza_1/Spring-Security-6-%ED%8A%9C%ED%86%A0%EB%A6%AC%EC%96%BC-2
 - DB용시큐리티참조 : https://dev-log.tistory.com/4