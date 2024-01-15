package pkg05_marker_interface;

// ctrl + space 하면 override 메소드 나옴
// 먹을 수 있는 음식

public class PineApple implements Food, Eatable {

  @Override
  public void eat() {
    System.out.println("파인애플 먹는다.");
  }
  
}
