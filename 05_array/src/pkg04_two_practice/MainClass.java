package pkg04_two_practice;

public class MainClass {
  
  public static void method1() {
    
    // 구구단 결과를 2차원 배열에 저장하기
    int[][] arr = new int[8][9];
    
    /*
     * arr[0][0] <- 2 * 1
     * arr[0][1] <- 2 * 2
     * ...
     * arr[1][0] <- 3 * 1
     * arr[1][1] <- 3 * 2
     * ...
     * ------------------
     * arr[i][j] <- (i+2) * (j+1)
     */
    for(int i = 0; i < arr.length; i++) {
      for(int j = 0; j<arr[i].length; j++) {
        arr[i][j] = (i+2) * (j+1);
        System.out.print(String.format("%3d", arr[i][j]));
      }
      System.out.println();
    }
    
  }
 
  public static void method2() {
    
    // apt 출력하기
    // 1층 : 11명
    // 2층 : 10명
    // 3층 : 9명
    int[][] apt = new int[][] {
      {2, 3, 2, 4},
      {1, 1, 5, 3},
      {4, 2, 2, 1}
    };
    
    
    for(int i = 0; i < apt.length; i++) {
      int total = 0;

      for(int j = 0; j < apt[i].length; j++) {
        total += apt[i][j]; 
      }  
      System.out.println(i + 1 +"층 : "+ total + "명");
    }
    
  }

  public static void method3() {
    
    // 배열 t 시계 방향으로 90도 회전하기
    
    /*
     * 1 1 1 1 1          0 0 0 0 1
     * 0 0 1 0 0          0 0 0 0 1
     * 0 0 1 0 0   --->   1 1 1 1 1
     * 0 0 1 0 0          0 0 0 0 1
     * 0 0 1 0 0          0 0 0 0 1
     */
    
    /*
     * 90도 회전하기
     * 1. t 배열의 90도 회전 상태를 rotate 배열에 저장한다.
     * 2. t 배열이 참조하는 값을 rotate 배열로 바꾼다.
     * 
     * rotate[0][0] = t[4(5-1)][0]
     * rotate[0][1] = t[3(5-2)][0]
     * rotate[0][2] = t[2(5-3)][0]
     * rotate[0][3] = t[1(5-4)][0]
     * rotate[0][4] = t[0(5-5)][0]
     *          j=0
     * rotate[0][4] = t[0][0]
     * rotate[1][0] = t[4][1]
     * 
     * rotate[i][j] = t[t.length-(j+1)][i]
     */
    
    int[][] t = {
        {1, 1, 1, 1, 1},
        {0, 0, 1, 0, 0},
        {0, 0, 1, 0, 0},
        {0, 0, 1, 0, 0},
        {0, 0, 1, 0, 0}
    };
    
    /*int[][] rotate = new int[][] {
      {t[4][0], t[3][0], t[2][0], t[1][0], t[0][0]},
      {t[4][1], t[3][1], t[2][1], t[1][1], t[0][1]},
      {t[4][2], t[3][2], t[2][2], t[1][2], t[0][2]},
      {t[4][3], t[3][3], t[2][3], t[1][3], t[0][3]},
      {t[4][4], t[3][4], t[2][4], t[1][4], t[0][4]}
      
      
  };*/
    
    int[][] rotate = new int[5][5];
    
    // 내가 푼 것
    /*for(int i = 0 ; i < t.length ; i++) {
      for(int j = 0; j < t[i].length; j++) {
        rotate[i][j] = t[t.length - (j+1)][i];
      }
    };
    for(int i = 0; i< t.length; i++) {
      for(int j = 0; j< t.length; j++ ) {
        System.out.print(String.format("%2d", rotate[i][j]));
      }
      System.out.println();
    }
    
    t = rotate;
    
    System.out.println();*/
    
    
    // 선생님 풀이
    // [i][j] -> [j][4-i]
    for(int i = 0; i < t.length; i++) {
      for(int j = 0; j < t[i].length; j++) {
        rotate[j][4-i] = t[i][j];
      }
    }
    t = rotate;
    
    for(int i = 0; i< t.length; i++) {
      for(int j = 0; j< t.length; j++ ) {
        System.out.print(String.format("%2d", rotate[i][j]));
      }
      System.out.println();
    }
   
    
  }
  
  public static void main(String[] args) {

    method3();
 
  }

}
