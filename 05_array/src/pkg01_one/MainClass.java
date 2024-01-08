package pkg01_one;

public class MainClass {
  
  public static void method1() {
    /*
     * 배열
     * 1. 변수 여러 개를 하나의 이름으로 관리하는 자료구조이다. 이걸 기억하렴
     * 2. 각 변수 구분을 위해서 인덱스를 활용한다.
     * 3. 구성
     *    1) 배열이름 : 모든 변수의 대표 이름
     *    2) 배열길이 : 변수의 개수
     *    3) 인덱스   : 변수를 구분하는 숫자(0부터 시작하는 정수값)
     *    4) 배열요소 : 각 변수를 의미(배열이름과 대괄호[]와 인덱스를 조합해서 사용)
     */
    
    /*
     * 배열의 선언과 생성
     * 1. 배열은 선언과 생성 과정이 모두 필요하다.
     * 2. 배열의 선언
     *    1) int[] 배열이름 - 추천 (타입만으로 일반 변수인지 배열인지 파악이 쉬움)
     *    2) int 배열이름[]
     * 3. 배열의 생성
     *    new int[배열길이]
     * 4. 배열이 생성되면 배열의 모든 요소는 자동으로 초기화된다. (변수는 자동초기화 없음)
     *    0, 0.0, false, null (정수, 실수, 논리, 참조일때 초기화 값) - 기억할 것.
     */
    
    // 배열 선언
    int[] arr;      // complie 시점에서 stack 에 참조값을 저장할 arr이란 변수 생성
    
    // 배열 생성
    arr = new int[3];     // runtime 시점에서 heap 에 3개의 변수들이 들어갈 메모리를 할당하고 그 주소값을 arr에 저장함
    
    // 배열요소(배열이름 + 대괄호 + 인덱스), 자동초기화 0, 인덱스는 0부터 시작
    System.out.println(arr[0]);     // 첫번째 변수
    System.out.println(arr[1]);     // 두번째 변수
    System.out.println(arr[2]);     // 세번째 변수
    
    //System.out.println(arr[3]);     // 배열 생성보다 큰 인덱스를 달라 하면 오류남
    
    
    
  }

  public static void method2() {
  
    /*
     * 배열 초기화
     * 1. 배열을 선언할 때 초기화 값들을 전달할 수 있다.
     * 2. 형식
     *    1) int[] 배열이름 = new int[]{값1, 값2, 값3, ... } //메소드에서 배열값을 사용할 때 사용
     *    2) int[] 배열이름 = {값1, 값2, 값3, ...}
     */
    
    // 배열 선언 및 초기화
    int[] arr = new int[] {10, 20, 30, 40, 50};
    
    // 배열 요소
    System.out.println(arr[0]);
    System.out.println(arr[1]);
    System.out.println(arr[2]);
    System.out.println(arr[3]);
    System.out.println(arr[4]);
    
    }
    
  public static void method3() {
    
    /*
     * 배열 길이
     * 1. 배열 요소의 개수를 의미한다.
     * 2. 배열이 생성된 이후에는 수정할 수 없다.
     * 3. 배열 길이 필드값
     *    배열이름.length
     */
    
    // 배열 선언 및 초기화
    int[] arr = {10, 20, 30, 40, 50};
    
    // 배열 길이 확인
    System.out.println(arr.length); // 메소드 : .메소드이름(), 필드 = .필드(값)
    
    // 배열과 for
    // for문에서 i <= arr.length - 1 같은 조건은 사용하지 말자
    for(int i = 0; i < arr.length; i++) { // for문 통으로 외우기
      System.out.println(arr[i]);
    }
   
    
  }
  
  public static void method4() {
    // stack  : 코드블록{}이 실행되면 생기고, 코드블록{}이 종료되면 사라짐
    // heap   : 코드블록과 상관 없이 개발자가 new 명령을 실행할 때 생기고 java가 없애고 싶을 때 사라짐
    
    /*
     * 배열의 길이를 늘이는 방법
     * 1. 새로운 배열을 만든다.
     * 2. 기존 배열 요소를 모두 옮긴다.
     * 3. 새로운 배열의 참조값을 가져온다.
     */
    
    int[] a = new int[] {10, 20, 30};
    
    // 1. 새로운 배열을 만들기
    int[] b = new int[10];
    
    // 2. 기존 배열 요소를 모두 옮긴다.
    for(int i = 0; i < a.length; i++) {
      b[i] = a[i];
    }
    
    // 3. 새로운 배열의 참조값을 가져온다.
    
    a = b;
    
    for(int i = 0; i < a.length ; i++) {
      System.out.println(a[i]); // 10, 20, 30, 0 0 0 0 0 0 0
    }
     
  }

  public static void method5() {
    
    // advanced for
    // for(변수 : 배열) {  }
    // 배열의 값을 바꿀때는 사용하지 못한다. 제약적으로 사용
    
    int[] arr = new int[] {10, 20, 30, 40, 50};
    
    // arr에 있는 값들을 하나씩 number에 옮기시오
    for(int number : arr) {
      System.out.println(number);
      
    }
    
  }
  
  public static void main(String[] args) {
    method5();
  }

}
