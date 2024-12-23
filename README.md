# user-currency 💰
## 고객 환전 서비스 🧑🏻‍💻

------------
## API 명세서 📋
### Lv 0. API 명세 작성   `필수`
 - [X]  **API 명세서 작성하기**
    - [X]  API명세서는 프로젝트 com.example.usercurrency 경로의 `test.http` 에 작성

<details>
 <summary>  API 명세서 test.http </summary>

#### 고객 생성
<img width="333" alt="고객 생성 2024-11-29 오후 2 53 10" src="https://github.com/user-attachments/assets/f4086ac0-a700-4b94-b669-c3b2e22093f6">

#### 고객 전체 조회
<img width="333" alt="고객 전체 조회 2024-11-29 오후 2 53 25" src="https://github.com/user-attachments/assets/af9eb4c4-9f76-4881-ab7c-491015128d7e">

#### 선택 고객 조회
<img width="333" alt="선택 고객 조회 2024-11-29 오후 2 53 32" src="https://github.com/user-attachments/assets/8c449811-ce50-4024-81aa-547a9ee94d0c">

#### 선택 고객 삭제
<img width="333" alt="선택 고객 삭제 2024-11-29 오후 2 53 39" src="https://github.com/user-attachments/assets/64c5c80b-3d3e-4374-ab20-4aadcfa77350">

#### 통화 생성
<img width="333" alt="통화 생성 2024-11-29 오후 2 53 47" src="https://github.com/user-attachments/assets/d1ec9662-8e7b-459f-a342-1636d030a175">

#### 통화 전체 조회
<img width="333" alt="통화 전체 조회 2024-11-29 오후 2 53 56" src="https://github.com/user-attachments/assets/7940d692-e1a3-4da7-8ae3-6698487558f4">

#### 선택 통화 조회
<img width="333" alt="선택 통화 조회 2024-11-29 오후 2 54 03" src="https://github.com/user-attachments/assets/266312e0-b7ce-4875-9227-ce07fb906c96">

#### 환전 요청 생성
<img width="333" alt="환전 요청 생성 2024-11-29 오후 2 54 10" src="https://github.com/user-attachments/assets/c4e3be3d-be1f-4b83-9fdd-9b41c9d69204">

#### 고객의 환전 요청 조회
<img width="408" alt="고객의 환전 요청 조회 2024-11-29 오후 2 54 26" src="https://github.com/user-attachments/assets/c4ffa767-b9c1-406e-8748-64a05ca4c04a">

#### 고객별 환전 요청 그룹화 조회
<img width="410" alt="고객별 환전 요청 그룹화 데이터 조회 2024-11-29 오후 2 54 34" src="https://github.com/user-attachments/assets/d43368c5-1c69-43c0-a124-4a2bae36d3ac">

#### 고객의 환전 요청 상태 변경
<img width="520" alt="고객의 환전 요청 상태 변경 2024-11-29 오후 2 54 40" src="https://github.com/user-attachments/assets/014979fa-0f27-4e6c-8e2e-8fec8cd9fc7a">

#### 고객의 환전 요청 삭제
<img width="364" alt="고객의 환전 요청 삭제 2024-11-29 오후 2 54 48" src="https://github.com/user-attachments/assets/4bffa810-0615-4020-bedf-73a2b620afa9">


 </details>

    
     [POSTMAN](https://documenter.getpostman.com/view/39375040/2sAYBXBrBX)

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


- Exchange

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
        - [X]  아래는 예시 형식이다.
          {
              "errorCode": "ERR001",
              "errorMessage": "요청값의 형식이 맞지 않습니다."
          }
        - [X]  요청값의 형식이 맞지 않습니다.
        - [X]  네트워크 요청에 실패했습니다. 다시 시도해주시기 바랍니다.
        - [X]  코드 형태를 고민해봐도 좋겠습니다.

### Lv 4. PostConstruct 적용  `도전`

- [X]  조건
    - [X]  스프링이 구동될 때 통화 테이블에 있는 환율이 0이거나 음수이거나 지정된 범위를 벗어나는 경우
- [X]  유효하지 않은 값으로 간주하고 로그를 기록하세요.
- [X]  키워드
    - [X]  `@Component`, `@Slf4j`
    
### Lv 5. JPQL `도전`

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
[고객 환전 서비스_트러블 슈팅.TIL](https://sooyeoneo.tistory.com/80)
