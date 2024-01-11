package practice04_Car;

public class Car {
  
  // field
  private Driver driver;
  private int currSpeed;
  private int fuel;
  public final static int MAX_SPEED = 100; // final 과 static 작성 순서는 상관없다
  
  // constructor
  public Car() {
   
  }
  public Car(Driver driver, int currSpeed, int fuel) { 
    super();
    this.driver = driver;
    this.currSpeed = currSpeed;
    this.fuel = fuel;                        // max_Speed 는 빠져 있다
  }
  
  // method
  // static 호출은 !!! 클래스명.스태틱필드 !!! -> getter 못써요!!!
  public Driver getDriver() {
    return driver;
  }
  public void setDriver(Driver driver) {
    this.driver = driver;
  }
  public int getCurrSpeed() {
    return currSpeed;
  }
  public void setCurrSpeed(int currSpeed) {
    this.currSpeed = currSpeed;
  }
  public int getFuel() {
    return fuel;
  }
  public void setFuel(int fuel) {
    this.fuel = fuel;
  }
  
  public void enginStart() {
    if(driver == null || fuel == 0) {
      System.out.println("시동 실패");
    }else {
      System.out.println("시동 성공");
    }
  }
  
  // 1초당 n씩 속도가 증가하는 accelerator.(n = bestDriver는 10, 아니면 5)
  // 1초당 1씩 연료가 줄어드는 accelerator.
  public void accelerator(int pushTime) {
    if(currSpeed == MAX_SPEED) {
      System.out.println("이미 최고 속도입니다.");
      return;
    }
    
    if(fuel == 0) {
      System.out.println("연료가 없습니다.");
      return;
    }
    
    if(pushTime <= 0) {
      System.out.println("accelerator 를 잘 밟으세요");
      return;
    }
    
    /*int n = 0;
    if(driver.isBestDriver() == true) {
      n = 10;
    } else n = 5;*/
    
    int n = driver.isBestDriver() ? 10 : 5; // isBestDriver() 가 true 이면 10, false 면 5
    
    currSpeed += (pushTime * n);
    currSpeed = Math.min(currSpeed, MAX_SPEED); // currSpeed와 MAX_SPEED 중 작은 값을 쓰겠다.
    
    fuel -= pushTime;
    fuel = Math.max(fuel, 0); // 음수가 나오면 안되니까
    
    System.out.println("현재 연료량 : " + fuel + " , 현재 속도 : " + currSpeed );
    
  }
  
  // 1초당 10씩 속도가 줄어드는 brake
  
  public void brake(int pushTime) {
    if(currSpeed == 0) {
      System.out.println("이미 멈춰 있습니다.");
      return;
    }
    if(pushTime <= 0) {
      System.out.println("brake 를 잘 밟으세요");
      return;
    }
    
    currSpeed -= (pushTime * 10);
    currSpeed = Math.max(currSpeed, 0);
    
    System.out.println("현재 연료량 : " + fuel + " , 현재 속도 : " + currSpeed );
    
  }
}
