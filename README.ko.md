# 야구 시뮬레이션 프로젝트 기본 세팅

## 프로젝트 개요

### 기본 정보
- **프로젝트명**: plsim
- **타입**: 야구 시뮬레이션 리그 게임
- **기술스택**: Kotlin, Spring Boot 3.x, Gradle, JPA
- **아키텍처**: Clean Architecture + 멀티모듈

### 게임 특징
1. **리그 시스템**: 30팀 제한, 여러 리그 병렬 운영
2. **선수 획득**: 드래프트 + 트레이드 + FA 시스템
3. **경기 처리**: 정해진 시간 일괄 배치 처리 (하루 3경기)
4. **시뮬레이션**: 이닝별, 타석별, 구별 상세 결과

## 멀티모듈 구조

```
baseball-sim/
├── build.gradle.kts           # 루트 - 공통 설정
├── settings.gradle.kts        # 모듈 정의
├── common/                    # 공통 유틸리티 (예외, 상수, 유틸)
├── domain/                    # 핵심 도메인 (Pure Java)
├── application/               # 비즈니스 로직 (UseCase + Service)
├── infrastructure/            # 인프라 (Repository 구현, 외부 연동)
├── simulation-engine/         # 시뮬레이션 엔진 (별도 모듈)
├── batch/                     # 배치 처리 (경기 실행, FA 처리)
└── api/                       # REST API (Spring Boot 실행 모듈)
```

### 모듈별 역할

- **common**: 모든 모듈에서 사용하는 공통 코드 (예외, 유틸리티, 상수)
- **domain**: 야구 게임의 핵심 비즈니스 로직 (Pure Java, 외부 의존성 최소화)
- **application**: 비즈니스 유스케이스 구현 (UseCase + Service 패턴)
- **infrastructure**: 데이터베이스, 외부 API 연동 (Repository 구현체)
- **simulation-engine**: 야구 시뮬레이션 엔진 (경기, 타석, 구별 시뮬레이션)
- **batch**: 정해진 시간에 실행되는 배치 작업 (일일 경기, 주간 FA 처리)
- **api**: REST API 엔드포인트 (Spring Boot 메인 애플리케이션)

### 의존성 관계

```
api → application → domain
  ↓         ↓
infrastructure → domain
     ↑
   common (모든 모듈에서 참조 가능)
```
