package pkg03_dql;

import java.sql.Date;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/*
 * DTO
 * 1. Data Transfer Object (데이터 전송 객체)
 * 2. 데이터베이스의 데이터를 자바와 주고 받을 때 사용하는 객체이다.
 * 3. 기본적으로 테이블 하나당 DTO 하나를 만든다.
 * 4. 필드는 칼럼에 매칭하고 생성자와 Getter/Setter 를 만든다.
 *    이제 생성자, Getter, Setter 생성은 lombok 에게 맡긴다 (lombok 으로 생성한 생성자, getter, setter 는 필드값이 바뀔때 자동으로 바뀐다)
 */

/*
 * lombok 사용하기
 * 1. https://projectlombok.org/download 접속해서 다운로드하기
 * 2. GDJ77 -> jar 폴더에 저장 (json jar 저장되어있는 폴더)
 * 3. 커맨드 이용하여 elipse 에 설치하기 - GDJ77\jar 폴더에서 커맨드 키고 java -jar lombok.jar 명령문 실행
 *    1) jar 폴더 주소 복사
 *    2) cmd cd 주소 입력 (cd : 폴더바꾸기)
 *    3) java -jar lombok.jar 명령문 실행
 *    4) specify location -> 이클립스 설치폴더에서 이클립스.exe 선택 후 select -> install/update 클릭
 *    5) eplise 껏다 키기
 * 4. lombok 설치 후 이클립스가 안켜지는 경우 : 주소에 한글이나 공백이 포함되어 있는 경우
 * 5. lombok 제거 방법
 *    1) C:\GDJ77\tools\eclipse\eclipse.ini 열기
 *    2) 마지막 javaagent 값을 지우고 저장
 *    3) 생성된 lombok.jar 지우기
 * 6. build path 생성
 */

@ToString
@NoArgsConstructor    /* default constructor */
@AllArgsConstructor   /* constructor using field */
@Getter
@Setter
public class SampleDto {
  
  // field
  private int sample_no;    // java 네이밍에는 어긋나지만 db 칼럼이름에 매칭
  private String sample_content;
  private String sample_editor;
  private Date sample_dt;   // java.sql import
}
