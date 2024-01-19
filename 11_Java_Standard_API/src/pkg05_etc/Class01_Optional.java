package pkg05_etc;

import java.util.Optional;

public class Class01_Optional {

  public static void main(String[] args) {
    
    // Optional<T> : T 타입의 데이터를 감싸는 클래스
    // 사과를 봉지로 쌀때 이때 봉지가 Optional<T> 이다
    
    // 1. null 값이 없는 데이터 (쌀때는 .of(), 꺼낼때는 get())
    String str1 = "사과";
    Optional<String> opt1 = Optional.of(str1);
    System.out.println(opt1.get());
    
    
    // 2. null 값이 있는 데이터 (쌀때는 .ofNullable(null), 꺼낼때는 orElse(다른값) 사용)(배우는 목적) 
    // ex) 목록 보기 구현
    String str2 = null;
    Optional<String> opt2 = Optional.ofNullable(str2);
    System.out.println(opt2.orElse("바나나")); // null 일 때만 바나나를 쓰겠다.
    

  }

}
