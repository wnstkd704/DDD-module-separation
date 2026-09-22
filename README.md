# DDD-module-separation
도메인 주도 설계(DDD), MSA, 상품, 주문, 결제 정산 - 1부 회원과 글 모듈 분리하기

## 요구 사항
- JDK 25 이상
  - Gradle Toolchain이 설정돼 있어(`build.gradle.kts`) 로컬에 JDK 25가 없어도 Gradle이 자동으로 내려받아 사용합니다.
- Gradle은 따로 설치할 필요 없이 프로젝트에 포함된 Gradle Wrapper(9.7.1)를 사용합니다.

## 데이터베이스 설정
- `local` 프로필(`application-local.yaml`) 기준, 별도 DB 서버 설치 없이 파일 기반 H2를 사용합니다.
  - URL: `jdbc:h2:./db_dev;MODE=MySQL` (프로젝트 루트에 `db_dev.mv.db` 파일이 생성되며, `.gitignore`에 포함되어 커밋되지 않습니다)
  - Username: `sa`
  - Password: 없음
  - Driver: `org.h2.Driver`
- `spring.jpa.hibernate.ddl-auto: update`로 설정되어 있어 별도 마이그레이션 스크립트 없이 엔티티 기준으로 스키마가 자동 생성/갱신됩니다.
- 애플리케이션 실행 후 `http://localhost:8080/h2-console`에서 위 URL/계정 정보로 접속해 데이터를 직접 확인할 수 있습니다.

## 실행 방법
```bash
# 개발 서버 실행 (기본 프로필: local, 기본 포트: 8080)
./gradlew bootRun

# 테스트 실행
./gradlew test

# 빌드
./gradlew build

# 빌드된 jar 실행
java -jar build/libs/ddd-module-separation-0.0.1-SNAPSHOT.jar
```
