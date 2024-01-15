package pkg03_interface_extends;

public class MainClass {

  public static void main(String[] args) {

    Elec elec = new SmartPhone();
    elec.powerOn();
    System.out.println("(SmartPhone)elec");
    ((SmartPhone)elec).call();
    ((SmartPhone)elec).game();
    ((SmartPhone)elec).powerOn();
    
    System.out.println();
    
    Computer computer = new SmartPhone();
    computer.powerOn();
    computer.game();
    System.out.println("(SmartPhone)computer");
    ((SmartPhone)computer).call();
    ((SmartPhone)computer).game();
    ((SmartPhone)computer).powerOn();
    
    System.out.println();
    
    Phone phone = new SmartPhone();
    phone.call();
    System.out.println("(SmartPhone)phone");
    ((SmartPhone)phone).call();
    ((SmartPhone)phone).game();
    ((SmartPhone)phone).powerOn();
    
    System.out.println();
    
    SmartPhone smartPhone = new SmartPhone();
    smartPhone.powerOn();
    smartPhone.game();
    smartPhone.call();
    
    
  }

}

/*
 * ** 인터페이스 구현으로 짜면 인터페이스 타입으로 선언하여 사용하거라 **
 * interface A {
 *  void aa(); 
 *  void bb();
 *  }
 *  
 * class B implements A {
 *  void aa() { };
 *  void bb() { };
 *  void cc() { };
 *  }
 *  
 *  A a = new B();
 *  a.aa();
 *  a.bb();
 *  a.cc(); => 실행안됨
 *  
 *  ((B)a).cc();  => 실행됨
 */