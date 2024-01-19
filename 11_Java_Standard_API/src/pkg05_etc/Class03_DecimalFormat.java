package pkg05_etc;

import java.text.DecimalFormat;

public class Class03_DecimalFormat {

  public static void main(String[] args) {
    
    double number = 12345.6789;
    DecimalFormat df = new DecimalFormat("#,##0.00"); // # : 없으면 안들어감. 0 : 없으면 0    
    System.out.println(df.format(number));  // 올림, 내림 지정 없으면 기본은 반올림이다.

  }

}
