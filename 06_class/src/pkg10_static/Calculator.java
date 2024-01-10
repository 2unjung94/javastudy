package pkg10_static;

/*
 * 메모리 공간 할당 과정
 * 
 * 클래스 영역(메소드 영역) -> 스택 영역 -> 힙 영역
 * 클래스 로드                 변수         배열, 인스턴스(객체)
 * static 생성시점은 여기
 */

/*
 * 클래스 멤버
 * 1. 클래스 영역에 저장되는 멤버이다.
 * 2. 인스턴스의 생성이 없어도 접근이 가능하다.
 * 3. 클래스 메소드(static 처리 메소드)에서는 클래스 멤버만 호출할 수 있다. (***기억할것)
 *    (인스턴스 멤버는 호출할 수 없다. -> 클래스 메소드가 생성되었을 때는 인스턴스 멤버는 메모리에 존재하지 않기 때문)
 * 4. 호출 방법 
 *    1) 클래스.멤버   - 추천 (**기억할것)
 *    2) 인스턴스.멤버 - 가능하지만 비추천 (인스턴스로 클래스 멤버로 호출 가능)
 */

// instance = object = 객체
// instance : 메모리에 할당받은 객체. object 는 더 큰 의미의 객체
// instance member : 인스턴스마다 값이 다른 애들..(ex. Computer 클래스에서 model, price)
// class member : instance(object) = 1 : m
// static -> class member 만들 때 사용
// static 은 객체를 안만들어도 되고, class 를 이용해서 필드, 메소드 호출 : class.field, class.method()
// static 으로 지정된 멤버(클래스멤버)는 모든 인스턴스 멤버가 하나의 저장 공간을 공유하기에 항상 같은 값을 가짐

public class Calculator {
  
  // 상수
  public final static String maker = "samsung";   // static 변수는 다른 클래스들과 공유하는 변수이기 때문에 final 추가함. (public final static) 세트로 잘 묶임
  
  // 클래스 메소드
  // 접근제어자 + static + 변환형 + 메소드이름순으로 작성
  public static void add(int a, int b) {
    
    System.out.println(a + " + " + b + " = " + (a + b));
  }
  

}
