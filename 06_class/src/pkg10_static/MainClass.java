package pkg10_static;


// 인스턴스를 안만들고 실행하려면 static 처리로 하여 실행되는 방식
public class MainClass {

  public static void main(String[] args) {

    // 클래스 멤버 호출 : 클래스.멤버
    System.out.println(Calculator.maker); // static 으로 설정한 필드값을 출력. 이클립스에선 static 으로 정의된 멤버들은 글자가 기울어져 있음.
    
    Calculator.add(1, 3);

  }

}
