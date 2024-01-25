package pkg01_java_net;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class Class01_InetAddress {

  public static void main(String[] args) {
    
    try {
      
      InetAddress address1 = InetAddress.getByName("gdu.co.kr");
      System.out.println("IP주소 : " + address1.getHostAddress());
      System.out.println("도메인 : " + address1.getHostName());
      
      // byte 배열의 범위는 -128 부터 127 까지므로 127이 넘어가는 숫자는 byte 캐스팅 해야함
      InetAddress address2 = InetAddress.getByAddress(new byte[] {112, (byte)175, (byte)247, (byte)163});   
      System.out.println("IP주소 : " + address2.getHostAddress());
      System.out.println("도메인 : " + address2.getHostName());    // 도메인은 다르게 나올 수 있다.
      
    } catch (UnknownHostException e) {
      e.printStackTrace();
    }
    

  }

}
