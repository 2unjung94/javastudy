package practice03_Club;

public class MainClass {
  

  public static void main(String[] args) {
    
    Club club = new Club();
    Person p1 = new Person("1");
    Person p2 = new Person("2");
    Person p3 = new Person("3");
    Person p4 = new Person("4");
    Person p5 = new Person("5");

    // System.out.println(System.identityHashCode(p3)); p3의 참조값 출력
    
    club.enterClub(p1);
    club.enterClub(p2);
    club.enterClub(p3);
    club.enterClub(p3);
    club.enterClub(p3);
    club.enterClub(p4);
    club.enterClub(p5);
    club.enterClub(new Person("6"));
    club.enterClub(new Person("6"));  
    /*
     * 3번과 6번의 중복 차이
     * Set 는 추가할 때 참조값을 검사한다.
     * person 의 id 검사를 안함. 참조값을 검사함.
     * p3는 동일한 참조값. 6번은 6번짜리 2개를 만들어 각각 참조값이 달라짐.
     */

    club.leaveClub(p1);
    
    club.leaveClub(new Person("1"));
    
    club.poolList();
    
  }

}
