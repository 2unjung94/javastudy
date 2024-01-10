package pkg08_this;

// Computer class 에서의 this 는 Computer 객체를 의미 
// 같은 class 에서의 객체는 this 이다.
public class Computer {

  String model;
  int price;
  
  // this()     : 생성자를 호출하는 것
  // this.멤버  : 멤버(필드, 메소드)를 호출하는 것 (기억할 것)
  Computer(){
    this(null, 0);   // Computer(null, 0) 생성자 호출
  }
  
  Computer(String model){
    this(model, 0);   // Computer(model, 0) 생성자 호출
  }
  
  Computer(String model, int price){      // 위 둘은 다 이걸 호출하므로 객체 생성은 얘가 담당함. -> 소스코드의 유지보수가 쉬워짐.
    this.model = model;                   // 매개변수 이름 바꿀 필요 없이 this.필드 사용해라~
    this.price = price;
  }
  
  void showThis() {
    System.out.println(this);   // this : 현재 객체(showThis() 메소드를 호출한 객체)를 의미한다.
  }
  
  void showModel() {
    System.out.println(this.model);
  }
  
}
