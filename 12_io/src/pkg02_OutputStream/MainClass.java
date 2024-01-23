package pkg02_OutputStream;

import java.io.BufferedOutputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.util.Arrays;
import java.util.List;

public class MainClass {

  /*
   * java.io.FileOutputStream
   * 1. 바이트 기반의 파일 출력 스트림이다. (= 바이트 기반의 파일을 보낸다.)
   * 2. 출력 단위
   *    1) int    : 하나만 보낼때 (4바이트지만, 1바이트만 싣고 보낸다)
   *    2) byte[] : 여러개 보낼때
   */
  
  /*
   * !! 중요 !!
   * java.io.BufferedOutputStream
   * 1. 버퍼링을 지원하는 바이트 출력 스트림이다.
   * 2. 보조 스트림으로 메인 스트림과 함께 사용해야 한다.
   * 3. 버퍼링을 지원하므로 출력 속도가 향상된다.
   */
  
  /*
   * java.io.DataOutputStream
   * 1. 자바 변수 값을 출력하는 바이트 출력 스트림이다.
   * 2. 보조 스트림으로 메인 스트림과 함께 사용해야 한다.
   * 3. 타입 별로 전용 메소드가 존재한다.
   */
  
  /*
   * java.io.ObjectOutputStream
   * 1. 객체를 출력하는 바이트 출력 스트림이다
   * 2. 보조 스트림으로 메인 스트림과 함께 사용해야 한다.
   * 3. 객체를 출력 스트림으로 전송하기 위해서는 직렬화 과정이 필요하다. (직렬화 : 객체를 바이트배열로 바꾸는 것)
   * 4. 직렬화 방법
   *    1) 직렬화 할 클래스는 java.io.Serializable 인터페이스를 구현한다. (필수)
   *    2) long serialVersionUID 필드 값을 임의로 생성한다. (implements 후 오류메시지 눌러서 serialVersonUID 생성) (안만들면 자바가 알아서 생성해준다)
   */
  
  public static void method1() {
    
    // 무조건 생성 모드 : 기존에 파일이 있으면 지우고 다시 만든다.
    
    // 디렉터리
    File dir = new File("\\storage");
    if( !dir.exists() ) {
      dir.mkdirs();
    }
    
    // 파일
    File file = new File(dir, "sample1.dat");   
    
    // 파일 출력 스트림 선언 (파일 출력 스트림 = 데이터를 보내는 통로)
    FileOutputStream out = null;
    
    // 파일 출력 스트림 생성(예외처리 필수)
    try {
      // 파일 출력 스트림 생성 (무조건 생성 모드)
      out = new FileOutputStream(file);     // 폴더(디렉터리)가 없을 때 FileNotFoundException 발생함
      
      // 출력할 데이터
      int c = 'A';
      String str = "pple";
      byte[] b = str.getBytes();  //String -> byte
      
      // 출력
      out.write(c);
      out.write(b);
      
      // 플러싱(선택) (출력 스트림 안에 있는 데이터를 보내는 것)
      out.flush();
      
      
      // 확인
      System.out.println(file.length() + "바이트 크기의 " + file.getPath() + " 파일이 생성되었습니다.");
      
    } catch (Exception e) {
      e.getStackTrace();
    } finally {
      // finally 는 예외 처리 되어도 실행하는 코드블록. close()는 예외처리가 필요한 메소드여서 try-catch를 finally 안에 또 작성해야 한다.
      // 이건 너무 too much 하니까 close()는 try 끝부분에 넣는 것도 괜찮다.
      try {
        
        // 파일 출력 스트림 닫기(종료) 꼭 해야함 
        // if 문을 넣은 이유 : out을 try 안에서 생성했기 때문에 out이 생성이 안된다면 out은 null이 된다. 이후 실행하다 보면 NullPointerException이 발생하므로 넣어줘라.
        if(out != null) {
          out.close();      
        }
        
      } catch (Exception e2) {
        e2.printStackTrace();
      }
    }
    
  }

  public static void method2() {
    
    // 추가 모드 : 기존에 파일이 없으면 새로 만들고 있으면 내용만 추가한다.
    
    // 안녕하세요 반갑습니다 -> sample2.dat 파일로 보내기
    File dir = new File("\\storage");
    if( !dir.exists() ) {
      dir.mkdirs();
    }
    
    File file = new File(dir, "sample2.dat");
    FileOutputStream out = null;
    try {
      
      // 파일 출력 스트림 생성 (추가모드) - true 추가
      out = new FileOutputStream(file, true);
      
      // 출력할 데이터
      String hello = "안녕하세요 반갑습니다\n";
      byte[] b = hello.getBytes();
      
      // 출력
      out.write(b);
      
      // 플러싱(선택)
      out.flush();
      
      // 확인
      System.out.println(file.length() + "바이트 크기의 " + file.getPath() + " 파일이 생성되었습니다.");
      
    } catch (Exception e) {
      e.getStackTrace();
    } finally {
      // finally 는 예외 처리 되어도 실행하는 코드블록. close()는 예외처리가 필요한 메소드여서 try-catch를 finally 안에 또 작성해야 한다.
      // 이건 너무 too much 하니까 close()는 try 끝부분에 넣는 것도 괜찮다.
      try {
        
        // 파일 출력 스트림 닫기(종료) 꼭 해야함 
        // if 문을 넣은 이유 : out을 try 안에서 생성했기 때문에 out이 생성이 안된다면 out은 null이 된다. 이후 실행하다 보면 NullPointerException이 발생하므로 넣어줘라.
        if(out != null) {
          out.close();      
        }
        
      } catch (Exception e2) {
        e2.printStackTrace();
      }
    }
    
  }
  
