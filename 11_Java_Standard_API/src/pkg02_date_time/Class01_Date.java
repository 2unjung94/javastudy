package pkg02_date_time;

import java.util.Date;

public class Class01_Date {

  public static void main(String[] args) {
    
    Date date1 = new Date();    // now
    System.out.println(date1);
    
    
    Date date2 = new Date(1000 * 60 * 60 * 24 * 30L); // 1970-01-31 timestamp 값 전달 (1000 분의 1초) ( 1970-01-01 0시 00분 부터 시작 )
    System.out.println(date2);
    
    

  }

}
