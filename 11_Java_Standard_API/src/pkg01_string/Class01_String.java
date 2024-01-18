package pkg01_string;

import java.util.Arrays;

// 외우려고 할 필요 없다 ~
// 파라미터가 (String regex) 라는 것은 정규식 달라는 얘기.
public class Class01_String {
  
  public static void method1() {
    
    // ppt 37p
    // String 은 불변 객체(Immutable)이다.
    
    String str = "a";
    str += "b";       
    str += "c";
    System.out.println(str);    // 메모리 상에서는 abc가 같은 메모리가 아니다. -> 메모리 낭비 심하다.
    
  }

  public static void method2() {
    
    // ppt 16p ~ 17p
    // String Literal : "문자열"
    // String Literal 은 JVM 이 관리한다. -> 동일한 Literal 은 재사용한다
    
    /*
     *  ┌--------------┐
     *  │  0x12345678  │ str1
     *  │--------------│
     *  │  0x12345678  │ str2
     *  │--------------│
     *  │      ...     │
     *  │--------------│
     *  │       a      │ 0x12345678
     *  │--------------│
     *  │      ...     │
     *  └--------------┘
     */
    
    String str1 = "a";
    String str2 = "a";
    System.out.println(System.identityHashCode(str1));    // str1 의 참조값
    System.out.println(System.identityHashCode(str2));    // str2 의 참조값 (같은 참조값)
    
  }

  public static void method3() {
    
    // ppt 18p ~ 19p
    // 문자열 객체 : new String("문자열")
    // 문자열 객체는 개발자가 관리한다. -> 동일한 문자열 객체도 여러개 생성될 수 있다.
    /*
     *  ┌--------------┐
     *  │  0x12345678  │ str1
     *  │--------------│
     *  │  0x98765432  │ str2
     *  │--------------│
     *  │      ...     │
     *  │--------------│
     *  │       a      │ 0x12345678
     *  │--------------│
     *  │      ...     │
     *  │--------------│
     *  │       a      │ 0x98765432
     *  │--------------│
     *  │      ...     │
     *  └--------------┘
     */
    
    String str1 = new String("a");
    String str2 = new String("a");
    
    System.out.println(System.identityHashCode(str1));  // str1 의 참조값
    System.out.println(System.identityHashCode(str2));  // str2 의 참조값 (다른 참조값)
    
  }

  public static void method4() {
    
    // equals           : 같은 문자열이면 true 반환
    // equalsIgnoreCase : 같은 문자열이면 true 반환 (대소문자 무시한다.) 
    
    String str1 = "a";
    String str2 = "A";
    
    System.out.println(str1.equals(str2));
    System.out.println(str1.equalsIgnoreCase(str2));
    
  }
  
  public static void method5() {
    
    // length : 문자 개수 반환
    
    String str = "hello\n"; // 6글자
    System.out.println(str.length());
    
  }
  
  public static void method6() {
    
    // charAt : 지정한 인덱스(index) 의 문자 반환 (char[] -> 문자열 -> 배열)
    String str = "hello";
    
    System.out.println(str.charAt(0));
    System.out.println(str.charAt(1));
    System.out.println(str.charAt(2));
    System.out.println(str.charAt(3));
    System.out.println(str.charAt(4)); 
    
  }
  
  public static void method7() {
    
    // indexOf      : 전달한 문자열이 발견된 첫번째 인덱스를 반환, 없으면 -1을 반환
    // lastIndexOf  : 전달한 문자열이 발견된 마지막 인덱스를 반환, 없으면 -1을 반환
    
    String str = "hello world apple";
    
    System.out.println(str.indexOf(" "));   // 공백의 위치 반환
    System.out.println(str.indexOf("y"));
    System.out.println(str.lastIndexOf(" "));  // 마지막 공백의 위치 반환
    
  }
  
  public static void method8() {
    
    // substring(int beginIndex)               : beginIndex 부터 끝까지 반환
    // substring(int beginIndex, int endIndex) : beginIndex 부터 endIndex 이전까지 반환 
    
    String str = "hello world";
    int spaceIndex = str.indexOf(" ");
    System.out.println(str.substring(0, spaceIndex));   // 공백 전까지
    System.out.println(str.substring(spaceIndex + 1));  // 공백 다음부터 끝까지
    
  }
  
  public static void method9() {
    
    // startsWith : 전달한 문자열로 시작하면 true 반환
    // endsWith   : 전달한 문자열로 끝나면   true 반환
    // contains   : 전달한 문자열을 포함하면 true 반환
    
    String str = "admin@example.com";
    
    System.out.println(str.startsWith("admin"));
    System.out.println(str.endsWith(".com"));
    System.out.println(str.contains("@"));
    
  }

  public static void method10() {
    
    // isEmpty : 글자수가 0이면       true 반환
    // isBlank : 공백 문자이면(space) true 반환 (jdk 11 부터 사용 가능)
    
    String str = " ";
    System.out.println(str.isEmpty());  // false : space 도 글자이므로 글자수는 1
    System.out.println(str.isBlank());  // true  : 공백문자 이므로 
    
  }

