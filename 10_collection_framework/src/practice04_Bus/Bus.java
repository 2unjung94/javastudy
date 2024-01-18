package practice04_Bus;

import java.util.ArrayList;
import java.util.List;

// 1. Seat[] -> List<Seat>
// 2. 25 -> public static final int 처리
// 3. exception 처리
public class Bus {
  
  // field
  private List<Seat> seats;
  public static final int LIMIT = 25;
  private int numOfPerson;

  // constructor
  public Bus() {
    seats = new ArrayList<Seat>(LIMIT);
    for(int i = 0; i < LIMIT; i++) {
      seats.add(new Seat());
    }
  }
  
  // method
  
  //버스 타기 (앞좌석부터)
  public void busOn(Person person) throws RuntimeException {
   
   if(numOfPerson >= LIMIT) {
     throw new RuntimeException("만석입니다. 버스에 탈 수 없습니다");
   }
   
   for(int i = 0; i < LIMIT ; i++) {
     // 각 좌석을 의미
     Seat seat = seats.get(i);          // *
     
     if(seat.getPerson() == null) {     // *
       seat.setPerson(person);          // *
       numOfPerson++;
       break;
     }
   }
 }
  
  public void off(int seatNo) throws RuntimeException {
    if(seatNo <= 0 || seatNo > LIMIT) {
      throw new RuntimeException("좌석 번호가 잘못 전달되었습니다.");
    }
    seats.get(seatNo - 1).setPerson(null);    // *
    numOfPerson--;
  }
  
  
  public void info() {
    System.out.println("=======탑승자 목록 확인=======");
    for(int i = 0; i < LIMIT ; i++) {
      Person person = seats.get(i).getPerson();
      if(person == null) {
        System.out.println(String.format("%02d",i + 1) + "번 좌석 : 비어 있음");
      } else {
        System.out.println(String.format("%02d", i + 1) + "번 좌석 : " + person.getName());
      }
    }
  }
}
