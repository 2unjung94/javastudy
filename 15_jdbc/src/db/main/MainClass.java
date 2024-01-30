package db.main;

import java.util.List;

import db.dao.UserDao;
import db.dto.UserDto;

public class MainClass {

  public static void main(String[] args) {
    
    // INSERT
    //UserDto userDto = new UserDto(0, "테스트이름", "테스트연락처", null);
    
    UserDao userDao = UserDao.getInstance();    // dao 의 메소드를 사용할 수 있게 선언
    
    //int result = userDao.saveUser(userDto);
    //System.out.println(result + "행이 삽입되었습니다.");
    
    // SELECT 목록
    //List<UserDto> users = userDao.getUsers();
    //for(UserDto user : users) {
    //System.out.println(user);
    //}
    
    // SELECT 1 ROW
    //UserDto userDto = userDao.getUser(1);
    //System.out.println(userDto);
    
    // 삭제
    //int result = userDao.removeUser(1);
    //System.out.println(result+"행이 삭제되었습니다.");
    
    // 수정
    //UserDto modifyUser = new UserDto(1, "수정이름", "수정연락처", null);
    //int result = userDao.modifyUser(modifyUser);
    //System.out.println(result+"행이 수정되었습니다.");
    
  }

}
