package practice03_Club;

import java.util.HashSet;
import java.util.Set;

public class Club {
  
  // field
  private Set<Person> pool;
  
  public Club() {
    pool = new HashSet<Person>();
  }
  
  // method
  public void enterClub(Person person) {
    pool.add(person);
  }
  
  public void leaveClub(Person person) {
    pool.remove(person);
  }
  
  public void poolList() {
    for(Person person : pool) {     //advanced for 문 따로 공부하자
      System.out.println(person);
    }
  }

}
