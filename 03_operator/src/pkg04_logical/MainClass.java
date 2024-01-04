package pkg04_logical;

public class MainClass {

  public static void main(String[] args) {

    /*
     * 논리 연산
     * 1. boolean 타입의 값을 이용한 연산이다.
     * 2. 종류
     *    1) A && B : 논리 AND, A와 B가 모두 true이면 true 나머지 경우는 false 반환 
     *    2) A || B : 논리  OR, A 또는 B가 true이면 true 나머지 경우는 false 반환
     *    3) ! A    : 논리 NOT, 전달된 항이 true 이면 false 반환 (반대 값을 반환)
     */
    
    /*
     * 숏 서킷
     * 1. 연산 결과의 빠른 처리를 위한 동작이다.
     * 2. 종류
     *    1) && : false 가 반환되면 최종 결과도 false 이므로 더 이상 동작하지 않는다.
     *    2) || : true 가 반환되면 최종 결과도 true 이므로 더 이상 동작하지 않는다.
     */
    
    int n1 = 10;
    int n2 = 20;
   
    boolean a = n1 == 10 && n2 == 20;     
    boolean b = n1 == 10 && n2 == 10;    
    boolean c = n1 == 20 && ++n2 == 20; // 숏 서킷에 의해서 ++n2 == 20은 실행되지 않는다. (이미 false가 나왔으므로)
    System.out.println(n2);             // 따라서 결과는 20 출력
    
    boolean d = n1 == 20 && n2++ == 10; // 숏 서킷에 의해서 n2++ == 20은 실행되지 않는다. (이미 false가 나왔으므로)
    System.out.println(n2);             // 따라서 결과는 20 출력  
    
    System.out.println(a); // true
    System.out.println(b); // false
    System.out.println(c); // false
    System.out.println(d); // false
    
    boolean f = n1 == 10 || n2++ == 20; // 숏 서킷에 의해서 n2++ == 20은 실행되지 않는다.(이미 true가 나왔으므로)
    boolean g = n1 == 10 || ++n2 == 10; // 숏 서킷에 의해서 n2++ == 20은 실행되지 않는다.(이미 true가 나왔으므로)
    
    System.out.println(f);
    System.out.println(g);
    
    boolean h = !(n1 == 10);  //false
    System.out.println(h);
    
  }

}
