package pkg02_generic_type;

public class MainClass {

  public static void main(String[] args) {

    // Integer 저장용 Container
    Container<Integer> container1 = new Container<Integer>();        // generic 타입은 기본 형식(int같은)은 <>에 들어갈 수 없다
    container1.setItem(10);                                          // setItem의 매개변수가 Integer 인거 확인
    System.out.println(container1.getItem());
    
    // String 저장용 Container
    Container<String> container2 = new Container<>();         // 생성자에서 <>안에는 생략 가능
    container2.setItem("hello");                              // setItem의 매개변수가 Integer 인거 확인
    System.out.println(container2.getItem());

  }

}
