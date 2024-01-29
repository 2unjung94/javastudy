package pkg01_connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Enumeration;
import java.util.Properties;

public class MainClass {

  /*
   * oracle.jdbc.OracleDriver (method1)
   * 1. 오라클 데이터베이스에 접속하기 위해 필요한 드라이버 클래스
   * 2. 오라클에서 만들어서 배포한다.
   * 3. 18c XE 버전의 경우 C:\app\사용자\product\18.0.0\dbhomeXE\jdbc\lib\ojdbc8.jar 파일을 프로젝트의 build path 에 등록해야 한다.
   */
  
  /*
   * java.sql.Connection (method2)
   * 1. 데이터베이스 접속 객체 타입의 인터페이스이다.
   * 2. java.sql.DriverManager 클래스가 데이터베이스 접속 객체를 생성한다.
   * ** DriverManager가 생성, Connection 타입 형태로 저장
   * 3. 형식
   *    Connection connection = DriverManager.getConnection();
   */
  
  /*
   * 프로퍼티(Property, 속성) (method3), (method4)
   * 1. 운영체제의 정보나 자바 실행 정보 등을 가지고 있는 값이다.
   * 2. 사용자가 프로퍼티를 추가해서 사용할 수 있다.
   * 3. 프로퍼티 추가 방법 (eclipse 기준)
   *    1) [Run] - [Run Configurations] - [Arguments] - [VM arguments]
   *    2) 프로퍼티 앞에 prefix 값으로 -D 를 사용한다. (프로퍼티 사용시 -D는 빼고 사용)
   *    3) *.properties 라는 파일을 만들어서 github.com 에 안올리고 파일을 읽어들인다.
   * 4. github.com 에 올릴 수 없는 민감 정보를 처리하는 용도로 사용한다.
   * 5. 프로퍼티로 등록한 값은 System.getProperty() 메소드를 이용해서 가져온다.
   * ** 프로퍼티는 마침표(.) 로 구분한다.
   */   
  
  public static void method1() {
    
    // oracle.jdbc.OracleDriver 클래스를 메모리에 올리기 (한번만 해두면 된다)
    try {
      Class.forName("oracle.jdbc.OracleDriver");    // 외우기
      System.out.println("oracle.jdbc.OracleDriver 클래스가 메모리에 로드되었습니다.");
    } catch (Exception e) {
      System.out.println("oracle.jdbc.OracleDriver 클래스를 찾을 수 없습니다.");
    }
    
  }

  public static void method2() {
    
    // 접속을 위해서 필요한 정보(주소, 계정정보(계정이름, 계정비밀번호))
    // jdbc:oracle:this:@주소:포트번호:서비스이름
    // @ 뒷부분은 개발할 때 바뀐다
    // localhost 대신 적을 수 있는 IP 주소 : 127.0.0.1
    String url = "jdbc:oracle:thin:@localhost:1521:xe";
    String user = "GD";
    String password = "1111";
    
    // Connection 객체 선언
    Connection con = null;
    try {
      
      // Connection 객체 생성
      con = DriverManager.getConnection(url, user, password);
      System.out.println("데이터베이스에 접속되었습니다.");
      
    } catch (SQLException e) {
      e.printStackTrace();
    } finally {
      
      // Connection 객체 닫기
      try {
        if(con != null) 
          con.close();
      } catch (Exception e) {
        e.printStackTrace();
      }
    }
  }
  
  public static void method3() {
    
    Properties props = System.getProperties();      // 모든 프로퍼티 가져오기
    
    Enumeration enumeration = props.propertyNames(); // Enumeration : 값을 여러개 가진 인터페이스를 다루는 객체
    
    while(enumeration.hasMoreElements()) {      // hasMoreElements() : 저장된 값이 있냐
      
      String property = (String)enumeration.nextElement();
      System.out.println(property + " = " + props.getProperty(property));
      
    }
  }

  public static void method4() {
    
    // 사용자 프로퍼티 등록(jdbc.url, jdbc.user, jdbc.password)
    // -Djdbc.url=jdbc:oracle:thin:@localhost:1521:xe
    // -Djdbc.user=GD
    // -Djdbc.password=1111
    
    // 데이터베이스 접속 정보 (사용자 프로퍼티 가져오기)
    String url = System.getProperty("jdbc.url");
    String user = System.getProperty("jdbc.user");
    String password = System.getProperty("jdbc.password");
    
    Connection con = null;
    try {
      con = DriverManager.getConnection(url, user, password);
      System.out.println("데이터베이스에 접속되었습니다.");
      
    } catch (Exception e) {
      e.printStackTrace();
    } finally {
      try {
        if(con != null) con.close();
      } catch (Exception e2) {
        e2.printStackTrace();
      }
    }
    
    
    
  }
  
  public static void main(String[] args) {
    method4();

  }

}
