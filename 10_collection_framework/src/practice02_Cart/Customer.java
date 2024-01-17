package practice02_Cart;

public class Customer {
  
  // field
  private int money;
  private Cart cart;
  
   // constructor
  public Customer() {

  }
  public Customer(int money) {
    super();
    this.money = money;
  }
  
  // method
  public int getMoney() {
    return money;
  }
  public void setMoney(int money) {
    this.money = money;
  }
  public Cart getCart() {
    return cart;
  }
  public void setCart(Cart cart) {
    this.cart = cart;
  }
  
  // 물건 넣기
  public void addToCart(Product prodoct) {
    cart.addProduct(prodoct);
  }
  
  // 물건 바꾸기
  public void changeCart(int idx, Product product) {
    cart.changeProduct(idx, product);
  }
  
  // 물건 빼기
  public void removeCart(int idx) {
    cart.removeProduct(idx);
  }
  
  // 구매
  // 반환 : 영수증 (String)
  public String buy() {
    
    String receipt = "영수증\n";
    int total = 0;
    /*
     * cart.getCount()는 변하지 않는 값인데 메소드 호출이 자주 있어서 조건문에 넣으면 조건문이 실행 될 때마다 호출됨.
     * 따라서 초기화 부분에 변수로 지정하고 조건문에는 변수가 호출 될 수 있게 만들어라.
     */
    for(int i = 0, count = cart.getProducts().size(); i < count ; i++) {    
      
      // cart 에서 뺀 물건
      Product product = cart.getProducts().get(i);
      total += product.getPrice();
      
      // 구매 가능 여부 체크
      if(money < total) {
        System.out.println("돈이 부족합니다.");
        return null;
      }
      
      // 영수증 만들기
      receipt += product.getName();
      receipt += "......";
      receipt += product.getPrice();
      receipt += "\n";
    }
    
    // 구매
    money -= total;
    
    // 영수증 만들기 추가 
    receipt += "총 구매액........" + total + "\n";
    
    return receipt;
  }

}
