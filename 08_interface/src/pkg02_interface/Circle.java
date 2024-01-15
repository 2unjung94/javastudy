package pkg02_interface;

/*
 * 용어 비교
 *    클래스          인터페이스
 * 1. 상속한다.       구현한다.
 * 2. extends         implements      2번은 외우기
 * 3. 자식클래스      구현클래스
 * 4. 인터페이스를 사용할 클래스 만들기
 *    -> new -> class -> interface -> add -> 해당 인터페이스 찾기 -> finish
 */

public class Circle implements Shape {
  
  // field
  private double x;
  private double y;
  private double radius;
  
  // constructor
  public Circle() {
  }
  
  public Circle(double x, double y, double radius) {
    super();
    this.x = x;
    this.y = y;
    this.radius = radius;
  }

  // method
  public double getX() {
    return x;
  }
  public void setX(double x) {
    this.x = x;
  }
  public double getY() {
    return y;
  }
  public void setY(double y) {
    this.y = y;
  }
  public double getRadius() {
    return radius;
  }
  public void setRadius(double radius) {
    this.radius = radius;
  }


  @Override
  public double getArea() {
    return PI * Math.pow(radius, 2);
  }

  @Override
  public double getCircum() {
    return 2 * PI * radius ;
  }
  
  

}
