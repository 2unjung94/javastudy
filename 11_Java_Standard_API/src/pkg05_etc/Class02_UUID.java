package pkg05_etc;

import java.util.UUID;

public class Class02_UUID {
  // ppt 64
  /*
   * java.util.UUID
   * 1. Universal Unique IDentifier
   * 2. 전역 고유 식별자
   * 3. 형식 
   *    1) 16진수 32개와 하이픈(-) 4개로 구성 : 
   *    2) 8자리    - 4자리 - 4자리 - 4자리 - 12자리
   *       12345678 - 1234  - 1234  - 1234  - 1234567890ab
   */

  public static void main(String[] args) {
    
    // UUID verson 3
    String name = "고은정";
    UUID uuid1 = UUID.nameUUIDFromBytes(name.getBytes());
    String result1 = uuid1.toString();
    System.out.println(result1);
    
    // UUID verson 4
    UUID uuid2 = UUID.randomUUID();
    String result2 = uuid2.toString();
    System.out.println(result2);
    
  }

}
