package practice06_Cart;

public class Cart {
  
  // field
  public final static int CART_SIZE = 10; 
  private Product[] products;             // 카트에 담은 물건들
  private int count;                      // 카트에 담은 물건의 수 - products 배열의 인덱스값

  // constructor
  public Cart(int cartSize) {
    products = new Product[Math.min(cartSize, CART_SIZE)];
  }

  // method
  public Product[] getProducts() {
    return products;
  }
  public void setProducts(Product[] products) {
    this.products = products;
  }
  public int getCount() {
    return count;
  }
  public void setCount(int count) {
    this.count = count;
  }
  
  // 물건 담기
  public void addProduct(Product product) {
    
    // 카트가 꽉 찬 경우
    if(count == products.length) {
      System.out.println("카트가 가득 찼습니다.");
      return;
    }
    
    if(product == null) {
      System.out.println("카트에 담을 물건이 없습니다.");
      return;
    }
    products[count++] = product;
    
  }
  
  
  // 물건 바꾸기
  public void changeProduct(int idx, Product product) {
    
    // 카트가 비어 있을 때
    if(count == 0) {
      System.out.println("카트가 비어 있습니다.");
      return;
    }
    
    // 바꿀 물건이 없을 때
    if (product == null) {
      System.out.println("바꿀 물건이 없습니다.");
      return;
    }
    
    // 존재하지 않는 물건 번호(인덱스)인 경우 - idx 유효 범위 검사
    if(idx < 0 || idx >= products.length) {
      System.out.println("물건 번호가 잘못되었습니다.");
      return;
    }
    products[idx] = product; 
  }
   
  // 물건 빼기 ( 배열복사 )
  public void removeProduct(int idx) {
    
    // 카트가 비어 있을 때
    if(count == 0) {
      System.out.println("카트가 비어 있습니다.");
      return;
    }
    
    // 존재하지 않는 물건 번호(인덱스)인 경우 - idx 유효 범위 검사
    if(idx < 0 || idx >= products.length) {
      System.out.println("물건 번호가 잘못되었습니다.");
      return;
    }
    
    /*
     * 물건이 5개(count)인 경우로 가정
     * 
     * 삭제할 idx      복사할 요소의 개수    일반화 -> (count - idx - 1)
     * 0               4  
     * 1               3
     * 2               2
     * 3               1
     * 4               0
     */
    System.arraycopy(products, idx + 1, products, idx, count - idx - 1); // products[idx + 1]의 값을 products[idx]에 count - idx - 1 개 복사한다.
    count--;
    
  }
  
  
  
}
