package pkg09_access_modifier;

// field -> constructor -> method 순으로 작성

// getter, setter 는 이름 규칙 꼭 지킬 것(라이브러리가 인식을 해야하기 때문)
/*
 * Getter
 * 1. 클래스의 필드값을 외부로 반환하는 메소드이다.(필드값을 가져오는 메소드)
 * 2. get + 필드명으로 메소드이름을 결정해야 한다. (boolean 타입은 is + 필드명)
 * 3. return 필드값은 이미 필드값으로 되어있어서 this.필드 라 할 필요 없다.
 */

/*
 * Setter
 * 1. 외부로부터 전달된 값을 필드에 저장하는 메소드이다.(값을 필드로 저장하는 메소드)
 * 2. set + 필드명으로 메소드이름을 결정해야 한다.
 */

public class Computer {
  
  // field
  private String model;
  private int price;
  private Calculator calculator;
  
  
  // eclipse Source -> generate constructor using field -> generate 하면 자동생성해줌
  public Computer(String model, int price, Calculator calculator) {
    
    this.model = model;
    this.price = price;
    this.calculator = calculator;
  }

  
  // eclipse Source -> generate getters and setters -> select all, generate 하면 자동생성해줌
  public String getModel() {
    return model;
  }

  public void setModel(String model) {
    this.model = model;
  }

  public int getPrice() {
    return price;
  }

  public void setPrice(int price) {
    this.price = price;
  }

  public Calculator getCalculator() {
    return calculator;
  }

  public void setCalculator(Calculator calculator) {
    this.calculator = calculator;
  }
  
  
  
  

}
