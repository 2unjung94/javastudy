package pkg07_constructor;

// field -> constructor -> method 순으로 작성
public class Computer {
  
  // field
  String model;
  int price;
  Calculator calculator;
  
  // constructor : 필드 초기화를 위해 직접 작성
  // 생성자 오버로딩 : 생성자를 여러개를 만든다.
  Computer(){
    System.out.println("Computer()");
  }
  Computer(String _model, int _price){
    model = _model;
    price = _price;
  }
  Computer(String _model, int _price, Calculator _calculator){
    model = _model;
    price = _price;
    calculator = _calculator;
  }
  
  // method
  void develop() {
    System.out.println(model + " 이용해서 개발중");
  }
  
  void danggeun() {
    System.out.println(price / 100 * 60 + "원에 쿨거래");
  }

}
