package practice04_Car;

public class Driver {

  // field
  private String name;
  private int career;
  private boolean bestDriver; // career 가 10 이상이면 true
  
  // constructor
  public Driver() {
    
  }
  public Driver(String name, int career) {    // 10년 이상이면 best driver 인데 잘못된 데이터를 넣을 수 있음. 매개변수를 못받게 하기 위해 지움
    super();
    this.name = name;
    this.career = career;
    this.bestDriver = career >= 10;         // best driver 조건 추가
  }
  
  // method
  public String getName() {
    return name;
  }
  public void setName(String name) {
    this.name = name;
  }
  public int getCareer() {
    return career;
  }
  public void setCareer(int career) {
    this.career = career;
    this.setBestDriver(career >= 10);   // career 를 전달하면 best driver 여부를 저장한다.
  }
  public boolean isBestDriver() {
    return bestDriver;
  }
  private void setBestDriver(boolean bestDriver) {      // driver.setBestDriver(false); 메인에서 호출 못하게 하기 -> setBestDriver를 private 으로 바꾸기
    this.bestDriver = bestDriver;
  }
  
}
