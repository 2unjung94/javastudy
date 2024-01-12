package pkg07_polymorphism;

// Upcasting

public class Person {
 
  //powerOn의 매개변수로 new Tv(), new Radio()를 받고 싶을때 upcasting 사용
  
  public void powerOn(Elec elec) {  // Elec elec = new Tv() 또는 Elec elec = new Radio()
 
    /*
     * Elec 클래스는 powerOn()이라는 메소드가 없어서 실행 못하므로 다운캐스팅해서 사용
     * 
     * 1. 다운캐스팅으로 powerOn() 호출하기 -> 전자제품이 추가될 때 마다 코드의 추가가 필요하므로 추천하지 않는다.
     * 
     * if(elec instanceof Tv) {
     *  ((Tv) elec).powerOn();
     * } 
     * else if(elec instanceof Radio) {
     *  ((Radio) elec).powerOn();      
     * }
     */
   
    /*
     * 2. Elec 에 powerOn() 메소드를 추가하고 Tv나 Radio 가 오버라이드 하기
     *    -> 부모클래스 Elec에 powerOn()을 넣기
     */
    elec.powerOn();   // 다형성 : 하나의 코드로 여러가지 실행을 하는 의미
    
    
    /*
     * 다형성의 순서??
     * 1. 클래스들의 부모를 세울것
     * 2. 부모에 자식들의 메소드를 다 집어 넣을 것
     * 3. 자식들은 @Override 붙여서 다시 메소드 작성할 것.
     */
              
  }

}
