package pkg02_date_time;

import java.text.SimpleDateFormat;
import java.util.Date;

// ppt 71p
// 년도 2자리 yy, 년도 4자리 y/yyy/yyyy
// 월 M 또는 L,
// 일 d
// 월만 대문자, 나머지 소문자
//
// AMPM a
// 1~12시 h
// 0~23시 H
// 분 m
// 초 s
// 밀리초 S
public class Class02_SimpleDateFormat {

  public static void main(String[] args) {
    
    Date date = new Date();
    SimpleDateFormat sdf = new SimpleDateFormat("a h:mm yyyy-MM-dd");
    String result = sdf.format(date);
    System.out.println(result);
    
  }

}
