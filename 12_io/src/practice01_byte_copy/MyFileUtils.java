package practice01_byte_copy;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class MyFileUtils {
  
  // src : 어디에 있는 어떤 파일
  // dest : 새로 만든 파일의 위치
  
  public static void fileCopy(String src, String dest) {
    
    // 원본 File 객체
    File srcFile = new File(src);
    
    // 복사본 File 객체
    File destFile = new File(dest);
    
    // 원본을 읽는 버퍼 입력 스트림 선언
    BufferedInputStream in = null;
    
    // 복사본을 만드는 버퍼 출력 스트림 선언
    BufferedOutputStream out = null;
    
    
    try {
      // 원본을 읽는 버퍼 입력 스트림 생성
      in = new BufferedInputStream(new FileInputStream(srcFile));
      
      // 복사본을 만드는 버퍼 출력 스트림 생성
      out = new BufferedOutputStream(new FileOutputStream(destFile));
      
      // 원본을 5바이트씩 읽어온다.
      byte[] bytes = new byte[5];
      
      // 원본을 끝까지 읽는다. 읽은 내용을 복사본으로 보낸다.
      int readByte = 0;
      while( (readByte = in.read(bytes)) != -1) {
        out.write(bytes, 0, readByte);          // bytes 배열에서 0부터 readByte 만큼만 보내시오
      };
      
      // 버퍼 입력 스트림 닫기 (닫을 때 생성 순서의 반대로)
      out.close();
      in.close();
      
    } catch (IOException e) {
      e.printStackTrace();
    }
    
  }
  
  // 파일 복사 메소드<연습>
  public static void fileCopyMy(String src, String dest) {
    
    // src로부터 읽은 데이터를 바이트 배열에 저장하고, 
    // 바이트 배열에 있는 데이터를 파일 출력 스트림으로 보내는 방식
    
    File srcFile = new File(src);
    File destFile = new File(dest);
    
    BufferedOutputStream out = null;
    BufferedInputStream in = null;
    
    try {
      out = new BufferedOutputStream(new FileOutputStream(srcFile));
      in = new BufferedInputStream(new FileInputStream(destFile));
      
      byte[] bytes = new byte[5];
      int readByte = 0;
      
      while( (readByte = in.read()) != -1) {
        out.write(bytes, 0, readByte);
      }
      
      in.close();
      out.close();
      
    } catch (IOException e) {
      e.printStackTrace();
    }
    
    
    
  }

  
  // 파일 이동 메소드
  public static void fileMove(String src, String dest) {
    
    // 원본 File 객체
    File srcFile = new File(src);
    
    // 디렉터리 생성
    File destDir = new File(dest);
    if(!destDir.exists()) {
      destDir.mkdirs();
    }
    // 복사본 File 객체
    File destFile = new File(dest, srcFile.getName());
    
    // 원본을 읽는 버퍼 입력 스트림 선언
    BufferedInputStream in = null;
    
    // 복사본을 만드는 버퍼 출력 스트림 선언
    BufferedOutputStream out = null;
    
    
    try {
      // 원본을 읽는 버퍼 입력 스트림 생성
      in = new BufferedInputStream(new FileInputStream(srcFile));
      
      // 복사본을 만드는 버퍼 출력 스트림 생성
      out = new BufferedOutputStream(new FileOutputStream(destFile));
      
      // 원본을 5바이트씩 읽어온다.
      byte[] bytes = new byte[5];
      
      // 원본을 끝까지 읽는다. 읽은 내용을 복사본으로 보낸다.
      int readByte = 0;
      while( (readByte = in.read(bytes)) != -1) {
        out.write(bytes, 0, readByte);          // bytes 배열에서 0부터 readByte 만큼만 보내시오
      };
      
      // 버퍼 입력 스트림 닫기 (닫을 때 생성 순서의 반대로)
      out.close();
      in.close();
      
      srcFile.deleteOnExit();
      
    } catch (IOException e) {
      e.printStackTrace();
    }
    
  }
}
