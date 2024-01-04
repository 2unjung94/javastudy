package pkg06_practice;

public class MainClass {

  public static void method1() {
    // 산술 연산
    
    int second = 90;
    int m = second / 60 ; // 1   분
    int s = second % 60 ; // 30  초
    
    System.out.println(m);
    System.out.println(s);
  }
  
  public static void method2() {
    
    // x와 y의 값을 교환하기 (swap)
    
    int x = 10;
    int y = 20;
    int temp;
    
    temp = x;   // temp에 x 값을 넣는다.
    x = y;      // x에 y값을 넣는다.
    y = temp;   // y에 이전 x값을 옮겨 두었던 temp 값을 넣는다.
    
    
    System.out.println(x); // 20
    System.out.println(y); // 10
  }
  
  public static void method3() {
    // 점수가 90점대이면 true 아니면 false
    
    int score = 80;
    
    // 90점 이상 그리고 100점 미만
    boolean result1 = score >= 90 && score < 100;
    System.out.println(result1);
    
    // 10으로 나눈 몫이 9인 수
    boolean result2 = (score / 10) == 9;
    System.out.println(result2);
  }
  
  public static void method4() {
    // 짝수/홀수 판단
    // 짝수 : 2로 나눈 나머지가 0인 수
    // 홀수 : 2로 나눈 나머지가 1인 수
    
    int n = 0;
    String result1= "";
    String result2= "";
    
    result1 = ( n % 2 == 1 ) ? "홀수" : "짝수";
    System.out.println(result1);
    
    result2 = ( n % 2 == 0 ) ? "짝수" : "홀수";
    System.out.println(result2);
        
    
  }

  
  public static void main(String[] args) {
    method4();
    
  }
  

}
