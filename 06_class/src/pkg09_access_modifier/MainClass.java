package pkg09_access_modifier;

public class MainClass {

  // method : public 사용
  // field : private 사용
  // 거의 public, private 주로 사용함
  public static void main(String[] args) {

    // Computer 객체 선언 및 생성
    // 생성가능 (왜? Computer 클래스에서 생성자는 public 으로 되어있기 때문)
    Computer computer = new Computer("thinkbook", 100, new Calculator());
    
    // System.out.println(computer.model); model 은 private 으로 생성되었기 때문에 직접 접근 불가
    // computer.develop(); -> 메소드를 통해서 field 간접 접근 가능(메소드는 public, 필드는 private)
    
    computer.setModel("gram");
    computer.setPrice(200);
    computer.setCalculator(new Calculator());
    
    System.out.println(computer.getModel());
    System.out.println(computer.getPrice());
    computer.getCalculator().add();
    computer.getCalculator().add(1);
    computer.getCalculator().add(2,3);
    computer.getCalculator().add();
    
  }

}
