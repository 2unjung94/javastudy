package practiice02_Cup;

public class Cup {
  
  private Coffee coffee;
  
  //setter를 fill로 구현했다
  public void fill(Coffee coffee) {
    this.coffee = coffee;
  }
  
  // 다형성
  public void whoami() {
    coffee.whoami();
  }
  

}
