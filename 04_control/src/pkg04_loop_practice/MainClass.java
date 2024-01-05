package pkg04_loop_practice;

public class MainClass {

  public static void method1() {

    // 100 ~ 1 출력하기
    
    for(int i = 100;  i > 1; i--) {
      System.out.println(i);
    }
    
    int num = 100;
    while(num > 0) {
      System.out.println(num);
      num--;
    }
  }
  
  public static void method2() {
    
    // 5 ~ 20 사이 모든 정수의 평균 
    // while ver.
    int n = 5;
    int total = 0;
    int count = 0;
    int avg = 0;
    
    while(n <= 20) {
      total += n;
      count++;
      n++;
    }
    
    // for ver.
    count = 0;
    total = 0;
    for(int i = 5; i <= 20; i++) {
      total += i;
      count++;
    }
    
    avg = total / count;
    System.out.println(avg);
    
    /*// 정수 개수 구하는 다른 방법
    int begin = 5;
    int end = 20;
    
    int n = begin;
    int total = 0;
    while(n <= end) {
      total += n;
      n++;
    }
    
    double avg = total/(end - begin + 1.0); // int 나누기 int 는 몫. 1을 1.0으로 바꿔주면 1.0의 도메인이 더 넓어져서 double로 자동으로 바뀜.
    System.out.println(avg);*/
    
    
  }
  
  public static void method3() {
    
    // 구구단 3단 출력하기
    int dan = 3;
    
    // for ver.
    for(int i = 1; i <= 9; i++) {
      System.out.println(dan + " x " + i + " = " + dan * i);
    } // + 를 연결 연산자로 쓰려면 반드시 String이 필요하다.
    
    // while ver.
    int n = 1;
    while(n < 10) {
      System.out.println(dan + " * " + n + " = " + dan * n);
      n++;
    }
    
    
  }
  
  public static void method4() {
    
    // 70원씩 모금하기
    // 목표는 100000원 이상
    
    // 1회 모금액 70원
    // 2회 모금액 140원
    // 3회 모금액 210원
    // ..
    // n회 모금액 100000원 이상 금액 -> 1429회 모금액 100030원
    
    int money = 70;           // 1회 당 70원
    int total = 0;            // 전체 모금액
    
    final int GOAL = 100_000; // 3자리마다 _ 은 천단위 구분 기호
    
    // for ver.
    /*for(int i = 1; ; i++) {
      total += money;
      System.out.println(i+"회 모금액 : "+total+"원");
      if(total > GOAL) break;
      
    }*/
    
    // while ver.
    int nth = 0;
    while(total < GOAL) {
      total += money;
      nth++;
      System.out.println(nth + "회 모금액 : " + total + "원");
    }
      
      
    }
  
  public static void method5() {
    
    // 2x1=2
    // 2x2=4
    // ...
    // 9x9=81
    // 고정값을 out for문, 바뀌는 값을 inner for문
    
    outer:    // 라벨 - 중첩을 손쉽게 없앰
    for(int dan = 2 ; dan <= 9 ; dan++) {
      for(int n = 1 ; n <= 9; n++) {
        System.out.println(dan + "x" + n + "=" + dan*n);
        if(dan == 5 && n ==5) {
          break outer;
        }
      }
    }
    
    
    // 내가 짠 것
    /*for(int i = 2 ; i <= 9 ; i++) {
      for(int j = 1 ; j <= 9; j++) {
        System.out.println(i + " x " + j + " = "+ i*j);
      }
    }*/
    
    
  }
  
  public static void method6() {
    // 2x1=2  3x1=3 ... 9x1=9
    // 2x2=4  3x2=6 ... 9x2=18
    
    for(int n = 1; n <= 9; n++) {
      for(int dan = 2; dan <=9; dan++) {
        System.out.print(dan + "x" + n + "=" + dan * n + "\t");
      }
      System.out.println(); // 줄 바꿈
    }
    
    
    // 내가 짠 것
    /*for(int a = 1 ; a <= 9 ; a++) {
      for(int b = 2; b <=9; b++) {
        System.out.print(b + " x " + a + " = "+ b*a + "\t");
      }
      System.out.print("\n");
    }*/
  }

  public static void method7() {

    /*
     * 삼각별 출력하기-1
     *        star=12345 
     * row=1       * 
     * row=2       ** 
     * row=3       *** 
     * row=4       **** 
     * row=5       *****
     * 
     * row=1, star=1~1 
     * row=2, star=1~2 
     * row=3, star=1~3 
     * row=4, star=1~4 
     * row=5, star=1~5
     * 
     * row=1~5, star=1~row
     */
    for(int row = 1; row <= 5 ; row++) {
      for(int star = 1 ; star <= row; star++) {
        System.out.print("*");
      }
      System.out.println();
    }
  }
    
  public static void method8() {
    
    /*
     * 삼각별 출력하기-2
     *        star=12345 
     * row=1       *****
     * row=2       ****
     * row=3       ***
     * row=4       **
     * row=5       *
     * 
     * row=1, star=1~5
     * row=2, star=1~4
     * row=3, star=1~3
     * row=4, star=1~2
     * row=5, star=1~1
     * 
     * row=1~5 star=1~6-row
     */
    for(int row = 1; row <= 5 ; row++) {
      for(int star = 1; star <= 6-row; star++) {
        System.out.print("*");
      }
      System.out.println();
    }
    
    
    
  }
  
  public static void method9() {
    
    /*
     * 삼각별 출력하기-3
     * space/star=123456789
     * row=1          *
     * row=2         ***
     * row=3        *****
     * row=4       *******
     * row=5      *********
     * 
     * row=1, space=1~4, star=5~5
     * row=2, space=1~3, star=4~6
     * row=3, space=1~2, star=3~7
     * row=4, space=1~1, star=2~8
     * row=5, space=1~0, star=1~9
     * 
     * row=1~5, space=1~5-row, star = 6-row ~ row+4
     */
    for(int row = 1; row <=5; row++) {
      for(int space = 1; space <= 5-row ; space++) {
        
        System.out.print(" ");
      }
      for(int star = 6-row ; star <= row+4; star++) {
        System.out.print("*");
      }
      System.out.println("");
    }
    
    
    
    

  }
  
  public static void method10() {
    
    /*
     * 삼각별 출력하기-4
     * space/star=123456789
     * row=1      *********
     * row=2       *******
     * row=3        *****
     * row=4         ***
     * row=5          *
     * 
     * row=1, space=1~0, star=1~9
     * row=2, space=1~1, star=2~8
     * row=3, space=1~2, star=3~7
     * row=4, space=1~3, star=4~6
     * row=5, space=1~4, star=5~5
     * 
     * row=1~5, space=1~row-1, star=row~10-row
     */
    for(int row = 1; row <= 5;  row++) {
      for(int space = 1; space <= row-1; space++) {
        System.out.print(" ");
      }
      for(int star = row; star <= 10-row; star++) {
        System.out.print("*");
      }
      System.out.println();
    }
    
    

  }  
  
  public static void main(String[] args) {
    method10();

  }

}
