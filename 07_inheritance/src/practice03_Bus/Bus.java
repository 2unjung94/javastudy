package practice03_Bus;

// 25개 seat
// 각 seat에 Man, Woman 저장 가능
public class Bus {
  
  // field
  private Seat[] busSeat;
  private int numOfPerson;

  // constructor
  public Bus() {
    busSeat = new Seat[25];
    for(int i = 0; i < busSeat.length; i++) {
      busSeat[i] = new Seat();
    }
  }
  
  // method
  
  //버스 타기 (앞좌석부터)
  public void busOn(Person person) {
   
   if(numOfPerson >= busSeat.length) {
     System.out.println("만석입니다. 버스에 탈 수 없습니다");
     return;
   }
   
   for(int i = 0; i< busSeat.length ; i++) {
     if(busSeat[i].getPerson() == null) {
       busSeat[i].setPerson(person);
       numOfPerson++;
       break;
     }
   }
 }
  
  public void off(int seatNo) {
    if(seatNo <= 0 || seatNo > busSeat.length) {
      System.out.println("좌석 번호가 잘못 전달되었습니다.");
      return;
    }
    busSeat[seatNo - 1 ].setPerson(null);
    numOfPerson--;
  }
  
  
  public void info() {
    System.out.println("=======탑승자 목록 확인=======");
    for(int i = 0; i < busSeat.length ; i++) {
      Person person = busSeat[i].getPerson();
      if(person == null) {
        System.out.println(String.format("%02d",i + 1) + "번 좌석 : 비어 있음");
      } else {
        System.out.println(String.format("%02d", i + 1) + "번 좌석 : " + person.getName());
      }
    }
  }
}