  // method3() 안보고 칠 수 있어야 한다
  public static void method3() {
    
    File dir = new File("\\storage");
    if(!dir.exists()) {
      dir.mkdir();
    }
    
    File file = new File(dir, "sample3.dat");
    
    // 버퍼 출력 스트림 선언
    BufferedOutputStream out = null;
    
    try {
      
      // 버퍼 출력 스트림 생성
      out = new BufferedOutputStream(new FileOutputStream(file));
      
      // 출력할 데이터
      String str1 = "how do you do? nice to meet you\n";
      String str2 = "I'm fine thank you";
      
      // 출력
      out.write(str1.getBytes());
      out.write(str2.getBytes());
      
      // 버퍼 출력 스트림 닫기
      out.close();
      
      // 확인
      System.out.println(file.length() + "바이트 크기의 " + file.getPath() + " 파일이 생성되었습니다.");
      
    } catch (Exception e) {
      e.printStackTrace();
    }
    
    
    
  }
  
  public static void method4() {
    
    File dir = new File("\\storage");
    
    if(!dir.exists()) {
      dir.mkdirs();
    }
    
    File file = new File(dir, "sample4.dat");
    
    // 데이터 출력 스트림 선언
    DataOutputStream  out = null;
    try {
      
      // 데이터 출력 스트림 생성
      out = new DataOutputStream(new FileOutputStream(file));
      
      // 출력할 데이터
      String name = "홍길동";
      int age = 10;
      double height = 140.5;
      boolean isAdult = (age >= 20);
      char gender = '남';
      
      // 출력
      out.writeUTF(name);
      out.writeInt(age);
      out.writeDouble(height);
      out.writeBoolean(isAdult);
      out.writeChar(gender);
      
      // 데이터 출력 스트림 닫기
      out.close();
      
      System.out.println(file.length() + "바이트 크기의 " + file.getPath() + " 파일이 생성되었습니다.");
      
    } catch (Exception e) {
      e.printStackTrace();
    }
    
  }

  public static void method5() {
    
    File dir = new File("\\storage");
    if(!dir.exists()) {
      dir.mkdirs();
    }
    
    File file = new File(dir, "sample5.dat");
    
    // 객체 출력 스트림 선언
    ObjectOutputStream out = null;
    try {
      
      // 객체 출력 스트림 생성
      out = new ObjectOutputStream(new FileOutputStream(file));
      
      // 출력할 객체
      Employee employee = new Employee(1, "홍길동");
      List<Employee> employees = Arrays.asList(new Employee(2,"홍길순"), new Employee(3, "홍순자"));
      
      // 객체 출력
      out.writeObject(employee);
      out.writeObject(employees);
      
      // 출력 스트림 닫기
      out.close();
      
      // 확인
      System.out.println(file.length() + "바이트 크기의 " + file.getPath() + " 파일이 생성되었습니다.");
      
    } catch (Exception e) {
      // TODO: handle exception
    }
    
    
  }
  
  public static void main(String[] args) {
    practice1();
    practice2();
  }
  
  public static final String SONG = "동해물과 백두산이 마르고 닳도록\n하느님이 보우하사 우리나라 만세\n무궁화 삼천리 화려강산\n대한사람 대한으로 길이 보전하세\n";
  
  public static void practice1() {
 
    // FileOutputStream 으로 애국가 1절 파일로 보내기 : 시간 재기
 // FileOutputStream 으로 애국가 1절 파일로 보내기 : 시간 재기
    File dir = new File("\\storage");
    if(!dir.exists()) {
      dir.mkdirs();
    }
    
    File file = new File(dir, "FileOutputStream.dat");
    FileOutputStream out = null;
    try {
      out = new FileOutputStream(file);
      
      long start = System.nanoTime();
      out.write(SONG.getBytes());
      long end = System.nanoTime();
      
      out.close();
      
      System.out.println(file.length() + "바이트 크기의 " + file.getPath() + " 파일이 생성되었습니다.");
      System.out.println("FileOutputStream : " + (end - start) + "ns 소요됨");
      
    } catch (Exception e) {
      e.printStackTrace();
    }
    
  }
  
  public static void practice2() {
    
    // BufferedOutputStream 으로 애국가 1절 파일로 보내기 : 시간 재기

    File dir = new File("\\storage");
    if(!dir.exists()) {
      dir.mkdirs();
    }
    
    File file = new File(dir, "BufferedOutputStream.dat");
    BufferedOutputStream out = null;
   
    try {
      out = new BufferedOutputStream(new FileOutputStream(file));
      
      long start = System.nanoTime();
      out.write(SONG.getBytes());
      long end = System.nanoTime();
      
      out.close();
      
      System.out.println(file.length() + "바이트 크기의 " + file.getPath() + " 파일이 생성되었습니다.");
      System.out.println("BufferedOutputStream : " + (end - start) + "ns 소요됨");
      
    } catch (Exception e) {
      e.printStackTrace();
    }
    
  }

}
