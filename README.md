# user-currency 💰
## 고객 환전 서비스 🧑🏻‍💻

------------
## API 명세서 📋
### Lv 0. API 명세 작성   `필수`
 - [X]  **API 명세서 작성하기**
    - [X]  API명세서는 프로젝트 com.example.usercurrency 경로의 `test.http` 에 작성 

<details>
  <summary>  고객 생성 </summary> 
  
  <img width="333" alt="고객 생성 2024-11-29 오후 2 53 10" src="https://github.com/user-attachments/assets/8d52c060-34bd-42bd-a529-72b64f17375e">

  </details> 

<details>
  <summary>  고객 전체 조회 </summary> 

  <img width="333" alt="고객 전체 조회 2024-11-29 오후 2 53 25" src="https://github.com/user-attachments/assets/ea296fb0-274a-4599-a7de-8ee07f0ab9c3">

  </details> 

<details>
  <summary>  선택 고객 조회 </summary> 
  
  <img width="333" alt="선택 고객 조회 2024-11-29 오후 2 53 32" src="https://github.com/user-attachments/assets/7c9ef4a6-8ad7-4a2a-87fb-755d5d12686d">

  </details> 

<details>
  <summary>  선택 고객 삭제 </summary> 
  
  <img width="333" alt="선택 고객 삭제 2024-11-29 오후 2 53 39" src="https://github.com/user-attachments/assets/a382178e-6eea-42b5-86e3-e8d1d5b41661">

  </details> 

<details>
  <summary>  통화 생성 </summary> 
  
  <img width="333" alt="통화 생성 2024-11-29 오후 2 53 47" src="https://github.com/user-attachments/assets/5433a97b-0201-4bd3-9395-b403627b363f">

   <details>

<details> 
  <summary>  통화 전체 조회 </summary> 
  
  <img width="333" alt="통화 전체 조회 2024-11-29 오후 2 53 56" src="https://github.com/user-attachments/assets/6d50c150-f9fa-4746-b031-e80532a25530">
  
  </details> 

<details>
  <summary>  선택 통화 조회 </summary> 

  <img width="333" alt="선택 통화 조회 2024-11-29 오후 2 54 03" src="https://github.com/user-attachments/assets/e8e07a32-89fa-4af2-b3e1-e598c159110e">

  </details> 

<details>
  <summary>  환전 요청 생성 </summary> 

  <img width="333" alt="환전 요청 생성 2024-11-29 오후 2 54 10" src="https://github.com/user-attachments/assets/6cbbc700-4a88-45f8-87c9-ade864a8e92d">

  </details> 

<details>
  <summary>  고객의 환전 요청 조회 </summary> 

  <img width="408" alt="고객의 환전 요청 조회 2024-11-29 오후 2 54 26" src="https://github.com/user-attachments/assets/3d3d3230-b7c4-40c3-b2f6-8ef9d9894465">

  </details> 

<details>
  <summary>  고객별 환전 요청 그룹화 데이터 조회 </summary> 

  <img width="410" alt="고객별 환전 요청 그룹화 데이터 조회 2024-11-29 오후 2 54 34" src="https://github.com/user-attachments/assets/6d35f2b0-2a55-4951-9782-7cbb4f39d1f9">

  </details> 

<details>
  <summary>  고객의 환전 요청 상태 변경 </summary> 

  <img width="520" alt="고객의 환전 요청 상태 변경 2024-11-29 오후 2 54 40" src="https://github.com/user-attachments/assets/bfc0e8ef-25e8-4a32-ad6b-135ba660558f">

  </details> 

<details>
  <summary>  고객의 환전 요청 삭제 </summary> 

  <img width="364" alt="고객의 환전 요청 삭제 2024-11-29 오후 2 54 48" src="https://github.com/user-attachments/assets/9141da8f-cd19-4b47-8f3a-803465444b92">

  </details> 


------------

## ERD 📁

### Lv 0. ERD   `필수`   
 - [X]  **ERD 작성하기**
    - [X]  ERD는 프로젝트 root(최상위) 경로의 `README.md` 에 첨부

<img width="1257" alt="스크린샷 2024-11-29 오후 3 19 33" src="https://github.com/user-attachments/assets/8e1e016f-67dd-4df1-a726-0c9d0e4f4b0d">

     
---------------
## 기능 구현 🖥
### 개발 전, 공통 조건

- 모든 테이블은 고유 식별자(ID)를 가진다.
- `3 Layer Architecture` 에 따라 각 Layer의 목적에 맞게 개발
- CRUD 필수 기능은 모두 데이터베이스 연결 및 `JPA`를 사용해서 개발
- 생성, 수정일자는 `JPA Auditing` 을 통해 관리
- 주어진 코드에 필요한 기능이 있다면 필수 기능에 없더라도 개발해서 사용
- `Currency` 테이블은 달러에 대한 데이터를 가지고 진행
    - 환율 데이터 설정은 현재 기준을 참고
 
- User
    
    | 컬럼명 | 설명 | 예시 |
    | --- | --- | --- |
    | id | 고객 고유 식별자 | 1 |
    | email | 고객 이메일 | test@naver.com |
    | name | 고객 이름 | park |
    | created_at | 생성일자 | 2024-11-18 16:42:03.000000 |
    | modified_at | 수정일자 | 2024-11-18 16:42:03.000000 |
    
