package db.dto;

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

@ToString
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class UserDto {  
  private int user_no;
  private String user_name;
  private String user_tel;
  private String join_dt;
}
