# AES
## 대충 배경지식
- http://www.secmem.org/blog/2019/02/06/block-cipher/
### block cipher encryption?
- 평문을 블록 단위로 암호화하는 대칭키 암호화 방식을 말한다.
- 그럼 대칭키 암호화 방식은?
  - 암호화와 복호화를 할 때 모두 하나의 키를 사용한다는 것.
- 대칭키 암호화 방식의 반대는?
  - 공개키 암호화 방식으로 암호화 할 때와 복호화 할 때의 키가 다름.
- 대표적인 블록 암호화 방식
  - DES
    - 블록의 크기가 64비트
  - AES
    - 블록의 크기가 128, 192, 256비트.
### padding이란?
- 주어진 평문을 블록 크기의 배수로 만듭니다.
- PKCS5 padding 알고리즘이란?

### 평문을 암호화하는 방식
- CBC
  - 현재 블록을 암호화할 때 이전 블록의 암호화 결과를 XOR한 후에 암호화하는 방법
- IV
  - Initialization Vector의 약자
  - CBC방식에서 동일한 평문을 동일한 키에서 암호화하더라도 매번 다른 결과를 내도록 하기 위해 사용하는 것으로서, 특히 CBC에서는 첫번째 블록을 XOR하는 용도로 사용한다.