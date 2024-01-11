package practice05_Bakery;

public class MainClass {

  public static void main(String[] args) {
    // TODO Auto-generated method stub
    // 빵집 2개 구매자 1개
    
    Bakery bakery1 = new Bakery(10, 10000);
    Bakery bakery2 = new Bakery(5, 5000);
    
    Customer customer = new Customer(5000, 3);
    
    // bakery1에서 3개의 빵 구매
    customer.buy(bakery1, customer.getCount(), customer.getMoney());
    System.out.println(customer.getCount() + " " + customer.getMoney()); //도대체 왜 money가 -3500일까..????????????????????????????????
    System.out.println(bakery1.getCount() + " " + bakery1.getMoney());
    
    //customer.buy(bakery2, customer.getCount(), customer.getMoney());
    
    
  }

}