- Currency
  
    | 컬럼명 | 설명 | 예시 |
    | --- | --- | --- |
    | id | 통화 고유 식별자 | 1 |
    | exchange_rate | 환율 | 1430.00 |
    | currency_name | 통화 이름 | USD |
    | symbol | 표시 | $ |
    | created_at | 생성일자 | 2024-11-18 16:42:03.000000 |
    | modified_at | 수정일자 | 2024-11-18 16:42:03.000000 |  

  
    | 컬럼명 | 설명 | 예시 |
    | --- | --- | --- |
    | id | 환전 요청 고유 식별자 | 1 |
    | user_id | 고객 고유 식별자 (User 테이블 ID) | 1 |
    | to_currency_id | 환전 대상 통화 식별자 (Currency 테이블 ID) | 1 |
    | amount_in_krw | 환전 전 금액 (원화 기준) | 10000 |
    | amount_after_exchange | 환전 후 금액 | 6.99 |
    | status | 상태 | normal |  
    | created_at | 생성 일자 | 2024-11-18 16:42:03.000000 |
    | modified_at | 수정 일자 | 2024-11-18 16:42:03.000000 |
     
### Lv 1. 고객(User)과 통화(Currency) 복잡한 연관 관계  `필수`

- [X]  환전 요청 중간 테이블 생성
    - [X]  필드: 고객 고유 식별자, 환전 대상 통화 식별자, 환전 전 금액, 환전 후 금액, 상태
- [X]  고객과 통화 테이블 간 연관관계
    - [X]  한 고객이 여러 통화로 환전할 수 있고 한 통화는 여러 고객들에 의해 환전될 수 있다.
    - [X]  `환전 요청 테이블`은 중간 테이블이고 `User`와 `Currency` 간 관계를 관리한다.

### Lv 2. 환전 요청 CRUD  `필수`

- [X]  C: 환전 요청 수행
    - [X]  환전 대상 통화 식별자가 Currency 테이블에 가지고 있는 환율을 기준으로 환전을 수행
    - [X]  환전 후 금액은 환전 전 금액을 환율로 나눈 결과
    - [X]  `환전 후 금액` 계산식 : 환전 후 금액 = 환전 전 금액 / 환율`
     
     #### 예시
     #### 환전 전 금액이 10,000원이고, 환율이 900원/1달러인 경우

     #### 환전 후 금액: 10,000원 / 900원 = 11.11

- [X]  `환전 후 금액`에 대해 소수점 두번째 반올림 수행
- [X]  R: `고객 고유 식별자`를 기반으로 특정 고객이 수행한 환전 요청 조회
    - [X]  조건
        - [X]  `고객 고유 식별자`: 환전 요청 테이블에 있는 User ID
- [X]  U: 특정 환전 요청 상태를 취소로 변경
    - [X]  상태 값은 `normal`, `cancelled`
- [X]  D: 고객이 삭제될 때 해당 고객이 수행한 모든 환전 요청도 삭제
    - [X]  키워드
        - [X]  `영속성 전이`, `cascade`
              
### Lv 3. 예외 처리  `필수`

- 모든 상황에 대해 유효성 검사와 예외 처리를 구현하지 않아도 됩니다. 핵심적으로 중요하다고 생각하는 1~2가지 항목에 대해 수행하면 충분합니다.
- [X]  **유효성 검사 추가**: 입력 값에 대한 유효성 검사를 추가하여 정책에 맞는 데이터만 취합
    - [X]  `3-Layered Architecture` 에서 유효성 검사가 어떤 계층의 책임인지 고민해보세요!
    - [X]  이메일, 일자 데이터, 길이 등
    - [X]  키워드
        - [X]  `Validation`
- [X]  **예외 처리 강화**: 적절한 예외 처리 로직을 추가하여 오류 발생 시 사용자에게 명확한 피드백 제공
    - [X]  API 예외처리
        - [X]  키워드
            - [X]  `GlobalExceptionHandler`
    - [X]  단순히 400, 500 에러코드만 보내지 않고 더 많은 정보를 포함하여 에러 메세지를 전달
        - [X]  아래는 예시 형식입니다.
          {
              "errorCode": "ERR001",
              "errorMessage": "요청값의 형식이 맞지 않습니다."
          }
        - [X]  요청값의 형식이 맞지 않습니다.
        - [X]  네트워크 요청에 실패했습니다. 다시 시도해주시기 바랍니다.
        - [X]  코드 형태를 고민해봐도 좋겠습니다.

### Lv 4. PostConstruct 적용  `도전`

- [X]  조건
    - [X]  스프링이 구동될 때 통화 테이블에 있는 환율이 0이거나 음수이거나 지정된 범위를 벗어나는 경우
- [X]  유효하지 않은 값으로 간주하고 로그를 기록하세요.
- [X]  키워드
    - [X]  `@Component`, `@Slf4j`
    
### Lv 5. JPQL  `도전`

- [X]  고객의 모든 환전 요청을 그룹화하여 조회
- [X]  반환해야하는 컬럼
    - [X]  해당 고객이 수행한 환전 요청 데이터들의 총 row 수
    - [X]  해당 고객이 환전을 요청한 총 금액
    - [X]  예시
          [
              {
                  "count": 3,
                  "totalAmountInKrw": 50000.00
              }
          ]

- [X]  키워드
    - [X]  `@Query`, `Group By`, `SUM`, `COUNT`

------------
## 트러블 슈팅 🎯
[고객 환전 서비스_트러블 슈팅.TIL](https://sooyeoneo.tistory.com)
