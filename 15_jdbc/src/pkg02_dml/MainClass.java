package pkg02_dml;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Scanner;

/*
 * java 에서 insert, update, delete 실행시 return 값은 처리된 행 개수이다.
 * ex) insert/update/delete 중 1행의 데이터 갖고 쿼리문을 작성했을때 성공하면 return 값은 1, 실패하면 0
 * jdbc 는 auto commit. java 코드로 commit 안들어간다.
 * 
 */

public class MainClass {

  /*
   * java.sql.PreparedStatement
   * 1. 쿼리문을 실행하는 역할을 가진다.
   * 2. PreparedStatement 객체 생성 이전에 쿼리문이 완성되어 있어야 한다.
   * ** Statement 객체도 존재하지만 보안상 이유로 사용하지 않는다. PreparedStatement 사용할 것!
   * 3. 미리 작성한 쿼리문에 변수 처리가 필요한 경우 "?" 를 활용한다.
   * 4. PreparedStatement 객체는 Connection 객체가 생성한다.
   *    PreparedStatement ps = con.prepareStatement(쿼리문);
   */
  
  public static void method1() {
    
    // Connection, PreparedStatement 객체 선언
    Connection con = null;
    PreparedStatement ps = null;
    
    try {
      // oracle.jdbc.OracleDriver 클래스 로드
      Class.forName("oracle.jdbc.OracleDriver");
      
      // 데이터베이스 접속 정보
      String url = System.getProperty("jdbc.url");
      String user = System.getProperty("jdbc.user");
      String password = System.getProperty("jdbc.password");
      
      // Connection 객체 생성
      con = DriverManager.getConnection(url, user, password);
      
      // 쿼리문 작성 (문자열 쿼리문 다음 ; 은 지울것)
      String sql = "INSERT INTO SAMPLE_T (SAMPLE_NO, SAMPLE_CONTENT, SAMPLE_EDITOR, SAMPLE_DT) VALUES (SAMPLE_SEQ.NEXTVAL, '콘텐츠', '에디터', CURRENT_DATE)";
      
      // PreparedStatement 객체 생성
      ps = con.prepareStatement(sql);
      
      // 쿼리문 실행. 삽입된 행의 개수가 반환된다
      int result = ps.executeUpdate();
      
      System.out.println(result + " 행 이(가) 삽입되었습니다.");
      
      
    } catch (Exception e) {
      e.printStackTrace();
    } finally {
      // Connection, PreparedStatement 객체 닫기(반환)
      try {
        if(con != null) con.close();
        if(ps != null) ps.close(); 
      } catch (Exception e) {
        e.printStackTrace();
      }
      
    }
  }

  // method2() 로 공부할 것
  public static void method2() {
    
    Connection con = null;
    PreparedStatement ps = null;
    
    try {
      
      Class.forName("oracle.jdbc.OracleDriver");
      
      String url = System.getProperty("jdbc.url");
      String user = System.getProperty("jdbc.user");
      String password = System.getProperty("jdbc.password");
      con = DriverManager.getConnection(url, user, password);
      
      // 쿼리문에서 변수 처리할 부분은 ? 로 처리한다.
      String sql = "INSERT INTO SAMPLE_T (SAMPLE_NO, SAMPLE_CONTENT, SAMPLE_EDITOR, SAMPLE_DT) VALUES (SAMPLE_SEQ.NEXTVAL, ?, ?, CURRENT_DATE)";
      
      ps = con.prepareStatement(sql);
      
      // 변수 입력 받기
      Scanner sc = new Scanner(System.in);
      System.out.println("내용 입력하세요 >>>");
      String content = sc.next();
      System.out.println("편집자를 입력하세요 >>>");
      String editor = sc.next();
      sc.close();
      
      // 변수를 쿼리문에 전달하기
      ps.setString(1, content);    // 쿼리문의 1번째 물음표에 content 전달하기
      ps.setString(2, editor);     // 쿼리문의 2번째 물음표에 editor 전달하기
      
      int result = ps.executeUpdate();
      System.out.println(result + " 행 이(가) 삽입되었습니다.");
      
    } catch (Exception e) {
      e.printStackTrace();
    } finally {
      try {
        
        // 생성과 반환의 순서는 반대!
        if(ps != null) ps.close();
        if(con != null) con.close();
        
      } catch (Exception e2) {
        e2.printStackTrace();
      }
    }
    
  }
  
  public static void method3() {
    
    Connection con = null;
    PreparedStatement ps = null;
    
    try {
      
      Class.forName("oracle.jdbc.OracleDriver");
      
      String url = System.getProperty("jdbc.url");
      String user = System.getProperty("jdbc.user");
      String password = System.getProperty("jdbc.password");
      
      con = DriverManager.getConnection(url, user, password);
      
      String sql = "UPDATE SAMPLE_T SET SAMPLE_EDITOR = SAMPLE_EDITOR || 2, SAMPLE_DT = CURRENT_DATE WHERE SAMPLE_NO = ?";
      
      ps = con.prepareStatement(sql);
      
      // 수정할 SAMPLE_NO 입력
      Scanner sc = new Scanner(System.in);
      System.out.println("수정할 SAMPLE_NO 입력하세요 >>>");
      int sampleNo = sc.nextInt();
      sc.close();
      
      // 입력값을 쿼리문에 전달
      ps.setInt(1, sampleNo);   // 쿼리문의 1번째 물음표에 sampleNo 전달하기
      
      int result = ps.executeUpdate();
      
      System.out.println(result + " 행 이(가) 수정되었습니다.");
      
    } catch (Exception e) {
      e.printStackTrace();
    } finally {
      try {
        
        if(ps != null) ps.close();
        if(con != null) con.close();
        
      } catch (Exception e2) {
        e2.printStackTrace();
      }
    }
  }
  
  public static void method4() {
    
    Connection con = null;
    PreparedStatement ps = null;
    
    // PK 를 기준으로 삭제하는 것이 좋다
    try {
      
      Class.forName("oracle.jdbc.OracleDriver");
      
      String url = System.getProperty("jdbc.url");
      String user = System.getProperty("jdbc.user");
      String password = System.getProperty("jdbc.password");
      
      con = DriverManager.getConnection(url, user, password);
      
      String sql = "DELETE FROM SAMPLE_T WHERE SAMPLE_NO = ?";
      ps = con.prepareStatement(sql);
      
      Scanner sc= new Scanner(System.in);
      System.out.println("삭제할 SAMPLE_NO 입력하세요 >>>");
      int sampleNo = sc.nextInt();
      sc.close();
      
      ps.setInt(1, sampleNo);
      
      int result = ps.executeUpdate();
      System.out.println(result + " 행이(가) 삭제되었습니다.");
      
      
    } catch (Exception e) {
      e.printStackTrace();
    } finally {
      try {
        
        if (ps != null) ps.close();
        if (con != null) con.close();
        
      } catch (Exception e2) {
        e2.printStackTrace();
      }
    }
  }
  
  
  public static void main(String[] args) {
    method2();

  }

}
