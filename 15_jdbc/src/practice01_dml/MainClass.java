package practice01_dml;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class MainClass {
  
  /*
   * TALK_T 테이블에 1행씩 삽입하시오.
   * TALK_T 구조
   *    TALK_NO      NUMBER (PK)
   *    TALK_CONTENT VARCHAR2(1000 BYTE)
   *    TALK_USER    VARCHAR2(1000 BYTE)
   *    WRITEN_AT    TIMESTAMP (* 현재 날짜/시간 : CURRENT_TIMESTAMP)
   * TALK_SEQ 시퀀스 존재함
   * DB 서버 환경
   *    192.168.0.214
   *    GD/1111
   */

  public static void main(String[] args) {
    
    Connection con = null;
    PreparedStatement ps = null;
    try {
      Class.forName("oracle.jdbc.OracleDriver");
      
      String url = System.getProperty("jdbc.url");
      String user = System.getProperty("jdbc.user");
      String password = System.getProperty("jdbc.password");
      
      con = DriverManager.getConnection(url, user, password);
      
      String sql = "INSERT INTO TALK_T(TALK_NO, TALK_CONTENT, TALK_USER, WRITEN_AT) VALUES(TALK_SEQ.NEXTVAL, '안녕하세요', '고은정', CURRENT_TIMESTAMP)";
      
      ps = con.prepareStatement(sql);
      
      int result = ps.executeUpdate();
      System.out.println(result + " 행이(가) 삽입되었습니다.");
      
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

}
