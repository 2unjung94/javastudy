package pkg02_two;

public class MainClass {
  public static void method1() {
    
    /*
     * 2차원 배열
     * 1. 1차원 배열이 여러 개 모인 자료 구조이다.
     * 2. 1차원 배열 여러 개를 같은 이름으로 관리한다.
     * 3. 행과 열의 집합체인 테이블 구조로 이해를 하면 된다.
     * 4. 사용하는 인덱스가 2개(행, 열). 반복문도 2개 사용 -> for문의 중첩이 기본으로 사용됨
     */
    
    /*
     * 2차원 배열의 선언과 생성
     * 1. 선언
     *    1) int[][] 배열이름 - 사용할 것
     *    2) int 배열이름[][]
     * 2. 생성
     *    1) new int[m][n]  - 길이가 n인 1차원 배열이 m개 있는 배열(고정형 배열 생성 방법) 
     *    2) new int[m][]   - 길이가 ?인 1차원 배열이 m개 있는 배열(?는 나중에 결정함)
     *    ex) 각 행의 길이가 다를 수 있음.
     *                 
     *    ** new int[][n] 이건 불가함 **
     */
    
    // 배열 선언
    int[][] arr;
    
    // 배열 생성
    arr = new int [2][3];   //길이가 3인 1차원 배열이 2개 생긴다.
    
    // 배열 요소(배열이름 + 대괄호 2개 + 인덱스 2개)
    
    // 1번째 1차원 배열의 요소 3개
    System.out.println(arr[0][0]); // arr[0] : 첫번째 배열의 이름이라고 생각. 배열[인덱스]는 1차원 배열. 따라서 (arr[0])의 첫번째 값은 (arr[0])[0]
    System.out.println(arr[0][1]);
    System.out.println(arr[0][2]);
    
    // 2번째 1차원 배열의 요소 3개
    System.out.println(arr[1][0]);
    System.out.println(arr[1][1]);
    System.out.println(arr[1][2]);
    
    /*
     *  메모리에는 9개의 공간이 있음
     *  stack : arr  0x100
     *  
     *          arr[0] 0x200   주소 : 0x100
     *          arr[1] 0x300
     *          
     *  heap  : arr[0][0]  주소 : 0x200
     *          arr[0][1]
     *          arr[0][2]
     *          
     *          arr[1][0]  주소 : 0x300
     *          arr[1][1]
     *          arr[1][2]
     */
    
    
    
  }
  
  public static void method2() {
    
    // 2차원 배열의 선언 및 생성
    int [][] arr = new int[2][3];
    
    // 1번째 1차원 배열
    System.out.println(arr[0]);             // 참조값
    System.out.println(arr[0].length);      // 3
    
    // 2번째 1차원 배열
    System.out.println(arr[1]);             // 참조값
    System.out.println(arr[1].length);      // 3
  }
  
  public static void method3() {
    
    // 선언 및 생성
    int[][] arr = new int[2][3];
    
    // 1번째 1차원 배열 출력
    for(int j = 0 ; j < arr[0].length; j++) {
      System.out.println(arr[0][j]);
    }
    
    
    // 2번째 1차원 배열 출력
    for(int j = 0 ; j < arr[1].length; j++) {
      System.out.println(arr[1][j]);
    }
    
    
    // 위의 for 2개 합치기
    for(int i = 0 ; i< arr.length; i++) {
      for(int j= 0 ; j < arr[i].length; j++) {
        System.out.println(arr[i][j]);
      }
    }
    
    //2차원으로 출력
    for(int i = 0 ; i< arr.length; i++) {
      for(int j= 0 ; j < arr[i].length; j++) {
        //System.out.printf("%3d", arr[i][j]);               // %3d : 출력할 때 고정폭 3개 준비하고 정수값을 출력하라
        System.out.print(String.format("%3d", arr[i][j]));
      }
      System.out.println();
    }
  }
  
  public static void method4() {
    
    // 2차원 배열 초기화
    // 초기화 방법은 1차원 배열 형식과 같다. 중괄호 부분은 다름
    int[][] arr = new int[][] {
      {10, 20, 30},
      {40, 50, 60},
    };
    
    // 2차원으로 출력
    for(int i = 0 ; i < arr.length; i++) {
      for(int j = 0 ; j < arr[i].length; j++) {
        System.out.print(String.format("%3d", arr[i][j]));
      }
      System.out.println();
    }
    
  }
 
  public static void main(String[] args) {

    method4();
    
    

 
  }

}
