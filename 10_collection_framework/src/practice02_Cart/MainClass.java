package practice02_Cart;

public class MainClass {

  // main 에서도 예외 회피 가능하다. 회피하면 최종적으로 JVM이 받아서 처리. 이건 개발자가 예외 처리를 안한것으로 본다.
  public static void main(String[] args) { 

    try {
      // 10000원 가진 고객
      Customer customer = new Customer(10000);
      
      // 10개 물건 담을 수 있는 카트
      Cart cart = new Cart(10);
      
      // 고객이 카트가지기
      customer.setCart(cart);
      
      // 고객 쇼핑
      customer.addToCart(new Product("맛동산", 3000));
      customer.addToCart(new Product("양파링", 2000));
      customer.addToCart(new Product("홈런볼", 5000));
      customer.changeCart(1, new Product("오땅", 1000));
      customer.removeCart(0);

      // 구매하면 영수증이 반환됨
      String receipt = customer.buy();
      
      // 영수증 확인
      System.out.println(receipt);
      
      // 고객정보 확인
      System.out.println("고객이 가진 돈 : " + customer.getMoney() + "원");

    } catch (Exception e) {
      
      System.out.println(e.getMessage()); // 예외 메시지 출력
      e.printStackTrace();    // 예외 추적 (Console 에서 빨간색 글씨 부분)
    }
    
  }

}
