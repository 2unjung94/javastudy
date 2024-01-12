package pkg04_override;

// 메소드 오버라이드
// 1. 자식 클래스가 부모 클래스의 메소드를 다시 만드는 것이다.
// 2. 부모의 메소드를 자식이 가져다 쓰는게 맞지 않는 경우 사용한다.
// 3. 메소드 앞에 @Override annotation 을 추가한다. (추가를 안하면 동작에 문제는 없지만, 추가하면 JVM이 문법 체크를 해 준다.) 추가 해야 하는 것으로 인지해라.
// 4. 부모 메소드와 똑같이(반환타입, 메소드 이름, 매개변수) 만들어야 한다.
// 5. 자동화 가능 [Source] -> [Override/Implements Method...]

// ** 메소드 오버로딩 vs 메소드 오버라이딩 비교하는 게 기술면접 질문중 하나임

public class WhiteMix extends Kanu {

  @Override     // 오버라이드한 메소드라고 JVM에게 알려준다. (부가적으로 다른 개발자에게도 알려준다.)
  public void color(){
    System.out.println("커피색");
  }
  
}
