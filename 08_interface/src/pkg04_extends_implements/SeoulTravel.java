package pkg04_extends_implements;

/*
 * 클래스 상속과 인터페이스 구현을 동시에 처리하는 방법
 * 1. 먼저 클래스를 상속한다.
 * 2. 이후 인터페이스를 구현한다.
 *    ex) public class SeoulTravel (1.extends Domestic) (2.implements Travel)
 */



public class SeoulTravel extends Domestic implements Travel{

  @Override
  public void sightseeing() {
    System.out.println("남산");
  }

  @Override
  public void vehicle() {
    System.out.println("KTX");
  }
  
  
  
}
