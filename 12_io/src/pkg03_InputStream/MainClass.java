package pkg03_InputStream;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class MainClass {

  /*
   * java.io.FileInputStream
   * 1. 바이트 기반의 파일 입력 스트림이다. (파일을 읽어들이는 스트림)
   * 2. 입력 단위
   *    1) int    : 하나씩
   *    2) byte[] : 여러개
   */
  
  /*
   * java.io.BufferedInputStream
   * 1. 버퍼링 지원하는 바이트 입력 스트림이다.
   * 2. 보조 스트림이므로 메인 스트림과 함께 사용해야 한다.
   * 3. 버퍼링을 지원하므로 입력 속도가 향상된다.
   */
  
  public static void method1() {
    
    File dir = new File("\\storage");
    File file = new File(dir, "sample1.dat");
    
    // 파일 입력 스트림 선언
    FileInputStream in = null;
    
    try {
      
      // 파일 입력 스트림 생성
      in = new FileInputStream(file);   // FileNotFoundException 예외 발생(file 이 없거나 디렉터리 주소가 잘못되었을때)
      
      // 읽은 데이터를 보관할 배열
      byte[] b = new byte[(int)file.length()];
      int idx = 0;
      
      // 읽을 단위 (int 변수로 1바이트식 읽는다.)
      int c;
      
      // 읽기 read() : 1바이트 읽는 메소드
      while(true) {
        c = in.read();    // 1바이트 읽은 것을 4바이트 int 에 담음
        if(c == -1)
          break;
        b[idx++] = (byte)c;   // 4바이트에 담은 것을 1바이트로 강제캐스팅함.
        
      }
      
      // 확인
      /*for(int i = 0 ; i < b.length ; i++) {
        System.out.println(b[i]);
        System.out.println((char)b[i]); Apple
        
      }*/
      System.out.println(new String(b));
      
      // 파일 입력 스트림 닫기
      in.close();
      
    } catch (FileNotFoundException e) {
      System.out.println("파일의 경로를 확인하세요.");
    } catch (IOException e ) {
      System.out.println("입출력 예외가 발생했습니다.");
    }
    
  }
  
  public static void method2() {
    
    File dir = new File("\\storage");
    File file = new File(dir, "sample2.dat");
    
    // 파일 입력 스트림 선언
    FileInputStream in = null;
    
    try {
      
      // 파일 입력 스트림 만들기
      in = new FileInputStream(file);
      
      // 읽은 데이터를 보관할 배열
      byte[] b = new byte[(int)file.length()];
      
      // 읽을 단위 (byte[] 배열로 읽는다.)
      byte[] bytes = new byte[5];
      int idx = 0;
      
      // 읽기 : read(bytes) 읽어오는 바이트의 수를 반환한다
      while(true) {
        int readByte = in.read(bytes);
        if(readByte == -1) {
          break;
        }
        System.arraycopy(bytes, 0, b, idx, readByte); // bytes 배열의 첫번째부터 readByte만큼 값을 b 배열의 idx 부터 붙여넣는다.
        idx += bytes.length;   // 또는 idx += readByte;
      }
      
      // 확인
      System.out.println(new String(b));
      
      // 파일 입력 스트림 닫기
      in.close();
      
    } catch (FileNotFoundException e) {
      System.out.println(file.getPath() + " 파일이 존재하지 않습니다.");
    } catch (IOException e) {
      System.out.println("입출력 오류가 발생했습니다.");
    }
    
  }
  
  public static void method3() {
    
    File dir = new File("\\storage");
    File file = new File(dir, "sample3.dat");
    
    // 버퍼 입력 스트림 선언
    BufferedInputStream in = null;
    
    try {
      
      // 버퍼 입력 스트림 생성
      in = new BufferedInputStream(new FileInputStream(file));
      
      // 담을 배열
      byte[] b = new byte[(int)file.length()];
      
      // 읽는 단위 - 배열
      byte[] bytes = new byte[5];
      int idx = 0;
      
      // 변수 선언을 반복문 안에 넣는건 안좋다.
      int readByte = 0;
      
      // code style change
      // while 조건을 readByte 가 -1 이 아닐 동안으로 설정
      while( (readByte = in.read(bytes)) != -1) { 
        System.arraycopy(bytes, 0, b, idx, readByte);
        idx += bytes.length;
      }
      // 확인
      System.out.println(new String(b));
      
      // 파일 입력 스트림 닫기
      in.close();
      
    } catch (IOException e) {
      e.printStackTrace();
    }
    
  }
  
  public static void main(String[] args) {
    
    method3();
    
  }

}
