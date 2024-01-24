package pkg03_InputStream;

import java.io.BufferedInputStream;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.List;

import pkg02_OutputStream.Employee;

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
  
  /*
   * java.io.DataInputStream
   * 1. 자바 변수로 구성된 데이터를 읽는 바이트 입력 스트림이다.
   * 2. 보조 스트림이므로 메인 스트림과 함께 사용해야 한다.
   * 3. 타입 별로 전용 메소드가 존재한다.
   */
  
  /*
   * java.io.ObjectInputStream
   * 1. 객체로 구성된 데이터를 읽는 바이트 입력 스트림이다.
   * 2. 보조 스트림이므로 메인 스트림과 함께 사용해야 한다.
   * 3. 읽은 객체는 Object 타입으로 반환되므로 객체 타입으로 캐스팅해서 사용한다.
   *    -> IOException과 ClassNotFoundException 예외가 발생할 수 있다. (catch 블록의 순서는 상관없다. 둘은 상속관계가 아니기 때문) 
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
  
  public static void method4() {
    
    File dir = new File("\\storage");
    File file = new File(dir, "sample4.dat");
    
    // 데이터 입력 스트림 선언
    DataInputStream in = null;
    
    try {
      
      // 데이터 입력 스트림 생성
      in = new DataInputStream(new FileInputStream(file));
      
      // 입력
      String name = in.readUTF();             // 출력 시 out.writeUTF(name) 사용
      int age = in.readInt();                 // 출력 시 out.writeInt(age) 사용
      double height = in.readDouble();        // 출력 시 out.writeDouble(height) 사용
      boolean isAdult = in.readBoolean();     // 출력 시 out.writeBoolean(isAdult) 사용
      char gender = in.readChar();            // 출력 시 out.writeChar(gender) 사용
      
      System.out.println("name : "+ name + ", age : " + age + ", height : " + height + ", isAdult : " + isAdult + ", gender : " + gender);
      
      // 데이터 입력 스트림 닫기
      in.close();
      
    } catch (IOException e) {
      e.printStackTrace();
    }
    
  }

  public static void method5() {
    
    File dir = new File("\\storage");
    File file = new File(dir, "sample5.dat");
    
    // 객체 입력 스트림 선언
    ObjectInputStream in = null;
    try {
      
      // 객체 입력 스트림 생성
      in = new ObjectInputStream(new FileInputStream(file));
      
      // 객체 입력
      Employee emp1 = (Employee) in.readObject();   // 다른 패키지에 있는 클래스는 import 해줘야 한다.
      List<Employee> emp2 = (List<Employee>) in.readObject();   // 현재 List<Employee> 형변환은 경고 뜰 수 밖에 없으므로 신경 꺼라
         
      
      // 확인
      System.out.println(emp1);
      System.out.println(emp2.get(0));
      System.out.println(emp2.get(1));
      
      in.close();
      
    } catch (IOException | ClassNotFoundException e ) {     // 동시에 catch 선언하는 방법
      e.printStackTrace();
    }
    
  }
  
  public static void main(String[] args) {
    
    method5();
    
  }

}
