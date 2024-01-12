package practice05_Bakery;

public class Customer {
  
  // field
  private int money;
  private int count;
  
  // constructor
  public Customer() {
   
  }

  public Customer(int money, int count) {
    super();
    this.money = money;
    this.count = count;
  }

  // method
  public int getMoney() {
    return money;
  }
  public void setMoney(int money) {
    this.money = money;
  }
  public int getCount() {
    return count;
  }
  public void setCount(int count) {
    this.count = count;
  }
  
  // 구매
  // 인자 : 구매할 가게, 구매할 빵 개수, 구매할 때 낼 돈
  // 반환 : 없음 (구매가 끝나고 주는게 없음)
  
  public void buy (Bakery bakery, int count, int money) {
    
    // 가진 돈이 부족하다
    if(this.money < money) {
      System.out.println("가진 돈이 부족합니다.");
      return;
    }
    
    // 구매 ( 곧 bakery 의 판매를 의미한다.) -> bakery 가 null 인 경우
    BreadChange breadChange = null;
    if( bakery != null ) {
      breadChange = bakery.sell(money, count);
    }
    
    // 구매 결과 처리 -> 판매를 실패하는 경우 breadChange는 null 값이다.
    if(breadChange != null) {
      count += breadChange.getBread();  // this.count += breadChange.getBread();으로 교체하면 다시 3500이 됨 
      money += breadChange.getChange(); // this.money += breadChange.getChange();으로 교체하면 다시 3500이 됨 
      this.money -= money;
    }
  }
}