  public static void method11() {
    
    // trim : 문자열의 앞뒤에 포함된 공백 문자 제거
    
    String str = "\n hello \n";
    System.out.println(str.trim().length());
    
  }

  public static void method12() {
    
    // replace    : 어떤 문자열을 다른 문자열로 변환한 문자열을 반환 (주로 사용할 것)
    // replaceAll : 어떤 정규식 패턴을 다른 문자열로 변환한 문자열을 반환 
    
    String str = "192.168.0.214";
    
    System.out.println(str.replace(".", "_"));
    System.out.println(str.replaceAll("\\.", "_")); // 정규식 패턴(Regular Expression) : 정규식에서 . 는 모든 문자열을 의미한다. .쓰고 싶으면 \\ 추가해서 사용
    
  }
  
  public static void method13() {
    
    // split : 지정한 정규식 패턴으로 문자열을 분리한 String [] 을 반환
    // join  : String[] 의 모든 요소와 전달한 문자열을 연결한 문자열을 반환
    
    String str = "aaa.bbb.ccc.ddd.txt";
    
    String[] result = str.split("\\.");
    System.out.println(Arrays.toString(result));    // 단순 참조 출력은 헬퍼클래스인 Arrays 사용

    System.out.println(result[result.length - 1]);  // 시작 : 0, 마지막 : 배열길이 - 1
    
    System.out.println(String.join(".", result));   // result 원상복구
    
  }
  
  public static void method14() {
    
    // toUpperCase : 대문자로 변환
    // toLowerCase : 소문자로 변환
    
    String str = "I am a Student";
    
    System.out.println(str.toUpperCase());
    System.out.println(str.toLowerCase());
    
    
  }

  public static void method15() {
    
    // format : 형식이 적용된 문자열 반환
    
    // 실수 형식
    double number1 = 100.5;
    System.out.println(String.format("%f", number1));
    System.out.println(String.format("%.2f", number1));     // 소수점 2자리
    System.out.println(String.format("%10.2f", number1));   // 전체 자리수가 10자리 그중 소수점은 2자리
    
    // 정수 형식
    int number2 = 123;
    System.out.println(String.format("%o", number2));   // 8진수
    System.out.println(String.format("%x", number2));   // 16진수(0 ~ f 까지 숫자 사용)
    System.out.println(String.format("%X", number2));   // 16진수(0 ~ F 까지 숫자 사용)
    System.out.println(String.format("%d", number2));   // 10진수
    System.out.println(String.format("%5d", number2));  // 10진수 5자리 없으면 공백
    System.out.println(String.format("%05d", number2)); // 10진수 5자리 없으면 0으로 붙임
    
    // 문자열 형식
    String str = "hello";
    System.out.println(String.format("%s", str));
    System.out.println(String.format("%10s", str));   // 오른쪽 정렬
    System.out.println(String.format("%-10s", str));  // 왼쪽 정렬
    
  }
  
  public static void main(String[] args) {
    practice02();

  }
  
  public static void practice01() {
    
    String uri = "/project/list.do";
    String contextPath = "/project";
    
    System.out.println(uri.indexOf(contextPath)); // 0
    System.out.println(contextPath.length());// 8   
    System.out.println(uri.indexOf(contextPath) + contextPath.length()); // 0 + 8, 인덱스의 시작점 구하기 (어디서부터 몇글자)
    
    
    //String mapping = uri.substring(uri.lastIndexOf("/")); // "/list.do"
    
    String mapping = uri.substring(uri.indexOf(contextPath) + contextPath.length());
    System.out.println(mapping);
    
  }
  
  public static void practice02() {
    // 앞으로 읽어도 뒤로 읽어도 동일한 문자열 판단하기. 같으면 true, 다르면 false
    
    String word = "level";
    boolean result = true;
    
    // 1. 한 글자씩 비교하기
    for(int i = 0, length = word.length(); i < (length / 2) ; i++) {
      if( word.charAt(i) != word.charAt(length - 1 - i)) {
        result=false;
        break;
      }
      
    }
    System.out.println(result);
    
    
    
    // 2. 거꾸로 문자열을 만들어서 비교하기 (이게 더 편함)
    // String 클래스 사용
    String reverse1 = ""; 
    long start1 = System.nanoTime();
    for(int i = word.length() - 1; i >= 0 ; i--) {
      reverse1 += word.charAt(i);
    }
    long end1 = System.nanoTime();
    System.out.println(word.equals(reverse1));
    System.out.println(end1-start1);
    
    
    // StringBuilder 사용
    StringBuilder reverse2 = new StringBuilder();
    long start2 = System.nanoTime();
    for(int i = word.length()-1  ; i >= 0; i--) {
      reverse2.append(word.charAt(i));
    }
    long end2 = System.nanoTime();
    String resultString = reverse2.toString();
    
    System.out.println(end2-start2);
    System.out.println(word.equals(resultString));
        
    
    
  }

}
