package practice06_Cart;

public class MainClass {

  public static void main(String[] args) {

    // 10000원 가진 고객
    Customer customer = new Customer(40000);
    
    // 5개 물건 담을 수 있는 카트
    Cart cart = new Cart(6);
    
    
    // 고객이 카트가지기
    customer.setCart(cart);
    
    // 고객 쇼핑
    customer.addToCart(new Product("맛동산", 3000));
    customer.addToCart(new Product("양파링", 2000));
    customer.addToCart(new Product("홈런볼", 2000));
    customer.addToCart(new Product("마이쮸", 1000));
    customer.addToCart(new Product("오예스", 2000));
    customer.addToCart(new Product("포카칩", 1000));
    customer.addToCart(new Product("포카칩", 1000));
    
    
    // 구매하면 영수증이 반환됨
    String receipt = customer.buy();
    
    // 영수증 확인
    System.out.println(receipt);
    
    // 고객정보 확인
    System.out.println("고객이 가진 돈 : " + customer.getMoney() + "원");
    
    
  }

}
