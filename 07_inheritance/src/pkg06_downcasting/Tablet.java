package pkg06_downcasting;


//downcasting : 부모를 자식으로 바꾸는거??
public class Tablet extends Computer {
  
  public void screenTouch() {
    System.out.println("화면 터치");
  }
  
  public void portable() {
    System.out.println("휴대");
  }

}
