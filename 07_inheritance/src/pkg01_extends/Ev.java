package pkg01_extends;

// 자식클래스 만들기 : class 자식 extends 부모 { }
// 다중상속이 안된다.(자식은 부모가 1개다)
// Ev의 사용할 수 있는 메소드는 4개

// 부모 클래스 : 여러 개의 클래스들이 공통으로 갖고 있는 메소드를 모아둔 것.
// class 자식 extends 부모 { }
// class 서브 extends 슈퍼 { }



public class Ev extends Car{

  public void charge() {
    // System.out.println(model);     // 부모의 private 에는 접근 불가
    System.out.println(maker);        // 부모의 protected 에는 접근 가능
    System.out.println("충전");
  }
  
}
