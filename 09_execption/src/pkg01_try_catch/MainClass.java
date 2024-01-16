package pkg01_try_catch;

public class MainClass {

  public static void method1() {
    
    // 예외 처리가 발생하는 상황
    
    String userInput = "12.3";
    
    int number = Integer.parseInt(userInput); // input이 정수가 아니면 exception 나옴
    System.out.println(number);
    
  }
  
  public static void method2() {
    
    // 예외 처리 : try - catch (프로그램이 정상적으로 종료될 수 있도록 예외처리하는 구문)
    
    
    try {                                           // 실행하고싶은 코드를 try 에 작성
      
      String userInput = "12.3";
      
      int number = Integer.parseInt(userInput);     // jvm 이 NumberFormatException 예외 던짐
      System.out.println(number);
      
    } catch(NumberFormatException e) {              // 던진 예외를 catch 가 잡고 e 객체에 저장. catch 블록 비우지말아라
     
     System.out.println("정수만 입력하세요.");
      
    }
    
  }

  public static void method3() {
    
    String[] userInputs = {"10", "20", "1.5", "2.5", "30"};
    
    for(int i = 0 ; i< userInputs.length ; i++) {
      
      try {
        
        int number = Integer.parseInt(userInputs[i]);
        System.out.println(number);
        
      } catch(NumberFormatException e) {
        
        System.out.println(userInputs[i] + "는 정수가 아닙니다.");
        
      }
      
    }
    
  }
  
  public static void method4() {
    
    // 다중 catch 블록 : 상속 관계를 이해하고 만들 것
    // 다중 catch 블록의 순서는 상속 관계에 따라 달라질 수 있다
    // 자식을 위 부모를 밑에 작성
    
    String[] userInputs = {"10", "20", "15", "25", "30"};
    
    try {
      
      for(int i = 0 ; i < 6 ; i++) {
        
        int number = Integer.parseInt(userInputs[i]); // userInputs[5]는 존재하지 않음
        System.out.println(number);
        
      }
      
    }catch(ArrayIndexOutOfBoundsException e) {                        // RuntimeException의 자식
      
      System.out.println("사용할 수 없는 인덱스가 사용되었습니다.");
      
    
    }catch(RuntimeException e) {                      // ArrayIndexOutOfBoundsException의 부모
      
      System.out.println("정수만 처리할 수 있습니다.");
    }
      
    
  }
  
  public static void main(String[] args) {
    method4();

  }

}
