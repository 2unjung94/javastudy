package practice04_Car;

public class MainClass {

  public static void main(String[] args) {

    //Driver driver = new Driver("elsa", 10, false); -> 10년 이상이면 best driver 인데 잘못된 데이터를 넣을 수 있음. 매개변수를 못받게 하기 위해 지움
    Driver driver1 = new Driver("elsa", 5);
    System.out.println(driver1.isBestDriver());
    
    Driver driver2 = new Driver();
    driver2.setName("anna");
    driver2.setCareer(20);
    System.out.println(driver2.isBestDriver());
    
    Car car1 = new Car(driver1, 0, 100);
    car1.enginStart();
    car1.accelerator(5);
    car1.brake(5);
    
  }

}
