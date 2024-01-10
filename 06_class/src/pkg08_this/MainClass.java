package pkg08_this;

// 여기서의 this는 MainClass 객체를 의미.
public class MainClass {

  public static void main(String[] args) {

    Computer computer = new Computer(); // 이때 computer는 새로 만들어진 Computer객체의 참조값을 갖고 있음.
    
    System.out.println(computer);
    computer.showThis();              // showThis()를 호출한 객체 = computer 이므로 같은값이 출력된다.
    
    System.out.println(computer.model);
    computer.showModel();
   
    
    
  }

}
