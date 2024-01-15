package pkg03_interface_extends;

/*
 * 인터페이스 다중 구현
 * 1. 다중 상속은 불가능하지만, 다중 구현은 가능하다.
 * 2. implements 키워드 뒤에 구현할 인터페이스를 모두 명시한다. ,로 구분
 */

// 오버라이드 메소드 개수 = 3
public class SmartPhone implements Computer, Phone{

  @Override
  public void powerOn() {
    // TODO Auto-generated method stub
    System.out.println("powerOn()");
  }
  @Override
  public void call() {
    // TODO Auto-generated method stub
    System.out.println("call()");
  }
  @Override
  public void game() {
    // TODO Auto-generated method stub
    System.out.println("game()");
  }
}
