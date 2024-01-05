package pkg02_loop;

public class Class01_while {

  public static void main(String[] args) {
    
    /*
     * while (조건을 중요시할 때)
     * 1. 조건식을 만족하면 반복해서 실행한다.
     * 2. 형식
     *    while(조건식){
     *      실행문 // 실행문이 끝나면 조건식이 유효한지 검사하고 또 실행. 조건식이 유효하지 않을 때까지 실행.
     *    }
     * - db에서 가지고 온 목록들 while로 하나씩 꺼내는 루프를 돌릴 때 사용.
     * - 끝이 언제인지 모를때 사용
     */
    
    // 1, 2, 3, 4, 5 출력하기
    
    int n = 1;          // 초기값 
    
    while(n <= 5) {     // 반복 조건
      System.out.println(n);
      n++;              // 상태 변환. 안하면 무한루프 빠짐     
    }
    
    // 1 ~ 5 모두 더하기
    n = 1;
    int total = 0;      // 초기화를 안하면 메모리 안에 쓰레기값이 있기 때문에 사용 불가다. 꼭 초기화 할 것
    
    while(n <= 5) {
      total += n;       // total에 n 값을 더한다.
      n++;              // n값 증가
    }
    System.out.println(total);

  }

}
