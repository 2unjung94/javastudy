package pkg03_dql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MainClass {

  /*
   * java.sql.ResultSet
   * 1. SELECT 문의 실행 결과를 처리하는 인터페이스이다.
   * 2. SELECT 문의 결과 행(Row)을 하나씩 조회하는 포인터 역할을 수행한다.
   * 3. 주요 메소드
   *    1) boolean next()                   : 결과 행(Row)이 있으면 해당 행(Row)을 선택하고 true 를 반환한다.
   *    2) int getInt(String columnLabel)   : ResultSet 포인터가 선택한 결과 행(Row)의 칼럼 중 이름이 columnLabel 이고 타입이 int 인 값을 반환한다.
   *       int getInt(int columnIndex)      : ResultSet 포인터가 선택한 결과 행(Row)의 칼럼 중 순번이 columnIndex 이고 타입이 int 인 값을 반환한다.
   *       ** get해당타입() 으로 다른 타입 메소드도 호출 할 수 있다
   * 4. SELECT 목록 반환은 List 를 사용하고, 반복문을 돌린다. SELECT 1행 반환은 if문으로 돌린다
   */
  public static void method1() {

    Connection con = null;
    PreparedStatement ps = null;
    ResultSet rs = null;
    
    try {
      
      Class.forName("oracle.jdbc.OracleDriver");
      
      String url = System.getProperty("jdbc.url");
      String user = System.getProperty("jdbc.user");
      String password = System.getProperty("jdbc.password");
      con = DriverManager.getConnection(url, user, password);
      
      String sql = "SELECT SAMPLE_NO, SAMPLE_CONTENT, SAMPLE_EDITOR, SAMPLE_DT FROM SAMPLE_T ORDER BY SAMPLE_NO DESC";
      
      ps = con.prepareStatement(sql);
      
      // SELECT 문 실행 결과는 ResultSet 이 처리한다.
      rs = ps.executeQuery(sql);
      
      // 결과를 저장할 List<SampleDto> 를 생성한다.
      List<SampleDto> samples = new ArrayList<SampleDto>();
      
      // SELECT 문 실행 결과를 행(Row) 단위로 조회한다.
      while(rs.next()) {
        
        // rs 포인터가 조회하는 행(Row) 을 SampleDto 객체로 만든다.
        SampleDto sampleDto = new SampleDto();
        sampleDto.setSample_no(rs.getInt("SAMPLE_NO"));
        sampleDto.setSample_content(rs.getString("SAMPLE_CONTENT"));
        sampleDto.setSample_editor(rs.getString("SAMPLE_EDITOR"));
        sampleDto.setSample_dt(rs.getDate("SAMPLE_DT"));

        // samples 리스트에 sampleDto 객체를 저장한다.
        samples.add(sampleDto);
        
      }
      
      // 결과 확인
      for(int i = 0, size = samples.size(); i<size; i++) {
        System.out.println(samples.get(i)); 
      }
      
      
    } catch (Exception e) {
      e.printStackTrace();
    } finally {
      try {
        if(rs != null) rs.close();
        if(ps != null) ps.close();
        if(con != null) con.close();
        
      } catch (Exception e2) {
        e2.printStackTrace();
      }
    }
  }
  
  public static void method2() {
  
    Connection con = null;
    PreparedStatement ps = null;
    ResultSet rs = null;
    
    try {
      
      Class.forName("oracle.jdbc.OracleDriver");
      
      String url = System.getProperty("jdbc.url");
      String user = System.getProperty("jdbc.user");
      String password = System.getProperty("jdbc.password");
      
      con = DriverManager.getConnection(url, user, password);
      
      String sql = "SELECT SAMPLE_NO, SAMPLE_CONTENT, SAMPLE_EDITOR, SAMPLE_DT FROM SAMPLE_T WHERE SAMPLE_NO = ?";
      
      ps = con.prepareStatement(sql);
      
      // 변수처리
      Scanner sc = new Scanner(System.in);
      System.out.println("조회할 SAMPLE_NO 입력하세요 >>>");
      int sampleNo = sc.nextInt();
      sc.close();
      
      ps.setInt(1, sampleNo);   // 쿼리문의 1번째 물음표에 sampleNo 를 전달한다.
      
      // 쿼리문 실행
      rs = ps.executeQuery();
      
      // 결과를 저장할 SampleDto 객체 선언
      SampleDto sampleDto = null;
      
      // 결과 조회 (동등비교 결과는 1 아님 0 이기 때문에 반복문 대신 조건문 사용한다)
      if(rs.next()) {
        
        // 결과 행을 SampleDto 객체로 만든다.
        sampleDto = new SampleDto();
        sampleDto.setSample_no(rs.getInt(1));
        sampleDto.setSample_content(rs.getString(2));
        sampleDto.setSample_editor(rs.getString(3));
        sampleDto.setSample_dt(rs.getDate(4));
        
      } 
      // 결과 확인
      System.out.println(sampleDto);
      
    } catch (Exception e) {
      e.printStackTrace();
    } finally {
      try {
        if(rs != null) rs.close();
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
    ResultSet rs = null;
    
    try {
      
      Class.forName("oracle.jdbc.OracleDriver");
      
      String url = System.getProperty("jdbc.url");
      String user = System.getProperty("jdbc.user");
      String password = System.getProperty("jdbc.password");
      
      con = DriverManager.getConnection(url, user, password);
      
      String sql = "SELECT COUNT(*) AS CNT FROM SAMPLE_T";    
      
      ps = con.prepareStatement(sql);
      
      rs = ps.executeQuery();
      
      // 결과를 저장할 변수
      int cnt = 0;
      
      // 결과 조회
      if(rs.next()) {
        
        cnt = rs.getInt("CNT");   // 별명을 지정한 경우 별명이름이 인덱스 이름이 된다.
//        cnt = rs.getInt(1);
        
      }
      System.out.println(cnt);
      
    } catch (Exception e) {
      e.printStackTrace();
    } finally {
      try {
        if(rs != null) rs.close();
        if(ps != null) ps.close();
        if(con != null) con.close();
        
      } catch (Exception e2) {
        e2.printStackTrace();
      }
    }
  }
  
  public static void main(String[] args) {
    
      method3();

  }
}
